package backEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Utils.JdbcUtils;
import Utils.ScannerUtils;
import entity.Account;
import entity.Department;
import entity.Position;
import utility.properties.MessageProperties;

public class AccountDao {
	private JdbcUtils jdbcUtils;
	private MessageProperties messagePoperties;

	public AccountDao() throws IOException {
		jdbcUtils = new JdbcUtils();
		messagePoperties = new MessageProperties();
	}

	public List<Account> Q1getListAcc(List<Department> listOfDepts, List<Position> listOfPosits)
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Account> listOfAccs = new ArrayList<Account>();
		Connection cnnt = jdbcUtils.connect();
		Statement stmt = cnnt.createStatement();

		String query = "SELECT * FROM `account`";

		ResultSet RS = stmt.executeQuery(query);

		while (RS.next()) {
			listOfAccs.add(new Account(RS.getInt("account_id"), RS.getString("email"), RS.getString("username"),
					RS.getString("fullname"), RS.getString("gender"),searchDeptByID(listOfDepts, RS.getInt("department_id")) ,
					searchPosiByID(listOfPosits, RS.getInt("position_id")), LocalDate.parse(RS.getString("create_date"))));
		}
		jdbcUtils.disconnect();
		return listOfAccs;
	}

	public void showAllAcc(List<Account> listOfAccs) {
		if (listOfAccs.size() == 0) {
			System.out.println("Chưa có account nào");
		} else {
			for (Account account : listOfAccs) {
				System.out.println(account.toString());
			}
		}
	}
	
	public Department searchDeptByID(List<Department> listOfDepts, int id) {
		for (Department dept : listOfDepts) {
			if (dept.getId() == id) {
				return dept;
			}
		}
		return null;
	}

	public Position searchPosiByID(List<Position> listOfPosits, int id) {
		for (Position posi : listOfPosits) {
			if (posi.getId() == id) {
				return posi;
			}
		}
		return null;
	}
	
	public Account Q2searchById(List<Account> listOfAccs, int id) {
		for (Account account : listOfAccs) {
			if (account.getId() == id) {
				return account;
			}
		}
		System.out.println("Cannot find account id= " + id);
		return null;
	}

	public Account Q2searchByUsername(List<Account> listOfAccs, String username) {
		for (Account account : listOfAccs) {
			if (account.getUsername().equals(username)) {
				return account;
			}
		}
		System.out.println("Cannot find account username= " + username);
		return null;
	}

	public Account Q2searchByFullName(List<Account> listOfAccs, String fullName) {
		for (Account account : listOfAccs) {
			if (account.getFullName().equals(fullName)) {
				return account;
			}
		}
		System.out.println("Cannot find account full name= " + fullName);
		return null;
	}

	public Account Q2searchByEmail(List<Account> listOfAccs, String email) {
		for (Account account : listOfAccs) {
			if (account.getEmail().equals(email)) {
				return account;
			}
		}
		System.out.println("Cannot find account email= " + email);
		return null;
	}

	public boolean isAccIdExist(List<Account> listOfAccs, int id) {
		for (Account account : listOfAccs) {
			if (account.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmailExist(List<Account> listOfAccs, String email) {
		for (Account account : listOfAccs) {
			if (account.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public boolean isUsernameExist(List<Account> listOfAccs, String username) {
		for (Account account : listOfAccs) {
			if (account.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean isFullNameExist(List<Account> listOfAccs, String fullName) {
		for (Account account : listOfAccs) {
			if (account.getFullName().equals(fullName)) {
				return true;
			}
		}
		return false;
	}

	public void Q5createAcc(List<Account> listOfAccs, String email, String username, String fullName, String gender,
			int deptID, int posiID, String createDate)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();

		String query = "INSERT INTO \r\n"
				+ "`account`(email,	username, 	fullname, gender, department_id, position_id, create_date)\r\n"
				+ "VALUES\r\n" + "	(		?,		?,				?,		?,		?,				?,			?)";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, email);
		PS.setString(2, username);
		PS.setString(3, fullName);
		PS.setString(4, gender);
		PS.setInt(5, deptID);
		PS.setInt(6, posiID);
		PS.setString(7, createDate);

		if (isUsernameExist(listOfAccs, username)) {
			System.out.println("Username đã tồn tại");
		} else if (isEmailExist(listOfAccs, email)) {
			System.out.println("Email đã tồn tại");
		} else {
			System.out.println(PS.executeUpdate());
		}
		jdbcUtils.disconnect();
	}

	public void Q7deleteAccById(List<Account> listOfAccs, int id)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "DELETE FROM `account` WHERE account_id = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setInt(1, id);

		if (!isAccIdExist(listOfAccs, id)) {
			System.out.println("Cannot find account with id = " + id);
		} else {
			System.out.println(PS.executeUpdate());
		}
		jdbcUtils.disconnect();
	}

	public void Q7deleteAccByUsername(List<Account> listOfAccs, String username)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "DELETE FROM `account` WHERE username = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, username);

		if (!isUsernameExist(listOfAccs, username)) {
			System.out.println("Cannot find account with username = " + username);
		} else {
			System.out.println(PS.executeUpdate());
		}
		jdbcUtils.disconnect();
	}

	public void Q7deleteAccByEmail(List<Account> listOfAccs, String email)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "DELETE FROM `account` WHERE email = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, email);

		if (!isEmailExist(listOfAccs, email)) {
			System.out.println("Cannot find account with email = " + email);
		} else {
			System.out.println(PS.executeUpdate());
		}
		jdbcUtils.disconnect();
	}
	
	public void Q6updateAccEmailByID(List<Account> listOfAccs, int id, String email) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "UPDATE `account` SET email = ? WHERE account_id = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, email);
		PS.setInt(2, id);
		
		if (!isAccIdExist(listOfAccs, id)) {
			System.out.println("Cannot find account with id = " + id);
		} else {
			if (isEmailExist(listOfAccs, email)) {
				System.out.println("Email đã tồn tại");
			} else {
				System.out.println(PS.executeUpdate());
			}
		}
		jdbcUtils.disconnect();
	}
	
	public void Q6updateAccUsernameByID(List<Account> listOfAccs, int id, String username) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "UPDATE `account` SET username = ? WHERE account_id = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, username);
		PS.setInt(2, id);
		
		if (!isAccIdExist(listOfAccs, id)) {
			System.out.println("Cannot find account with id = " + id);
		} else {
			if (isUsernameExist(listOfAccs, username)) {
				System.out.println("Username đã tồn tại");
			} else {
				System.out.println(PS.executeUpdate());
			}
		}
		jdbcUtils.disconnect();
	}
	
	public void Q6updateAccFullNameByID(List<Account> listOfAccs, int id, String fullName) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "UPDATE `account` SET fullname = ? WHERE account_id = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		PS.setString(1, fullName);
		PS.setInt(2, id);
		
		if (!isAccIdExist(listOfAccs, id)) {
			System.out.println("Cannot find account with id = " + id);
		} else {
			System.out.println(PS.executeUpdate());
		}
		jdbcUtils.disconnect();
	}
	
	
}

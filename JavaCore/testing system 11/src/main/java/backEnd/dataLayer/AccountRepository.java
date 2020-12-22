package backEnd.dataLayer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Utils.JdbcUtils;
import entity.*;
import utility.properties.MessageProperties;
public class AccountRepository implements IAccountRepositoryV1{
	private JdbcUtils jdbcUtils;
	private MessageProperties messagePoperties;

	public AccountRepository() throws IOException {
		jdbcUtils = new JdbcUtils();
		messagePoperties = new MessageProperties();
	}

	public List<Account> getListAcc()
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Account> listOfAccs = new ArrayList<Account>();
		Connection cnnt = jdbcUtils.connect();
		Statement stmt = cnnt.createStatement();

		String query = "SELECT * FROM `account`";

		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			listOfAccs.add(new Account(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4), RS.getString(5), RS.getInt(6), RS.getInt(7), LocalDate.parse(RS.getString(8))));
		}
		
		return listOfAccs;
	}

	public Account createAcc() {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccByID() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccExist(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccExist(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public Account updateAccById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAcc(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}

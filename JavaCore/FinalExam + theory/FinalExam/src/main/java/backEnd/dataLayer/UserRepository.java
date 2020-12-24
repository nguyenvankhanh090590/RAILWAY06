package backEnd.dataLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.JdbcUltils;
import Utils.ScannerUtils;
import entity.Employee;
import entity.Manager;
import entity.Project;
import entity.User;

public class UserRepository implements IUserRepository {

	private JdbcUltils jdbc;

	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		this.jdbc = new JdbcUltils();
	}

	public List<Project> getListOfProjects() throws ClassNotFoundException, SQLException {
		List<Project> listOfProjects = new ArrayList<Project>();
		Connection cnnt = jdbc.connect();

		Statement stmt = cnnt.createStatement();
		String sql = "SELECT * FROM project";

		ResultSet RS = stmt.executeQuery(sql);
		while (RS.next()) {
			Project project = new Project(RS.getInt(1), RS.getInt(2), RS.getInt(3));
			listOfProjects.add(project);
		}

		jdbc.disConnect();

		return listOfProjects;
	}

	public List<User> getListOfUsers() throws ClassNotFoundException, SQLException {
		List<User> listOfUsers = new ArrayList<User>();
		
		Connection cnnt = jdbc.connect();
		
		Statement stmt = cnnt.createStatement();
		String sql = "SELECT * FROM `user`";
		
		ResultSet RS = stmt.executeQuery(sql);
		while (RS.next()) {
			if (RS.getString(5).equals("Manager")) {
				User user = new Manager(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4), RS.getInt(6));
				user.setRole("Manager");
				listOfUsers.add(user);
			} else {
				User user = new Employee(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4), RS.getInt(7),
						RS.getString(8));
				user.setRole("Employee");
				listOfUsers.add(user);
			}

		}
		
		jdbc.disConnect();
		
		return listOfUsers;

	}

	private boolean isProjectIdExist(int id) throws ClassNotFoundException, SQLException {
		List<Project> listOfProjects = getListOfProjects();
		if (listOfProjects.size() == 0) {
			return false;
		}
		for (Project project : listOfProjects) {
			if (project.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void getEmplOfProjectById() throws ClassNotFoundException, SQLException {

		System.out.println("Mời nhập vào ID của project:");
		int idProject = ScannerUtils.inputInt("Nhập sai, mời nhập lại");
		if (!isProjectIdExist(idProject)) {
			System.out.println("Project không tồn tại");
		} else {
			List<User> listEmplOfProject = new ArrayList<User>();
			List<User> listOfUsers = getListOfUsers();
			
			Connection cnnt = jdbc.connect();
			
			Statement stmt = cnnt.createStatement();
			String sql = "SELECT id_employee FROM project_employee WHERE project_id = " + idProject;
			
			ResultSet RS = stmt.executeQuery(sql);
			while (RS.next()) {
				for (User user : listOfUsers) {
					if (user.getId() == RS.getInt(1)) {
						listEmplOfProject.add(user);
					}
				}
			}
			if (listEmplOfProject.size() == 0) {
				System.out.println("Project không có employee nào");
			} else {
				for (User user : listEmplOfProject) {
					System.out.println(((Employee) user).toString());
				}
			}
			
			jdbc.disConnect();
		}

	}

	public void getManagerOfProject() throws ClassNotFoundException, SQLException {
		Connection cnnt = jdbc.connect();
		
		Statement stmt = cnnt.createStatement();
		String sql = "SELECT * FROM `user` u RIGHT JOIN project p ON u.user_id = p.id_manager";
		
		ResultSet RS = stmt.executeQuery(sql);
		System.out.println(
				"ProjectID" + "	" + "ManagerID" + "	" + "Full name" + "	" + "Email" + "		" + "ExpInYear");
		while (RS.next()) {
			System.out.println(RS.getInt(9) + "		" + RS.getInt(1) + "		" + RS.getString(2) + "	"
					+ RS.getString(3) + "	" + RS.getInt(6));
		}
		
		jdbc.disConnect();
	}

	private boolean checkPass(String pass) {
		// check xem có chữ viết hoa trong password
		boolean bl = false;
		for (int i = 0; i < pass.length(); i++) {
			if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z') {
				bl = true;
			}
		}
		// check 6-12 ký tự và viết hoa
		if (pass.length() >= 6 && pass.length() <= 12 && bl == true) {
			return true;
		} else {
			return false;
		}
	}
	// kiểm tra email thông thường, cái này em nhặt trên mạng
	private boolean checkEmail(String email) {
		String emailPartern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";// cấu trúc 1 email thông thường

		Pattern pattern = Pattern.compile(emailPartern);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private String inputEmail() {
		while (true) {
			System.out.println("Mời nhập vào email:");
			String email = ScannerUtils.inputString("Mục này không được bỏ trống, nhập lại");
			if (!checkEmail(email)) {
				System.out.println("Sai định dạng, nhập lại");
			} else {
				return email;
			}
		}
	}

	private String inputPassword() {
		while (true) {
			System.out.println("Mời nhập vào password:");
			String pass = ScannerUtils.inputString("Mục này không được bỏ trống, nhập lại");
			if (!checkPass(pass)) {
				System.out.println("Nhập từ 6 đến 12 ký tự, có ít nhất 1 chữ viết hoa, nhập lại");
			} else {
				return pass;
			}
		}
	}

	public User login() throws ClassNotFoundException, SQLException {
		List<User> listOfUsers = getListOfUsers();
		
		String email = inputEmail();
		String password = inputPassword();
		
		
		boolean blEmail = false;
		boolean blPass = false;
		for (User user : listOfUsers) {
			if (user.getEmail().equals(email)) {
				blEmail = true;
			}
			if (user.getPassword().equals(password)) {
				blPass = true;
			}
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				System.out.println("Đăng nhập thành công");
				return user;
			}
		}
		if (blEmail == false) {
			System.out.println("Đăng nhập không thành công, email không tồn tại");
		}
		if (blPass == false) {
			System.out.println("Đăng nhập không thành công, password không đúng");
		}
		return null;
	}

}

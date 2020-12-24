package backEnd.presentationLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import backEnd.businessLayer.UserService;
import entity.User;

public class UserController {
	private UserService US;
	
	public void getEmplOfProjectById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		US = new UserService();
		US.getEmplOfProjectById();
	}

	public void getManagerOfProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		US = new UserService();
		US.getManagerOfProject();
	}

	public User login() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		US = new UserService();
		return US.login();
	}
}

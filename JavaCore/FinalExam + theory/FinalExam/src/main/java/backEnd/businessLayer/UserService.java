package backEnd.businessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import backEnd.dataLayer.UserRepository;
import entity.User;

public class UserService implements IUserService {
	private UserRepository UR;
	public void getEmplOfProjectById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		UR = new UserRepository();
		UR.getEmplOfProjectById();
	}

	public void getManagerOfProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		UR = new UserRepository();
		UR.getManagerOfProject();
	}

	public User login() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		UR = new UserRepository();
		return UR.login();
	}
	
}

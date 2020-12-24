package backEnd.businessLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import entity.User;

public interface IUserService {
	void getEmplOfProjectById() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	void getManagerOfProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	User login() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}

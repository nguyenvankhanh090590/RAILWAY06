package backEnd.dataLayer;

import java.sql.SQLException;

import entity.User;

public interface IUserRepository {
	void getEmplOfProjectById() throws ClassNotFoundException, SQLException;
	void getManagerOfProject() throws ClassNotFoundException, SQLException;
	User login() throws ClassNotFoundException, SQLException;
}

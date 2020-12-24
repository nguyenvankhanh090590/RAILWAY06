package frontEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import backEnd.presentationLayer.UserController;

public class DemoQ4 {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		UserController UC = new UserController();
		System.out.println(UC.login());
	}

}

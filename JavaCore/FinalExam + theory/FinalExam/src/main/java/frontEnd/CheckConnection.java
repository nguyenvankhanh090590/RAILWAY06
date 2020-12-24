package frontEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import Utils.JdbcUltils;

public class CheckConnection {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUltils jdbc = new JdbcUltils();
		Connection cnnt = jdbc.connect();
	}

}

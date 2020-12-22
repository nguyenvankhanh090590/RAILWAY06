package backEnd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Utils.ScannerUtils;

public class Ex1 {
	private Properties prop;
	private Connection cnnt;

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public Connection getCnnt() {
		return cnnt;
	}

	public void setCnnt(Connection cnnt) {
		this.cnnt = cnnt;
	}

	public Ex1() throws IOException {
		prop = new Properties();
		FileInputStream FIS = new FileInputStream("src\\main\\resource\\database.properties");
		prop.load(FIS);

	}

	public Connection Q1Connect() throws ClassNotFoundException, SQLException {
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		// register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// get a Database Connection
		cnnt = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success");
		return cnnt;
	}

	public void Q2GetPosition() throws SQLException {
		// create a statement object
		Statement stm = cnnt.createStatement();

		// tạo query, thực thi và lấy kết quả
		String query = "SELECT * FROM `position`";
		ResultSet RS = stm.executeQuery(query);

		// in ra kết quả
		while (RS.next()) {
			System.out.println("ID: " + RS.getInt("position_id") + " / Position: " + RS.getString("position_name"));
		}
	}

	public void Q3InsertPosition() throws SQLException {
		// input information
		System.out.println("Mời nhập vào tên chức vụ:");
		String positionName = ScannerUtils.inputString("Mục này không được bỏ trống, mời nhập lại");

		// tạo một đối tượng statement
		String query = "INSERT INTO `position`(position_name) VALUES (?)";
		PreparedStatement PS = cnnt.prepareStatement(query);

		// đặt thông số
		PS.setString(1, positionName);

		// Thực thi query
		int effectedRecordAmount = PS.executeUpdate();

		// biểu diễn kết quả
		System.out.println("Amount Of Added Position: " + effectedRecordAmount);
	}

	public void Q4UpdatePosition() throws SQLException {
		// tạo một đối tượng statment
		String query = "UPDATE `position` SET position_name = 'DEV' WHERE position_id = 5";
		Statement stm = cnnt.createStatement();

		// thực thi query
		int effectedRecordAmount = stm.executeUpdate(query);

		// biểu diễn kết quả
		System.out.println("Amount Of Updated Position: " + effectedRecordAmount);
	}

	public void Q5DeletePosition() throws SQLException {
		// Nhập thông tin
		System.out.println("Mời nhập ID của Position muốn xóa");
		int id = ScannerUtils.inputId();

		// tạo một đối tượng statment
		String query = "DELETE FROM `position` WHERE position_id = ?";
		PreparedStatement PS = cnnt.prepareStatement(query);

		// set thông tin
		PS.setInt(1, id);

		// Thực thi query
		int effectedRecordAmount = PS.executeUpdate();

		// in kết quả
		System.out.println("Amount Of Deleted Position: " + effectedRecordAmount);
	}
}

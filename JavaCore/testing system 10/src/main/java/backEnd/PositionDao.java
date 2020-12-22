package backEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.JdbcUtils;
import Utils.ScannerUtils;
import entity.Position;
import utility.properties.MessageProperties;

public class PositionDao {
	private JdbcUtils jdbcUtils;
	private MessageProperties messagePoperties;

	public PositionDao() throws IOException {
		jdbcUtils = new JdbcUtils();
		messagePoperties = new MessageProperties();
	}

	public List<Position> Q1getListPosi()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List<Position> listOfPosits = new ArrayList<Position>();
		Connection cnnt = jdbcUtils.connect();
		Statement stmt = cnnt.createStatement();

		String query = "SELECT * FROM `position`";

		ResultSet RS = stmt.executeQuery(query);

		while (RS.next()) {
			listOfPosits.add(new Position(RS.getInt(1), RS.getString(2)));
		}
		jdbcUtils.disconnect();
		return listOfPosits;
	}

	public void showAllPosi(List<Position> listOfPosits) {
		if (listOfPosits.size() == 0) {
			System.out.println("Chưa có department nào");
		} else {
			for (Position posi : listOfPosits) {
				System.out.println(posi.toString());
			}
		}
	}

	public Position Q2searchPosiByID(List<Position> listOfPosits) {
		System.out.println("Mời nhập vào ID của department cần tìm kiếm:");
		int id = ScannerUtils.inputId();

		for (Position posi : listOfPosits) {
			if (posi.getId() == id) {
				return posi;
			}
		}

		System.out.println("Không có vị trí nào");
		return null;
	}

	public Position Q3searchPosiByName(List<Position> listOfPosits) {
		System.out.println("Mời nhập vào tên của position cần tìm kiếm:");
		String name = ScannerUtils.inputString("Mục này không được bỏ trống, nhập lại");
		for (Position posi : listOfPosits) {
			if (posi.getPosiName().equals(name)) {
				return posi;
			}
		}
		System.out.println("Vị trí không tồn tại");
		return null;
	}

	public boolean Q4isPosiNameExist(List<Position> listOfPosits, String name) {
		for (Position posi : listOfPosits) {
			if (posi.getPosiName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void Q5createPosi(List<Position> listOfPosits)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String name = null;
		do {
			System.out.println("Mời chọn tên chức vụ muốn thêm:\n1. Dev\n2. Test\n3. Scrum Master\n4. PM\n5. Khác");
			int n = ScannerUtils.inputInt();

			switch (n) {
			case 1:
				name = "Dev";
				break;
			case 2:
				name = "Test";
				break;
			case 3:
				name = "Scrum Master";
				break;
			case 4:
				name = "PM";
			case 5:
				System.out.println("Mời nhập tên chức vụ:");
				name = ScannerUtils.inputString("Mục này không được bỏ trống, nhập lại");
			default:
				System.out.println("Nhập sai, mời nhập lại");
			}
		} while (name == null);

		String query = "INSERT INTO `position`(position_name) VALUES ('" + name + "')";
		Statement stmt = cnnt.createStatement();

		if (!Q4isPosiNameExist(listOfPosits, name)) {
			System.out.println(stmt.executeUpdate(query));
		} else {
			System.out.println("Đã tồn tại vị trí này!");
		}
		jdbcUtils.disconnect();
	}

	public boolean isPosiIdExist(List<Position> listOfPosits, int id) {
		for (Position posi : listOfPosits) {
			if (posi.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void Q6updatePosi(List<Position> listOfPosits, int id, String name)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "UPDATE `position` SET position_name = '" + name + "' WHERE position_id =" + id;
		Statement stmt = cnnt.createStatement();

		if (!isPosiIdExist(listOfPosits, id)) {
			System.out.println("Cannot find position which has id = " + id);
		} else {
			if (Q4isPosiNameExist(listOfPosits, name)) {
				System.out.println("Position đã tồn tại");
			} else {
				System.out.println(stmt.executeUpdate(query));
			}
		}
		jdbcUtils.disconnect();
	}

	public void Q7DeletePosi(List<Position> listOfPosits, int id)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "DELETE FROM `position` WHERE position_id = " + id;
		Statement stmt = cnnt.createStatement();

		if (!isPosiIdExist(listOfPosits, id)) {
			System.out.println("Cannot find position which has id = " + id);
		} else {
			System.out.println(stmt.executeUpdate(query));
		}
		jdbcUtils.disconnect();
	}

}

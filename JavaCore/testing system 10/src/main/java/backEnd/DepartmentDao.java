package backEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.JdbcUtils;
import Utils.ScannerUtils;
import entity.Department;
import utility.properties.MessageProperties;

public class DepartmentDao {
	private JdbcUtils jdbcUtils;
	private MessageProperties messagePoperties;

	public DepartmentDao() throws IOException {
		jdbcUtils = new JdbcUtils();
		messagePoperties = new MessageProperties();
	}

	public List<Department> Q1getDepartment()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List<Department> listOfDepts = new ArrayList<Department>();
		Connection cnnt = jdbcUtils.connect();

		// tạo statement
		String query = "SELECT * FROM `department` ORDER BY department_id";
		Statement stmt = cnnt.createStatement();

		// thực thi truy vấn
		ResultSet RS = stmt.executeQuery(query);

		// thu kết quả vào List

		while (RS.next()) {
			Department dept = new Department(RS.getInt("department_id"), RS.getString("department_name"));
			listOfDepts.add(dept);
		}
		jdbcUtils.disconnect();
		return listOfDepts;
	}

	public void showAllDepartment(List<Department> listOfDepts) {
		if (listOfDepts.size() == 0) {
			System.out.println("Chưa có department nào");
		} else {
			for (Department dept : listOfDepts) {
				System.out.println(dept.toString());
			}
		}
	}

	public Department Q2searchDeptByID(List<Department> listOfDepts) {
		System.out.println("Mời nhập vào ID của department cần tìm kiếm:");
		int id = ScannerUtils.inputId();

		for (Department dept : listOfDepts) {
			if (dept.getId() == id) {
				return dept;
			}
		}

		System.out.println("Không có deparment nào");
		return null;
	}

	public Department Q3searchDeptByName(List<Department> listOfDepts) {
		System.out.println("Mời nhập vào tên của department cần tìm kiếm:");
		String name = ScannerUtils.inputString("Mục này không được bỏ trống, nhập lại");
		for (Department dept : listOfDepts) {
			if (dept.getName().equals(name)) {
				return dept;
			}
		}
		System.out.println("Department không tồn tại");
		return null;
	}

	public boolean Q4isDeptNameExist(List<Department> listOfDepts, String name) {
		for (Department dept : listOfDepts) {
			if (dept.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void Q5createDept(List<Department> listOfDepts, String name)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "INSERT INTO department(department_name) VALUES ('" + name + "')";
		Statement stmt = cnnt.createStatement();

		if (!Q4isDeptNameExist(listOfDepts, name)) {
			System.out.println(stmt.executeUpdate(query));
		} else {
			System.out.println("Đã tồn tại department này!");
		}
		jdbcUtils.disconnect();
	}

	public boolean isDeptIdExist(List<Department> listOfDepts, int id) {
		for (Department dept : listOfDepts) {
			if (dept.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void Q6updateDept(List<Department> listOfDepts, int id, String name)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "UPDATE department SET department_name = '" + name + "' WHERE department_id =" + id;
		Statement stmt = cnnt.createStatement();

		if (!isDeptIdExist(listOfDepts, id)) {
			System.out.println("Cannot find department which has id = " + id);
		} else {
			if (Q4isDeptNameExist(listOfDepts, name)) {
				System.out.println("Department đã tồn tại");
			} else {
				System.out.println(stmt.executeUpdate(query));
			}
		}
		jdbcUtils.disconnect();
	}

	public void Q7DeleteDept(List<Department> listOfDepts, int id)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "DELETE FROM department WHERE department_id = " + id;
		Statement stmt = cnnt.createStatement();

		if (!isDeptIdExist(listOfDepts, id)) {
			System.out.println("Cannot find department which has id = " + id);
		} else {
			System.out.println(stmt.executeUpdate(query));
		}
	}

	public void Ex3deleteDeptByProcedure(List<Department> listOfDepts, int id)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		String query = "{CALL sp_deletede_partment(?)}";
		CallableStatement CS = cnnt.prepareCall(query);
		CS.setInt(1, id);

		if (!isDeptIdExist(listOfDepts, id)) {
			System.out.println("Cannot find department which has id = " + id);
		} else {
			CS.executeUpdate();
		}
		jdbcUtils.disconnect();
	}

}

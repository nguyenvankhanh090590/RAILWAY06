package backEnd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utils.JdbcUtils;
import utility.properties.MessageProperties;
import backEnd.AccountDao;
import backEnd.DepartmentDao;
public class Transaction {
	private JdbcUtils jdbcUtils;
	private MessageProperties messagePoperties;
	
	public Transaction() throws IOException {
		jdbcUtils = new JdbcUtils();
		messagePoperties = new MessageProperties();
	}
	
	
	
	
	public void deleteDeptAccByDeptId(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection cnnt = jdbcUtils.connect();
		
		// tắt autoCommit
		cnnt.setAutoCommit(false);
		// query delete acc
		String query1 = "DELETE FROM `account` WHERE department_id = ?";
		PreparedStatement PS1 = cnnt.prepareStatement(query1);
		PS1.setInt(1,id);
		
		// query delete dept
		String query2 = " DELETE FROM department WHERE department_id = ?";
		PreparedStatement PS2 = cnnt.prepareStatement(query2);
		PS2.setInt(1,id);
		
		// Cho chạy query trong try-catch
		try {
			System.out.println("Delete " + PS1.executeUpdate() + " account");
			System.out.println("Delete " + PS2.executeUpdate() + " department");
			cnnt.commit();
			System.out.println("Transaction success");
		} catch (Exception e) {
			System.out.println(e.toString());
			// nếu gặp lỗi cho rollback về ban đầu
			cnnt.rollback();
			System.out.println("Transaction rollback");
		}
		// Bật lại autoCommit
		cnnt.setAutoCommit(true);
		
		cnnt.close();
	}
}

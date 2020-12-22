package frontEnd;
import java.io.IOException;
import java.sql.SQLException;
import backEnd.DepartmentDao;
import backEnd.AccountDao;
import backEnd.Transaction;
import backEnd.PositionDao;
public class Transaction_Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Transaction BE = new Transaction();
		DepartmentDao DD = new DepartmentDao();
		AccountDao AD = new AccountDao();
		PositionDao PD = new PositionDao();
		BE.deleteDeptAccByDeptId(3);
		DD.showAllDepartment(DD.Q1getDepartment());
		AD.showAllAcc(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()));
		DD.showAllDepartment(DD.Q1getDepartment());
	}

}

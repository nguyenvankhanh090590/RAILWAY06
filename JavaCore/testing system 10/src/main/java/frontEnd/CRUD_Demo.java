package frontEnd;
import java.io.IOException;
import java.sql.SQLException;

import backEnd.AccountDao;
import backEnd.DepartmentDao;
import backEnd.PositionDao;
public class CRUD_Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		DepartmentDao DD = new DepartmentDao();
		PositionDao PD = new PositionDao();
		AccountDao AD = new AccountDao();
//		DD.Q6updateDept(DD.Q1getDepartment(), 11, "Tap Su");
//		DD.Q7DeleteDept(DD.Q1getDepartment(), 11);
//		DD.showAllDepartment(DD.Q1getDepartment());
//		
//		System.out.println(PD.Q2searchPosiByID(PD.Q1getListPosi()).toString());
//		System.out.println(PD.Q3searchPosiByName(PD.Q1getListPosi()).toString());
//		PD.Q5createPosi(PD.Q1getListPosi());
//		PD.Q6updatePosi(PD.Q1getListPosi(), 5, "Check");
//		PD.Q7DeletePosi(PD.Q1getListPosi(), 6);
//		PD.showAllPosi(PD.Q1getListPosi());
//		
//		System.out.println(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()));
//		
//		AD.Q5createAcc(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()),
//				"aik@gmail.com", "aik", "Ai ich khong", "M", 3, 4, "2020-11-12");
//		
//		
//		AD.Q7deleteAccById(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()), 13);
//		AD.showAllAcc(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()));
//		AD.Q6updateAccEmailByID(AD.Q1getListAcc(DD.Q1getDepartment(),PD.Q1getListPosi()), 1, "heoquay@gmail.com");
		AD.showAllAcc(AD.Q1getListAcc(DD.Q1getDepartment(), PD.Q1getListPosi()));
//		
//		DD.Ex3deleteDeptByProcedure(DD.Q1getDepartment(), 1);
//		DD.showAllDepartment(DD.Q1getDepartment());
	}

}

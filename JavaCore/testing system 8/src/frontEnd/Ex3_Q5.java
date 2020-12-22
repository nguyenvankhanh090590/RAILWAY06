package frontEnd;
import backEnd.Q5_Ex3;
import entity.Ex3.Employee;
public class Ex3_Q5 {

	public static <T> void main(String[] args) {
		Q5_Ex3 BE = new Q5_Ex3<T>();
		BE.khoiTao();
		BE.showAllEmpl();
		BE.showLastSalary((Employee) BE.listEmpls.get(1));
		BE.showLastSalary((Employee) BE.listEmpls.get(2));
		BE.showLastSalary((Employee) BE.listEmpls.get(3));
	}

}

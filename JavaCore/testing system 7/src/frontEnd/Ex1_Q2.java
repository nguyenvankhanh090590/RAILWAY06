package frontEnd;
import entity.Student;
import backEnd.Q1_Ex1;
public class Ex1_Q2 {

	public static void main(String[] args) throws Exception {
		Q1_Ex1 BE = new Q1_Ex1();
		Student.setMoneyGroup(100000*BE.khoitao().length);
		System.out.println("Đóng quỹ lớp mỗi người 100K");
		System.out.println("Quỹ lớp ban đầu: "+Student.getMoneyGroup());
		
		System.out.println("St1 lấy 50K");
		Student.setMoneyGroup(Student.getMoneyGroup()-50000);
		System.out.println("Quỹ lớp còn lại: "+Student.getMoneyGroup());
		System.out.println("St1 lấy 20K");
		Student.setMoneyGroup(Student.getMoneyGroup()-20000);
		System.out.println("Quỹ lớp còn lại: "+Student.getMoneyGroup());
		System.out.println("St1 lấy 150K");
		Student.setMoneyGroup(Student.getMoneyGroup()-150000);
		
		System.out.println("Quỹ lớp còn lại: "+Student.getMoneyGroup());
		System.out.println("Đóng quỹ lớp mỗi người 50K");
		Student.setMoneyGroup(Student.getMoneyGroup()+ 50000*BE.khoitao().length); 
		System.out.println("Quỹ lớp bây giờ: "+Student.getMoneyGroup());
		
		
	}

}

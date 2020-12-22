package frontEnd;
import backEnd.Q1_Ex1;
import entity.Student;
public class Ex1_Q1 {
	public static void main(String[] args) throws Exception {
		Student.college = "Đại học Bách Khoa";
		Q1_Ex1 BE = new Q1_Ex1();
		
		for (int i = 0; i < BE.khoitao().length; i ++) {
			System.out.println(BE.khoitao()[i]);
		}
		
		Student.college = "Đại học Công Nghệ";
		for (int i = 0; i < BE.khoitao().length; i ++) {
			System.out.println(BE.khoitao()[i]);
		}
	}
}

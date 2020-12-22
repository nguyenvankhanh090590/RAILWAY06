package backEnd;
import entity.Ex2.*;
public class Q2_Q3_Ex2 {
	public void khoiTao() {
		PrimaryStudent PS1 = new PrimaryStudent("Lan", "Primary1");
		SecondaryStudent SS1 = new SecondaryStudent("Hòa", "Đại Số");
		
		System.out.println(PS1.toString());
		System.out.println(SS1.toString());
	}
	
	public void Q3_Ex2() {
		PrimaryStudent.study();
		SecondaryStudent.study();
	}
}

package backEnd;
import entity.PrimaryStudent;
import entity.SecondaryStudent;
import entity.Student;
public class Q6_Ex1 {
	
	
	

	public void khoitao() throws Exception {
		
		Student PS1 = new PrimaryStudent(1,"Văn", "Hóa 1");
		Student PS2 = new PrimaryStudent(2,"An", "Hóa 2");
		Student PS3 = new PrimaryStudent(3,"Bình", "Hóa 2");
		Student PS4 = new PrimaryStudent(4,"Giang", "Hóa 1");
		Student PS5 = new PrimaryStudent(5,"Giang1", "Hóa 1");
		Student PS6 = new PrimaryStudent(6,"Giang2", "Hóa 1");
		
		
		Student SC1 = new SecondaryStudent(1,"Hùng", "Hóa 3", "Trực chủ nhật");
		Student SC2 = new SecondaryStudent(2,"Hoàng", "Hóa 3", "Trực thứ bảy");
	}
	
	public int countSt() throws Exception {
		return Student.getCount();
	}
	public int countPS() throws Exception {
		return PrimaryStudent.getCountPrim();
	}
	public int countSC() throws Exception {
		return SecondaryStudent.getCountSecn();
	}
	
	
	
}

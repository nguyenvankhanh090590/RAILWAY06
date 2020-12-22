package frontEnd;
import entity.Ex3.Staff;
public class Ex3_Q8 {

	public static void main(String[] args) {
		Staff<Integer> staff1 = new Staff<Integer>(1, "Nguyễn Mạnh Cường");
		Staff<Long> staff2 = new Staff<Long>((long) 2, "Nguyễn Đắc Ngọc");
		System.out.println(staff1);
		System.out.println(staff2);
	}

}

package frontEnd;
import entity.Ex3.Phone;
public class Ex3_Q7 {

	public static void main(String[] args) {
		Phone<String, String> phn1 = new Phone<String, String>("cuongnm568@gmail.com", "012345678");
		Phone<Integer, String> phn2 = new Phone<Integer, String>(1, "087654321");
		Phone<String, String> phn3 = new Phone<String, String>("Nguyễn Mạnh Cường", "012345678");
		
		System.out.println(phn1);
		System.out.println(phn2);
		System.out.println(phn3);
	}

}

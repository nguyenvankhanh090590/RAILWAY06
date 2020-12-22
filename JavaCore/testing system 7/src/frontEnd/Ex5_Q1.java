package frontEnd;

import Utils.*;
import entity.Ex5.Student;

public class Ex5_Q1 {
	public static void main(String[] args) throws Exception {
		

		Student st1 = new Student();
		Student st2 = new Student();
		Student st3 = new Student();
		Student[] sts = { st1, st2, st3 };
		String info = "";
		for (Student st : sts) {
			info = info + "Student " + st.getId() + "\n" + "	ID: " + st.getId() + "\n" + "	Họ và tên: "
					+ st.getName() + "\n";
		}

//		FileManager.createNewFile("D:\\StudentInfo.txt");
		IOStream.writeFile("D:\\StudentInfo.txt", info, false);
		System.out.println(IOStream.readFile("D:\\StudentInfo.txt"));

	}

}

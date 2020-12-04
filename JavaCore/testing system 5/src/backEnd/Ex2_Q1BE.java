package backEnd;

import entity.Q1.Ex2.Student;

public class Ex2_Q1BE {
	// tạo 10 hs, chia thành 3 nhóm
	public Student[] insertStu() {
		Student st1 = new Student(1,"Nguyễn Thanh Tùng", 1);
		Student st2 = new Student(2,"Từ Văn Đại", 2);
		Student st3 = new Student(3,"Đào Thủy Tiên", 3);
		Student st4 = new Student(4,"Nguyễn Mạnh Cường", 1);
		Student st5 = new Student(5,"Trần Văn Tùng", 2);
		Student st6 = new Student(6,"Hà Tiến Hiệp", 3);
		Student st7 = new Student(7,"Nguyễn Đắc Ngọc", 1);
		Student st8 = new Student(8,"Lưu Thị Hoa", 2);
		Student st9 = new Student(9,"Đàm Thanh Hóa", 3);
		Student st10 = new Student(10,"Lê Văn Minh", 1);
		
		Student[] listOfSts = {st1,st2,st3,st4,st5,st6,st7,st8,st9,st10};
		
		return listOfSts;
	}
	public static void CaLopDiemDanh() {
		Ex2_Q1BE BE = new Ex2_Q1BE();
		Student[] listOfSts = BE.insertStu();
		for (Student st : listOfSts) {
			st.diemDanh();
		}
	}
	public static void nhom1HocBai() {
		Ex2_Q1BE BE = new Ex2_Q1BE();
		Student[] listOfSts = BE.insertStu();
		for (Student st : listOfSts) {
			if(st.getGroup() == 1) {
				st.hocBai();
			}
		}	
	}
	public static void nhom2DonVS() {
		Ex2_Q1BE BE = new Ex2_Q1BE();
		Student[] listOfSts = BE.insertStu();
		for (Student st : listOfSts) {
			if(st.getGroup() == 2) {
				st.trucNhat();
			}	
		}
	}
	
	
}

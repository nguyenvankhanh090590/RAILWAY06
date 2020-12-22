package backEnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Utils.ScannerUtils;
import entity.Student;

public class Q1_Ex1 {
	List<Student> Students = new ArrayList<>();
	public void khoiTao() {
		Student st1 = new Student( "Tuấn");
		Student st2 = new Student( "Nam");
		Student st3 = new Student( "Tú");
		Student st4 = new Student( "Tài");
		Student st5 = new Student( "Nam");
		Student st6 = new Student( "Tú");
		Student st7 = new Student( "Nam");
		Student st8 = new Student( "Nam");
		
		
		Students.add(st1);
		Students.add(st2);
		Students.add(st3);
		Students.add(st4);
		Students.add(st5);
		Students.add(st6);
		Students.add(st7);
		Students.add(st8);
		
		
		
	}
	
	public void showSizeOfStudents() {
		System.out.println(Students.size());
	}
	
	public void getStudentFromStudents(int i) {
		System.out.println("Student thứ " + i + " là : \n"+Students.get(i-1).toString());
		
	}
	
	public void getFirstLastStudent() {
		System.out.println("Student thứ nhất là : \n"+Students.get(0).toString());
		System.out.println("Student cuối cùng là : \n"+Students.get(Students.size()-1).toString());
	}
	
	public void addFirstStudent() {
		Student st4 = new Student("Nữ");
		Students.add(0,  st4);
		System.out.println(Students.get(0).toString());
	}
	public void addLastStudent() {
		Student st5 = new Student("Nga");
		Students.add(st5);
		System.out.println(Students.get(Students.size()-1).toString());
	}
	public void reverseStudents() {
		System.out.println("Students list before reverse:");
		for (Student student : Students) {
			System.out.println(student);
		}
		Collections.reverse(Students);
		System.out.println("Students list after reverse:");
		for (Student student : Students) {
			System.out.println(student);
		}
	}
	
	public void searchByID() {
		boolean bl = false;
		do {
			try {
				System.out.println("Mời nhập ID muốn tìm kiếm");
				int ID = ScannerUtils.inputInt("Nhập sai, mời nhập lại");
				for (int i = 0; i < Students.size(); i ++) {
					if (Students.get(i).getId()==ID) {
						bl = true;
						System.out.println(Students.get(i));
						
					}
				}
			} catch (Exception e) {
				System.err.println(e.toString());
			}
			System.out.println("\n1.Tìm ID khác\n2. Thoát");
			int n = ScannerUtils.inputInt("Nhập sai, mời nhập lại");
			if (n == 1) {
				bl = false;
			} else {
				bl = true;
			}
		} while (bl == false);
	}
	
	public void searchByName() {
		boolean bl = false;
		do {
			try {
				System.out.println("Mời nhập vào tên muốn tìm kiếm");
				String Name = ScannerUtils.inputString("Không bỏ trống mục này, mời nhập lại");
				for (int i = 0; i < Students.size(); i ++) {
					if (Students.get(i).getName().equals(Name)) {
						System.out.println(Students.get(i));
						bl = true;
					}
				}
			} catch (Exception e) {
				System.err.println(e.toString());
			}
			System.out.println("1. Tìm lại\n2. Thoát");
			int n = ScannerUtils.inputInt("Nhập sai, mời nhập lại");
			if (n == 1) {
				bl = false;
			} else {
				bl = true;
			}
		} while (bl == false);
	}
	
	public void nameInTheSame() {
		
		List<Student> temp = Students;
		int n = Students.size();
		for (int i = 0; i < (n-1);i++) {
			
			ArrayList<Student> names = new ArrayList<>();
			names.add(Students.get(i));
			for (int j = i+1; j < n;j++) {
				if (Students.get(i).getName().equals(Students.get(j).getName())) {
					names.add(Students.get(j));
					Students.remove(j);
					n = n - 1;
					j = j - 1;
				}
			}
			if (names.size() > 1) {
				for (Student st : names) {
					System.out.println(st);
				}
			}
		}
		Students = temp;
	}
	
	public void nameInTheSame2() {
		List<Student> ListStus = new ArrayList<>();
		for (int i = 0; i < Students.size(); i ++) {
			for (int j = 0; j <Students.size(); j++ ) {
				if (i==j) {
					continue;
				}
				if (Students.get(i).getName().equals(Students.get(j).getName())) {
					ListStus.add(Students.get(i));
					break;
				}
			}
		}
		System.out.println("Danh sách các tên trùng nhau");
		for (Student st : ListStus) {
			System.out.println(st);
			
		}
	}
	
	
	
	public void deleteName(int ID) {
		for (Student st : Students) {
			if (st.getId() == ID) {
				st.setName(null);
			}
		}
		System.out.println("Sinh viên có id = "+ID + " đã bị xóa tên");
	}
	public void deleteSt(int ID) {
		int n = Students.size();
		for (int i =0; i < n;i++) {
			if (Students.get(i).getId()==ID) {
				Students.remove(i);
				n = n -1;
				i = i -1;
			}
		}
	}
	
	public void copySt() {
		ArrayList<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(Students);
	}
}

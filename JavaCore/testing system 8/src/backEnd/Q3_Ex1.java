package backEnd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import entity.Student;
public class Q3_Ex1 {
	
	Set<Student> setStudents = new HashSet<Student>();
	
	public void khoiTao() {
		Student st1 = new Student("Anh");
		Student st2 = new Student("Minh");
		Student st3 = new Student("Thái");
		Student st4 = new Student("Thái");
		Student st5 = new Student("Tùng");
		Student st6 = new Student("Toản");
		
		setStudents.add(st1);
		setStudents.add(st2);
		setStudents.add(st3);
		setStudents.add(st4);
		setStudents.add(st5);
		setStudents.add(st6);
		
		
	}
	
	public void showSizeOfStudents() {
		System.out.println(setStudents.size());
	}
	
	public void getStudentFromStudents(int n) {
		Iterator<Student> iter = setStudents.iterator();
		System.out.println("Student thứ " + n + " là :");
		for (int i = 0; i < n-1; i ++) {
			iter.next();
		}
		System.out.println(iter.next());
	}
	
	public void getFirstLastStudent() {
		Iterator<Student> iter = setStudents.iterator();
		int n = setStudents.size();
		System.out.println("Student thứ nhất là :");
		System.out.println(iter.next());
		
		for (int i = 1; i < n-1; i ++) {
			iter.next();
		}
		System.out.println("Student cuối cùng là :");
		System.out.println(iter.next());
	}
	
	public void addFirstStudent() {
		
	}
	
	public void addLastStudent() {
	
	}
	
	public void reverseStudents() {
		
	}
	
	public Student searchByID() {
		return null;
	}
	
	public void searchByName() {
		
	}
	
	public void nameInTheSame() {
		
	}
	
	public void deleteName(int ID) {
		
	}
	
	public void deleteSt(int ID) {
		
	}
	
	public void copySt() {
		
	}
}

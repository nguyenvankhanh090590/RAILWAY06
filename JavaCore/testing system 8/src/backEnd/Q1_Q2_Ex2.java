package backEnd;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.Ex2.Student;

public class Q1_Q2_Ex2 {
	List<Student> listOfStus = new ArrayList<Student>();
	public void khoiTao() {
		listOfStus.add(new Student(1, "Hoàng", LocalDate.of(1993, 2, 13), 7.6f));
		listOfStus.add(new Student(2, "Việt", LocalDate.of(2000, 12, 26), 8.4f));
		listOfStus.add(new Student(3, "Thọ", LocalDate.of(1997, 5, 21), 7.9f));
		listOfStus.add(new Student(4, "Việt", LocalDate.of(1998, 10, 05), 7.7f));
		listOfStus.add(new Student(5, "Việt", LocalDate.of(1995, 2, 26), 8.2f));
		System.out.println("Danh sách các sinh viên:");
		showAllStu();
	}
	
	public void showAllStu() {
		System.out.println("Danh sách các sinh viên:");
		for (Student st : listOfStus) {
			System.out.println(st);
		}
	}
	
	public void sortByNameDateScore() {
		Collections.sort(listOfStus);
		System.out.println("Danh sách các sinh viên sau khi sắp xếp:");
		showAllStu();
	}
	
}

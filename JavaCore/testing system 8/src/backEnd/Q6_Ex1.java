package backEnd;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import backEnd.Q1_Ex1;
import entity.Student;

public class Q6_Ex1 {
	Map<Integer, String> MapStudents = new HashMap<Integer, String>();
	Q1_Ex1 BE1 = new Q1_Ex1();
	public void taoMapStudent() {
		BE1.khoiTao();
		for (int i = 0; i < BE1.Students.size(); i++) {
			MapStudents.put(Integer.valueOf(BE1.Students.get(i).getId()), BE1.Students.get(i).getName());
		}
		 for (Map.Entry<Integer, String> entry : MapStudents.entrySet()) {
			 System.out.println("ID: " + entry.getKey()+ "& Name: " + entry.getValue() );
		 }
		
	}
	
	public void inRaKey() {
			System.out.println(MapStudents.keySet());
	}
	
	public void inRaValue() {
			System.out.println(MapStudents.values());
	}
	
	public void sortByName() {
		
		Collections.sort(BE1.Students);
		System.out.println("Danh sách sinh viên sắp theo tên");
		for (Student st : BE1.Students) {
			System.out.println(st);
		}
	}
	
	public void convertMapToSet() {
		Set<Student> setStudents = new HashSet<Student>();
		for (Map.Entry<Integer, String> entry : MapStudents.entrySet()) {
			setStudents.add(new Student(entry.getKey().intValue(),entry.getValue()));
		}
		System.out.println("In ra Set mới");
		Iterator<Student> iter = setStudents.iterator();
		for (int i = 0; i < setStudents.size(); i ++) {
			System.out.println(iter.next());
		}
	}
}

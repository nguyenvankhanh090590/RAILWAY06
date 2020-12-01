/**
 * 
 */
package backend;

import entity.Ex1.Student;

public class Ex4_Encapsulation {

	public void question1(){
		Student student1 = new Student("Hiệp", "Ninh Bình");
		student1.setScore(8);
		
		Student student2 = new Student("Hiếu", "Hà Nội");
		student2.setScore(7);
		
		Student stu3 = new Student("Ngọc", "Ninh Thuận");
		
		stu3.setScore(6.5f);
		
		student1.plusScore(1.5f);
		System.out.println(student1);
		System.out.println(student2.toString());
		
	}
	

}

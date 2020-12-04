package backEnd;

import java.time.LocalDate;
import java.util.Scanner;

import entity.Q2.Ex2.Person;
import entity.Q2.Ex2.Student;

public class Ex2_Q2BE_Student extends Ex2_Q2BE_Person {
	@Override
	public void inputInfo() {
		System.out.println("Tạo student mới");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập tên:");
		String name = sc.nextLine();
		System.out.println("Mời nhập giới tính:");
		String gender = sc.nextLine();
		System.out.println("Mời nhập địa chỉ:");
		String address = sc.nextLine();
		System.out.println("Mời nhập ngày sinh (yyyy-MM-dd):");
		LocalDate birthDate = LocalDate.parse(sc.nextLine());
		System.out.println("Mời nhập ID:");
		String id = sc.next();
		System.out.println("Mời nhập email:");
		String email = sc.next();
		System.out.println("Mời nhập điểm trung bình:");
		float avgScore = sc.nextFloat();
		Student st = new Student(name,gender,address,birthDate,id,email,avgScore);
		
		listOfPeople.add(st);
	}
	
	@Override
	public void showInfo() {
		for (Person st :listOfPeople ) {
			System.out.println(((Student)st).toString());
		}
	}
	
	public void xetHB() {
		for (Person st :listOfPeople ) {
			if (((Student)st).getAvgScore() >= 8.0) {
				System.out.println(((Student)st).toString());
			}
		}
	}
	
}

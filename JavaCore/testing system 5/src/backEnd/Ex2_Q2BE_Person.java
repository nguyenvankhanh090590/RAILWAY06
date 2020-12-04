package backEnd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Q2.Ex2.Person;

public class Ex2_Q2BE_Person {
	public ArrayList<Person> listOfPeople = new  ArrayList<Person>();
	
	public void inputInfo() {
		System.out.println("Tạo người dùng mới");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập tên:");
		String name = sc.nextLine();
		System.out.println("Mời nhập giới tính:");
		String gender = sc.nextLine();
		System.out.println("Mời nhập địa chỉ:");
		String address = sc.nextLine();
		System.out.println("Mời nhập ngày sinh (yyyy-MM-dd):");
		LocalDate birthDate = LocalDate.parse(sc.nextLine());
		Person ps = new Person(name,gender,address,birthDate);
		
		listOfPeople.add(ps);
		
	}
	public void showInfo() {
		for (Person ps :listOfPeople ) {
			System.out.println(ps);
		}
	}
	
	
	
	
}
	

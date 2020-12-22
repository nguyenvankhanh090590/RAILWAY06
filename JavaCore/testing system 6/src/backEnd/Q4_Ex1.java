package backEnd;

import entity.Department;

public class Q4_Ex1 {
	static Department dept1 = new Department(1,"dept1");
	static Department dept2 = new Department(2,"dept2");
	static Department dept3 = new Department(3,"dept3");
	static Department[] departments = {dept1,dept2,dept3};
	
	public static void getIndex(int index) {
		System.out.println(departments[index].toString());
	}
}

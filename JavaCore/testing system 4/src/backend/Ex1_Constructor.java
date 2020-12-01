package backend;

import java.time.LocalDateTime;

import entity.Ex1.Account;
import entity.Ex1.Department;
import entity.Ex1.Group;

public class Ex1_Constructor {

	public static void main(String[] args) {
		Q3Ex1();

	}

	// ******************Ex1_Constructor******************

	// Q1: Khởi tạo với mỗi constructor đã thực hiện

	public static void Q1Ex1() {
		Department dept1 = new Department();
		dept1.setId((byte) 1);
		dept1.setName("CEO");

		Department dept2 = new Department("Sale");

		System.out.println(dept1);
		System.out.println(dept2);

	}
	// Q2: Khởi tạo với mỗi constructor đã thực hiện

	public static void Q2Ex1() {
		Department dept1 = new Department();
		dept1.setId((byte) 1);
		dept1.setName("CEO");

		Department dept2 = new Department("Sale");

		Account acc1 = new Account();
		acc1.setId(1);
		acc1.setEmail("cuongnm568@gmail.com");
		acc1.setUsername("cuongnm");
		acc1.setFullName("Nguyễn Mạnh Cường");
		acc1.setDepartmentID(dept1);
		acc1.setPositionID(1);
		acc1.setCreateDate(LocalDateTime.of(2020, 11, 23, 12, 0, 0));

		Account acc2 = new Account(2, "duckdollar9x@gmail.com", "engine194", "Ngọc", "Đắc Nguyễn");

		Account acc3 = new Account(3, "tramnguyen@gmail.com", "tramheo", "Ngọc Trâm", "Nguyễn Thị", 2);

		Account acc4 = new Account(4, "hongga@gmail.com", "hongga1998", "Hồng", "Đắc Nguyễn", 4,
				LocalDateTime.of(2020, 10, 12, 12, 0, 0));

		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println(acc4);
	}
	
	// Q3: Tạo constructor cho Group
	public static void Q3Ex1() {
		Account acc1 = new Account();
		acc1.setId(1);
		acc1.setEmail(null);
		acc1.setUsername("cuongnm");
		acc1.setFullName(null);
		acc1.setDepartmentID(null);
		acc1.setPositionID(0);
		acc1.setCreateDate(null);

		Account acc2 = new Account(2, null, "engine194", null, null);

		Account acc3 = new Account(3, null, "tramheo", null, null, 0);

		
		
		Account[] accOfGr1 = {acc1,acc2};
		Account[] accOfGr2 = {acc2,acc3};
		Account[] accOfGr3 = {acc1,acc2,acc3};
		
		
		
		
		Group gr1 = new Group();
		gr1.setId((short) 1);
		gr1.setName("Java");
		gr1.setAccountIDs(accOfGr1);
		gr1.setCreatorID(acc1);
		gr1.setUsername(acc1);
		gr1.setCreateDate(null);
		
		Group gr2 = new Group("mySQL", acc2,accOfGr2, null);
		Group gr3 = new Group("C#",acc3,acc3,accOfGr3,null);
		
		System.out.println(gr1);
		System.out.println(gr2);
		System.out.println(gr3);
	}
	
	
	
}

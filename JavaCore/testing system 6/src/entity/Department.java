package entity;

import java.util.Scanner;
import backEnd.ScannerUtils;

public class Department {
	int id;
	String name;
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
	
	public Department() {
		this.id = inputID();
		this.name = inputName();
		
	}
	
	private int inputID() {
		System.out.print("Mời nhập ID của phòng ban:");
		return ScannerUtils.inputInt("ID không hợp lệ, mời nhập lại");
	}
	private String inputName() {
		System.out.println("Mời nhập tên phòng ban");
		return ScannerUtils.inputString("Tên không được bỏ trống");
	}
	
}

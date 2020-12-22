package entity.Ex5;

import Utils.ScannerUtils;

public class Student {
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int id;
	private String name;
	
		

	int inputID() {
		System.out.println("Mời nhập ID của student:");
		return ScannerUtils.inputInt("Nhập sai, mời nhập lại");
	}
	String inputName() {
		System.out.println("Mời nhập tên của student:");
		return ScannerUtils.inputString("Mục này không thể bỏ trống, mời nhập lại!");
	}
	public Student() {
		super();
		this.id = inputID();
		this.name = inputName();
	}
}

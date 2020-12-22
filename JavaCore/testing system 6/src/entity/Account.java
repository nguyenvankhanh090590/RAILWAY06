package entity;

import backEnd.ScannerUtils;
import frontEnd.InvalidAgeInputingException;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Account() throws InvalidAgeInputingException {
		super();
		this.id = inputID();
		this.email = inputEmail();
		this.username = inputUsername();
		this.fullName = inputFullName();
		this.age = inputAge();
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", fullName=" + fullName + ", age="
				+ age + "]";
	}
	
	private int inputID() {
		System.out.print("Mời nhập ID của account:");
		return ScannerUtils.inputInt("Nhập sai, mời nhập lại");
	}
	
	private String inputEmail() {
		System.out.print("Mời nhập email của account:");
		return ScannerUtils.inputString("Mục này không được bỏ trống");
	}
	private String inputUsername() {
		System.out.print("Mời nhập username của account:");
		return ScannerUtils.inputString("Mục này không được bỏ trống");
	}
	private String inputFullName() {
		System.out.print("Mời nhập full name của account:");
		return ScannerUtils.inputString("Mục này không được bỏ trống");
	}
	private int inputAge() throws InvalidAgeInputingException {
		while (true) {
			System.out.print("Mời nhập tuổi:");
			int age = ScannerUtils.inputInt("Nhập sai, mời nhập lại");
			try {
				if (age <= 0 ) {
					throw new InvalidAgeInputingException("The age must be greater than 0");
				} else if ( age <18) {
					throw new InvalidAgeInputingException("The age must be greater than 18");
				} else { 	
					return age;
				}
			} catch (InvalidAgeInputingException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
}

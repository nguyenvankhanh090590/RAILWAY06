package entity;

import Utils.ScannerUtils;

public class Student {
	
	private static int moneyGroup = 0;
	public static String college;
	private int id;
	private String name;
	private static int count = 0;
	
	
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Student.count = count;
	}
	public static int getMoneyGroup() {
		return moneyGroup;
	}
	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}
	public static String getCollege() {
		return college;
	}
	public static void setCollege(String college) {
		Student.college = college;
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
	public Student(int id, String name) throws Exception  {
		super();
		Student.count ++;
		this.id = id;
		this.name = name;
		this.checkStu();
	}
	
	
	public Student() throws Exception {
		super();
		count ++;
		this.checkStu();
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college ="+ college + "]";
	}
	
	void checkStu() throws Exception {
		if (Student.count > 7 ) {
			throw new Exception("Số lượng sinh viên không được quá 7!");
		}
	}

}

package entity.Q1.Ex5;

public class CanBo {
	private String fullName;
	private int age;
	private String gender;
	private String address;
	
	
	
	// set toString
	@Override
	public String toString() {
		return "CanBo [fullName=" + fullName + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}


	// Khởi tạo tất cả các thuộc tính
	public CanBo(String fullName, int age, String gender, String address) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	
	// khởi tạo ko thuộc tính nào
	public CanBo() {
		super();
	}
	
	// get & set
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}

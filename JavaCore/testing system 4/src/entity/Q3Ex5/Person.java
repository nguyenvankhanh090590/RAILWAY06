package entity.Q3Ex5;

public abstract class Person {
	private String name;
	// Khởi tạo thuộc tính name
	public Person(String name) {
		super();
		this.name = name;
	}
	
	// Khởi tạo ko thuộc tính nào
	public Person() {
		super();
	}
	// get & set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package entity.Q3Ex5;

public abstract class Student extends Person {
	private int id;

// Khởi tạo 2 thuộc tính id và name
	public Student(String name, int id) {
		super(name);
		this.id = id;
	}

	public Student(String name) {
		super(name);
	}
	// khởi tạo không thuộc tính nào
	public Student() {
	}
// Get & set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}

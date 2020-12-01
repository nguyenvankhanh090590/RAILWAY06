
public class Department {
	byte id;
	String name;

	// khởi tạo các thuộc tính

	public Department(byte id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// Khởi tạo ko thuộc tính
	public Department() {
		super();
	}

	// toString
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}

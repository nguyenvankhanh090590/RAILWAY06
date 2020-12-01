package entity.Ex1;

public class Department {
	private byte id;
	private String name;

	// Tạo constructor ko có thuộc tính
	public Department() {
		super();
	}

	// Tạo constructor có thuộc tính name và default id của department bằng 0
	public Department(String name) {
		super();
		this.name = name;
		this.id = 0;
	}

	// get & set
	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// toString
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}

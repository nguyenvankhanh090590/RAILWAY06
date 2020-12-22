package entity.Ex2;

public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	private final int id = 0;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	public static final void study() {
		System.out.println("Đang học bài ...");
	}
	public Student() {
		super();
	}
	
	
	
}

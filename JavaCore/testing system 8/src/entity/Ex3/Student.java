package entity.Ex3;

public class Student <T extends Number> {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private T id;
	private String name;
	
	public Student(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}

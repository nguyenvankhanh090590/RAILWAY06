package entity;

public class Interview {
	
	private String name;

	@Override
	public String toString() {
		return "Interview [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Interview(String name) {
		super();
		this.name = name;
	}
	
}

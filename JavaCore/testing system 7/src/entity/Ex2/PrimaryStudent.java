package entity.Ex2;

public final class PrimaryStudent extends Student {
	@Override
	public String toString() {
		return "PrimaryStudent [level=" + level + " id=" + getId()+ " name=" + getName() + "]";
	}

	public String level;

	public PrimaryStudent(String name, String str) {
		super(name);
		this.level = str;
	}
	
}

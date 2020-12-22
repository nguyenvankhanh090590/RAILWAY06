package entity.Ex2;

public final class SecondaryStudent extends Student {
	public String clasz;

	public SecondaryStudent(String name, String clasz) {
		super(name);
		this.clasz = clasz;
	}
	@Override
	public String toString() {
		return "SecondaryStudent [clasz=" + clasz + " id=" + getId()+ " name=" + getName() + "]";
	}
}

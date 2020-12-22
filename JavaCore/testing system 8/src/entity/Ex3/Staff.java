package entity.Ex3;

public class Staff<N> extends MyMap<N, String> {
	@Override
	public String toString() {
		return "Staff [getID=" + getID() + ", getName=" + getName() + "]";
	}

	public Staff(N ID, String name) {
		super(ID, name);
	}
	
	public N getID() {
		return getKey();
	}
	public String getName() {
		return getValue();
	}
	
}

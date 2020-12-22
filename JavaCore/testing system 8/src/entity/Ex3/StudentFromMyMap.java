package entity.Ex3;

public class StudentFromMyMap<N> extends MyMap <N, String> {

	@Override
	public String toString() {
		return "StudentFromMyMap [getID=" + getID() + ", getName=" + getName() + "]";
	}

	public StudentFromMyMap(N id, String name) {
		super(id, name);
	}
	
	public N getID() {
		return getKey();
	}
	
	public String getName() {
		return getValue();
	}
	
}

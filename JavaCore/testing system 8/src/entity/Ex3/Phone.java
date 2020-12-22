package entity.Ex3;

public class Phone<K, V> extends MyMap<K, V> {
	@Override
	public String toString() {
		return "Phone [getInput=" + getInput() + ", getPhoneNumber=" + getPhoneNumber() + "]";
	}

	public Phone(K input, V number) {
		super (input, number);
	}
	
	public K getInput() {
		return getKey();
	}
	
	public V getPhoneNumber() {
		return getValue();
	}
	
	
}

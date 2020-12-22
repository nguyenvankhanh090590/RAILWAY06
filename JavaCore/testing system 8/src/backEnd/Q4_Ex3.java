package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Q4_Ex3 {
	public List<Integer> listInts = new ArrayList<Integer>();
	public List<Long> listLongs = new ArrayList<Long>();
	public List<Double> listDoubles = new ArrayList<Double>();
	
	public void khoiTao() {
		listInts.add(new Integer(12345));
		listInts.add(new Integer(23456));
		listLongs.add(new Long(3456789));
		listLongs.add(new Long(4567890));
		listDoubles.add(new Double(5.12345));
		listDoubles.add(new Double(6.54321));
		
	}
	
	public <T> void printArray(List<T> array ) {
		for (T t : array) {
			System.out.println(t);
		}
	}
}

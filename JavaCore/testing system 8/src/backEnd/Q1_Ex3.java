package backEnd;
import java.util.ArrayList;
import java.util.List;

import entity.Ex3.Student;
public class Q1_Ex3 <T extends Number>{
	public List<Student<T>> listStus = new ArrayList<Student<T>>();
	public void khoiTao() {
		Student<Integer> st1 = new Student<Integer>(1, "Bắc");
		Student<Float> st2 = new Student<Float>( 2.0f, "Trung");
		Student<Double> st3 = new Student<Double>(3.0d, "Nam");
		listStus.add((Student<T>) st1);
		listStus.add((Student<T>) st2);
		listStus.add((Student<T>) st3);
		for (Student<T> st : listStus) {
			System.out.println(st);
		}
	}
	
	
	public <T> void print(T o) {
		System.out.println(o);
	}
//	public <T> void print(List<T> input) {
//		for (T t : input) {
//			System.out.println(t);
//		}
//	}
}

package backEnd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import entity.Student;
import backEnd.Q3_Ex1;

public class Q4_Ex1 {
	Q3_Ex1 BE = new Q3_Ex1();
	Set<String> Names = new HashSet<String>();

	public void nameNotInTheSame() {
		BE.khoiTao();
		Iterator<Student> iter = BE.setStudents.iterator();
		int n = BE.setStudents.size();
		for (int i = 0; i < n; i++) {
			String str = new String(iter.next().getName());
			Names.add(str);
		}
		
		Iterator<String> iterNames = Names.iterator();
		n = Names.size();
		System.out.println("Danh sách các tên không trùng nhau:");
		for (int i = 0; i < n; i++) {
			System.out.println(iterNames.next());
		}
	}
	
	public Set<String> setNameNotInTheSame(){
		BE.khoiTao();
		Iterator<Student> iter = BE.setStudents.iterator();
		int n = BE.setStudents.size();
		for (int i = 0; i < n; i++) {
			String str = new String(iter.next().getName());
			Names.add(str);
		}
		return Names;
	}
	
	
	
}

package backEnd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import backEnd.Q4_Ex1;
import entity.Student;
public class Q5_Ex1 {
	Q4_Ex1 BE = new Q4_Ex1();
	
	public void sortUniqeName() {
		ArrayList<String> NamesArray = new ArrayList<>();
		Iterator<String> iterNames = BE.setNameNotInTheSame().iterator();
		for (int i = 0; i < BE.setNameNotInTheSame().size();i++) {
			NamesArray.add(new String(iterNames.next()));
		}
		Collections.sort(NamesArray);
		System.out.println("Tên các sinh viên không trùng lặp sắp theo thứ tự:");
		for (String str : NamesArray) {
			System.out.println(str);
		}
	}
}

package backEnd;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import entity.Interview;

public class Q2_Ex1 {
	List<Interview> listInv = new ArrayList<>();
	public void khoiTao() {
		Interview inv1 = new Interview("Nguyễn Văn Nam");
		Interview inv2 = new Interview("Nguyễn Văn Huyên");
		Interview inv3 = new Interview("Trần Văn Nam");
		Interview inv4 = new Interview("Nguyễn Văn An");
		
		listInv.add(inv1);
		listInv.add(inv2);
		listInv.add(inv3);
		listInv.add(inv4);
		
		for (Interview inv : listInv) {
			System.out.println(inv);
		}
		
	}
	
	public void comeEarly() {
		Queue<Interview> invEarly = new LinkedList<Interview>();
		for (int i = 0; i < listInv.size();i++) {
			invEarly.add(listInv.get(i));
		}
		invEarly.add(new Interview("Lê Thúy Ngân"));
		//System.out.println(invEarly.size());
		System.out.println("Danh sách thí sinh đi từ sớm đến muộn là:");
		int n = invEarly.size();
		for (int i = 0; i < n; i++) {
			System.out.println(invEarly.poll());
		}
		
	}
	
	public void comeLate() {
		Stack<Interview> invLate =  new Stack<Interview>();
		for (int i = 0; i < listInv.size();i++) {
			invLate.push(listInv.get(i));
		}
		invLate.push(new Interview("Lê Thúy Ngân"));
		//System.out.println(invLate.size());
		System.out.println("Danh sách thí sinh đi từ muộn đến sớm là:");
		int n =invLate.size();
		for (int i = 0; i < n ; i++) {
			System.out.println(invLate.pop());
		}
	}
}

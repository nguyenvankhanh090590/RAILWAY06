package frontEnd;

import backEnd.Q1_Ex1;

public class Ex1_Q1_Q2 {

	public static void main(String[] args) {
		
		try {
			System.out.println(Q1_Ex1.devide(7,0));
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		} catch (Exception e) {
		System.out.println(e.toString());
		} finally {
			System.out.println("devide completed!");
		}
		
	}

}

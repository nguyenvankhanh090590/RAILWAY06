package frontEnd;

public class Ex1_Q3 {
	public static void main(String[] args) {
		try {
			int[] numbers  = {1,2,3};
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
	}
}

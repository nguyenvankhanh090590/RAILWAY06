package entity;

public class MyMath {
	public static int findMax(int a, int b) {
		if (a>=b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static int findMin(int a, int b) {
		if (a<=b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static int findSum(int a, int b) {
		return a + b;
	}
	public static final float PI = 3.14f;
	public static float sum(int a) {
		return (float)a + PI;
	}
	
	public static float changePI() {
//		PI = 3.15f;
		return PI;
	}
	
	
	
}

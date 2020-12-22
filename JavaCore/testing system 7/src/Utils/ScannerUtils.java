package Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
	
	public static int inputInt(String messErr) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				return sc.nextInt();
			} catch (Exception e) {
				System.err.println(messErr);
			}
		}
	}
	
		
	public static float inputFloat(String messErr) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				return sc.nextFloat();
			} catch (Exception e) {
				System.err.println(messErr);
			}
		}
	}
	
	public static double inputDouble(String messErr) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				return sc.nextDouble();
			} catch (Exception e) {
				System.err.println(messErr);
			}
		}
	}
	
	public static String inputString(String messErr) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(messErr);
			}
		}
	}
	
	public static LocalDate inputDate(String messErr) {
		while (true) {
			try{
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				return LocalDate.parse(input);
			} catch (Exception e) {
				System.err.println(messErr);
			}
		}
	}
	
}

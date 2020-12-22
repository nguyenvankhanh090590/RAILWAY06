package backEnd;

import java.util.Scanner;

import frontEnd.InvalidAgeInputingException;

public class Q5_Q6_Ex1 {
	public static int inputAge1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào một số nguyên lớn hơn bằng 0:");
		try {
			int n = sc.nextInt();
			if (n >= 0) {
				return n;
			} else {
				System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				return 0;
			}

		} catch (Exception e) {
			System.out.println("wrong inputing! Please input an age as int, input again.");
		}
		return 0;
	}

	private static int inputAge2() {

		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Mời nhập vào một số nguyên lớn hơn bằng 0:");

				int n = sc.nextInt();
				if (n >= 0) {
					return n;
				} else {
					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				}
			} catch (Exception e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	public static void checkAge(int i) throws InvalidAgeInputingException {
		if (i < 18) {
			throw new InvalidAgeInputingException("you are not enough 18!");
		}
	}
}

package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import backEnd.ScannerUtils;
import frontEnd.InvalidAgeInputingException;

public class Group {
	private int id;
	private String name;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private LocalDate createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public ArrayList<Account> addAcc() throws InvalidAgeInputingException {
		boolean bl = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhập một account vào group hiện tại:\n1. Có\n2.Không");
			int n = sc.nextInt();
			if (n == 1) {
				Account acc = new Account();
				accounts.add(acc);
			} else if (n == 2) {
				System.out.println("Group hiện tại");
				
				if (accounts.size() == 0) {
					System.out.println("không có account nào\n");
				} else {
					System.out.println("gồm các Account sau:");
					for (Account acc : accounts) {
						System.out.println(acc.toString());
					}
				}
			}
			System.out.println("Hãy chọn bước tiếp theo:\n1. Quay lại\n2. Thoát");
			n = sc.nextInt();
			if (n == 1) {
				bl = false;
			} else {
				bl = true;
			}
		} while (bl == false);
		return accounts;
	}

	private LocalDate inputDate() {
		System.out.println("Mời nhập ngày (yyyy-MM-dd):");
		return ScannerUtils.inputDate("Nhập sai định dạng, mời nhập lại");
	}

	private int inputID() {
		System.out.print("Mời nhập ID của group:");
		return ScannerUtils.inputInt("Nhập sai, mời nhập lại");
	}

	private String inputName() {
		System.out.print("Mời nhập tên của group:");
		return ScannerUtils.inputString("Mục này không được bỏ trống");
	}

	public Group() throws InvalidAgeInputingException {
		super();
		this.id = inputID();
		this.name = inputName();
		this.createDate = inputDate();
		this.accounts = addAcc();

	}

}

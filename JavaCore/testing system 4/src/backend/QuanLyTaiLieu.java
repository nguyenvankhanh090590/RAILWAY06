package backend;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Q4.Ex5.*;

public class QuanLyTaiLieu {
	ArrayList<TaiLieu> danhSachTL = new ArrayList<TaiLieu>();

	public void addTaiLieu() {
		Scanner sc = new Scanner(System.in);
		TaiLieu tl = new TaiLieu();
		System.out.println("Nhập id:");
		tl.setId(sc.nextInt());
		System.out.println("Nhập tên NXB:");
		sc.nextLine();
		tl.setNXB(sc.nextLine());
		;

		System.out.println("Nhập số phát hành:");
		tl.setNumPub(sc.nextInt());

		danhSachTL.add(tl);
	}

	public void hienThiDanhSachTL() {
		for (TaiLieu tl : danhSachTL) {
			System.out.println(tl);
		}
	}

	public void searchTheoID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		int x = sc.nextInt();
		for (TaiLieu tl : danhSachTL) {
			if (tl.getId() == x) {
				System.out.println(tl);
			}
		}
	}

	public void deleteTL() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		int x = sc.nextInt();
		for (int i = 0; i < danhSachTL.size();) {
			if (danhSachTL.get(i).getId() == x) {
				danhSachTL.remove(i);
			} else {
				i++;
			}
		}
	}

}

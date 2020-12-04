package backEnd;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Q5.Ex1.KhoiA;
import entity.Q5.Ex1.KhoiB;
import entity.Q5.Ex1.KhoiC;
import entity.Q5.Ex1.ThiSinh;

public class Ex1_Q5BE_TuyenSinh implements ITuyenSinh {
	ArrayList<ThiSinh> listOfTSs = new ArrayList<ThiSinh>();

	@Override
	public void addTS() {
		boolean bl = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời nhập khối thi của thí sinh:\nA - Toán Lý Hóa\nB - Toán Hóa Sinh\nC - Văn Sử Địa\nUN - chưa rõ");
			String khoiThi = sc.nextLine();
		
			if (khoiThi.equals("A") || khoiThi.equals("a")) {
				addA();
			} else if (khoiThi.equals("B") || khoiThi.equals("b")) {
				addB();
			} else if (khoiThi.equals("C") || khoiThi.equals("c")) {
				addC();
			} else if (khoiThi.equals("UN") || khoiThi.equals("un") || khoiThi.equals("Un") ) {
				add0();
			} else {
				System.out.println("Khối thi không có trong hệ thống");
			}
			System.out.println("\n1. Tiếp tục thêm thí sinh\n2. Thoát");
			int pp = sc.nextInt();
			if (pp == 1) {
				bl = false;
			} else {
				bl = true;
			}
			
		} while (bl == false);	
	}

	public void addA() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập SBD");
		int sbd = sc.nextInt();
		sc.nextLine();
		System.out.println("Mời nhập họ tên");
		String fullName = sc.nextLine();
		System.out.println("Mời nhập địa chỉ");
		String address = sc.nextLine();
		System.out.println("Mời nhập mức ưu tiên");
		int priolevel = sc.nextInt();

		KhoiA kA = new KhoiA(sbd, fullName, address, priolevel);
		kA.addScore();
		kA.setKhoiThi("Khối A");

		listOfTSs.add(kA);
	}

	public void addB() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập SBD");
		int sbd = sc.nextInt();
		sc.nextLine();
		System.out.println("Mời nhập họ tên");
		String fullName = sc.nextLine();
		System.out.println("Mời nhập địa chỉ");
		String address = sc.nextLine();
		System.out.println("Mời nhập mức ưu tiên");
		int priolevel = sc.nextInt();

		KhoiB kB = new KhoiB(sbd, fullName, address, priolevel);
		kB.addScore();
		kB.setKhoiThi("Khối B");
		listOfTSs.add(kB);
	}
	
	public void add0() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập SBD");
		int sbd = sc.nextInt();
		sc.nextLine();
		System.out.println("Mời nhập họ tên");
		String fullName = sc.nextLine();
		System.out.println("Mời nhập địa chỉ");
		String address = sc.nextLine();
		System.out.println("Mời nhập mức ưu tiên");
		int priolevel = sc.nextInt();
		
		ThiSinh ts = new ThiSinh(sbd, fullName, address, priolevel);
		ts.setKhoiThi("Unknown");
		listOfTSs.add(ts);
	}

	public void addC() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập SBD");
		int sbd = sc.nextInt();
		sc.nextLine();
		System.out.println("Mời nhập họ tên");
		String fullName = sc.nextLine();
		System.out.println("Mời nhập địa chỉ");
		String address = sc.nextLine();
		System.out.println("Mời nhập mức ưu tiên");
		int priolevel = sc.nextInt();

		KhoiC kC = new KhoiC(sbd, fullName, address, priolevel);
		kC.addScore();
		kC.setKhoiThi("Khối C");
		listOfTSs.add(kC);
	}

	@Override
	public void showTS() {
		for (ThiSinh ts : listOfTSs) {
			if (ts.getKhoiThi().equals("Khối A")) {
				System.out.println(((KhoiA)ts).toString());
			} else if (ts.getKhoiThi().equals("Khối B")) {
				System.out.println(((KhoiB)ts).toString());
			} else if (ts.getKhoiThi().equals("Khối C")) {
				System.out.println(((KhoiC)ts).toString());
			} else if (ts.getKhoiThi().equals("Unknown")){
				System.out.println(ts.toString());
			}
		}
	}

	@Override
	public void addScore() {
		boolean bl = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời nhập SBD thí sinh:");
			int sbd = sc.nextInt();
			for (ThiSinh ts : listOfTSs) {
				if (ts.getSbd() == sbd && ts.getKhoiThi().equals("Khối A")) {
					((KhoiA) ts).addScore();
					bl = true;
				} else if (ts.getSbd() == sbd && ts.getKhoiThi().equals("Khối B")) {
					((KhoiB) ts).addScore();
					bl = true;
				} else if (ts.getSbd() == sbd && ts.getKhoiThi().equals("Khối C")) {
					((KhoiC) ts).addScore();
					bl = true;
				} else if (ts.getSbd() == sbd && ts.getKhoiThi().equals("Unknown")) {
					System.out.println("Thí sinh chưa rõ khối thi");
					bl = true;
				}
			}
			if (bl == false) {
				System.out.println("SBD không tồn tại");
			}
			System.out.println("\n1. Tiếp tục chỉnh sửa\n2. Thoát");
			int pp = sc.nextInt();
			if (pp == 1) {
				bl = false;
			} else {
				bl = true;
			}
			
		} while (bl == false);	
	}

	public void menuThiSinh() {
		boolean bl1 = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out
					.println("Mời nhập chức năng:\n1. Thêm mới một thí sinh\n2. Hiển thị thông tin tất cả thí sinh\n3. "
							+ "Thêm điểm hoặc hiệu chỉnh điểm cho thí sinh");
			int pp = sc.nextInt();
			switch (pp) {
			case 1:
				addTS();
				break;
			case 2:
				showTS();
				break;
			case 3:
				addScore();
				break;
			default:
				System.out.println("Chức năng không tồn tại");
			}
			System.out.println("\n1. Chọn chức năng khác\n2. Thoát");
			int ppp = sc.nextInt();
			if (ppp == 1) {
				bl1 = false;
			} else {
				bl1 = true;
			}

		} while (bl1 == false);
	}

}

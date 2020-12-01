package backend;

import java.util.ArrayList;
import java.util.Scanner;
import enity.Q1.Ex5.*;

public class QuanLyCanBo {
	ArrayList<CanBo> danhsachcanbo = new ArrayList<CanBo>();
	public void addCanBo() {
		Scanner sc = new Scanner(System.in);
		CanBo cb = new CanBo();
		System.out.println("Nhập họ và tên:");
		cb.setFullName(sc.nextLine());
		System.out.println("Nhập tuổi:");
		cb.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập giới tính:");
		cb.setGender(sc.nextLine());
		System.out.println("Nhập địa chỉ:");
		cb.setAddress(sc.nextLine());
		
		danhsachcanbo.add(cb);
	}
	
	public void hienThiDanhSachCanBo() {
		for (CanBo canBo : danhsachcanbo) {
			System.out.println(canBo.toString());
		}
	}
	
	public void searchTheoTen(String name) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ và tên cán bộ muốn tra cứu:");
		for (CanBo CB : danhsachcanbo) {
			if (CB.getFullName().equals(name)) {
				System.out.println(CB);				
			}
		}
	}
	
	public void deleteCB() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ và tên cán bộ muốn xóa:");
		String fullName = sc.nextLine();
		
		for(int i =0; i < danhsachcanbo.size(); ) {
			if(danhsachcanbo.get(i).getFullName().equals(fullName)) {
				danhsachcanbo.remove(i);
			} else {
				i++;
			}
		}
	}
}

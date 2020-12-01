package frontend;

import backend.QuanLyCanBo;

public class program5 {

	public static void main(String[] args) {
		
		
		QuanLyCanBo qlcb = new QuanLyCanBo();
		qlcb.addCanBo();
		qlcb.addCanBo();
		qlcb.addCanBo();
		
		qlcb.hienThiDanhSachCanBo();
		qlcb.deleteCB();
		qlcb.hienThiDanhSachCanBo();
		
	}

}

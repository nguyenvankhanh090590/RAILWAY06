package frontEnd;
import entity.Ex3.NgayThangNam;
import entity.Ex3.NgayThangNam.GioPhutGiay;
public class Ex3_Q4 {

	public static void main(String[] args) {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 13;
		date.thang = 12;
		date.nam = 2020;
		
		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 16;
		time.phut = 50;
		time.giay = 9;
		
		time.xuatThongTin();
		
	}

}

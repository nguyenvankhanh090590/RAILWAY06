import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		Q7Ex5();
	}

	// *************Ex1_DataTypeCasting*****************

	// Q1: Khai báo 2 số lương có kiểu dữ liệu là float.
	// Khởi tạo Lương của Account 1 là 5240.5 $
	// Khởi tạo Lương của Account 2 là 10970.055$
	// Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
	// Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

	public static void Q1Ex1() {
		System.out.println("Question 1 Ex1\n");
		float f1 = 5240.5f;
		float f2 = 10970.055f;

		int in1 = (int) Math.round(f1);
		int in2 = (int) Math.round(f2);
		System.out.println("Lương của Account1 là: " + in1);
		System.out.println("Lương của Account 2 là: " + in2);

	}

	// Q2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
	// có số 0 ở đầu cho đủ 5 chữ số)

	public static int Q2Ex1() {
		System.out.println("Question 2 Ex1\n");
		Random rd = new Random();
		int in1 = rd.nextInt(100000);
		System.out.printf("%05d", in1);
		return in1;

	}

	// Q3: Lấy 2 số cuối của số ở Question 2 và in ra.
	// Gợi ý:
	// Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
	// Cách 2: chia lấy dư số đó cho 100

	public static void Q3Ex1() {
		System.out.println("Question 3 Ex1\n");
		int in1 = Q2Ex1();
		System.out.println("Hai số cuối là:" + (in1 % 100));
	}

	public static void Q3_1Ex1() {
		System.out.println("Question 3 Ex1\n");
		Integer in1 = Q2Ex1();
		String castToString = in1.toString();
		String subStr = castToString.substring(3, 5);
		System.out.println("\nHai số cuối là: " + subStr);
	}

	// Q4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng

	public static float Q4Ex1() {

		Scanner sc4 = new Scanner(System.in);
		System.out.println("Mời nhập số nguyên a: ");
		int a = sc4.nextInt();
		System.out.println("Mời nhập số nguyên b: ");
		int b = sc4.nextInt();
		float f = (float) a / b;
		System.out.println("Thương của a/b là: " + f);
		return f;
	}

	// ****************Ex2_DefaultValue******************

	// Q1: Question 1:
	// Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
	// tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
	// Email: "Email 1"
	// Username: "User name 1"
	// FullName: "Full name 1"
	// CreateDate: now
	public static void Q1Ex2() {

		System.out.println("Question 1 Ex2\n");
		Account[] insertAcc = new Account[5];
		for (int i = 0; i < 5; i++) {
			insertAcc[i] = new Account();
			insertAcc[i].id = i + 1;
			insertAcc[i].email = "Email " + (i + 1);
			insertAcc[i].username = "Username " + (i + 1);
			insertAcc[i].fullName = "Full name " + (i + 1);
			insertAcc[i].createDate = LocalDate.now();
		}

		for (Account q1 : insertAcc) {
			System.out.println("Account ID: " + q1.id);
			System.out.println("Email: " + q1.email);
			System.out.println("Username: " + q1.username);
			System.out.println("Full name: " + q1.fullName);
			System.out.println("Create Date: " + q1.createDate);
			System.out.println("\n");
		}
	}

	// ***************Ex3_BoxingAndUnboxing******************

	// Q1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
	// Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
	// float có 2 số sau dấu thập phân)

	public static void Q1Ex3() {
		Integer salaryInt = 5000;
		float salaryF = (float) salaryInt;

		System.out.printf("%s: %.2f $", "Lương của nhân viên", salaryF);
	}

	// Q2: Khai báo 1 String có value = "1234567"
	// Hãy convert String đó ra số int

	public static void Q2Ex3() {

		String str = "1234567";
		int in = Integer.parseInt(str);
		System.out.println("Đã cast thành công chuỗi thành số " + in);
	}

	// Q3: Khởi tạo 1 số Integer có value là chữ "1234567"
	// Sau đó convert số trên thành datatype int

	public static void Q3Ex3() {

		Integer In = Integer.parseInt("1234567");
		int in = In.intValue();
		System.out.println("Đã cast thành công " + in + " sang kiểu int");
	}

	// ***************Ex4_String*******************

	// Q1: Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
	// thể cách nhau bằng nhiều khoảng trắng );
	public static void Q1Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời in ra một show ký tự:");
		String nhapchuoi = sc.nextLine();

		char space = ' ';
		char tab = '	';
		char enter = '\n';

		int n = nhapchuoi.length();
		int countLetter;
		if (nhapchuoi.charAt(0) == space || nhapchuoi.charAt(0) == tab || nhapchuoi.charAt(0) == enter) {
			countLetter = 0;
		} else {
			countLetter = 1;
		}
		boolean bl = false;
		for (int i = 0; i < n; i++) {
			char letter = nhapchuoi.charAt(i);
			if (letter != space && letter != tab && letter != enter) {
				if (bl == true) {
					countLetter = countLetter + 1;
				}
				bl = false;
			} else {
				bl = true;
			}
		}
		System.out.println("Show có " + countLetter + " từ");
	}
	// Q2: Nhập hai show ký tự s1, s2 nối show ký tự s2 vào show s1

	public static void Q2Ex4() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập show s1: ");
		String s1 = sc.nextLine();
		System.out.println("Mời nhập show s2: ");
		String s2 = sc.nextLine();

		String s3 = s1.concat(s2);
		System.out.println("Đã nối thành công s2 vào s1 và ta có:");
		System.out.println(s3);
	}

	// Q3: Viết chương trình để người dùng nhập vào tên
	// và kiểm tra, nếu tên chưa viết hoa chữ cái đầu thì
	// viết hoa lên

	public static void Q3Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời nhập vào họ và tên: ");
		String nhapchuoi = new String(sc.nextLine());

		char space = ' ';

		int n = nhapchuoi.length();
		int countLetter;
		if (nhapchuoi.charAt(0) == space) {
			countLetter = 0;
		} else {
			countLetter = 1;
		}
		boolean bl = false;

		if (nhapchuoi.charAt(0) != space) {
			nhapchuoi = nhapchuoi.substring(0, 1).toUpperCase() + nhapchuoi.substring(1, n);
		}
		for (int i = 0; i < n; i++) {
			char letter = nhapchuoi.charAt(i);
			if (letter != space) {
				if (bl == true) {
					countLetter = countLetter + 1;
					nhapchuoi = nhapchuoi.substring(0, i) + nhapchuoi.substring(i, i + 1).toUpperCase()
							+ nhapchuoi.substring(i + 1, n);
				}
				bl = false;
			} else {
				bl = true;
			}
			if (nhapchuoi.charAt(0) == space && countLetter == 1 && bl == true) {
				nhapchuoi = nhapchuoi.substring(0, i) + nhapchuoi.substring(i, i + 1).toUpperCase()
						+ nhapchuoi.substring(i + 1, n);
			}
		}
		// gọt đầu

		if (nhapchuoi.charAt(0) == space) {
			countLetter = 0;
		} else {
			countLetter = 1;
		}
		bl = false;

		for (int i = 0; i < n; i++) {
			char letter = nhapchuoi.charAt(i);
			if (letter != space) {
				if (bl == true) {
					countLetter = countLetter + 1;
					if (countLetter == 1) {
						nhapchuoi = nhapchuoi.substring(i, n);
						break;
					}
				}
				bl = false;
			} else {
				bl = true;
			}

		}
		System.out.println("Họ và tên đã được kiểm tra và tự động đổi thành:");
		System.out.println(nhapchuoi);

	}

	// Q4: Viết chương trình để người dùng nhập vào tên in từng ký tự trong
	// tên của người dùng ra

	public static void Q4Ex4() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào tên của bạn:");
		String name = sc.next();
		int n = name.length();
		name = name.toUpperCase();
		for (int i = 0; i < n; i++) {
			System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
		}
	}
	// Q5: Viết chương trình để người dùng nhập vào họ
	// sau đó yêu cầu người dùng nhập vào tên và hệ thống
	// sẽ in ra họ và tên đầy đủ

	public static void Q5Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào họ của bạn:");
		String family = new String(sc.nextLine());
		System.out.println("Mời nhập vào tên của bạn:");
		String name = new String(sc.nextLine());
		String fullName = family.concat(" " + name);
		System.out.println("Họ tên của bạn là: " + fullName);
	}
	// Q6: Viết chương trình yêu cầu người dùng nhập vào họ tên đầy đủ và
	// sau đó hệ thống sẽ tách ra họ, tên, tên đệm

	public static void Q6Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào họ tên đầy đủ của bạn:");
		String fullName = sc.nextLine();
		fullName = fullName.trim();
		String[] fullNameSplit = fullName.split(" ");
		int n = fullNameSplit.length;
		System.out.println("Họ là: " + fullNameSplit[0]);
		System.out.print("Tên đệm là: ");
		for (int i = 1; i < n - 1; i++) {
			System.out.print(fullNameSplit[i] + " ");
		}
		System.out.println("\nTên là: " + fullNameSplit[n - 1]);
	}

	// Q7: Viết chương trình yêu cầu người dùng nhập vào họ và tên
	// đầy đủ và chuẩn hóa họ và tên của họ.

	public static void Q7Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào họ và tên:");
		String fullName = sc.nextLine();
		fullName = fullName.trim();
		String[] fullNames = fullName.split(" ");
		int n = fullNames.length;

		String fNset = fullNames[0].substring(0, 1).toUpperCase() + fullNames[0].substring(1);

		for (int i = 1; i < n - 1; i++) {
			fNset = fNset + " " + fullNames[i].substring(0, 1).toUpperCase() + fullNames[i].substring(1);
		}

		fNset = fNset + " " + fullNames[n - 1].substring(0, 1).toUpperCase() + fullNames[n - 1].substring(1);

		System.out.println("Họ và tên đã được tự động chuẩn hóa thành:\n" + fNset);
	}

	// Q8: In tất cả các group có chứa chữ "Java"

	public static void Q8Ex4() {
		String[] groupNames = { "Java cơ bản", "Java nâng cao", "SQL nâng cao", "Rocket01" };
		System.out.println("Các group có chứa từ 'Java' là:");
		for (String grN : groupNames) {
			if (grN.contains("Java") || grN.contains("java")) {
				System.out.println(grN);
			}
		}
	}

	// Q9: In ra tất cả các group Java

	public static void Q9Ex4() {
		String[] groupNames = { "Java", "Angular", "mySQL", "C#" };
		for (String grN : groupNames) {
			if (grN.equals("Java") || grN.equals("java")) {
				System.out.println(grN);
			}
		}
	}

	// Q10: Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không

	public static void Q10Ex4() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào chuỗi cần so sánh:");
		String s1 = sc.nextLine();
		System.out.println("Mời nhập vào chuỗi tham chiếu:");
		String s2 = sc.nextLine();

		// tìm chuỗi đảo ngược của s1

		String s1revs = "";
		int n = s1.length();
		for (int i = 0; i < n; i++) {
			s1revs = s1revs + s1.substring(n - 1 - i, n - i);
		}

		if (s1revs.equals(s2)) {
			System.out.println("Hai chuỗi là đảo ngược của nhau");
		} else {
			System.out.println("Hai chuỗi không là đào ngược của nhau");
		}
	}

	// Q11: Count special Character
	// Tìm số lần xuất hiện ký tự "a" trong chuỗi

	// Nếu yêu cầu đếm số chữ 'a' trong chuỗi
	public static void Q11Ex4_demo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào một chuỗi:");
		String s1 = sc.nextLine();
		int count_a = 0;
		char a = 'a';
		char a1 = 'à';
		char a2 = 'á';
		char a3 = 'ả';
		char a4 = 'ã';
		char a5 = 'ạ';
		char A = 'A';
		char A1 = 'À';
		char A2 = 'Á';
		char A3 = 'Ả';
		char A4 = 'Ã';
		char A5 = 'Ạ';
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == a || s1.charAt(i) == a1 || s1.charAt(i) == a2 || s1.charAt(i) == a3
					|| s1.charAt(i) == a4 || s1.charAt(i) == a5 || s1.charAt(i) == A || s1.charAt(i) == A1
					|| s1.charAt(i) == A2 || s1.charAt(i) == A3 || s1.charAt(i) == A4 || s1.charAt(i) == A5) {
				count_a = count_a + 1;
			}
		}
		System.out.println("Chuỗi có " + count_a + " chữ 'a'");
	}

	public static void Q11Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào một chuỗi:");
		String s1 = sc.nextLine();
		int count_a = 0;
		char a = 'a';

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == a) {
				count_a = count_a + 1;
			}
		}
		System.out.println("Chuỗi có " + count_a + " ký tự 'a'");
	}

	// Q12: Reverse String
	// Đảo ngược chuỗi sử dụng vòng lặp
	public static void Q12Ex4() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào chuỗi cần reverse:");
		String s1 = sc.nextLine();

		String s1revs = "";
		int n = s1.length();
		for (int i = 0; i < n; i++) {
			s1revs = s1revs + s1.substring(n - 1 - i, n - i);
		}
		System.out.println(s1revs);
	}

	// Q13: String not contains digit
	// Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
	// lại true.

	public static void Q13Ex4() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập vào chuỗi cần kiểm tra:");
		String s1 = sc.nextLine();

		boolean haveNum = false;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
				haveNum = true;
				break;
			}
		}
		System.out.println("Tình trạng chuỗi chứa số: " + haveNum);
	}

	// Q14: Replace character
	// Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
	// cho trước.

	public static void Q14Ex4() {
		String s1 = "Học viện VTI Academy";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == 'c') {
				s1 = s1.subSequence(0, i) + "*" + s1.substring(i + 1);
			}
		}
		System.out.println("Chuỗi được chuyển thành: " + s1);
	}

	// Q15: Revert string by word
	// Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
	// thư viện.

	public static void Q15Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập một chuỗi:");
		String s1 = sc.nextLine();
		s1 = s1.trim();
		String[] s1Splited = s1.split(" ");
		String s2 = "";
		int n = s1Splited.length;
		for (int i = 0; i < n; i++) {
			s2 = s2 + " " + s1Splited[n - 1 - i];
		}
		s2 = s2.trim();
		System.out.println("Chuỗi được revert thành: " + s2);

	}

	// Q16: Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
	// bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
	// hình “KO”.

	public static void Q16Ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập một chuỗi:");
		String s1 = sc.nextLine();
		System.out.print("Mời nhập một số nguyên dương: ");
		int n = sc.nextInt();
		int m = s1.length();
		if (m % n == 0) {
			for (int i = 0; i < m / n; i++) {
				System.out.println(s1.substring(i * n, (i + 1) * n));
			}
		} else {
			System.out.println("KO");
		}
	}

	// *****************Ex5_Object's Method ****************

	public static Department[] insertDept() {
		Department dept1 = new Department((byte) 1, "Waiting room");
		Department dept2 = new Department((byte) 2, "Marketing");
		Department dept3 = new Department((byte) 3, "Sale");
		Department dept4 = new Department((byte) 4, "Boss of director");
		Department dept5 = new Department((byte) 5, "Sercurity");

		Department[] deptList = { dept1, dept2, dept3, dept4, dept5 };
		return deptList;
	}

	// Q1: In ra thông tin của phòng ban thứ 1

	public static void Q1Ex5() {
		Department[] deptList = insertDept();
		for (Department dept : deptList) {
			if (dept.id == 1) {
				System.out.println(dept.toString());
				break;
			}
		}

	}

	// Q2: In ra thông tin của tất cả các phòng ban
	public static void Q2Ex5() {

		Department[] deptList = insertDept();
		for (Department dept : deptList) {
			System.out.println(dept);
		}
	}
	// Q3: In ra địa chỉ của phòng ban thứ nhất

	public static void Q3Ex5() {

		Department[] deptList = insertDept();
		for (Department dept : deptList) {
			if (dept.id == 1) {
				System.out.println(dept.hashCode());
			}
		}
	}

	// Q4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không

	public static void Q4Ex5() {
		Department[] deptList = insertDept();
		if (deptList[1].name.equals("Phòng A")) {
			System.out.println("Phòng ban 1 là Phòng A");
		} else {
			System.out.println("Phòng ban 1 không phải là Phòng A");
		}
	}

	// Q5: Kiểm tra xem phòng ban thứ nhất và phòng ban thứ 2 xem có bằng
	// nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)

	public static boolean equalByName(Department dept1, Department dept2) {

		if (dept1.name.equals(dept2.name)) {
			return true;
		} else {
			return false;
		}
	}

	public static void Q5Ex5() {

		Department[] deptList = insertDept();
		if (equalByName(deptList[0], deptList[1])) {
			System.out.println("Phòng ban 1 giống phòng ban 2");
		} else {
			System.out.println("Phòng ban 1 khác phòng ban 2");
		}
	}

	// Q6: Khởi tạo một array phòng ban gồm 5 phòng ban,
	// sau đó in ra danh sách phòng ban theo thứ tự tăng dần
	// theo tên

	public static void Q6Ex5() {
		Department[] deptList = insertDept();
		for (Department dept : deptList) {
			dept.name = dept.name.trim();
		}

		// order by first letter of list dept
		String firstLti;
		String firstLtj;
		Department temp;

		for (int i = 0; i < deptList.length; i++) {
			for (int j = 0; j < (deptList.length - 1); j++) {

				if (deptList[i].name == null) {
					firstLti = null;
				} else {
					firstLti = deptList[i].name.substring(0, 1);
				}

				if (deptList[j].name == null) {
					firstLtj = null;
				} else {
					firstLtj = deptList[j].name.substring(0, 1);
				}

				if (firstLti.compareToIgnoreCase(firstLtj) < 0) {
					temp = deptList[i];
					deptList[i] = deptList[j];
					deptList[j] = temp;

				}
			}
		}

		// in ra kết quả
		for (Department dept : deptList) {
			System.out.println(dept.name);
		}
	}

	// Q7: Khởi tạo một array gồm 5 phòng ban, sau đó in ra danh sách phòng ban được
	// sắp xếp theo tên đầu tiên.

	public static void Q7Ex5() {
		Department[] deptList = insertDept();
		for (Department dept : deptList) {
			dept.name = dept.name.trim();
		}

		// order by first letter of list dept

		String firstLt_i_words;
		String firstLt_j_words;
		Department temp;

		for (int i = 0; i < deptList.length; i++) {
			for (int j = 0; j < (deptList.length - 1); j++) {

				if (deptList[i].name == null) {
					firstLt_i_words = null;
				} else {
					String[] i_words = deptList[i].name.split(" ");
					firstLt_i_words = i_words[i_words.length - 1].substring(0, 1);
				}

				if (deptList[j].name == null) {
					firstLt_j_words = null;
				} else {
					String[] j_words = deptList[j].name.split(" ");
					firstLt_j_words = j_words[j_words.length - 1].substring(0, 1);
				}

				if (firstLt_i_words.compareToIgnoreCase(firstLt_j_words) < 0) {
					temp = deptList[i];
					deptList[i] = deptList[j];
					deptList[j] = temp;

				}
			}
		}

		// in ra kết quả
		for (Department dept : deptList) {
			System.out.println(dept.name);
		}
	}

}

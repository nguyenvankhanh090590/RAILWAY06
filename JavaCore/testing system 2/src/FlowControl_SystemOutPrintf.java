import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class FlowControl_SystemOutPrintf {

	public static void main(String[] args) {
		// ****************** insert data into tables *****************

		// table Department
		Department dept1 = new Department();
		dept1.id = 1;
		dept1.name = "CEO";

		Department dept2 = new Department();
		dept2.id = 2;
		dept2.name = "General";

		Department dept3 = new Department();
		dept3.id = 3;
		dept3.name = "Sale";

		// table Position
		Position pot1 = new Position();
		pot1.id = 1;
		pot1.name = Position_name.DEV;

		Position pot2 = new Position();
		pot2.id = 2;
		pot2.name = Position_name.TEST;

		Position pot3 = new Position();
		pot3.id = 3;
		pot3.name = Position_name.PM;

		// table Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "cuongnm058@gmail.com";
		acc1.fullName = "Nguyễn Mạnh Cường";
		acc1.username = "cuongnm058";
		acc1.departmentID = dept1;
		acc1.positionID = pot3;
		acc1.createDate = LocalDateTime.of(2017, 12, 27, 14, 15, 12);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "tramnguyen@gmail.com";
		acc2.fullName = "Nguyễn Thị Ngọc Trâm";
		acc2.username = "tramnguyen";
		acc2.departmentID = dept2;
		acc2.positionID = pot2;
		acc2.createDate = LocalDateTime.of(2018, 04, 20, 15, 8, 0);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "engine194@icloud.com";
		acc3.fullName = "Nguyễn Đắc Ngọc";
		acc3.username = "Engine194";
		acc3.departmentID = dept3;
		acc3.positionID = pot1;
		acc3.createDate = LocalDateTime.of(2020, 10, 28, 10, 25, 0);

		// table Group
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "Gà quay";
		gr1.creatorID = acc2;
		gr1.createDate = LocalDateTime.of(2020, 11, 15, 9, 43, 0);
		Account[] gr_array1 = { acc1, acc2 };
		gr1.accountIDs = gr_array1;

		Group gr2 = new Group();
		gr2.id = 2;
		gr2.name = "Vịt quay";
		gr2.creatorID = acc3;
		gr2.createDate = LocalDateTime.of(2020, 11, 13, 9, 50, 0);
		Account[] gr_array2 = { acc3, acc2 };
		gr2.accountIDs = gr_array2;

		Group gr3 = new Group();
		gr3.id = 3;
		gr3.name = "Heo nướng";
		gr3.creatorID = acc1;
		gr3.createDate = LocalDateTime.of(2020, 11, 11, 10, 8, 0);
		Account[] gr_array3 = { acc1, acc2, acc3 };
		gr3.accountIDs = gr_array3;

		Group[] groupOfAcc1 = { gr1, gr3 };
		acc1.groups = groupOfAcc1;

		Group[] groupOfAcc2 = { gr1, gr2, gr3 };
		acc2.groups = groupOfAcc2;

		Group[] groupOfAcc3 = { gr2, gr3 };
		acc3.groups = groupOfAcc3;

		// skip on table GroupAccount

		// table TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;

		// table CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.categoryName = "Java";

		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.categoryName = "mySQL";

		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 3;
		cate3.categoryName = ".NET";

		// table Question
		Question ques1 = new Question();
		ques1.id = 1;
		ques1.content = "Câu hỏi về mySQL";
		ques1.categoryID = cate2;
		ques1.creatorID = acc1;
		ques1.createDate = LocalDateTime.of(2020, 10, 15, 11, 49, 0);
		ques1.typeID = type1;

		Question ques2 = new Question();
		ques2.id = 2;
		ques2.content = "Câu hỏi về .NET";
		ques2.categoryID = cate3;
		ques2.creatorID = acc2;
		ques2.createDate = LocalDateTime.of(2020, 9, 30, 16, 22, 0);
		ques2.typeID = type1;

		Question ques3 = new Question();
		ques3.id = 3;
		ques3.content = "Câu hỏi về Java";
		ques3.categoryID = cate1;
		ques3.creatorID = acc3;
		ques3.createDate = LocalDateTime.of(2020, 10, 10, 20, 30, 0);
		ques3.typeID = type2;

		// table Answer
		Answer an1 = new Answer();
		an1.id = 1;
		an1.content = "Câu trả lời cho mySQL";
		an1.questionID = ques1;
		an1.isCorrect = true;

		Answer an2 = new Answer();
		an2.id = 2;
		an2.content = "Câu trả lời cho Java";
		an2.questionID = ques3;
		an2.isCorrect = false;

		Answer an3 = new Answer();
		an3.id = 3;
		an3.content = "Câu trả lời cho .NET";
		an3.questionID = ques2;
		an3.isCorrect = true;

		// table Exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "A00215";
		exam1.title = "Đề thi về mySQL và Java";
		exam1.categoryID = 1;
		exam1.duration = 30;
		exam1.creatorID = acc2;
		exam1.createDate = LocalDateTime.of(2020, 11, 02, 15, 14, 0);
		Question[] quess1 = { ques1, ques3 };
		exam1.questionIDs = quess1;

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "B00217";
		exam2.title = "Đề thi về Java và .NET";
		exam2.categoryID = 2;
		exam2.duration = 60;
		exam2.creatorID = acc3;
		exam2.createDate = LocalDateTime.of(2020, 11, 03, 12, 07, 0);
		Question[] quess2 = { ques2, ques3 };
		exam2.questionIDs = quess2;

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "A00307";
		exam3.title = "Đề thi về mySQL và .NET";
		exam3.categoryID = 4;
		exam3.duration = 120;
		exam3.creatorID = acc1;
		exam3.createDate = LocalDateTime.of(2020, 11, 04, 8, 19, 0);
		Question[] quess3 = { ques1, ques2 };
		exam3.questionIDs = quess3;

		// skip on table ExamQuestion

		// **************IF**************

//				Q1: Kiểm tra account thứ 2
//				Nếu không có phòng ban (tức là department == null) thì sẽ in ra
//				text "Nhân viên này chưa có phòng ban"
//				Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là
//				..."
		System.out.println("Question 1: kiểm tra nhân viên số 2");
		if (acc2.departmentID == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + acc2.departmentID.name);
		}
		System.out.println("\n");

//				Q2: Kiểm tra account thứ 2,
//				Nếu không có group thì sẽ in ra text "Nhân viên này chưa có
//				group"
//				Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của
//				nhân viên này là Java Fresher, C# Fresher"
//				Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là
//				người quan trọng, tham gia nhiều group"
//				Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên
//				này là người hóng chuyện, tham gia tất cả các group"
		System.out.println("Question 2: kiểm tra nhân viên số 2");
		if (acc2.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (acc2.groups.length == 1 || acc2.groups.length == 2) {
			System.out.println("Group của nhân viên này là:");
			for (Group group : acc2.groups) {
				System.out.println(group.name);
			}
		} else if (acc2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if (acc2.groups.length == 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println("\n");

//				Q3: Sử dụng toán tử ternary để làm Question 1

		System.out.println("Question 3");
		System.out.println((acc2.departmentID == null) ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là: " + acc2.departmentID.name);
		System.out.println("\n");

//				Q4: Sử dụng toán tử ternary để làm yêu cầu sau:
//					Kiểm tra Position của account thứ 1
//					Nếu Position = Dev thì in ra text "Đây là Developer"
//					Nếu không phải thì in ra text "Người này không phải là
//					Developer"
		System.out.println("Question 4");
		System.out.println(
				(acc1.positionID.name == Position_name.DEV) ? "Đây là Developer" : "Người này không phải là Developer");
		System.out.println("\n");

		// **************SWITCH CASE**************

//				Q5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//				Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//				Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//				Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//				Còn lại in ra "Nhóm có nhiều thành viên"

		System.out.println("Question 5");
		switch (gr1.accountIDs.length) {
		case 0:
			System.out.println("Nhóm không có thành viên nào");
			break;
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
		System.out.println("\n");

//				Q6: Sử dụng switch case để làm lại Question 2

		System.out.println("Question 6");
		switch (acc2.groups.length) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
		case 2:
			System.out.println("Group của nhân viên này là:");
			for (Group group : acc2.groups) {
				System.out.println(group.name);
			}
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println("\n");

//				Q7: Sử dụng switch case để làm lại Question 4

		System.out.println("Question 7");
		switch (acc1.positionID.name) {
		case DEV:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}
		System.out.println("\n");

		// **************FOR-EACH**************

//				Q8: in ra thông tin các account bao gồm: Email, FullName và tên
//				phòng ban của họ

		System.out.println("Question 8");
		Account[] acc_array = { acc1, acc2, acc3 };
		int x8 = 1;
		for (Account q8 : acc_array) {
			System.out.println("Thông tin tài khoản số " + x8);
			System.out.println("Email: " + q8.email);
			System.out.println("Full name: " + q8.fullName);
			System.out.println("Phòng ban: " + q8.departmentID.name);
			x8++;
			System.out.println("\n");
		}

//				Q9: in ra thông tin các phòng ban bao gồm: id và name

		System.out.println("Question 9");
		Department[] dept_array = { dept1, dept2, dept3 };
		int x9 = 1;
		for (Department q9 : dept_array) {
			System.out.println("Thông tin phòng ban số " + x9);
			System.out.println("ID của phòng ban: " + q9.id);
			System.out.println("Tên phòng ban: " + q9.name);
			x9++;
			System.out.println("\n");
		}

		// **************FOR**************
//				Q10: in ra thông tin các account bao gồm: Email, FullName và tên
//				phòng ban của họ theo định dạng cho trước

		System.out.println("Question 10");
		for (int x10 = 1; x10 <= acc_array.length; x10++) {
			System.out.println("Thông tin account thứ " + x10 + " là:");
			System.out.println("Email: " + acc_array[x10 - 1].email);
			System.out.println("Full name: " + acc_array[x10 - 1].fullName);
			System.out.println("Department: " + acc_array[x10 - 1].departmentID.name);
			System.out.println("\n");
		}

//				Q11: in ra thông tin các phòng ban bao gồm: id và name theo định
//				dạng cho trước

		System.out.println("Question 11");
		for (int x11 = 1; x11 <= dept_array.length; x11++) {
			System.out.println("Thông tin department thứ " + x11 + " là:");
			System.out.println("Id: " + dept_array[x11 - 1].id);
			System.out.println("Name: " + dept_array[x11 - 1].name);
			System.out.println("\n");
		}

//				Q12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như
//				Question 11

		System.out.println("Question 12");
		for (int x12 = 1; x12 <= 2; x12++) {
			System.out.println("Thông tin department thứ " + x12 + " là:");
			System.out.println("Id: " + dept_array[x12 - 1].id);
			System.out.println("Name: " + dept_array[x12 - 1].name);
			System.out.println("\n");
		}

//				Q13: in ra thông tin tất cả các account ngoại trừ account thứ 2

		System.out.println("Question 13");
		for (int x13 = 1; x13 <= acc_array.length; x13++) {
			if (acc_array[x13 - 1].id == 2) {
				continue;
			}
			System.out.println("Thông tin account thứ " + x13 + " là:");
			System.out.println("Email: " + acc_array[x13 - 1].email);
			System.out.println("Full name: " + acc_array[x13 - 1].fullName);
			System.out.println("Department: " + acc_array[x13 - 1].departmentID.name);
			System.out.println("\n");
		}

//				Q14: in ra thông tin tất cả các account có id < 4

		System.out.println("Question 14");
		for (int x14 = 1; x14 <= acc_array.length; x14++) {
			if (acc_array[x14 - 1].id >= 4) {
				break;
			}
			System.out.println("Thông tin account thứ " + x14 + " là:");
			System.out.println("Email: " + acc_array[x14 - 1].email);
			System.out.println("Full name: " + acc_array[x14 - 1].fullName);
			System.out.println("Department: " + acc_array[x14 - 1].departmentID.name);
			System.out.println("\n");
		}

//				Q15: in ra các số chẵn nhỏ hơn hoặc bằng 20

		System.out.println("Question 15");
		for (int x15 = 0; x15 <= 20; x15 = x15 + 2) {
			System.out.println(x15);
		}

		// **************WHILE**************

//				Q16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE
//				kết hợp với lệnh break, continue

//				Q16.10

		System.out.println("Question 16.10");
		int x16_10 = 1;
		while (x16_10 <= acc_array.length) {
			System.out.println("Thông tin account thứ " + x16_10 + " là:");
			System.out.println("Email: " + acc_array[x16_10 - 1].email);
			System.out.println("Full name: " + acc_array[x16_10 - 1].fullName);
			System.out.println("Department: " + acc_array[x16_10 - 1].departmentID.name);
			System.out.println("\n");
			x16_10++;
		}

//				Q16.11

		System.out.println("Question 16.11");
		int x16_11 = 1;
		while (x16_11 <= dept_array.length) {
			System.out.println("Thông tin department thứ " + x16_11 + " là:");
			System.out.println("Id: " + dept_array[x16_11 - 1].id);
			System.out.println("Name: " + dept_array[x16_11 - 1].name);
			System.out.println("\n");
			x16_11++;
		}

//				Q16.12

		System.out.println("Question 16.12");
		int x16_12 = 1;
		while (x16_12 <= 2) {
			System.out.println("Thông tin department thứ " + x16_12 + " là:");
			System.out.println("Id: " + dept_array[x16_12 - 1].id);
			System.out.println("Name: " + dept_array[x16_12 - 1].name);
			System.out.println("\n");
			x16_12++;
		}

//				Q16.13

		System.out.println("Question 16.13");
		int x16_13 = 1;
		while (x16_13 <= acc_array.length) {
			if (acc_array[x16_13 - 1].id == 2) {
				x16_13++;
				continue;
			}
			System.out.println("Thông tin account thứ " + x16_13 + " là:");
			System.out.println("Email: " + acc_array[x16_13 - 1].email);
			System.out.println("Full name: " + acc_array[x16_13 - 1].fullName);
			System.out.println("Department: " + acc_array[x16_13 - 1].departmentID.name);
			System.out.println("\n");
			x16_13++;
		}

//				Q16.14

		System.out.println("Question 16.14");
		int x16_14 = 1;
		while (x16_14 <= acc_array.length) {
			if (acc_array[x16_14 - 1].id >= 4) {
				break;
			}
			System.out.println("Thông tin account thứ " + x16_14 + " là:");
			System.out.println("Email: " + acc_array[x16_14 - 1].email);
			System.out.println("Full name: " + acc_array[x16_14 - 1].fullName);
			System.out.println("Department: " + acc_array[x16_14 - 1].departmentID.name);
			System.out.println("\n");
			x16_14++;
		}

//				Q16.15

		System.out.println("Question 16.15");
		int x16_15 = 0;
		while (x16_15 <= 20) {
			System.out.println(x16_15);
			x16_15 = x16_15 + 2;
		}

//				Q17

//				Q17.10

		System.out.println("Question 17.10");
		int x17_10 = 1;
		do {
			System.out.println("Thông tin account thứ " + x17_10 + " là:");
			System.out.println("Email: " + acc_array[x17_10 - 1].email);
			System.out.println("Full name: " + acc_array[x17_10 - 1].fullName);
			System.out.println("Department: " + acc_array[x17_10 - 1].departmentID.name);
			System.out.println("\n");
			x17_10++;
		} while (x17_10 <= acc_array.length);

//				Q17.11

		System.out.println("Question 17.11");
		int x17_11 = 1;
		do {
			System.out.println("Thông tin department thứ " + x17_11 + " là:");
			System.out.println("Id: " + dept_array[x17_11 - 1].id);
			System.out.println("Name: " + dept_array[x17_11 - 1].name);
			System.out.println("\n");
			x17_11++;
		} while (x17_11 <= dept_array.length);

//				Q17.12

		System.out.println("Question 17.12");
		int x17_12 = 1;
		do {
			System.out.println("Thông tin department thứ " + x17_12 + " là:");
			System.out.println("Id: " + dept_array[x17_12 - 1].id);
			System.out.println("Name: " + dept_array[x17_12 - 1].name);
			System.out.println("\n");
			x17_12++;
		} while (x17_12 <= 2);

//				Q17.13

		System.out.println("Question 17.13");
		int x17_13 = 1;
		do {
			if (acc_array[x17_13 - 1].id == 2) {
				x17_13++;
				continue;
			}
			System.out.println("Thông tin account thứ " + x17_13 + " là:");
			System.out.println("Email: " + acc_array[x17_13 - 1].email);
			System.out.println("Full name: " + acc_array[x17_13 - 1].fullName);
			System.out.println("Department: " + acc_array[x17_13 - 1].departmentID.name);
			System.out.println("\n");
			x17_13++;
		} while (x17_13 <= acc_array.length);

//				Q17.14

		System.out.println("Question 17.14");
		int x17_14 = 1;
		do {
			if (acc_array[x17_14 - 1].id >= 4) {
				break;
			}
			System.out.println("Thông tin account thứ " + x17_14 + " là:");
			System.out.println("Email: " + acc_array[x17_14 - 1].email);
			System.out.println("Full name: " + acc_array[x17_14 - 1].fullName);
			System.out.println("Department: " + acc_array[x17_14 - 1].departmentID.name);
			System.out.println("\n");
			x17_14++;
		} while (x17_14 <= acc_array.length);

//				Q17.15

		System.out.println("Question 17.15");
		int x17_15 = 0;
		do {
			System.out.println(x17_15);
			x17_15 = x17_15 + 2;
		} while (x17_15 <= 20);

		// ******************Ex2_SystemOutPrintf****************

		// Q1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in
		// ra số nguyên đó
		System.out.println("Question 1 Ex2");
		int x1 = 5;
		System.out.printf("%d%n", x1);

		// Q2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out
		// printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
		System.out.println("Question 2 Ex2");
		int x2 = 100000000;

		System.out.printf("%,d%n", x2);

		// Q3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf
		// để in ra số thực đó chỉ bao gồm 4 số đằng sau
		System.out.println("Question 3 Ex2");
		float x3 = (float) 5.567098;
		System.out.printf("%.4f%n", x3);

		// Q4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó
		// theo định dạng như sau:
		// Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
		// Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		System.out.println("Question 4 Ex2");
		String hoVaTen;
		hoVaTen = "Nguyễn Thị Ngọc Trâm";
		System.out.printf("Tên tôi là %s và tôi đã có chồng %n", hoVaTen);

		// Q5: Lấy thời gian bây giờ và in ra theo định dạng sau:
		// 24/04/2020 11h:16p:20s
		System.out.println("Question 5 Ex2");
		Date date = new Date();
		System.out.printf("%1$td/%1$tm/%1$tY %1$tHh:%1$tMp:%1$tSs %n", date);

		// Q6: in ra thông tin account (như Question 8 phần FOREACH) theo
		// định dạng table (giống trong Database)

		System.out.println("Question 6 Ex2");
		String id = "ID";
		String fullName = "Full Name";
		String email = "Email";
		String department = "Department Name";

		System.out.printf("%s	%s				%s				%s%n", id, fullName, email, department);
		System.out.printf("%s	%s			%s		%s%n", acc1.id, acc1.fullName, acc1.email, acc1.departmentID.name);
		System.out.printf("%s	%s			%s		%s%n", acc2.id, acc2.fullName, acc2.email, acc2.departmentID.name);
		System.out.printf("%s	%s				%s		%s%n", acc3.id, acc3.fullName, acc3.email,
				acc3.departmentID.name);

		// Q7: in ra danh sách các account đã join vào group theo định dạng
//				table
//				Create Date của Account sẽ được định dạng theo format như sau: 24/04/2020
//				11h:16p:20s
		System.out.println("Question 7 Ex2");
		String username = "username";
		String position = "Position Name";
		String createDate = "Create Date";
		// It uses '<' flag in the format specifier to reuse the value from argument.
		System.out.printf("%s	%s	%s		%s			%s		%s		%s%n", id, username, fullName, email,
				department, position, createDate);
		System.out.printf("%d	%s	%s	%s	%s			%s			%te/%<tm/%<tY %<tHh:%<tMp:%<tSs%n", acc1.id,
				acc1.username, acc1.fullName, acc1.email, acc1.departmentID.name, acc1.positionID.name,
				acc1.createDate);
		System.out.printf("%d	%s	%s	%s	%s			%s			%te/%<tm/%<tY %<tHh:%<tMp:%<tSs%n", acc2.id,
				acc2.username, acc2.fullName, acc2.email, acc2.departmentID.name, acc2.positionID.name,
				acc2.createDate);
		System.out.printf("%d	%s	%s		%s	%s			%s			%te/%<tm/%<tY %<tHh:%<tMp:%<tSs%n", acc3.id,
				acc3.username, acc3.fullName, acc3.email, acc3.departmentID.name, acc3.positionID.name,
				acc3.createDate);

		// ***********************Ex3_DateFormat************************

		// Q1: In ra thông tin account thứ 1 và property create date sẽ được
		// format theo định dạng vietnamese

		System.out.println("Question 1 Ex3");

		Locale locale = new Locale("vi", "Vi");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		ZoneId defaultZoneID = ZoneId.systemDefault();
		Date acc1_date = Date.from(acc1.createDate.atZone(defaultZoneID).toInstant());
		String date_acc1 = dateFormat.format(acc1_date);

		System.out.printf("%s	%s	%s		%s			%s		%s		%s%n", id, username, fullName, email,
				department, position, createDate);
		System.out.printf("%d	%s	%s	%s	%s			%s			%s%n", acc1.id, acc1.username, acc1.fullName,
				acc1.email, acc1.departmentID.name, acc1.positionID.name, date_acc1);

		// Q2: In ra thông tin: account đã tham gia vào group ngày nào theo định
		// dạng
		// Năm – tháng – ngày – giờ – phút – giây

		System.out.println("Question 2 Ex3");

		String patern2 = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(patern2);
		String date_acc1_2 = simpleDateFormat2.format(acc1_date);

		System.out.println("Create Date: " + date_acc1_2);

		// Q3: Chỉ in ra ngày của create date trong Question 1

		System.out.println("Question 3 Ex3");

		String patern3 = "dd";
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(patern3);
		String date_acc1_3 = simpleDateFormat3.format(acc1_date);

		System.out.println("Date of Create Date: " + date_acc1_3);

		// Q4: Chỉ in ra năm của join date trong Question 2

		System.out.println("Question 4 Ex3");
		String patern4 = "yyyy";
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(patern4);
		String date_acc1_4 = simpleDateFormat4.format(acc1_date);

		System.out.println("Year of Create Date: " + date_acc1_4);

		// Q5: Chỉ in ra tháng và năm của join date trong Question 2

		System.out.println("Question 5 Ex3");
		String patern5 = "MM-yyyy";
		SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(patern5);
		String date_acc1_5 = simpleDateFormat5.format(acc1_date);
		System.out.println("Month-Year of Create Date: " + date_acc1_5);

		// Q6: Chỉ in ra "MM-DD" của join date trong Question 2

		System.out.println("Question 6 Ex3");
		String patern6 = "MM-dd";
		SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat(patern6);
		String date_acc1_6 = simpleDateFormat6.format(acc1_date);
		System.out.println("Month-Date of Create Date: " + date_acc1_6);

		// **************Ex4_RandomNumber****************

		// Q1: In ngẫu nhiên ra 1 số nguyên

		System.out.println("Question 1 Ex4");

		Random random1 = new Random();
		int a1 = random1.nextInt();
		System.out.println(a1);

		// Q2: In ngẫu nhiên ra 1 số thực

		System.out.println("Question 2 Ex4");

		Random random2 = new Random();
		float a2 = (float) random2.nextFloat();
		System.out.println(a2);

		// Q3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in
		// ngẫu nhiên ra tên của 1 bạn

		System.out.println("Question 3 Ex4");

		String[] friends = { "Lan Anh", "Thế Hào", "Tùng Anh", "Phượng", "Trâm", "Ngáo", "Bách" };

		int a3 = friends.length;
		Random random3 = new Random();
		int b3 = random3.nextInt(a3);
		System.out.println(friends[b3]);

		// Q4: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới
		// ngày 20-12-1995

		System.out.println("Question 4 Ex4");

		Random random4 = new Random();
		int minDate4 = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDate4 = (int) LocalDate.of(1995, 12, 20).toEpochDay();

		long random4_date4 = random4.nextInt(maxDate4 - minDate4) + minDate4;

		LocalDate date4_random4 = LocalDate.ofEpochDay(random4_date4);

		System.out.println(date4_random4);

		// Q5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây

		System.out.println("Question 5 Ex4");

		Random random5 = new Random();
		int minDate5 = (int) LocalDate.now().minusYears(1).toEpochDay();
		int maxDate5 = (int) LocalDate.now().toEpochDay();

		long random5_date5 = random5.nextInt(maxDate5 - minDate5) + minDate5;

		LocalDate date5_random5 = LocalDate.ofEpochDay(random5_date5);

		System.out.println(date5_random5);

		// Q6: Lấy ngẫu nhiên 1 ngày trong quá khứ

		System.out.println("Question 6 Ex4");
		Random random6 = new Random();

		int minDate6 = (int) LocalDate.of(1, 1, 1).toEpochDay();
		int maxDate6 = (int) LocalDate.now().toEpochDay();

		long random6_date6 = random6.nextInt(maxDate6 - minDate6) + minDate6;

		LocalDate date6_random6 = LocalDate.ofEpochDay(random6_date6);

		System.out.println(date6_random6);

		// Q7: Lấy ngẫu nhiên một số có 3 chữ số

		System.out.println("Question 7 Ex4");
		Random random7 = new Random();
		int a7 = random7.nextInt(999 - 100 + 1) + 100;
		System.out.println(a7);
		
		// ****************Ex5_InputFromConsole*****************

		// Q1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình

		System.out.println("Question 1 Ex5");

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Mời nhập ba số nguyên");
		System.out.print("số thứ nhất: ");
		int n1 = sc1.nextInt();
		System.out.println(n1 + " đã nhập");
		System.out.print("số thứ hai: ");
		int n2 = sc1.nextInt();
		System.out.println(n2 + " đã nhập");
		System.out.print("số thứ ba: ");
		int n3 = sc1.nextInt();
		System.out.println(n3 + " đã nhập");
		sc1.close();

		// Q2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình

		System.out.println("Question 2 Ex5");

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Mời nhập hai số thực");
		System.out.print("số thứ nhất: ");
		float f1 = (float)sc2.nextFloat();
		System.out.println("Đã nhập " + f1);
		System.out.print("số thứ hai: ");
		float f2 = (float)sc2.nextFloat();
		System.out.println("Đã nhập " + f2);
		sc2.close();

		// Q3: Viết lệnh cho phép người dùng nhập họ và tên
		
		System.out.println("Question 3 Ex5");

		Scanner sc3 = new Scanner(System.in);
		System.out.print("Mời nhập họ và tên: ");
		String hoVaTen3 = sc3.next();
		System.out.println("Họ tên " + hoVaTen3 + " đã được nhập");
		sc3.close();
		
		// Q4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		
		System.out.println("Question 4 Ex5");
		
		Scanner sc4 = new Scanner(System.in);
		System.out.print("Mời nhập ngày sinh nhật theo định dạng yyyy-mm-dd: ");
		String stringDate2 = sc4.next();
		LocalDate dateString2 = LocalDate.parse(stringDate2);
		System.out.println(dateString2 + " đã được lưu lại");
		sc4.close();
		
		// Q6: nhập số chẵn từ console
		
	}
		
		// Q5:Viết lệnh cho phép người dùng tạo account (viết thành method)
		//Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
		//chương trình sẽ chuyển thành Position.Dev, Position.Test,
		//Position.ScrumMaster, Position.PM
		
		public static void taoAccount() {
			
			System.out.println("Question 5 Ex5");
			
			Account acc5 = new Account();
			Scanner sc5 = new Scanner(System.in);
			System.out.println("Mời nhập dữ liệu cho account mới:");
			System.out.print("Id của account: ");
			acc5.id = sc5.nextInt();
			System.out.print("Username của account: ");
			acc5.username = sc5.next();
			System.out.print("Full name của account: ");
			acc5.fullName = sc5.next();
			System.out.print("Email của account: ");
			acc5.email = sc5.next();
			System.out.print("PositionID của account: ");
			byte acc5Pot = sc5.nextByte();
			sc5.close();
			
			
			System.out.println("Khởi tạo thành công!");
			System.out.println("Thông tin account vừa tạo");
			System.out.println("ID: "+acc5.id);
			System.out.println("Username: "+acc5.username);
			System.out.println("Full name: "+acc5.fullName);
			System.out.println("Email: "+acc5.email);
			switch (acc5Pot) {
			case 1:
				System.out.println("Position: DEV");
				break;
			case 2:
				System.out.println("Position: Test");
				break;
			case 3:
				System.out.println("Position: Scrum Master");
				break;
			case 4:
				System.out.println("Position: PM");
				break;
			default:
				break;
			}
			
		}
		
		// Q6: Viết lệnh cho phép người dùng tạo department (viết thành method)
		
		public static void taoDepartment() {
			
			System.out.println("Question 6 Ex5");
			
			Department dept = new Department();
			Scanner sc6 = new Scanner(System.in);
			
			System.out.println("Mời nhập dữ liệu cho department mới:");
			System.out.print("Id của department: ");
			dept.id = sc6.nextByte();
			System.out.print("Username của account: ");
			dept.name = sc6.next();
			sc6.close();
			
			System.out.println("Khởi tạo thành công!");
			System.out.println("Thông tin department vừa tạo");
			System.out.println("ID: "+dept.id);
			System.out.println("Name: "+dept.name);
			
					
		}
		
		// Q7: Nhập số chẵn từ console
		
		public static void nhapSoChan() {
			System.out.println("Question 7 Ex5");
			Scanner sc7 = new Scanner(System.in);
			int n7;
			
			do {
				System.out.println("Mời nhập một số chẵn: ");
				n7 = sc7.nextInt();
				
				if (n7 % 2 == 0) {
					System.out.println("Số"+n7+" hợp lệ");
				} else {
					System.out.println("Số"+n7+" không hợp lệ, hãy nhập lại");
				}
			} while (n7 % 2 != 0);
			sc7.close();
		}
			
		// Q8:Viết chương trình thực hiện theo flow sau
		//Bước 1: Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
		//Bước 2:
		//Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
		//Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
		//Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và
		//quay trở lại bước 1
		
		public static void nhapChucNang() {
			Scanner sc8 = new Scanner(System.in);
			byte n8;
			do {
				System.out.println("Mời nhập chức năng (1. tạo account, 2. tạo department): ");
				n8 = sc8.nextByte();
				if (n8 ==1) {
					taoAccount();
				} else if ( n8 == 2) {
					taoDepartment();
				} else {
					System.out.println("Mời bạn nhập lại");
				}
			} while (n8 != 1 && n8 != 2);
			sc8.close();
		}
		
	

}

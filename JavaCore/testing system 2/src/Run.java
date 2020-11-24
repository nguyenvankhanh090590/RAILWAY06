import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Run {

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
		
		
		//**************IF**************
		
				
				
				Locale locale = new Locale ("vi","Vi");
				DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale );
				ZoneId defaultZoneID = ZoneId.systemDefault();
				Date acc1_date = Date.from(acc1.createDate.atZone(defaultZoneID).toInstant());
				String date_acc1 = dateFormat.format(acc1_date);
				System.out.println(date_acc1);
				
				String patern = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat simple1 = new SimpleDateFormat(patern);
				String date = simple1.format(acc1_date);
				System.out.println(date);
				
				LocalDate date1 = LocalDate.now().minusYears(1);
				
				System.out.println(date1);
				
				LocalDate date5_random5 = LocalDate.ofEpochDay(-12);
				System.out.println(date5_random5);
				
	}

}

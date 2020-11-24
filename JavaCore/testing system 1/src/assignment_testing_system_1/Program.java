package assignment_testing_system_1;

import java.time.LocalDate;

public class Program {

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
		acc1.createDate = LocalDate.of(2017, 12, 27);

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "tramnguyen@gmail.com";
		acc2.fullName = "Nguyễn Thị Ngọc Trâm";
		acc2.username = "tramnguyen";
		acc2.departmentID = dept2;
		acc2.positionID = pot2;
		acc2.createDate = LocalDate.of(2018, 04, 20);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "engine194@icloud.com";
		acc3.fullName = "Nguyễn Đắc Ngọc";
		acc3.username = "Engine194";
		acc3.departmentID = dept3;
		acc3.positionID = pot1;
		acc3.createDate = LocalDate.of(2020, 10, 28);

		// table Group
		Group gr1 = new Group();
		gr1.id = 1;
		gr1.name = "Gà quay";
		gr1.creatorID = acc2;
		gr1.createDate = LocalDate.of(2020, 11, 15);
		Account[] gr_array1 = { acc1, acc2 };
		gr1.accountIDs = gr_array1;

		Group gr2 = new Group();
		gr2.id = 2;
		gr2.name = "Vịt quay";
		gr2.creatorID = acc3;
		gr2.createDate = LocalDate.of(2020, 11, 13);
		Account[] gr_array2 = { acc3, acc2 };
		gr2.accountIDs = gr_array2;

		Group gr3 = new Group();
		gr3.id = 3;
		gr3.name = "Heo nướng";
		gr3.creatorID = acc1;
		gr3.createDate = LocalDate.of(2020, 11, 11);
		Account[] gr_array3 = { acc1, acc2, acc3 };
		gr3.accountIDs = gr_array3;
		
		Group[] groupOfAcc1 = {gr1,gr3};
		acc1.groups = groupOfAcc1;
		
		Group[] groupOfAcc2 = {gr1,gr2,gr3};
		acc2.groups = groupOfAcc2;
		
		Group[] groupOfAcc3 = {gr2,gr3};
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
		ques1.createDate = LocalDate.of(2020, 10, 15);
		ques1.typeID = type1;

		Question ques2 = new Question();
		ques2.id = 2;
		ques2.content = "Câu hỏi về .NET";
		ques2.categoryID = cate3;
		ques2.creatorID = acc2;
		ques2.createDate = LocalDate.of(2020, 9, 30);
		ques2.typeID = type1;

		Question ques3 = new Question();
		ques3.id = 3;
		ques3.content = "Câu hỏi về Java";
		ques3.categoryID = cate1;
		ques3.creatorID = acc3;
		ques3.createDate = LocalDate.of(2020, 10, 10);
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
		exam1.createDate = LocalDate.of(2020, 11, 02);
		Question[] quess1 = { ques1, ques3 };
		exam1.questionIDs = quess1;

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "B00217";
		exam2.title = "Đề thi về Java và .NET";
		exam2.categoryID = 2;
		exam2.duration = 60;
		exam2.creatorID = acc3;
		exam2.createDate = LocalDate.of(2020, 11, 03);
		Question[] quess2 = { ques2, ques3 };
		exam2.questionIDs = quess2;

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "A00307";
		exam3.title = "Đề thi về mySQL và .NET";
		exam3.categoryID = 4;
		exam3.duration = 120;
		exam3.creatorID = acc1;
		exam3.createDate = LocalDate.of(2020, 11, 04);
		Question[] quess3 = { ques1, ques2 };
		exam3.questionIDs = quess3;

		// skip on table ExamQuestion
		
		// ************* Show on screen one record for each table *********************
		
		// table Department
		
		System.out.println("*********Department*********");
		System.out.println("ID" + "	Name");
		System.out.println(dept1.id+ "	"+dept1.name );
		System.out.println(dept2.id+ "	"+dept2.name );
		System.out.println(dept3.id+ "	"+dept3.name );
		System.out.println();
		
		// table Position
		System.out.println("**********Position**********");
		System.out.println("ID" + "	Name");
		System.out.println(pot1.id+ "	"+pot1.name );
		System.out.println(pot2.id+ "	"+pot2.name );
		System.out.println(pot3.id+ "	"+pot3.name );
		System.out.println();
		
		// table Account
		
		System.out.println("*********Account*********");
		System.out.println("ID	username	full name		email				department	position	create date");
		System.out.println(acc1.id+"	"+acc1.username+"	"+acc1.fullName+"	"+acc1.email+"		"+acc1.departmentID.name+"		"+acc1.positionID.name+"		"+acc1.createDate);
		System.out.println();
		
		// table Group
		
		System.out.println("**********Group**********");
		System.out.println("ID	group name	creator 		create date");
		System.out.println(gr1.id+"	"+gr1.name+"		"+gr1.creatorID.fullName+"	"+gr1.createDate);
		System.out.println();
		
		// table TypeQuestion
		
		System.out.println("********TypeQuestion********");
		System.out.println("ID" + "	type name");
		System.out.println(type1.id+ "	"+type1.name );
		System.out.println(type2.id+ "	"+type2.name );
		System.out.println();
		
		// table CategoryQuestion
		
		System.out.println("*******CategoryQuestion*******");
		System.out.println("ID" + "	Category name");
		System.out.println(cate1.id+ "	"+cate1.categoryName );
		System.out.println();
		
		// table Question
		
		System.out.println("**********Question**********");
		System.out.println("ID: "+ques1.id);
		System.out.println("content: "+ques1.content);
		System.out.println("type: "+ques1.typeID.name);
		System.out.println("category : "+ques1.categoryID.categoryName);
		System.out.println("creator: "+ques1.creatorID.fullName);
		System.out.println("create date: "+ques1.createDate);
		System.out.println();
		
		// table Answer
		
		System.out.println("**********Answer**********");
		System.out.println("ID: "+an1.id);
		System.out.println("content: "+an1.content);
		System.out.println("questionID: "+an1.questionID.id);
		System.out.println("True/False: "+an1.isCorrect);
		System.out.println();
		
		// table Exam
		
		System.out.println("**********Exam**********");
		System.out.println("ID: "+exam1.id);
		System.out.println("code: "+exam1.code);
		System.out.println("title: "+exam1.title);
		System.out.println("categoryID: "+exam1.categoryID);
		System.out.println("duration : "+exam1.duration);
		System.out.println("creator: "+exam1.creatorID.fullName);
		System.out.println("create date: "+exam1.createDate);
		
		

	}

}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex5_InputFromConsole {

	public static void main(String[] args) {
		
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
				
				taoAccount();
				
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
					System.out.print("DepatmentID của account: ");
					acc5.departmentID.id = sc5.nextByte();
					System.out.print("PositionID của account: ");
					acc5.positionID.id = sc5.nextByte();
					System.out.print("Create date của account theo định dạng yyyy-MM-dd HH:mm:ss ");
					String stringCreateDateAcc5 = sc5.next();
					acc5.createDate = LocalDateTime.parse(stringCreateDateAcc5); 
					
					System.out.println("Khởi tạo thành công!");
					System.out.println("Thông tin account vừa tạo");
					System.out.print("ID: "+acc5.id);
					System.out.print("Username: "+acc5.username);
					System.out.print("Full name: "+acc5.fullName);
					System.out.print("Email: "+acc5.email);
					System.out.print("Depatment Name: "+acc5.departmentID.name);
					switch (acc5.positionID.id) {
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
					System.out.println("Create Date: " + acc5.createDate);
					sc5.close();
				}
					
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		


}

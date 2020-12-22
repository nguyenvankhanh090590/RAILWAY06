package frontEnd;
import java.io.IOException;
import java.sql.SQLException;

import backEnd.Ex1;
public class Basic_Ex1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Ex1 BE = new Ex1();
		BE.Q1Connect();
		System.out.println();
		BE.Q3InsertPosition();
//		System.out.println();
		BE.Q2GetPosition();
		System.out.println();
//		BE.Q4UpdatePosition();
//		System.out.println();
//		BE.Q2GetPosition();
//		System.out.println();
//		BE.Q5DeletePosition();
//		System.out.println();
//		BE.Q2GetPosition();
		
	}

}

package frontEnd;
import java.io.IOException;
import java.sql.SQLException;
import backEnd.dataLayer.*;
import backEnd.presentationLayer.AccountController;
import Utils.JdbcUtils;
public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//		JdbcUtils jdbcU = new JdbcUtils();
//		jdbcU.connectForTesting();
//		AccountRepository AR = new AccountRepository();
//		System.out.println(AR.getListAcc());
		AccountController AC = new AccountController();
		System.out.println(AC.getListAcc());
		
	}

}

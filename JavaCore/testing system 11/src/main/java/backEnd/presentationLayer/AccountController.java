package backEnd.presentationLayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backEnd.businessLayer.AccountService;
import entity.Account;

public class AccountController {
	AccountService AS;
	
	public List<Account> getListAcc() throws ClassNotFoundException, IOException, SQLException{
		AS = new AccountService();
		return AS.getListAcc();
	}
}

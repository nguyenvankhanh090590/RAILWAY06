package backEnd.businessLayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backEnd.dataLayer.AccountRepository;
import entity.Account;

public class AccountService {
	AccountRepository AR;
	
	public List<Account> getListAcc() throws IOException, ClassNotFoundException, SQLException{
		AR = new AccountRepository();
		return AR.getListAcc();
	}
}

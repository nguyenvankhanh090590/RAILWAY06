package backEnd.dataLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entity.Account;

public interface IAccountRepositoryV1 {
	List<Account> getListAcc() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
	Account createAcc();
	Account getAccByID();
	boolean isAccExist(int id);
	boolean isAccExist(String name);
	Account updateAccById(int id);
	boolean deleteAcc(int id);
	
}

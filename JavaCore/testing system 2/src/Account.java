

import java.time.LocalDateTime;

public class Account {	
	int id;
	String email;
	String username;
	String fullName;
	Department departmentID;
	Position positionID;
	LocalDateTime createDate;
	Group[] groups;
}

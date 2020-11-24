

import java.time.LocalDateTime;

public class Exam {
	int id;
	String code;
	String title;
	int categoryID;
	int duration;
	Account creatorID;
	LocalDateTime createDate;
	Question[] questionIDs;
}

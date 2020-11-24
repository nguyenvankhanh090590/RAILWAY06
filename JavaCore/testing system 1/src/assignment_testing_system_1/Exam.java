package assignment_testing_system_1;

import java.time.LocalDate;

public class Exam {
	int id;
	String code;
	String title;
	int categoryID;
	int duration;
	Account creatorID;
	LocalDate createDate;
	Question[] questionIDs;
}

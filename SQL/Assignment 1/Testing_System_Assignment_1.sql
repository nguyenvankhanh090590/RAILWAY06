DROP DATABASE IF EXISTS testing_system_assignment_1;
CREATE DATABASE testing_system_assignment_1;
USE testing_system_assignment_1;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department 	(
	Department_ID			INT AUTO_INCREMENT,
    Department_Name			VARCHAR(50),
PRIMARY KEY (Department_ID)
);

DROP TABLE IF EXISTS Position_;
CREATE TABLE Position_ 		(
	Position_ID				INT AUTO_INCREMENT,
    Position_Name			ENUM('DEV','Test','Scrum Master','PM'),
PRIMARY KEY (Position_ID)
);

DROP TABLE IF EXISTS Account_;
CREATE TABLE Account_		(
	Account_ID				INT AUTO_INCREMENT,
    Email					VARCHAR(50),
    Username				VARCHAR(50),
    Fullname				VARCHAR(50),
    Department_ID			INT,
    Position_ID				INT,
    Create_date				DATE,
PRIMARY KEY (Account_ID)
);



DROP TABLE IF EXISTS Group_;
CREATE TABLE Group_			(
	Group_ID				INT AUTO_INCREMENT,
    Group_Name				VARCHAR(255),
    Creator_ID				INT,
    Create_Date				DATE,
PRIMARY KEY (Group_ID)
);

DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account	(
	Account_ID				INT AUTO_INCREMENT,
    Group_ID				INT,
    Join_Date				DATE,
PRIMARY KEY (Account_ID)
);



DROP TABLE IF EXISTS Type_Question;
CREATE TABLE Type_Question	(
	Type_ID					INT AUTO_INCREMENT,
    Type_Name				ENUM('Essay','Multiple-Choice'),
PRIMARY KEY (Type_ID)
);

DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question	(
	Category_ID				INT AUTO_INCREMENT,
    Category_Name			VARCHAR(50),
PRIMARY KEY (Category_ID)
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question	(
	Question_ID				INT AUTO_INCREMENT,
    Content					VARCHAR(255),
    Category_ID				INT,
    Type_ID					INT,
    Creator_ID				INT,
    Create_Date				DATE,
PRIMARY KEY (Question_ID)
);



DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer		(
	Answer_ID				INT AUTO_INCREMENT,
    Content					VARCHAR(255),
    Question_ID				INT,
    Is_Correct				ENUM('True','False'),
PRIMARY KEY (Answer_ID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam		(
	Exam_ID					INT AUTO_INCREMENT,
    Code_					VARCHAR(10),
    Title					VARCHAR(50),
    Category_ID				INT,
    Duration				TIME,
    Creator_ID				INT,
    Create_Date				DATE,
PRIMARY KEY (Exam_ID)
);

DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question	(
	Question_ID				INT AUTO_INCREMENT,
    Exam_ID					INT,
PRIMARY KEY (Question_ID)
);

ALTER TABLE Account_
ADD FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID) ON DELETE CASCADE,
ADD FOREIGN KEY (Position_ID) REFERENCES Position_(Position_ID) ON DELETE CASCADE;

ALTER TABLE Group_Account
ADD FOREIGN KEY (Group_ID) REFERENCES Group_(Group_ID) ON DELETE CASCADE;

ALTER TABLE Question
ADD FOREIGN KEY (Category_ID) REFERENCES Category_Question(Category_ID) ON DELETE CASCADE,
ADD FOREIGN KEY (Type_ID) REFERENCES Type_Question(Type_ID) ON DELETE CASCADE;

ALTER TABLE Answer
ADD FOREIGN KEY (Question_ID) REFERENCES Question(Question_ID);

ALTER TABLE Exam_Question
ADD FOREIGN KEY (Exam_ID) REFERENCES Exam(Exam_ID) ON DELETE CASCADE;


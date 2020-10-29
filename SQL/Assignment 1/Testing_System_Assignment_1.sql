DROP DATABASE IF EXISTS testing_system_assignment_1;
CREATE DATABASE testing_system_assignment_1;
USE testing_system_assignment_1;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department 	(
	Department_ID			INT PRIMARY KEY AUTO_INCREMENT,
    Department_Name			VARCHAR(50)
);

DROP TABLE IF EXISTS Position_;
CREATE TABLE Position_ 		(
	Position_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Position_Name			ENUM('DEV','Test','Scrum Master','PM')
);

DROP TABLE IF EXISTS Account_;
CREATE TABLE Account_		(
	Account_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Email					VARCHAR(50),
    Username				VARCHAR(50),
    Fullname				VARCHAR(50),
    Department_ID			INT,
    Position_ID				INT,
    Create_date				DATE
);



DROP TABLE IF EXISTS Group_;
CREATE TABLE Group_			(
	Group_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Group_Name				VARCHAR(255),
    Creator_ID				INT,
    Create_Date				DATE
);

DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account	(
	Account_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Group_ID				INT,
    Join_Date				DATE
);



DROP TABLE IF EXISTS Type_Question;
CREATE TABLE Type_Question	(
	Type_ID					INT PRIMARY KEY AUTO_INCREMENT,
    Type_Name				ENUM('Essay','Multiple-Choice')
);

DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question	(
	Category_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Category_Name			VARCHAR(50)
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question	(
	Question_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Content					VARCHAR(255),
    Category_ID				INT,
    Type_ID					INT,
    Creator_ID				INT,
    Create_Date				DATE
);



DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer		(
	Answer_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Content					VARCHAR(255),
    Question_ID				INT,
    Is_Correct				ENUM('True','False')
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam		(
	Exam_ID					INT PRIMARY KEY AUTO_INCREMENT,
    Code_					VARCHAR(10),
    Title					VARCHAR(50),
    Category_ID				INT,
    Duration				TIME,
    Creator_ID				INT,
    Create_Date				DATE
);

DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question	(
	Question_ID				INT PRIMARY KEY AUTO_INCREMENT,
    Exam_ID					INT
);
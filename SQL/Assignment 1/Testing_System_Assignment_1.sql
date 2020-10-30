DROP DATABASE IF EXISTS testing_system_assignment_1;
CREATE DATABASE testing_system_assignment_1;
USE testing_system_assignment_1;

DROP TABLE IF EXISTS department;
CREATE TABLE department (
	department_id			INT PRIMARY KEY AUTO_INCREMENT,
    department_name			VARCHAR(50)
);

DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
	position_id				INT PRIMARY KEY AUTO_INCREMENT,
    position_name			ENUM('DEV','Test','Scrum Master','PM')
);

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
	account_id				INT PRIMARY KEY AUTO_INCREMENT,
    email					VARCHAR(50),
    username				VARCHAR(50),
    fullname				VARCHAR(50),
    department_id			INT,
    position_id				INT,
    create_date				DATE
);



DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
	group_id				INT PRIMARY KEY AUTO_INCREMENT,
    group_name				VARCHAR(255),
    creator_id				INT,
    create_date				DATE
);

DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account (
	group_id				INT PRIMARY KEY AUTO_INCREMENT,
    account_id				INT,
    join_date				DATE
);



DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
	type_id					INT PRIMARY KEY AUTO_INCREMENT,
    type_name				ENUM('Essay','Multiple-Choice')
);

DROP TABLE IF EXISTS category_question;
CREATE TABLE qategory_question (
	category_id				INT PRIMARY KEY AUTO_INCREMENT,
    category_name			VARCHAR(50)
);

DROP TABLE IF EXISTS question;
CREATE TABLE question (
	question_id				INT PRIMARY KEY AUTO_INCREMENT,
    content					VARCHAR(255),
    category_id				INT,
    type_id					INT,
    creator_id				INT,
    create_date				DATE
);



DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
	answer_id				INT PRIMARY KEY AUTO_INCREMENT,
    content					VARCHAR(255),
    question_id				INT,
    is_correct				ENUM('True','False')
);

DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
	exam_id					INT PRIMARY KEY AUTO_INCREMENT,
    `code`					VARCHAR(10),
    title					VARCHAR(50),
    category_id				INT,
    duration				TIME,
    creator_id				INT,
    create_date				DATE
);

DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question (
	exam_id					INT PRIMARY KEY AUTO_INCREMENT,
    question_id				INT
);
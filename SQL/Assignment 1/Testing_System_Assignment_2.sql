DROP DATABASE IF EXISTS testing_system_assignment_2;
CREATE DATABASE IF NOT EXISTS testing_system_assignment_2;

USE testing_system_assignment_2;

DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department (
	department_id		TINYINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    department_name		NVARCHAR(100)
);
 
DROP TABLE IF EXISTS `position`;
CREATE TABLE IF NOT EXISTS `position` (
	position_id			TINYINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    position_name		ENUM('DEV','Test','Scrum Master','PM')
);

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
	account_id			SMALLINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    email				VARCHAR(200) 	UNIQUE KEY 		DEFAULT 'X',
    username			VARCHAR(100) 					DEFAULT 'UNKNOWN',
    fullname			VARCHAR(100) 					DEFAULT 'UNKNOWN',
    department_id		TINYINT 		UNSIGNED,
    position_id			TINYINT 		UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (department_id)			REFERENCES department (department_id),
    FOREIGN KEY (position_id) 			REFERENCES `position`(position_id)
);


DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
	group_id			SMALLINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    group_name			VARCHAR(200),
    creator_id			SMALLINT 		UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (creator_id)			REFERENCES `account`(account_id)
);

DROP TABLE IF EXISTS group_account;
CREATE TABLE IF NOT EXISTS group_account (
	group_id			SMALLINT 		UNSIGNED,
    account_id			SMALLINT 		UNSIGNED,
    join_date			DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id)				REFERENCES `group`(group_id),
    FOREIGN KEY (account_id)			REFERENCES `account`(account_id)
);


DROP TABLE IF EXISTS type_question;
CREATE TABLE IF NOT EXISTS type_question (
	type_id				TINYINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    type_name			ENUM('Essay','Multiple-Choice')
);

DROP TABLE IF EXISTS category_question;
CREATE TABLE IF NOT EXISTS category_question (
	category_id			TINYINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    category_name		VARCHAR(100)
);

DROP TABLE IF EXISTS question;
CREATE TABLE IF NOT EXISTS question	(
	question_id			SMALLINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    content				TEXT,
    category_id			TINYINT 		UNSIGNED,
    type_id				TINYINT 		UNSIGNED,
    creator_id			SMALLINT 		UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (category_id)			REFERENCES category_question(category_id),
    FOREIGN KEY (type_id)				REFERENCES type_question(type_id)
);


DROP TABLE IF EXISTS answer;
CREATE TABLE IF NOT EXISTS answer (
	answer_id			SMALLINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    content				TEXT,
    question_id			SMALLINT 		UNSIGNED,
    is_correct			ENUM('True','False') 			DEFAULT 'TRUE',
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

DROP TABLE IF EXISTS exam;
CREATE TABLE IF NOT EXISTS exam	(
	exam_id				SMALLINT 		UNSIGNED 		PRIMARY KEY 		AUTO_INCREMENT,
    `code`				VARCHAR(100) 	UNIQUE KEY		NOT NULL,
    title				VARCHAR(200),
    category_id			TINYINT 		UNSIGNED,
    duration			TINYINT 		UNSIGNED,
    creator_id			SMALLINT 		UNSIGNED,
    create_date			DATE
);

DROP TABLE IF EXISTS exam_question;
CREATE TABLE IF NOT EXISTS exam_question (
	question_id			SMALLINT 		UNSIGNED,
    exam_id				SMALLINT 		UNSIGNED,
    PRIMARY KEY (question_id, exam_id),
    FOREIGN KEY (question_id) 			REFERENCES question(question_id),
    FOREIGN KEY (exam_id) 				REFERENCES exam(exam_id)
);
DROP DATABASE IF EXISTS testing_system_assignment_5;
CREATE DATABASE IF NOT EXISTS testing_system_assignment_5;
USE testing_system_assignment_5;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department (
	department_id	TINYINT	UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    department_name	NVARCHAR(100) UNIQUE KEY
);
 
DROP TABLE IF EXISTS `position`;
CREATE TABLE IF NOT EXISTS `position` (
	position_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    position_name		ENUM('DEV','Test','Scrum Master','PM')
);

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
	account_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    email				VARCHAR(200) UNIQUE KEY DEFAULT 'X',
    username			NVARCHAR(100) DEFAULT 'UNKNOWN',
    fullname			NVARCHAR(100) DEFAULT 'UNKNOWN',
    department_id		TINYINT UNSIGNED,
    position_id			TINYINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (department_id)	REFERENCES department (department_id) ON DELETE CASCADE,
    FOREIGN KEY (position_id) 	REFERENCES `position`(position_id) ON DELETE CASCADE
);


DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
	group_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    group_name			NVARCHAR(200),
    creator_id			SMALLINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS group_account;
CREATE TABLE IF NOT EXISTS group_account (
	group_id			SMALLINT UNSIGNED NOT NULL,
    account_id			SMALLINT UNSIGNED NOT NULL,
    join_date			DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id)	REFERENCES `group`(group_id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);


DROP TABLE IF EXISTS type_question;
CREATE TABLE IF NOT EXISTS type_question (
	type_id				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    type_name			ENUM('Essay','Multiple-Choice')
);

DROP TABLE IF EXISTS category_question;
CREATE TABLE IF NOT EXISTS category_question (
	category_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    category_name		VARCHAR(100)
);

DROP TABLE IF EXISTS question;
CREATE TABLE IF NOT EXISTS question	(
	question_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    content				TEXT,
    category_id			TINYINT UNSIGNED,
    type_id				TINYINT UNSIGNED,
    creator_id			SMALLINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES type_question(type_id) ON DELETE CASCADE,
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);


DROP TABLE IF EXISTS answer;
CREATE TABLE IF NOT EXISTS answer (
	answer_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    content				TEXT,
    question_id			SMALLINT UNSIGNED,
    is_correct			ENUM('True','False') DEFAULT 'TRUE',
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS exam;
CREATE TABLE IF NOT EXISTS exam	(
	exam_id				SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `code`				VARCHAR(100) UNIQUE KEY NOT NULL,
    title				NVARCHAR(200),
    category_id			TINYINT UNSIGNED,
    duration			TINYINT	UNSIGNED,
    creator_id			SMALLINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS exam_question;
CREATE TABLE IF NOT EXISTS exam_question (
	question_id			SMALLINT 		UNSIGNED,
    exam_id				SMALLINT 		UNSIGNED,
    PRIMARY KEY (question_id, exam_id),
    FOREIGN KEY (question_id) 			REFERENCES question(question_id) ON DELETE CASCADE,
    FOREIGN KEY (exam_id) 				REFERENCES exam(exam_id) ON DELETE CASCADE
);


INSERT INTO department(department_name)
VALUES
	('Giám đốc'),
	('Thư ký'),
    ('Nhân sự'),
    ('Tài chính'),
    ('Luật sư'),
    ('Marketing'),
    ('Sale'),
    ('Bảo trì'),
    ('Bảo vệ'),
    ('Quản trị');

INSERT INTO `position` (position_name)
VALUES
	('Dev'),
    ('Test'),
    ('Scrum Master'),
    ('PM');

INSERT INTO 
`account`(email, 					username, 	fullname, 		department_id, position_id, create_date)
VALUES
	('heoquay@gmail.com',			'Heo',		'Nguyễn Ngọc Tuấn',		2,		1,		'2012-12-14'),
	('gaquay@gmail.com',			'Gà',		'Đào Thị Nở',			5,		1,		'2011-3-5'),
    ('vitquaybackinh@gmail.com',	'Vịt',		'Lê Trương Bình',		1,		1,		'2016-9-8'),
    ('thoquay@icloud.com',			'Thỏ',		'Lã Đại Gia',			6,		2,		'2019-10-23'),
    ('candauvan@vied.moet.edu.vn',	'Vân',		'Nguyễn Đại Phong',		3,		1,		'2015-4-27'),
    ('tonngokhong@icloud.com',		'Ngô',		'Trần Đại Vương',		3,		4,		'2009-3-11'),
    ('duckdollar@gmail.com',		'Duck',		'Đinh Lẩu Nướng',		1,		3,		'2004-4-19'),
    ('beheothichboiloi@icloud.com',	'Hợi',		'Ninh Lợn Cắp Nách',	3,		3,		'2020-1-24'),
    ('nhalauxehoi@mail.ru',			'Nha',		'Hồ Dao thọc tiết lợn',	2,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru1',		'Nha1',		'Hoàng Yên Ý',			11,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru2',		'Nha2',		'Trương Văn Vũ',		12,		4,		'2020-1-23'),
    ('andersonpt@mail.en',			'Anderson',	'Bố Cái Đại Vương',		7,		2,		'2018-9-2');

INSERT INTO 
`group`( group_name, 	creator_id, 	create_date)
VALUES
		('Đồ nướng',	2,			'2015-11-20'),
        ('Đồ hấp',		2,			'2010-3-8'),
        ('Đồ luộc',		2,			'2011-4-30'),
        ('Ăn sống',		2,			'2008-5-1'),
        ('Đồ uống',		10,			'2012-4-19'),
        ('Tiết canh',	1,			'2016-5-9'),
        ('Mì sợi',		3,			'2018-10-31'),
        ('Bánh bao',	1,			'2020-9-2'),
        ('Bánh giò',	4,			'2019-2-3'),
        ('Chân đất',	7,			'2017-3-26');
INSERT INTO
group_account(group_id, account_id, join_date)
VALUES
			(1,		5,			'2015-11-25'),
            (1,		6,			'2010-3-18'),
            (2,		7,			'2011-5-15'),
            (3,		2,			'2008-5-20'),
            (4,		2,			'2012-4-29'),
            (4,		9,			'2016-5-20'),
            (5,		10,			'2018-10-31'),
            (5,		1,			'2020-9-20'),
            (7,		8,			'2019-2-11'),
            (7,		3,			'2017-4-1');
INSERT INTO
type_question(type_name)
VALUES
		('Essay'),
        ('Multiple-Choice');
INSERT INTO
category_question(category_name)
VALUES
				('Java'),
                ('.NET'),
                ('mySQL'),
                ('Postman'),
                ('Ruby'),
                ('SQLServer'),
                ('C++'),
                ('Pascal'),
                ('Python'),
                ('Unknown');
INSERT INTO
question(content, 	category_id,	 type_id, 		creator_id, 	create_date)
VALUES
		(N'Câu hỏi 1',	1,			1,				1,				'2011-2-14'),
		(N'Câu hỏi 2',	3,			2,				1,				'2012-3-14'),
        ('Unknown3',	4,			2,				5,				'2013-2-14'),
        ('Unknown4',	2,			1,				3,				'2019-3-14'),
        ('Unknown5',	6,			2,				3,				'2010-1-14'),
        ('Unknown6',	8,			1,				6,				'2015-3-14'),
        ('Unknown7',	9,			1,				6,				'2018-4-14'),
        ('Unknown8',	10,			1,				10,				'2019-5-14'),
        ('Unknown9',	7,			2,				10,				'2017-2-14'),
        ('Unknown10',	5,			2,				10,				'2019-1-14');

INSERT INTO
answer(content, question_id, is_correct)
VALUES
	('Unknown1',		1,		'True'),
    ('Unknown2',		3,		'False'),
    ('Unknown3',		4,		'False'),
    ('Unknown4',		1,		'True'),
    ('Unknown5',		2,		'True'),
    ('Unknown6',		6,		'True'),
    ('Unknown7',		8,		'True'),
    ('Unknown8',		1,		'True'),
    ('Unknown9',		1,		'True'),
    ('Unknown10',		10,		'False');
    
INSERT INTO
exam(	`code`,			title, 						category_id,	duration, 	creator_id, create_date)
VALUES
		('A0002',		'Đề thi về my SQL',			3,					180,	1,		'2019-6-21'),
        ('B0014',		'Đề thi về C++',			4,					45,		1,		'2019-6-23'),
        ('A0033',		'Đề thi về Python',			6,					180,	1,		'2019-6-22'),
        ('V1024',		'Đề thi về SQLServer',		7,					200,	10,		'2020-6-25'),
        ('T4567',		'Đề thi về Pascal',			8,					45, 	8,		'2020-6-27'),
        ('G2984',		'Đề thi về Postman',		1,					60,		8,		'2020-6-28'),
        ('H4565',		'Đề thi về .NET',			2,					30,		10,		'2019-6-29'),
        ('O8763',		'Đề thi chung',				3,					20,		10,		'2020-6-30'),
        ('R2345',		'Đề thi về RUBY',			5,					120,	1,		'2019-6-24'),
        ('P9840',		'Đề thi về JAVA',			10,					50,		1,		'2019-6-29');
        
INSERT INTO
exam_question(exam_id, question_id)
VALUES
			(1,			10),
            (1,			7),
            (3,			1),
            (4,			6),
            (5,			4),
            (6,			4),
            (6,			2),
            (8,			5),
            (9,			3),
            (10,		8);
            
	-- ****************** Q1 danh sách nhân viên thuộc phòng ban sale *************

CREATE OR REPLACE VIEW view_1 AS
SELECT 
    account_id, fullname, email, department_name
FROM
    `account`
        JOIN
	department USING (department_id)
WHERE
    department_name = 'Sale';
    
-- ******************* Q2 Thông tin account tham gia vào nhiều group nhất ************

CREATE OR REPLACE VIEW view_2 AS
SELECT 
    account_id, fullname, email, GROUP_CONCAT(group_id) AS number_of_group
FROM
    `account`
        JOIN
    group_account USING (account_id)
GROUP BY account_id
HAVING COUNT(group_id) = (SELECT 
        MAX(number_of_group)
    FROM
        (SELECT 
            COUNT(group_id) AS number_of_group
        FROM
            group_account
        GROUP BY account_id) AS number_group);
        
-- ******************* Q3 lấy ra các câu hỏi có content quá dài (>15 ký tự) và xóa nó đi *************

INSERT INTO question 	(content, 	category_id, 	type_id, 	creator_id, 	create_date)
VALUES 					(N'Thế quái nào không xóa được',
									1,				3,			5,				'2020-08-11');
CREATE OR REPLACE VIEW view_3 AS
    SELECT 
        *, LENGTH(content)
    FROM
        question
    WHERE
        LENGTH(content) > 15;
DELETE
FROM view_3;

 -- ************ Q4 danh sách các phòng ban có nhiều nhân viên nhất ********************

CREATE OR REPLACE VIEW view_4 AS
    SELECT 
        department_id,
        COUNT(fullname) AS number_of_account,
        GROUP_CONCAT(fullname) AS list_of_account
    FROM
        department
            JOIN
        `account` USING (department_id)
    GROUP BY department_id
    HAVING COUNT(fullname) = (SELECT 
            MAX(number_of_staff)
        FROM
            (SELECT 
                COUNT(fullname) AS number_of_staff
            FROM
                department
            JOIN `account` USING (department_id)
            GROUP BY department_id) AS number_staff);
-- ********************** Q5 câu hỏi do user họ Nguyễn tạo ***************         

CREATE OR REPLACE VIEW view_5 AS
    SELECT 
        question_id
    FROM
        question q
            JOIN
        `account` a ON q.creator_id = a.account_id
    WHERE
        fullname LIKE ('Nguyen%');
        
	Select* from view_1;
    Select* from view_2;
    Select* from view_3;
    Select* from view_4;
    Select* from view_5;
DROP DATABASE IF EXISTS testing_system_assignment_6;
CREATE DATABASE IF NOT EXISTS testing_system_assignment_6;
USE testing_system_assignment_6;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department (
	department_id	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
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
    department_id		SMALLINT UNSIGNED,
    position_id			TINYINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (department_id)	REFERENCES department (department_id),
    FOREIGN KEY (position_id) 	REFERENCES `position`(position_id) 
);


DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
	group_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    group_name			NVARCHAR(200),
    creator_id			SMALLINT UNSIGNED,
    create_date			DATE,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

DROP TABLE IF EXISTS group_account;
CREATE TABLE IF NOT EXISTS group_account (
	group_id			SMALLINT UNSIGNED NOT NULL,
    account_id			SMALLINT UNSIGNED NOT NULL,
    join_date			DATE,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id)	REFERENCES `group`(group_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
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
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);


DROP TABLE IF EXISTS answer;
CREATE TABLE IF NOT EXISTS answer (
	answer_id			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    content				TEXT,
    question_id			SMALLINT UNSIGNED,
    is_correct			ENUM('True','False') DEFAULT 'TRUE',
    FOREIGN KEY (question_id) REFERENCES question(question_id)
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
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

DROP TABLE IF EXISTS exam_question;
CREATE TABLE IF NOT EXISTS exam_question (
	question_id			SMALLINT 		UNSIGNED,
    exam_id				SMALLINT 		UNSIGNED,
    PRIMARY KEY (question_id, exam_id),
    FOREIGN KEY (question_id) 			REFERENCES question(question_id),
    FOREIGN KEY (exam_id) 				REFERENCES exam(exam_id)
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
    ('nhalauxehoi@mail.ru1',		'Engine194','Hoàng Yên Ý',			10,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru2',		'Pythago',		'Trương Văn Vũ',		12,		4,		'2020-1-23'),
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
		(N'Câu hỏi 1',	1,			1,				1,				'2020-09-20'),
		(N'Câu hỏi 2',	3,			2,				1,				'2012-3-14'),
        ('Unknown3',	4,			2,				5,				'2020-02-01'),
        ('Unknown4',	2,			1,				3,				'2019-3-14'),
        ('Unknown5',	6,			2,				3,				'2020-10-14'),
        ('Unknown6',	8,			1,				6,				'2015-3-14'),
        ('Unknown7',	9,			1,				6,				'2018-4-14'),
        ('Unknown8',	10,			1,				10,				'2019-5-14'),
        ('Unknown9',	7,			2,				10,				'2017-2-14'),
        ('Unknown10',	5,			2,				10,				'2020-11-14');

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
		('A0002',		'Đề thi về my SQL',			3,					180,	1,		'2016-6-21'),
        ('B0014',		'Đề thi về C++',			4,					45,		1,		'2015-6-23'),
        ('A0033',		'Đề thi về Python',			6,					180,	1,		'2019-6-22'),
        ('V1024',		'Đề thi về SQLServer',		7,					200,	10,		'2012-6-25'),
        ('T4567',		'Đề thi về Pascal',			8,					45, 	8,		'2020-6-27'),
        ('G2984',		'Đề thi về Postman',		1,					60,		8,		'2015-6-28'),
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
            
/*
DROP PROCEDURE IF EXISTS ;
DELIMITER $$
CREATE PROCEDURE ()
	BEGIN
		SELECT
        FROM
	END $$
DELIMITER ;
*/            
-- ************ Q1 tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó ***********

DROP PROCEDURE IF EXISTS pro_1;
DELIMITER $$ 
CREATE PROCEDURE pro_1(IN DepartmentName NVARCHAR(100))
	BEGIN
		SELECT a.account_id, a.username, a.fullname, a.email
		FROM `account` a
            RIGHT JOIN department d ON a.department_id = d.department_id
		WHERE d.department_name = DepartmentName;
	END $$
DELIMITER ;
CALL pro_1('Quản trị');

-- ************ Q2 Tạo store để in ra số lượng account trong mỗi group ************

DROP PROCEDURE IF EXISTS pro_2;
DELIMITER $$
CREATE PROCEDURE pro_2()
	BEGIN
		SELECT g2.group_id, g2.group_name, COUNT(account_id) AS numer_of_acc
        FROM group_account g1
			RIGHT JOIN `group` g2 ON g1.group_id=g2.group_id
		GROUP BY group_id;
	END $$
DELIMITER ;
CALL pro_2();

-- *********** Q3 Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại **********

DROP PROCEDURE IF EXISTS pro_3;
DELIMITER $$
CREATE PROCEDURE pro_3()
	BEGIN
		SELECT t.type_id, t.type_name, COUNT(q.question_id) AS number_of_question
        FROM type_question t
				LEFT JOIN question q ON t.type_id = q.type_id
        WHERE MONTH(q.create_date) = MONTH(NOW()) AND YEAR(q.create_date)  = YEAR(NOW())
        GROUP BY q.type_id;
    END $$
DELIMITER ;
CALL pro_3;
select* from question;

-- ************ Q4 Tạo ra store để trả ra id của type question có nhiều câu hỏi nhất ************

DROP PROCEDURE IF EXISTS pro_4;
DELIMITER $$
CREATE PROCEDURE pro_4(OUT type_of_question INT UNSIGNED)
	BEGIN
		SELECT type_id INTO type_of_question
        FROM question			
		GROUP BY type_id
        HAVING COUNT(question_id) = (SELECT
									MAX(No_of_question)
								FROM (SELECT
									COUNT(question_id) AS No_of_question
								FROM question
                                GROUP BY type_id)
                                AS No_question)
		LIMIT 1;
	END $$
DELIMITER ;
SET @type_of_question = 0;
CALL pro_4(@type_of_question);
SELECT @type_of_question;

-- ************* Q5 Sử dụng store ở Q4 để tìm ra tên của type question ********

DROP PROCEDURE IF EXISTS pro_5;
DELIMITER $$
CREATE PROCEDURE pro_5()
	BEGIN
		DECLARE type_of_question SMALLINT UNSIGNED;
		SET type_of_question = 0;
        CALL pro_4(type_of_question);
		SELECT type_of_question;
        SELECT type_name
        FROM type_question
        WHERE type_id = type_of_question;
	END $$
DELIMITER pro_5();
CALL pro_5;

/* ************ Q6 viết một store cho phép người dùng nhập vào một chuỗi và trả về group có tên chứa chuỗi
của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào *********** */

DROP PROCEDURE IF EXISTS pro_6;
DELIMITER $$
CREATE PROCEDURE pro_6(IN input_username_or_group_name NVARCHAR(100))
	BEGIN
		SELECT username AS `name`, 'username' AS `type`
        FROM `account`
        WHERE username LIKE CONCAT('%', input_username_or_group_name , '%')
			UNION
        SELECT group_name `name`, 'group' AS `type`
        FROM `group`
        WHERE group_name LIKE CONCAT ('%', input_username_or_group_name, '%');
	END $$
DELIMITER ;
CALL pro_6('a');

/* ********** Q7 viết một store cho phép người dùng nhập vào thông tin full name, email và 
trong store sẽ tự động gán username sẽ giống email nhưng bỏ @...mail đi positionid sẽ có default là developer,
department_id sẽ được cho vào một phòng chờ. Sau đó in kết quả tạo thành công ***** */

DROP PROCEDURE IF EXISTS pro_7;
DELIMITER $$
CREATE PROCEDURE pro_7(IN enter_full_name NVARCHAR(100), IN enter_email VARCHAR(100))
	BEGIN
		DELETE FROM department
        WHERE department_id = 9999;
        INSERT INTO department	(department_id, 	department_name)
        VALUE 					(9999, 				'Phòng chờ');
		DELETE FROM `account`
        WHERE email = enter_email;
        INSERT INTO `account`	(email, 			username, 						fullname, 			department_id,	position_id,	create_date)
        VALUE 					(enter_email, SUBSTRING_INDEX(enter_email,'@',1),	enter_full_name,	9999,			1,				NOW());
        SELECT *
        FROM `account`
        WHERE email = enter_email;
	END $$
DELIMITER ;
CALL testing_system_assignment_6.pro_7('LÊ VĂN LỘC', 'locheo1234@icloud.com');


/* ********** Q8 Viết một store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi 
essay hoặc multiple-choice nào có content dài nhất ***** */

DROP PROCEDURE IF EXISTS pro_8;
DELIMITER $$
CREATE PROCEDURE pro_8(IN Essay_or_Multiple_Choice VARCHAR(15))
	BEGIN
		SELECT type_name, question_id, LENGTH(content)
        FROM type_question
			JOIN question USING (type_id)
		WHERE type_name = Essay_or_Multiple_Choice
        AND LENGTH(content) = (SELECT
								MAX(number_of_char)
                            FROM (SELECT
								LENGTH(content) AS number_of_char
							FROM question
								JOIN type_question USING (type_id)
							WHERE type_name = Essay_or_Multiple_Choice)
                            AS number_char);		
	END $$
DELIMITER ;

CALL pro_8('Multiple-Choice');

-- ********* Q9 Viết 1 store cho phép người dùng xóa exam dựa vào ID *******

DROP PROCEDURE IF EXISTS pro_9;
DELIMITER $$
CREATE PROCEDURE pro_9(IN enter_ID_exam INT UNSIGNED)
	BEGIN
		DELETE FROM exam
        WHERE exam_id = enter_ID_exam;
	END $$
DELIMITER ;

CALL pro_9(1);
SELECT * FROM exam;

/* ********* Q10 Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa).
Sau đó in số lượng record đã remove từ các table liên quan trong khi removing ****** */

DROP PROCEDURE IF EXISTS pro_10_1;
DELIMITER $$
CREATE PROCEDURE pro_10_1()
	BEGIN
		DECLARE exam_number SMALLINT UNSIGNED;
        DECLARE var1 SMALLINT UNSIGNED;
        DECLARE var2 SMALLINT UNSIGNED;
        SET exam_number = 0;
        SET var1 = 0;
        SET var2 = (SELECT
					COUNT(exam_id)
				FROM exam
				WHERE (YEAR(NOW()) - YEAR(create_date)) >= 3);
        REPEAT
			SET exam_number = (SELECT
							MAX(exam_id)
						FROM exam
						WHERE (YEAR(NOW()) - YEAR(create_date)) >= 3);
			CALL pro_9(exam_number);
            SET var1 = var1 + 1;
        UNTIL var1 = var2 END REPEAT;
	END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS pro_10;
DELIMITER $$
CREATE PROCEDURE pro_10()
	BEGIN
		SELECT 'exam' AS `table_name`, COUNT(exam_id) AS number_record_deleted FROM exam
		WHERE (YEAR(NOW()) - YEAR(create_date)) >= 3; 
        CALL pro_10_1();
	END $$
DELIMITER ;

/* ******* Q11 viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các
account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc***** */

DROP PROCEDURE IF EXISTS pro_11 ;
DELIMITER $$
CREATE PROCEDURE pro_11(IN input_department_name NVARCHAR(100))
	BEGIN
		WITH CTE1 AS (
			SELECT
				account_id 
			FROM `account`
					JOIN department USING (department_id)
			WHERE department_name = input_department_name)			
        UPDATE `account`
        SET department_id = 9999
        WHERE account_id = ANY (SELECT
							account_id
						FROM CTE1);
		DELETE FROM department
        WHERE department_name = input_department_name;
        DELETE FROM department
        WHERE department_id = 9999;
        INSERT INTO
			department	(department_id, department_name)
		VALUE 			(9999, 			'Phòng chờ');
		SELECT *
        FROM `account`;
	END $$
DELIMITER ;




/* ************* Q12 viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo ra trong năm nay *********** */

DROP VIEW IF EXISTS view_12;
CREATE VIEW view_12 As
	SELECT EachMonthInYear.`MONTH`
	FROM
	(
				SELECT 1 AS `MONTH`
				UNION SELECT 2 AS `MONTH`
				UNION SELECT 3 AS `MONTH`
				UNION SELECT 4 AS `MONTH`
				UNION SELECT 5 AS `MONTH`
				UNION SELECT 6 AS `MONTH`
				UNION SELECT 7 AS `MONTH`
				UNION SELECT 8 AS `MONTH`
				UNION SELECT 9 AS `MONTH`
				UNION SELECT 10 AS `MONTH`
				UNION SELECT 11 AS `MONTH`
				UNION SELECT 12 AS `MONTH`
	) AS EachMonthInYear;
    
DROP PROCEDURE IF EXISTS pro_12;
DELIMITER $$
CREATE PROCEDURE pro_12()
	BEGIN		
			WITH CTE2 AS(
				WITH CTE1 AS (
				SELECT MONTH(create_date) as month_created, count(question_id) AS number_question
				FROM question
				WHERE YEAR(create_date) = YEAR(NOW())
				GROUP BY month_created
				ORDER BY month_created)
            
				SELECT v12.`MONTH`, CTE1.number_question
				FROM view_12 v12
						JOIN CTE1 ON v12.`MONTH` = CTE1.month_created
					UNION
				SELECT v12.`MONTH`, 0 AS number_question
                FROM view_12 v12
						LEFT JOIN CTE1 ON v12.`MONTH` = CTE1.month_created
				WHERE CTE1.month_created IS NULL)
			SELECT * FROM CTE2
            ORDER BY `MONTH`;
	END $$
DELIMITER ;
CALL pro_12;

/* ************ Q13 Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo ra trong 6 tháng gần đây nhất 
(Nếu tháng nào không có sẽ in ra là không có câu hỏi nào trong tháng)******* */

DROP PROCEDURE IF EXISTS pro_13;
DELIMITER $$
CREATE PROCEDURE pro_13()
	BEGIN
		WITH CTE3 AS (
			WITH CTE1 AS (
				SELECT SixMonthInYear.`month`
				FROM
					(
					SELECT month(now()) AS `month`
					UNION SELECT month(now())-1 AS `month`
					UNION SELECT month(now())-2 AS `month`
					UNION SELECT month(now())-3 AS `month`
					UNION SELECT month(now())-4 AS `month`
					UNION SELECT month(now())-5 AS `month`
					) AS SixMonthInYear),
			CTE2 AS (
					SELECT MONTH(create_date) as month_created, count(question_id) AS number_question, MONTH(now())-MONTH(create_date)
					FROM question
					WHERE  (MONTH(now())- MONTH(create_date)) <= 5
					GROUP BY month_created
					ORDER BY month_created)
			SELECT CTE1.`month`, CTE2.number_question
			FROM CTE1 JOIN CTE2 ON CTE1.`month` = CTE2.month_created
				UNION
			SELECT CTE1.`month`, N'Không có câu hỏi nào trong tháng' As number_question
			FROM CTE1 LEFT JOIN CTE2 ON CTE1.`month` = CTE2.month_created
			WHERE CTE2.month_created IS NULL)
		SELECT *
		FROM CTE3
		ORDER BY CTE3.`month` DESC;
	END $$
DELIMITER ;
CALL pro_13;
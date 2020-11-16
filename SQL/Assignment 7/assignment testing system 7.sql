DROP DATABASE IF EXISTS testing_system_assignment_7;
CREATE DATABASE IF NOT EXISTS testing_system_assignment_7;
USE testing_system_assignment_7;
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
    gender				ENUM ('M','F','U','nam','nữ','không xác định'),
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
`account`(email, 					username, 	fullname, 				gender, department_id, position_id, create_date)
VALUES
	('heoquay@gmail.com',			'Heo',		'Nguyễn Ngọc Tuấn',		'M',		2,		1,		'2012-12-14'),
	('gaquay@gmail.com',			'Gà',		'Đào Thị Nở',			'F',		5,		1,		'2011-3-5'),
    ('vitquaybackinh@gmail.com',	'Vịt',		'Lê Trương Bình',		'M',		1,		1,		'2016-9-8'),
    ('thoquay@icloud.com',			'Thỏ',		'Lã Đại Gia',			'U',		6,		2,		'2019-10-23'),
    ('candauvan@vied.moet.edu.vn',	'Vân',		'Nguyễn Đại Phong',		'M',		3,		1,		'2015-4-27'),
    ('tonngokhong@icloud.com',		'Ngô',		'Trần Đại Vương',		'M',		3,		4,		'2009-3-11'),
    ('duckdollar@gmail.com',		'Duck',		'Đinh Lẩu Nướng',		'U',		1,		3,		'2004-4-19'),
    ('beheothichboiloi@icloud.com',	'Hợi',		'Ninh Lợn Cắp Nách',	'U',		3,		3,		'2020-1-24'),
    ('nhalauxehoi@mail.ru',			'Nha',		'Hồ Dao thọc tiết lợn',	'U',		2,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru1',		'Engine194','Hoàng Yên Ý',			'F',		10,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru2',		'Pythago',	'Trương Văn Vũ',		'M',		12,		4,		'2020-1-23'),
    ('andersonpt@mail.en',			'Anderson',	'Bố Cái Đại Vương',		'M',		7,		2,		'2018-9-2');

INSERT INTO 
`group`( group_name, 	creator_id, create_date)
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
    ('Unknown4',		1,		'False'),
    ('Unknown5',		2,		'True'),
    ('Unknown6',		6,		'True'),
    ('Unknown7',		8,		'True'),
    ('Unknown8',		1,		'False'),
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
            
-- *********** Q1 Tạo trigger không cho phép người dùng nhập vào group có ngày tạo trước 1 năm ************

DROP TRIGGER IF EXISTS trig_1;
DELIMITER $$
CREATE TRIGGER trig_1
BEFORE INSERT ON `group`
FOR EACH ROW
	BEGIN
		IF (YEAR(NOW()) - YEAR(NEW.create_date)) > 1 THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'chỉ nhập vào dữ liệu một năm trở lại đây';
        END IF;
    END $$
DELIMITER ;

-- ******** CHECK
INSERT INTO `group`	(group_name,creator_id,create_date)
VALUE 				('thử việc',10,'2018-11-15');

-- ********** Q2 Tạo trigger không cho phép người dùng thêm bất kỳ user nào vào department 'Sale' nữa,
-- khi thêm thì hiện ra thông báo 'Department 'Sale' cannot add more user' ************

DROP TRIGGER IF EXISTS trig_2;
DELIMITER $$
CREATE TRIGGER trig_2
BEFORE INSERT ON `account`
FOR EACH ROW
	BEGIN
		IF NEW.department_id = (SELECT
							department_id
						FROM department
                        WHERE department_name = 'Sale') THEN
		SIGNAL SQLSTATE '10002'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;

-- ******** CHECK
INSERT INTO `account`(email,username,fullname,department_id,position_id,create_date)
VALUE ('engine194@gmail.com', 'Engine194', 'Nguyễn Đắc Ngọc',7,7,NULL);

-- *********** Q3 Cấu hình một group có nhiều nhất là 5 user *****************

DROP TRIGGER IF EXISTS trig_3;
DELIMITER $$
CREATE TRIGGER trig_3
BEFORE INSERT ON `group_account`
FOR EACH ROW
	BEGIN
		IF (	(SELECT COUNT(account_id)
				FROM `group_account`
				WHERE group_id = NEW.group_id) + 1) > 5 THEN
			SIGNAL SQLSTATE '10003'
			SET MESSAGE_TEXT = 'Mỗi group nhiều nhất 5 người';
        END IF;
    END $$
DELIMITER ;

-- ******** CHECK
SELECT * FROM group_account;
INSERT INTO group_account (group_id, account_id) VALUE (1,10);

-- ********** Q4 Cấu hình 1 bài thi có nhiều nhất là 10 questions

DROP TRIGGER IF EXISTS trig_4;
DELIMITER $$
CREATE TRIGGER trig_4
BEFORE INSERT ON exam_question
FOR EACH ROW
	BEGIN
		IF ((SELECT
			COUNT(question_id)
		FROM exam_question
		WHERE exam_id = NEW.exam_id) + 1) > 10 THEN
		SIGNAL SQLSTATE '10004'
		SET MESSAGE_TEXT = 'Mỗi exam tối đa 10 câu hỏi';
		END IF;
	END $$
DELIMITER ;

-- ******** CHECK
SELECT * FROM exam_question;
INSERT INTO exam_question(question_id, exam_id) VALUE (11,3);

-- *********** Q5 Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com 9
-- đây là tài khoản admin, không cho phép các user xóa), còn lại các tài khoản khác thì sẽ cho phép
-- xóa tất cả các thông tin liên quan tới user đó

DROP TRIGGER IF EXISTS trig_5;
DELIMITER $$
CREATE TRIGGER trig_5
BEFORE DELETE ON `account`
FOR EACH ROW
	BEGIN
		IF OLD.email LIKE('%admin@gmail.com%') THEN
		SIGNAL SQLSTATE '10005'
		SET MESSAGE_TEXT = 'Không thể xóa admin';
		ELSE
		DELETE FROM exam 	WHERE creator_id = OLD.account_id;
		DELETE FROM `group` WHERE creator_id = OLD.account_id;
		DELETE FROM group_account WHERE account_id = OLD.account_id;
		DELETE FROM question WHERE creator_id = OLD.account_id;
		END IF;
	END $$
DELIMITER ;

-- *********** Q6 Không dùng DEFAULT cho trường department_id trong bảng account, hãy tạo
-- trigger cho phép người dùng tạo account không điền vào department_id thì sẽ được phân
-- vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS trig_6;
DELIMITER $$
CREATE TRIGGER trig_6
BEFORE INSERT ON `account`
FOR EACH ROW
	BEGIN
		IF NEW.department_id IS NULL THEN
        DELETE FROM department WHERE department_id = 9999;
        INSERT INTO department(department_id, department_name) VALUE (9999,'waiting Department');
        SET NEW.department_id = 9999;
        END IF;
    END $$
DELIMITER ;

-- ******** CHECK
INSERT INTO `account`(email,username,fullname,department_id,position_id,create_date)
VALUE ('engine194@gmail.com', 'Engine194', 'Nguyễn Đắc Ngọc',NULL,7,NULL);
SELECT * FROM `account`;

DELETE FROM `account` WHERE username = 'Engine194';

-- ********** Q7 Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answer cho mỗi question, trong đó
-- có tối đa 2 đáp án đúng

DROP TRIGGER IF EXISTS trig_7;
DELIMITER $$
CREATE TRIGGER trig_7
BEFORE INSERT ON answer
FOR EACH ROW
	BEGIN
		IF ((SELECT 
			COUNT(answer_id)
		FROM answer
        WHERE question_id = NEW.question_id)+1) > 4 THEN
        SIGNAL SQLSTATE '10007'
        SET MESSAGE_TEXT = 'Mỗi câu hỏi nhiều nhất 4 câu trả lời';
			ELSEIF (((SELECT
					COUNT(is_correct)
				FROM answer
                WHERE question_id = NEW.question_id
                AND is_correct = 'True') >= 2) AND NEW.is_correct = 'True') THEN
			SIGNAL SQLSTATE '10008'
			SET MESSAGE_TEXT = 'Mỗi câu hỏi tối đa 2 đáp án đúng';
        END IF;
    END $$
DELIMITER ;

-- ******** CHECK
SELECT * FROM answer;
INSERT INTO answer (answer_id,question_id,is_correct) VALUE (11,2, 'True');
INSERT INTO answer (answer_id,question_id,is_correct) VALUE (11,1, 'True');

-- ************ Q8 Viết trigger sửa lại dữ liệu cho đúng: nếu người dùng nhập vào gender của account là nam, nữ,
-- không xác định, thì sẽ đổi lại thành M,F,U cho giống với cấu hình cua database

DROP TRIGGER IF EXISTS trig_8;
DELIMITER $$
CREATE TRIGGER trig_8
BEFORE INSERT ON `account`
FOR EACH ROW
	BEGIN
		IF NEW.gender = 'nam' THEN
        SET NEW.gender = 'M';
        ELSEIF NEW.gender = N'nữ' THEN 
        SET NEW.gender = 'F';
        ELSEIF NEW.gender = N'không xác định' THEN
        SET NEW.gender = 'U';
        ELSEIF NEW.gender IS NULL THEN
        SET NEW.gender = 'U';
        END IF;
    END $$
DELIMITER ;

-- *********** CHECK
INSERT INTO `account`(email,username,fullname, gender, department_id,position_id,create_date)
VALUE ('engine194@gmail.com', 'Engine194', 'Nguyễn Đắc Ngọc', 'nam', 4 ,7,NULL);
SELECT * FROM `account`;
DELETE FROM `account` WHERE username = 'Engine194';

-- *********** Q9 viết trigger không cho phép người dùng xóa bài thi mới được tạo cách đây 2 ngày

DROP TRIGGER IF EXISTS trig_9;
DELIMITER $$
CREATE TRIGGER trig_9
BEFORE DELETE ON exam
FOR EACH ROW
	BEGIN
		IF (DATE(NOW()) - DATE(OLD.create_date)) < 2 THEN
        SIGNAL SQLSTATE '10009'
        SET MESSAGE_TEXT = 'Không thể xóa các bài thi mới tạo 2 ngày';
        END IF;
    END $$
DELIMITER ;

-- ************* CHECK
INSERT INTO exam(`code`,create_date) VALUE ('P9841','2020-11-12');
DELETE FROM exam where `code`='P9841';

-- ************* Q10 viết trigger chỉ cho phép người dùng update, delete các question khi question đó
-- chưa nằm trong exam nào.

DROP TRIGGER IF EXISTS trig_10_1;
DELIMITER $$
CREATE TRIGGER trig_10_1
BEFORE UPDATE ON question
FOR EACH ROW
	BEGIN
		IF (SELECT exam_id FROM exam_question WHERE question_id = OLD.question_id LIMIT 1) IS NOT NULL THEN
        SIGNAL SQLSTATE '10010'
        SET MESSAGE_TEXT = "Không thể update vì câu hỏi nằm trong exam";
        END IF;
    END $$
DELIMITER ;


DROP TRIGGER IF EXISTS trig_10_2;
DELIMITER $$
CREATE TRIGGER trig_10_2
BEFORE DELETE ON question
FOR EACH ROW
	BEGIN
		IF (SELECT exam_id FROM exam_question WHERE question_id = OLD.question_id LIMIT 1) IS NOT NULL THEN
        SIGNAL SQLSTATE '10011'
        SET MESSAGE_TEXT = "Không thể xóa vì câu hỏi nằm trong exam";
        END IF;
    END $$
DELIMITER ;

-- ********** CHECK
SELECT * FROM exam_question;
UPDATE question
SET content = 'ấdafsadf'
WHERE question_id = 10;
DELETE FROM question
WHERE question_id = 10;

-- ********** Q12 Lấy ra thông tin exam trong đó 
-- Duration <= 30 thì sẽ đổi thành giá trị 'Short time'
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị 'Medium time'
-- Duaration > 60 thì sẽ đổi thành giá trị 'Long time'

SELECT 
    *,
    CASE
        WHEN exam.duration <= 30 THEN 'Short time'
        WHEN
            exam.duration <= 60
                AND exam.duration > 30
        THEN
            'Medium time'
        WHEN exam.duration > 60 THEN 'Long time'
    END AS type_time
FROM
    exam; 

-- ************ Q13 Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là
-- the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group <= 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group < 5 và <= 20 thfi sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT 
    group_id,
    group_name,
    COUNT(account_id) AS number_user,
    CASE
        WHEN COUNT(account_id) <= 5 THEN 'few'
        WHEN
            COUNT(account_id) > 5
                AND COUNT(account_id) <= 20
        THEN
            'normal'
        WHEN COUNT(account_id) > 20 THEN 'higher'
    END AS the_number_user_amount
FROM
    group_account
        RIGHT JOIN
    `group` USING (group_id)
GROUP BY group_id
ORDER BY group_id;

-- *********** Q13 Thống kê mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có
-- user thì sẽ thay đổi giá trị 0 thành 'Không có User'

SELECT
	department_id,
    department_name,
	CASE
		WHEN COUNT(account_id) <> 0 THEN COUNT(account_id)
        WHEN COUNT(account_id) = 0 THEN 'Không có User'
	END AS number_of_user
FROM department
		LEFT JOIN `account` USING (department_id)
GROUP BY department_id
ORDER BY department_id;
DROP DATABASE IF EXISTS testing_system_assignment_4;
CREATE DATABASE IF NOT EXISTS testing_system_assignment_4;
USE testing_system_assignment_4;
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

-- Q1 Thêm ít nhất 10 bản ghi vào mỗi bảng
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
	('heoquay@gmail.com',			'Heo',		'Ngọc Tuấn',		2,		1,		'2012-12-14'),
	('gaquay@gmail.com',			'Gà',		'Thị Nở',			5,		1,		'2011-3-5'),
    ('vitquaybackinh@gmail.com',	'Vịt',		'Trương Bình',		1,		1,		'2016-9-8'),
    ('thoquay@icloud.com',			'Thỏ',		'Đại Gia',			6,		2,		'2019-10-23'),
    ('candauvan@vied.moet.edu.vn',	'Vân',		'Đại Phong',		3,		1,		'2015-4-27'),
    ('tonngokhong@icloud.com',		'Ngô',		'Đại Vương',		3,		4,		'2009-3-11'),
    ('duckdollar@gmail.com',		'Duck',		'Lẩu Nướng',		1,		3,		'2004-4-19'),
    ('beheothichboiloi@icloud.com',	'Hợi',		'Lợn Cắp Nách',		3,		3,		'2020-1-24'),
    ('nhalauxehoi@mail.ru',			'Nha',		'Dao thọc tiết lợn',2,		4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru1',		'Nha1',		'Dao thọc tiết lợn1',11,	4,		'2020-1-23'),
    ('nhalauxehoi@mail.ru2',		'Nha2',		'Dao thọc tiết lợn2',12,	4,		'2020-1-23'),
    ('andersonpt@mail.en',			'Anderson',	'Bố Cái Đại Vương',	7,		2,		'2018-9-2');

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
            (4,		4,			'2012-4-29'),
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
        ('Unknown3',	4,			2,				1,				'2013-2-14'),
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
            
	-- Q1 Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    a.account_id,
    a.email,
    a.username,
    a.fullname,
    b.department_name
FROM
    `account` a
        LEFT JOIN
    department b ON a.department_id = b.department_id;
    -- or
SELECT 
    account_id, email, username, fullname, department_name
FROM
    `account`
        LEFT JOIN
    department USING (department_id);
    
    -- Q2 Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT 
    *
FROM
    `account`
WHERE
    create_date > '2010-12-20';
    
    -- Q3 Viết lệnh để lấy ra rất cả các developer
SELECT 
    a.account_id,
    a.email,
    a.username,
    a.fullname,
    a.create_date,
    b.position_name
FROM
    `account` a
        JOIN
    `position` b ON a.position_id = b.position_id
WHERE
    position_name = 'DEV';
    -- or
SELECT 
    account_id,
    email,
    username,
    fullname,
    create_date,
    position_name
FROM
    `account`
        JOIN
    `position` USING (position_id)
WHERE
    position_name = 'DEV';
    
    -- Q4 Viết lệnh để lấy ra danh sách các phòng ban có hơn hoặc bằng 3 nhân viên.
SELECT 
    department_name,
    COUNT(username) AS number_of_members,
    GROUP_CONCAT(fullname) AS members_of_group
FROM
    `account`
        JOIN
    department USING (department_id)
GROUP BY department_id
HAVING COUNT(username) > 2;
	
    -- Q5 Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 
    question_id,
    COUNT(exam_id) AS number_of_exam,
    GROUP_CONCAT(exam_id) AS used_on_exam_id
FROM
    exam_question
GROUP BY question_id
HAVING COUNT(exam_id) = (SELECT 
        COUNT(exam_id)
    FROM
        exam_question
    GROUP BY question_id
    ORDER BY COUNT(exam_id) DESC
    LIMIT 1);

	-- Q6 Thống kê mỗi category được sử dụng trong bao nhiêu question
SELECT 
    category_id,
    category_name,
    COUNT(category_id) AS numer_of_question
FROM
    category_question
        LEFT JOIN
    question USING (category_id)
GROUP BY category_id;

	-- Q7 Thống kê mỗi question được sử dụng trong bao nhiêu exam
SELECT 
    question_id,
    COUNT(exam_id) AS number_of_exam,
    GROUP_CONCAT(exam_id) AS used_on_exam_id
FROM
    exam_question
        RIGHT JOIN
    question USING (question_id)
GROUP BY question_id
ORDER BY question_id;

	-- Q8 Lấy ra question có nhiều câu trả lời nhất
SELECT 
    question_id,
    COUNT(answer_id) AS number_of_answer,
    GROUP_CONCAT(answer_id) AS answer_id_for_question
FROM
    answer
GROUP BY question_id
HAVING COUNT(answer_id) = (SELECT 
        COUNT(answer_id)
    FROM
        answer
    GROUP BY question_id
    ORDER BY COUNT(answer_id) DESC
    LIMIT 1);
	
    -- Q9 Thống kê số lượng account trong mỗi group
SELECT 
    group_id, group_name, COUNT(account_id) AS number_of_acc
FROM
    group_account
        RIGHT JOIN
    `group` USING (group_id)
GROUP BY group_id
ORDER BY group_id;

	-- Q10 Tìm chức vụ có ít người nhất
SELECT 
    position_id,
    position_name,
    COUNT(account_id) AS number_of_acc
FROM
    `account`
        RIGHT JOIN
    `position` USING (position_id)
GROUP BY position_id
HAVING COUNT(account_id) = (SELECT 
        COUNT(account_id)
    FROM
        `account`
    GROUP BY position_id
    ORDER BY COUNT(account_id)
    LIMIT 1);
	
    -- Q11 Thống kê mỗi phòng ban có bao nhiêu nhân viên thuộc 1 trong 4 chức vụ (DEV, Test, Scrum Master, PM)
SELECT 
    *, COUNT(department_id)
FROM
    `account`
        RIGHT JOIN
    `position` USING (position_id)
WHERE
    position_name IN ('Dev' , 'Test', 'Scrum Master', 'PM')
GROUP BY department_id
ORDER BY department_id;

	-- Q12 Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, creator, câu trả lời ...
SELECT 
    a.question_id,
    a.content,
    c.category_name,
    d.type_name,
    e.fullname AS creator,
    b.content AS answer
FROM
    question a
        LEFT JOIN
    answer b ON a.question_id = b.question_id
        LEFT JOIN
    category_question c ON a.category_id = c.category_id
        LEFT JOIN
    type_question d ON a.type_id = d.type_id
        LEFT JOIN
    `account` e ON a.creator_id = e.account_id;
    
    -- Q13 Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 
    type_id, type_name, COUNT(question_id) AS number_of_question
FROM
    type_question
        LEFT JOIN
    question USING (type_id)
GROUP BY type_id
ORDER BY type_id;
	-- Q14 Lấy ra group không có account nào
SELECT 
    group_id, group_name, COUNT(account_id) AS number_of_acc
FROM
    `group`
        LEFT JOIN
    `group_account` USING (group_id)
GROUP BY group_id
HAVING COUNT(account_id) = 0
ORDER BY group_id; 
    
    -- Q15 Lấy ra group không có account nào, (giống hệt Q14)
SELECT 
    group_id, group_name,
    COUNT(account_id) AS number_of_acc
FROM
    `group`
        LEFT JOIN
    `group_account` USING (group_id)
GROUP BY group_id
HAVING COUNT(account_id) = 0
ORDER BY group_id;

	-- Q16 Lấy ra question không có answer nào
SELECT 
    question_id, COUNT(answer_id) AS number_of_answer
FROM
    question
        LEFT JOIN
    answer USING (question_id)
GROUP BY question_id
HAVING COUNT(answer_id) = 0
ORDER BY question_id;

	-- Q17a, lấy các account thuộc group 1
SELECT 
    account_id,
    email,
    username,
    fullname,
    group_id
FROM
    `account`
        LEFT JOIN
    `group_account` USING (account_id)
WHERE
    group_id = 1;
    -- Q17b, lấy ra các account thuộc group 2
SELECT 
    account_id,
    email,
    username,
    fullname,
    group_id
FROM
    `account`
        LEFT JOIN
    group_account USING (account_id)
WHERE
    group_id = 2;
	-- Q17c, ghép kết quả từ câu a, và b, sao cho không có record nào trùng nhau
SELECT 
    account_id,
    email,
    username,
    fullname, group_id
FROM
    `account`
        LEFT JOIN
    `group_account` USING (account_id)
WHERE
    group_id = 1
UNION
SELECT 
    account_id,
    email,
    username,
    fullname,
    group_id
FROM
    `account`
        LEFT JOIN
    group_account USING (account_id)
WHERE
    group_id = 2;
	
	-- Q18a, lấy các group có lớn hơn 5 thành viên
SELECT 
    group_id,
    COUNT(account_id) AS number_of_acc
FROM
    group_account
GROUP BY group_id
HAVING COUNT(account_id) > 5;
	-- Q18b, lấy các group có ít hơn 7 thành viên
SELECT 
    group_id,
    group_name,
    COUNT(account_id) AS number_of_acc
FROM
    group_account
        RIGHT JOIN
    `group` USING (group_id)
GROUP BY group_id
HAVING COUNT(account_id) < 7;
	-- Q18c, ghép hai kết quả từ câu a, b,
SELECT 
    group_id,
    group_name,
    COUNT(account_id) AS number_of_acc
FROM
    group_account
        RIGHT JOIN
    `group` USING (group_id)
GROUP BY group_id
HAVING COUNT(account_id) > 5 
UNION SELECT 
    group_id,
    group_name,
    COUNT(account_id) AS number_of_acc
FROM
    group_account
        RIGHT JOIN
    `group` USING (group_id)
GROUP BY group_id
HAVING COUNT(account_id) < 7;
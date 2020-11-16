DROP DATABASE IF EXISTS test_2;
CREATE DATABASE test_2;
USE test_2;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT(10) 	PRIMARY KEY AUTO_INCREMENT,
    first_name 	VARCHAR(30),
    last_name 	VARCHAR(30),
    email 		VARCHAR(100),
    phone 		VARCHAR(20),
    employee_id VARCHAR(10),
    avatar 		TEXT,
    department_id INT(10),
    gender 		TINYINT(10),
    age 		INT(3),
    created_at 	DATETIME,
    update_at 	DATETIME
);
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30),
    `description` TEXT,
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS user_department;
CREATE TABLE user_department (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    user_id INT(10),
    department_id INT(10),
    start_date DATE,
    end_date DATE,
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30),
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS salary;
CREATE TABLE salary (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    user_role_id INT(10),
    total_salary DOUBLE(12 , 2 ),
    `month` VARCHAR(2),
    `year` VARCHAR(4),
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    user_department_id INT(10),
    role_id INT(10),
    start_date DATE,
    end_date DATE,
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS salary_detail_type;
CREATE TABLE salary_detail_type (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(10),
    created_at DATETIME,
    update_at DATETIME
);
DROP TABLE IF EXISTS salary_detail;
CREATE TABLE salary_detail (
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE(12 , 2 ),
    salary_id INT(10),
    salary_detail_type_id INT(10),
    operation TINYINT(3)
);

INSERT INTO
department 	(`name`)
VALUES 		('Admin'),
			('HR'),
            ('IT'),
            ('Delivery');

INSERT INTO
users		(first_name, last_name, 	email,					phone,			department_id, gender, age)
VALUES      ('Phan',	'Thế Anh',		'theanh89@gmail.com',	'0977462219',	2,				'Nam', 26),
            ('Lương',	'Mạnh Hà',		'manhha99@icloud.com',	'0988562453',	3,				'Nam', 25),
            ('Lê',		'Thị Vân Anh',	'vanhle01@gmail.com',	'0462345686',	4,				'Nữ',  19),
            ('Nguyễn',	'Đắc Ngọc',		'duckdollar@gmail.com',	'0977462218',	2,				'Nam', 24),
            ('Lương',	'Mạnh Hà1',		'manhha99@icloud.com',	'0988562453',	4,				'Nam', 25),
            ('Lương',	'Mạnh Hà2',		'manhha99@icloud.com',	'0988562453',	4,				'Nam', 25),
            ('Lương',	'Mạnh Hà3',		'manhha99@icloud.com',	'0988562453',	4,				'Nam', 25),
            ('Lương',	'Mạnh Hà4',		'manhha99@icloud.com',	'0988562453',	5,				'Nam', 25),
            ('Lương',	'Mạnh Hà5',		'manhha99@icloud.com',	'0988562453',	5,				'Nam', 25),
            ('Lương',	'Mạnh Hà6',		'manhha99@icloud.com',	'0988562453',	3,				'Nam', 25),
            ('Phan',	'Thế Anh',		'theanh89@gmail.com',	'0977462219',	1,				'Nam', 26),
            ('Phan',	'Thế Anh',		'theanh89@gmail.com',	'0977462219',	1,				'Nam', 26),
            ('Phan',	'Thế Anh',		'theanh89@gmail.com',	'0977462219',	2,				'Nam', 26),
            ('Phan',	'Thế Anh',		'theanh89@gmail.com',	'0977462219',	2,				'Nam', 26);
 INSERT INTO
 roles		(`name`)
 VALUES		('Giám đốc'),
			('Trưởng phòng'),
            ('Phó phòng'),
            ('Nhân viên'),
            ('CTV');

		
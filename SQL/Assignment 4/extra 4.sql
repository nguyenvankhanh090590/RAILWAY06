DROP DATABASE if EXISTS extra_4;
CREATE DATABASE IF NOT EXISTS extra_4;
USE extra_4;
SET foreign_key_checks = 0;
-- ************* Q1 tạo bảng với các ràng buộc và kiểu dữ liệu *******************
CREATE TABLE department (
    department_num MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    department_name NVARCHAR(100)
);

CREATE TABLE employee (
    employee_num INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    employee_name NVARCHAR(100),
    department_num MEDIUMINT UNSIGNED,
    Foreign KEY (department_num) REFERENCES department(department_num)
);

CREATE TABLE employee_skill (
    employee_num INT UNSIGNED,
    skill_code SMALLINT UNSIGNED,
    date_registered DATE,
    PRIMARY KEY (employee_num, skill_code),
    FOREIGN KEY (employee_num) REFERENCES employee(employee_num),
	FOREIGN KEY (skill_code) REFERENCES skill(skill_code)
);

create table skill (
	skill_code SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    skill_name NVARCHAR(50)
);

-- ************* Q2 thêm ít nhất 10 bản ghi vào các bảng ********************

INSERT INTO 
department(	department_name)
VALUES
			('CEO'),
			('Giám đốc'),
			('Thư ký'),
			('Luật sư'),
			('Nhân sự'),
			('Sale'),
			('Marketing'),
			('Bảo trì'),
			('Đào tạo'),
			('Bảo vệ');

INSERT INTO
employee(employee_name, 			department_num)
VALUES
		('Tống Thùy Nga',			1),
		('Nguyễn Đắc Thắng',		3),
		('Lê Sơn Hưng',				3),
		('Đoàn Minh Quang',			4),
		('Lê Đức Việt',				5),
		('Nguyễn Đắc Ngọc',			6),
		('Từ Văn Đại',				7),
		('Đào Thị Thủy Tiên',		8),
		('Nguyễn Ngọc Yến',			1),
		('Đàm Thanh Sơn',			2),
		('Vũ Trọng Phụng',			9),
		('Nguyễn Khoái',            6),
		('Trần Trọng Kim',          3),
		('Đoan Trang',              4),
		('Lung Thị Linh',           NULL),
        ('Đào Tuyết Nhi',           1),
        ('Trần Thanh Tùng',         1),
        ('Lã Thị Thơm',             1),
        ('Quả Thị Ánh',             3),
        ('Lương Thế Minh',          3),
        ('Johny Deppt',             4);

INSERT INTO
employee_skill (	employee_num, 	skill_code, 	date_registered)
VALUES
				(	1,				2,				'2011-12-09'),
                (	1,				3,				'2010-04-19'),
                (	2,				4,				'2011-05-27'),
                (	3,				3,				'2009-02-23'),
                (	4,				5,				'2016-06-10'),
                (	5,				1,				'2015-09-29'),
                (	5,				7,				'2012-07-04'),
                (	6,				10,				'2009-10-11'),
                (	7,				8,				'2012-01-18'),
                (	7,				9,				'2013-11-23'),
                (	7,				4,				'2016-05-07'),
                (	8,				2,				'2018-03-06'),
                (	8,				1,				'2020-06-12'),
                (	9,				1,				'2019-07-18'),
                (	10,				9,				'2017-09-22'),
                (	11,				7,				'2014-04-01'),
                (	12,				5,				'2018-11-13'),
                (	13,				2,				'2019-12-27'),
                (	14,				3,				'2016-01-15'),
                (	15,				4,				'2017-02-16'),
                (	15,				1,				'2014-06-28'),
                (	16,				10,				'2014-06-28'),
                (	17,				2,				'2014-06-28'),
                (	17,				4,				'2014-06-28'),
                (	17,				5,				'2014-06-28'),
                (	17,				6,				'2014-06-28'),
                (	18,				7,				'2014-06-28'),
                (	18,				4,				'2014-06-28'),
                (	19,				2,				'2014-06-28'),
                (	19,				8,				'2014-06-28'),
                (	20,				9,				'2014-06-28'),
                (	21,				10,				'2014-06-28'),
                (	22,				7,				'2014-06-28');

INSERT INTO
skill		(skill_name)
VALUES
			('JAVA'),
			('C++'),
			('mySQL'),
			('SQL Server'),
			('Đánh quyền'),
			('Quản lý'),
			('Thuyết trình'),
			('Ruby'),
			('Postman'),
			('UNKNOWN');
            
-- *************** Q3 Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java **********

SELECT 
    employee_name
FROM
    employee
        JOIN
    employee_skill USING (employee_num)
        JOIN
    skill USING (skill_code)
WHERE
    skill_name = 'Java';
    
-- *************** Q4 Viết lệnh để lấy ra danh sách các phòng ban có trên 3 nhân viên

SELECT 
    department_name
FROM
    department
        JOIN
    employee USING (department_num)
GROUP BY department_num
HAVING COUNT(employee_num) > 3
ORDER BY department_num;

-- **************** Q5 Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban ***************

SELECT 
    a.department_num,
    a.department_name,
    b.employee_name
FROM
    department a
LEFT JOIN
    employee b ON a.department_num = b.department_num
HAVING department_name IS NOT NULL
UNION
SELECT 
    a.department_num,
    a.department_name,
    b.employee_name
FROM
    department a
RIGHT JOIN
    employee b ON a.department_num = b.department_num
GROUP BY department_num
HAVING department_name IS NOT NULL
ORDER BY department_num;

-- *************** Q6 Viết lệnh để lấy ra danh sách nhân viên có nhiều hơn 1 skill ***************
 SELECT 
    employee_num, employee_name, GROUP_CONCAT(skill_name)
FROM
    employee
        LEFT JOIN
    employee_skill USING (employee_num)
        LEFT JOIN
    skill USING (skill_code)
WHERE
    skill_name != 10
GROUP BY employee_name
HAVING COUNT(skill_code) > 1
ORDER BY employee_num;
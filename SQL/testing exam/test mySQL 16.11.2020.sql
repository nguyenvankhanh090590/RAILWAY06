DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;
-- ***************************************************Tạo các bảng
DROP TABLE IF EXISTS country;
CREATE TABLE country (
	country_id		SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    country_name	NVARCHAR(100)
);
DROP TABLE IF EXISTS location;
CREATE TABLE location (
	location_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    street_address 	NVARCHAR(200),
    postal_code 	VARCHAR(9),
    country_id		SMALLINT UNSIGNED,
    FOREIGN KEY (country_id) REFERENCES country(country_id)
);
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	employee_id 	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name		NVARCHAR(100),
    email			VARCHAR(100) UNIQUE,
    location_id		INT UNSIGNED,
    FOREIGN KEY (location_id) REFERENCES location(location_id)
);
-- ********************************************************** Nhập dữ liệu cho các bảng
INSERT INTO
country (country_name)
VALUES	('Việt Nam'),
		('Anh'),
        ('Nga'),
        ('Mỹ'),
        ('Pháp');
INSERT INTO
location(street_address,				postal_code,	country_id)
VALUES	('107 Võ Chí Công, Hà Nội',		'150232',		1),
		('8 Duy Tân, Cầu Giấy, Hà Nội',	'140115',		1),
        ('69 Lenin, Obninsk',			'249037',		3),
        ('1 Student, Moskva',			'118288',		3),
        ('87/54 Great Way, New York',	'25051',		4);
INSERT INTO
employee(full_name, 		email, 						location_id)
VALUES	('Đào Thùy Linh', 	'linksvip.net@gmail.com', 	1	),
		('Võ Văn Tiên', 	'tieneinsteingmail.com',	2	),
        ('Nguyễn Tú Anh',	'parkcaukieu@icloud.com',	5	),
        ('Join Markcoin', 	'babypenny082@gmail.com',	5	),
        ('Putin Mikhailovna Elena','Elena_PM@mail.ru',	3	),
        ('Krasnov Fedoevich Ivan','IvanIV@mail.ru',		3	);
-- ******************************************************************** Viết lệnh câu 2
-- a, lấy tất cả các nhân viên thuộc VN

SELECT e.employee_id, e.full_name, e.email, e.location_id
FROM employee e
		JOIN location l ON e.location_id = l.location_id
        JOIN country c ON c.country_id = l.country_id
WHERE c.country_name = 'Việt Nam'
ORDER BY e.employee_id;

-- b, lấy ra tên quốc gia của nhân viên có email là nn03@gmail.com

SELECT country_name 
FROM country
WHERE country_id = (SELECT country_id
					FROM location
					WHERE location_id = ANY	(SELECT location_id
											FROM employee
											WHERE email = 'nn03@gmail.com'));

-- c thống kê mỗi country, mỗi location có bao nhiêu nhân viên đang làm việc

WITH CTE2 AS (
	WITH CTE1 AS (
		SELECT location_id, COUNT(employee_id) AS number_empl
		FROM employee RIGHT JOIN location USING(location_id)
		GROUP BY location_id)
	SELECT l.country_id, x.location_id, x.number_empl
	FROM location l JOIN CTE1 x ON l.location_id = x.location_id
		UNION
	SELECT c.country_id, 0 AS location_id, 0 AS number_empl
	FROM country c LEFT JOIN location l ON c.country_id = l.country_id
	WHERE  l.country_id IS NULL)
SELECT * 
FROM CTE2
ORDER BY country_id, location_id;

-- ***************************************************************** câu 3

DROP TRIGGER IF EXISTS trig_1;
DELIMITER $$
CREATE TRIGGER trig_1
BEFORE INSERT ON employee
FOR EACH ROW
	BEGIN
		IF (SELECT COUNT(e.employee_id)
			FROM employee e
					JOIN location l ON e.location_id = l.location_id
					JOIN country c ON c.country_id = l.country_id
			WHERE c.country_id = 	(SELECT country_id
									FROM location
                                    WHERE location_id = NEW.location_id)) >= 10 THEN
			SIGNAL SQLSTATE '10020'
			SET MESSAGE_TEXT = 'Mỗi quốc gia không quá 10 nhân viên';
		END IF;
    END $$
DELIMITER ;

-- *****************CHECK****************
-- Nhập đủ 10 nhân viên có location tại VN
INSERT INTO
employee(full_name, 		email, 						location_id)
VALUES	('Đào Thùy Linh', 	'linksvip.net@gmail.com3', 	1),
		('Đào Thùy Linh', 	'linksvip.net@gmail.com4', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com5', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com6', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com7', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com8', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com9', 	1),
        ('Đào Thùy Linh', 	'linksvip.net@gmail.com10',	1);

INSERT INTO employee(full_name, 		email, 						location_id)
VALUES	('Đào Thùy Linh', 	'linksvip.net@gmail.com11', 	1);

-- ******************************************************************************** câu 4
-- hãy cấu hình table sao cho khi cóa 1 location nào đó thì tất cả các employee
-- ở location đó sẽ có location_id = NULL


DROP TRIGGER IF EXISTS trig_2;
DELIMITER $$
CREATE TRIGGER trig_2
BEFORE DELETE ON location
FOR EACH ROW
	BEGIN
		UPDATE employee
        SET location_id = NULL
        WHERE location_id = OLD.location_id;
    END $$
DELIMITER ;

-- ***************** CHECK ********************
DELETE FROM location
WHERE location_id = 1;
SELECT * FROM employee;


DROP DATABASE IF EXISTS test_3;
CREATE DATABASE test_3;
USE test_3;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS student;
CREATE TABLE student (
	RN		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name`	NVARCHAR(100),
    age		TINYINT(2),
    gender	ENUM('M','F','U')
);
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
	sID		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `s_name`	NVARCHAR(100)
);
DROP TABLE IF EXISTS student_subject;
CREATE TABLE student_subject (
	RN		INT UNSIGNED,
    sID		INT UNSIGNED,
    mark	TINYINT(3),
    `date`	DATE,
    PRIMARY KEY (RN,sID),
    FOREIGN KEY (RN) REFERENCES student(RN),
    FOREIGN KEY (sID) REFERENCES `subject`(sID)
);

INSERT INTO student (`name`, 				age, 	gender)
VALUES				('Nguyễn Lương Băng', 	15, 	'M'),
					('Lê Thị Hằng', 		12, 	'F'),
                    ('Trần Thành Tâm', 		15, 	'M');

INSERT INTO `subject` (`s_name`)	
VALUES				('Toán'),
					('Lý'),
                    ('Hóa'),
                    ('Sử');
INSERT INTO student_subject (RN,sID,mark,	`date`)
VALUES						(1, 1, 78, 		'2020-11-12'),
							(1, 2, 90, 		'2020-11-10'),
                            (1, 3, NULL,	'2020-11-11'),
                            (1, 4, NULL,	'2020-11-14'),
                            (2, 1, 99, 		'2020-11-12'),
                            (2, 2, 87, 		'2020-11-10'),
                            (2, 3, NULL, 	'2020-11-11'),
                            (2, 4, NULL,	'2020-11-14'),
                            (3, 1, 50, 		'2020-11-12'),
                            (3, 2, 39, 		'2020-11-10'),
                            (3, 3, 45, 		'2020-11-11'),
                            (3, 4, NULL,	'2020-11-14');

-- b, a, viết lệnh lấy ra tất cả các môn học không có bất kỳ điểm nào
WITH CTE1 AS (
	SELECT sID, COUNT(1) FROM student_subject
    WHERE mark IS NULL
    GROUP BY sID
    HAVING COUNT(1) = (SELECT COUNT(RN) FROM student))
SELECT sID, `s_name`
FROM `subject`
WHERE sID = ANY (SELECT sID FROM CTE1)
OR sID NOT IN (SELECT sID FROM student_subject GROUP BY sID);

-- b, b, Lấy dánh sách các môn học có ít nhất 2 điểm
WITH CTE1 AS (
	SELECT sID, COUNT(1) FROM student_subject
    WHERE mark IS NOT NULL
    GROUP BY sID
    HAVING COUNT(1) >= 2)
SELECT s.sID, s.`s_name`
FROM `subject` s JOIN CTE1 c ON s.sID = c.sID;

-- c, 
SELECT  s.RN, ss.sID, s.`name`, s.age, 
	CASE
		WHEN s.gender = 'M' THEN 'Male'
        WHEN s.gender = 'F' THEN 'Female'
        WHEN s.gender = 'U' THEN 'Unknown'
	END AS gender,
sb.s_name, ss.mark, ss.`date`
FROM student s JOIN student_subject ss ON s.RN = ss.RN
JOIN `subject` sb ON sb.sID = ss.sID;

-- d tạo trriger
-- a. 
DROP TRIGGER IF EXISTS cas_update;
DELIMITER $$
CREATE TRIGGER cas_update
AFTER UPDATE ON `subject`
FOR EACH ROW
	BEGIN
		UPDATE student_subject
        SET sID = NEW.sID;
    END $$
DELIMITER ;
-- d,b
DROP TRIGGER IF EXISTS cas_del;
DELIMITER $$
CREATE TRIGGER cas_del
AFTER DELETE ON student
FOR EACH ROW
	BEGIN
		DELETE FROM student_subject
        WHERE RN = OLD.RN;
    END $$
DELIMITER ;

-- e

DROP PROCEDURE IF EXISTS pro_5;
DELIMITER $$
CREATE PROCEDURE pro_5(IN enter_student_name NVARCHAR(100))
	BEGIN
		DECLARE x1 NVARCHAR(100);
		
        DECLARE x3 INT UNSIGNED;
        DECLARE x4 INT UNSIGNED;
        DECLARE x5 INT UNSIGNED;
        SET x1 = enter_student_name;
        
        SET x3 = 0;
        SET x4 = 0;
        SET x5 = 0;
        IF x1 = '*' IS NULL THEN
			SET x3 = (SELECT COUNT(mon_hoc) FROM (SELECT DISTINCT sID AS mon_hoc FROM student_subject) AS so_mon_hoc);
        END IF;
        
        REPEAT
			SET x4 = (SELECT MAX(mon_hoc) FROM (SELECT DISTINCT sID AS mon_hoc FROM student_subject) AS so_mon_hoc);
            DELETE FROM student_subject
            WHERE sID = x4 AND mark < (SELECT mark FROM student_subject WHERE sID = x4 AND RN = x1);
            SET x5 = x5 + 1;
			UNTIL x5 = x3
        END REPEAT;
       
        DELETE FROM student
        WHERE `name` = x1;
		  
    END $$
DELIMITER ;

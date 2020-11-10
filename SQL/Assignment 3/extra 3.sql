DROP DATABASE IF EXISTS extra_3;
CREATE DATABASE IF NOT EXISTS extra_3;
USE extra_3;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS trainee;
CREATE TABLE IF NOT EXISTS trainee (
	trainee_id			SMALLINT		UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    fullname			NVARCHAR(100),
    birth_date			DATE,
    gender				ENUM('male','female','unknown')	DEFAULT 'unknown',
    et_iq				TINYINT CHECK(et_iq BETWEEN 0 AND 20),
    et_gmath			TINYINT CHECK(et_gmath BETWEEN 0 AND 20),
    et_english			TINYINT CHECK(et_english BETWEEN 0 AND 50),
    training_class		NVARCHAR(50),
    evaluation_notes	TEXT                        
	);
    
ALTER TABLE trainee
ADD COLUMN 	VTI_account VARCHAR(100)	UNIQUE KEY		NOT NULL
AFTER		gender;


/* ********Q1 thêm ít nhất 10 bản ghi vào table ******* */
INSERT INTO 
	trainee(fullname, 				birth_date, gender, 	VTI_account, 		et_iq, 		et_gmath, 	et_english, training_class, 	evaluation_notes)
VALUES
			('Nguyễn Văn An ',		'1995-01-01','male',	'A1',				'2',		'16',		'15',		'class11',				'note1'),
            ('Nguyễn Bá Bình',		'1996-02-14','female',	'B1',				'13',		'1',		'17',		'class11',				'note2'),
            ('Nguyễn Văn Cờ',		'1990-04-21','male',	'C1',				'20',		'7',		'23',		'class11',				NULL),
            ('Lê Dinh',				'1997-10-31','male',	'D1',				'6',		'18',		'14',		'class12',				'note4'),
            ('Doãn Enroll',			'2001-12-05','male',	'E1',				'7',		'17',		'13',		'class12',				'note5'),
            ('Nguyễn Văn Female',	'2000-09-20','male',	'F1',				'14',		'16',		'30',		'class11',				'note6'),
            ('Nguyễn Văn Giờ',		'1996-04-19','female',	'G1',				'12',		'20',		'9',		'class12',				'note7'),
            ('Đinh Văn Hết',		'1999-07-21','female',	'H1',				'16',		'20',		'31',		'class12',				'note8'),
            ('Ninh Văn Iinh',		'1997-08-24','female',	'I1',				'17',		'5',		'27',		'class12',				NULL),
            ('Nguyễn Văn Kim Lương','1999-05-01','female',	'K1',				'8',		'11',		'33',		'class11',				'note10'),
            ('Trần Văn Lan',		'2002-06-27','male',	'L1',				'11',		'19',		'45',		'class13',				'note11'),
            ('Mạc Minh Hiếu',		'2001-11-20','unknown',	'M1',				'20',		'19',		'39',		'class12',				'note12'),
            ('Lung Thị Linh',		'1995-01-15','male',	'N1',				'9',		'13',		'10',		'class13',				'note13'),
            ('Nguyễn Vê',			'2003-04-17','female',	'O1',				'9',		'10',		'34',		'class12',				NULL),
            ('Lê Ánh',				'2002-02-11','unknown',	'P1',				'10',		'17',		'45',		'class13',				NULL);
            
/* *************** Q2 viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào và nhóm chúng thành các tháng sinh khác nhau************* */
SELECT 
    trainee_id, month(birth_date) as month_of_birthday, GROUP_CONCAT(fullname)
FROM
    trainee
GROUP BY MONTH(birth_date)
ORDER BY trainee_id;

/* ************* Q3 Viết lệnh để lấy ra thực tập sinh có tên dài nhất với các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)************** */

SELECT 
    fullname, year(now()) - year (birth_date) AS age, gender, VTI_account, et_iq, et_gmath, et_english, training_class,	evaluation_notes
FROM
    trainee
HAVING LENGTH(fullname) = (	SELECT 
								MAX(ky_tu)
							FROM
								(SELECT 
									LENGTH(fullname) AS ky_tu
								FROM
									trainee) AS do_dai_ten);

/* ************************ Q4 viết lệnh để lấy ra tất cả các thực tập sinh là ET, trong đó ET là thực tập sinh đã vượt qua bài test đầu vào và thảo mãn số điểm sau
ET_IQ + ET_Gmath >= 20
ET_IQ >= 8
ET_Gmath >= 8
ET_English >=18
*/

SELECT 
    trainee_id, fullname as ET, et_iq, et_gmath, et_english
FROM
    trainee
WHERE
    (et_iq + et_gmath) >= 20 AND et_iq >= 8
        AND et_gmath >= 8
        AND et_english >= 18;

/* *********** Q5 xóa thực tập sinh có trainee_id = 3 *********** */

Delete from trainee where trainee_id =3;
select * from trainee;

/* ************ Q6 thực tập sinh có trainee_id = 5 được chuyển sang lớp 2, hãy cập nhật thông tin vào database */

update trainee
set training_class = 'class2' where trainee_id = 5;
select * from trainee;
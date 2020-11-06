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

DROP TABLE IF EXISTS table_01;
CREATE TABLE IF NOT EXISTS table_01 (
	id					INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name`				NVARCHAR(100),
    `code`				CHAR(5),
    modifield_date		DATETIME DEFAULT NOW()
);

DROP TABLE IF EXISTS table_02;
CREATE TABLE IF NOT EXISTS table_02 (
	id					INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name`				VARCHAR(100),
    `birth_date`		DATE,
    gender				BIT, #ENUM('0','1','unknown')
    is_deleted_flag		BIT NOT NULL #hoac ENUM('0','1')
);

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
            ('Nguyễn Văn Kim Lương','1999-05-01','female',	'K1',				'8',		'6',		'33',		'class11',				'note10'),
            ('Trần Văn Lan',		'2002-06-27','male',	'L1',				'11',		'19',		'45',		'class13',				'note11'),
            ('Mạc Minh Hiếu',		'2001-11-20','unknown',	'M1',				'0',		'19',		'39',		'class12',				'note12'),
            ('Lung Thị Linh',		'1995-03-15','male',	'N1',				'0',		'13',		'10',		'class13',				'note13'),
            ('Nguyễn Vê',			'2003-04-17','female',	'O1',				'9',		'10',		'34',		'class12',				NULL),
            ('Lê Ánh',				'2002-02-11','unknown',	'P1',				'10',		'17',		'45',		'class13',				NULL);
            
/* *************** Q2 viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào và nhóm chúng thành các tháng sinh khác nhau************* */
SELECT 
    trainee_id, fullname
FROM
    trainee
WHERE
    (et_iq + et_gmath) >= 18 AND et_iq >= 8
        AND et_gmath >= 8
        AND et_english >= 16
GROUP BY ;

/* ************* Q3 Viết lệnh để lấy ra thực tập sinh có tên dài nhất với các thông tin sau: tên, tuổi, 
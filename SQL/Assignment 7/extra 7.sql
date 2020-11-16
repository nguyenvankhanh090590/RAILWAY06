DROP DATABASE IF EXISTS extra_7;
CREATE DATABASE extra_7;
USE extra_7;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	employee_id			INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    employee_last_name	NVARCHAR(50),
    emloyee_first_name  NVARCHAR(50),
    employee_hire_date	DATE,
    employee_status		ENUM('Working','Waiting','Unknown'),
    supervisor_id		INT UNSIGNED,
    social_security_number	CHAR(9),
    FOREIGN KEY (supervisor_id) REFERENCES employee(employee_id)
);
DROP TABLE IF EXISTS project;
CREATE TABLE project (
	project_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    manager_id		INT UNSIGNED,
    project_name	NVARCHAR(100),
    project_start_date DATE,
    project_description TEXT,
    project_default NVARCHAR(100),
    project_completed_on DATE,
	FOREIGN KEY (manager_id) REFERENCES employee(employee_id)
);
DROP TABLE IF EXISTS project_modules;
CREATE TABLE project_modules (
	module_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    project_id		INT UNSIGNED,
    employee_id		INT UNSIGNED,
    project_module_date	DATE,
    project_module_complete_on DATE,
    project_module_description	TEXT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id)
);
DROP TABLE IF EXISTS work_done;
CREATE TABLE work_done (
	work_done_id	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    employee_id		INT UNSIGNED,
    module_id		INT UNSIGNED,
    work_done_date	DATE,
    work_done_description TEXT,
    work_done_status ENUM('completed','progressing'),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (module_id) REFERENCES project_modules(module_id)
);

INSERT INTO employee(employee_last_name,	emloyee_first_name,	employee_hire_date ,employee_status, supervisor_id, social_security_number)
VALUES              ('Hoàng',				'Thùy Dương',		'2019-04-19',		'working',		 5,				'078051120'),
					('Nguyễn',				'Ánh Linh',			'2020-10-21',		'waiting',		 NULL,			'078051121'),
					('Trương',				'Thanh Tú',			'2017-12-15',		'working',		 4,				'078051010'),
                    ('Đinh',				'La Giáng',			'2016-02-07',		'working',		 NULL,			'078059056'),
                    ('Nguyễn',				'Hòa Vang',			'2018-06-30',		'working',		 NULL,			'078059005'),
                    ('Lê',					'Thanh Sơn',		'2020-03-09',		'working',		 5,				'078051122'),
                    ('Nguyễn',				'Chí Mạnh',			'2020-02-11',		'working',		 4,				'078051123'),
                    ('Trần',				'Hải Yến',			'2020-01-27',		'working',		 5,				'078051124'),
                    ('Doãn',				'Tú Linh',			'2020-11-27',		'unknown',		 NULL,			'078051125');
                    
INSERT INTO project (manager_id, project_name, 	project_start_date,	project_description,	project_completed_on)
VALUES              (3,			'Tuyển sinh', 	'2019-06-10',		'DEV, TEST',			'2019-10-31'),
					(4,			'Dự án 1', 		'2020-05-20',		'Đối tác 1,2,4',		'2020-11-10'),
                    (5,			'Dự án 2', 		'2020-10-22',		'Đối tác 3',			 NULL);
                    
INSERT INTO project_modules (project_id,	employee_id, project_module_date, project_module_complete_on, project_module_description)
VALUES						(1,				1,			 '2019-07-31',		  '2019-07-13',				  'Tuyển sinh DEV'),
							(1,				7,			 '2019-07-31',		  '2019-07-01',				  'Tuyển sinh TEST'),
                            (1,				1,			 '2019-08-31',		  '2019-08-30',				  'Hoàn thành hồ sơ nhập học DEV'),
                            (1,				7,			 '2019-08-31',		  '2019-08-25',				  'Hoàn thành hồ sơ nhập học TEST'),
                            (1,				4,			 '2019-09-30',		  '2019-09-20',				  'Sắp thời khóa biểu DEV + TEST'),
                            (1,				4,			 '2019-10-31',		  '2019-09-28',				  'Sắp giáo viên, mentor và chuẩn bị trang thiết bị'),
                            (2,				2,			 '2020-05-31',		  '2020-06-02',				  'Ký hợp đồng bên 1'),
                            (2,				8,			 '2020-06-15',		  '2020-06-20',				  'Ký hợp đồng bên 2'),
                            (2,				4,			 '2020-06-30',		  '2020-06-27',				  'Ký hợp đồng bên 3'),
                            (2,				2,			 '2020-07-31',		  '2020-07-21',				  'Triển khai dự án bên 1'),
							(2,				8,			 '2020-08-15',		  '2020-08-19',				  'Triển khai dự án bên 2'),
                            (2,				4,			 '2020-09-30',		  '2020-10-09',				  'Triển khai dự án bên 3'),
                            (2,				4,			 '2020-10-30',		  '2020-10-30',				  'Tổng kết 3 dự án'),
                            (3,				3,			 '2020-10-30',		  '2020-11-01',				  'Ký hợp đồng bên 3'),
                            (3,				5,			 '2021-02-16',		  NULL,						  'Triển khai dự án bên 3');

INSERT INTO work_done (employee_id, module_id, work_done_date, work_done_description, work_done_status)
VALUES				  (1,			1,		   '2019-07-13',   'Work 1.1.1',		  'completed'),
					  (1,			1,		   '2019-07-13',   'Work 1.1.2',		  'completed'),
                      (7,			1,		   '2019-07-01',   'Work 7.1.1',		  'completed'),
                      (7,			1,		   '2019-07-01',   'Work 7.1.2',		  'completed'),
                      (1,			3,		   '2019-08-30',   'Work 1.3.1',		  'completed'),
                      (1,			3,		   '2019-08-30',   'Work 1.3.2',		  'completed'),
                      (1,			3,		   '2019-08-30',   'Work 1.3.3',		  'completed'),
                      (7,			4,		   '2019-08-25',   'Work 7.4.1',		  'completed'),
                      (7,			4,		   '2019-08-25',   'Work 7.4.2',		  'completed'),
                      (4,			5,		   '2019-09-20',   'Work 4.5',			  'completed'),
                      (4,			6,		   '2019-09-28',   'Work 4.6',			  'completed'),
                      (2,			7,		   '2020-06-02',   'Work 2.7',			  'completed'),
                      (8,			8,		   '2020-06-20',   'Work 8.8',			  'completed'),
                      (4,			9,		   NULL,		   'Work 4.9',			  'completed'),
                      (2,			10,		   NULL,		   'Work 2.10',			  'completed'),
                      (8,			11,		   NULL,		   'Work 8.11',			  'completed'),
                      (4,			13,		   NULL,		   'Work 4.13.1',		  'completed'),
                      (4,			13,		   NULL,		   'Work 4.13.2',		  'completed'),
                      (4,			14,		   NULL,		   'Work 4.14',			  'completed'),
                      (3,			15,		   NULL,		   'Work 3.15',			  'completed'),
                      (5,			16,		   NULL,		   'Work 5.16.1',		  'completed'),
                      (5,			16,		   NULL,		   'Work 5.16.2',		  'progressing'),
                      (9,			16,		   NULL,		   'Work 5.16.3',		  'progressing');

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
            
            
/* ****** EX1 Tiếp tục với database của bài extra 6
Viết trigger để tránh trường hợp người dùng nhập thông tin module project không hợp lệ
(project_modules.project_module_date < project.project_start_date,
project_modules.project_modules_completed_on > project.project_completed_on)
*/

DROP TRIGGER IF EXISTS trig_ex1;
DELIMITER $$
CREATE TRIGGER trig_ex1
BEFORE INSERT ON project_modules
FOR EACH ROW
	BEGIN
		IF NEW.project_module_date < 	(SELECT project_start_date
										FROM project
                                        WHERE project_id = NEW.project_id) 
                                        THEN
			SIGNAL SQLSTATE '10015'
			SET MESSAGE_TEXT = 'Khai báo lỗi: Ngày dự kiến hoàn thành module sớm hơn ngày bắt đầu của dự án';
        ELSEIF NEW.project_module_complete_on > (SELECT project_completed_on
												FROM project
                                                WHERE project_id = NEW.project_id
														AND project_id IS NOT NULL) THEN
			SIGNAL SQLSTATE '10016'
			SET MESSAGE_TEXT = 'Khai báo lỗi: Ngày hoàn thành module trễ hơn ngày hoàn thành của dự án';
        END IF;
    END $$
DELIMITER ;

-- ************ CHECK
INSERT INTO project_modules (project_id,	employee_id, project_module_date, project_module_complete_on, project_module_description)
VALUES						(2,				4,			 '2020-10-31',		  '2020-11-29',				  'CHECK');
SELECT * FROM project_modules;
SELECT * FROM project;


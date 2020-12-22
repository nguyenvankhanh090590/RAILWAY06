/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE UserManager;
USE UserManager;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FirstName 	NVARCHAR(50) NOT NULL,
	LastName 	NVARCHAR(50) NOT NULL,
	Phone		VARCHAR(12),
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		VARCHAR(50),
    ExpInYear	TINYINT,
   	ProjectName	VARCHAR(100),
   	ProSkill	VARCHAR(100)
   	
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  (UserID   , FirstName, LastName, 		Phone, 			Email,				 `Password`,			`Role`,		ExpInYear,	ProjectName,		ProSkill	) 
VALUES
					(1,			'Nguyễn', 'Thị Mỵ',	'0123456789','mynt2407@gmail.com', 		'Mynguyen123',			'Employee',		0,			'Testing System',	'MySQL'),
					(2,			'Nguyễn','Ngọc Duy','0123456789','duynn03@gmail.com', 		'duyNguyen',			'Manager',		5,			null,				null),
                    (3,			'Nguyễn','Hùng Mạnh','0123456789','hungmanh@gmail.com', 	'hunGmanh1',			'Employee',		0,			'CRM',				'Dev'),
                    (4,			'Tống','Thị Nhung',	'0123456789','nhung@gmail.com', 		'nhungtOng',			'Employee',		0,			'Testing System',	'Java'),
                    (5,			'Trần','Thị Kim Anh','0123456789','kimoanh.tran@gmail.com', 'tran.kim',				'Employee',		0,			'CRM',				'MySQL'	);
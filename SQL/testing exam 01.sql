DROP DATABASE IF EXISTS testing_exam;
CREATE DATABASE IF NOT EXISTS testing_exam;
USE testing_exam;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
	user_id	SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name	NVARCHAR(100),
    email		VARCHAR(100) UNIQUE KEY DEFAULT NULL,
    `password`	VARCHAR(50),
    `role`		NVARCHAR(20) NOT NULL,
    expInYear	TINYINT DEFAULT 0,
    proSkill	VARCHAR(50) DEFAULT NULL
);

INSERT INTO `user` (user_id, full_name,email,`password`,`role`, expInYear, proSkill)
VALUES
	(1, 'Nguyễn Văn A', 'VanA@gmail.com', 'A123456', 'Admin', 5, NULL),
    (2, 'Nguyễn Văn B', 'VanB@gmail.com', 'B123456', 'Employee', 0, 'Dev'),
    (3, 'Nguyễn Văn C', 'VanC@gmail.com', 'C23456', 'Employee', 0, 'Test'),
    (4, 'Nguyễn Văn D', 'VanD@gmail.com', 'D123456', 'Employee', 0, 'Java'),
    (5, 'Nguyễn Văn E', 'VanE@gmail.com', 'E123456', 'Employee', 0, 'SQL');
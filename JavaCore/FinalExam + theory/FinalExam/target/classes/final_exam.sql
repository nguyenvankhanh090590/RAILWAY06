DROP DATABASE IF EXISTS final_exam;
CREATE DATABASE IF NOT EXISTS final_exam;
USE final_exam;

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
	user_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    full_name	NVARCHAR(100),
    email		VARCHAR(100) UNIQUE KEY DEFAULT NULL,
    `password`	VARCHAR(50),
    `role`		NVARCHAR(20) NOT NULL,
    expInYear	TINYINT DEFAULT 0,
    project_id	INT UNSIGNED DEFAULT 0,
    proSkill	VARCHAR(50) DEFAULT NULL,
    FOREIGN KEY (project_id) REFERENCES project (project_id)
);

DROP TABLE IF EXISTS project;
CREATE TABLE IF NOT EXISTS project (
	project_id	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    team_size	INT UNSIGNED,
    id_manager	INT UNSIGNED,	
    FOREIGN KEY (id_manager) REFERENCES `user` (user_id)
);

DROP TABLE IF EXISTS project_employee;
CREATE TABLE IF NOT EXISTS project_employee (
	project_id	INT UNSIGNED,
    id_employee	INT UNSIGNED,
    PRIMARY KEY (project_id,id_employee),
    FOREIGN KEY (id_employee) REFERENCES `user` (user_id)
);
 
INSERT INTO project (project_id, team_size, id_manager)
VALUES				(1,		1,		1),
					(2,		2,		3);
                    

INSERT INTO project_employee (project_id, id_employee) 
VALUES	(1, 2 ),
		(2, 4 ),
        (2, 5 );
        

INSERT INTO `user` (user_id, full_name,email,`password`,`role`, expInYear, project_id, proSkill)
VALUES
	(1, 'Nguyễn Văn A', 'VanA@gmail.com', 'A123456', 'Manager', 5, 1,  NULL),
    (2, 'Nguyễn Văn B', 'VanB@gmail.com', 'B123456', 'Employee', 0, 1, 'Dev'),
    (3, 'Nguyễn Văn C', 'VanC@gmail.com', 'C23456', 'Manager', 7, 2, NULL),
    (4, 'Nguyễn Văn D', 'VanD@gmail.com', 'D123456', 'Employee', 0, 2, 'Java'),
    (5, 'Nguyễn Văn E', 'VanE@gmail.com', 'E123456', 'Employee', 0, 2, 'SQL');
    

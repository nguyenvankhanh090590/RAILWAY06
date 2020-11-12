
-- ************ a, Tạo table với các ràng buộc và kiểu dữ liệu. Sau đó thêm ít nhất 3 bản ghi vào mỗi table trên

DROP DATABASE IF EXISTS extra_6;
CREATE DATABASE extra_6;
USE extra_6;
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
	project_id		INT UNSIGNED,
    manager_id		INT UNSIGNED,
    project_name	NVARCHAR(100),
    project_start_date DATE,
    project_description TEXT,
    project_default NVARCHAR(100),
    project_completed_on DATE,
    PRIMARY KEY (project_id, manager_id),
    FOREIGN KEY (manager_id) REFERENCES employee(employee_id)
);
DROP TABLE IF EXISTS project_modules;
CREATE TABLE project_modules (
	module_id		INT UNSIGNED,
    project_id		INT UNSIGNED,
    employee_id		INT UNSIGNED,
    project_module_date	DATE,
    project_module_complete_on DATE,
    project_module_description	TEXT,
    PRIMARY KEY (module_id,project_id),
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

INSERT INTO employee(employee_last_name,	emloyee_first_name, employee_hire_date ,employee_status, supervisor_id, social_security_number)
VALUES              ('Hoàng',				'Thùy Dương',		'2019-04-19',		'working',		 5,				'078051120'),
					('Nguyễn',				'Ánh Linh',			'2020-10-21',		'waiting',		 5,				'078051121'),
					('Trương',				'Thanh Tú',			'2017-12-15',		'working',		 4,				'078051010'),
                    ('Đinh',				'La Giáng',			'2016-02-07',		'working',		 NULL,			'078059056'),
                    ('Nguyễn',				'Hòa Vang',			'2018-06-31',		'working',		 NULL,			'078059005'),
                    ('Lê',					'Thanh Sơn',		'2020-11-09',		'waiting',		 5,				'078051122');
                    
INSERT INTO         	
VALUES              
                    
INSERT INTO
VALUES

INSERT INTO
VALUES


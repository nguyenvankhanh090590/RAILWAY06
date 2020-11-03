DROP DATABASE IF EXISTS extra_assignment_1_2_2;
CREATE DATABASE IF NOT EXISTS extra_assignment_1_2_2;
USE extra_assignment_1_2_2;

DROP TABLE IF EXISTS table_01;
CREATE TABLE IF NOT EXISTS table_01 (
	id					INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name`				VARCHAR(100),
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
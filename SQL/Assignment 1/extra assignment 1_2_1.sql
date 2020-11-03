DROP DATABASE IF EXISTS extra_assignment_01_2_1;
CREATE DATABASE IF NOT EXISTS extra_assignment_01_2_1;
USE extra_assignment_01_2_1;

DROP TABLE IF EXISTS trainee;
CREATE TABLE IF NOT EXISTS trainee (
	trainee_id			SMALLINT		UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    full_name			NVARCHAR(100),
    birth_date			DATE,
    gender				ENUM('male','female','unknown')	DEFAULT 'unknown',
    et_iq				TINYINT CHECK(et_iq BETWEEN 0 AND 20),
    et_gmath			TINYINT CHECK(et_gmath BETWEEN 0 AND 20),
    et_english			TINYINT CHECK(et_english BETWEEN 0 AND 50),
    training_class		VARCHAR(50),
    evaluation_notes	TEXT,                        
	);
    
ALTER TABLE trainee
ADD COLUMN 	VTI_account VARCHAR(100)	UNIQUE KEY		NOT NULL
AFTER		gender;

    
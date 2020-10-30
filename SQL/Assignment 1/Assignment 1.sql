DROP DATABASE IF EXISTS assignment_01;
CREATE DATABASE IF NOT EXISTS assignment_01;
USE assignment_01;

DROP TABLE IF EXISTS trainee;
CREATE TABLE IF NOT EXISTS trainee (
	trainee_id			SMALLINT		UNSIGNED		PRIMARY KEY		AUTO_INCREMENT,
    full_name			NVARCHAR(100),
    birth_date			DATE,
    gender				ENUM('male','female','unknown')	DEFAULT 'unknown',
    et_iq				TINYINT			UNSIGNED,
    et_gmath			TINYINT			UNSIGNED,
    et_english			TINYINT			UNSIGNED,
    training_class		VARCHAR(50),
    evaluation_notes	TEXT,
						CONSTRAINT et_iq
                        CHECK(et_iq BETWEEN 0 AND 20),
                        CONSTRAINT et_gmath
                        CHECK(et_gmath BETWEEN 0 AND 20),
                        CONSTRAINT et_english
                        CHECK(et_english BETWEEN 0 AND 50)
	);
    
ALTER TABLE trainee
ADD COLUMN 	VTI_account VARCHAR(100)	UNIQUE KEY		NOT NULL
AFTER		gender;

    
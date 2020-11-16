DROP DATABASE IF EXISTS test_1;
CREATE DATABASE test_1;
USE test_1;
DROP TABLE IF EXISTS car;
CREATE TABLE car (
	car_id		INT UNSIGNED PRIMARY KEY,
    marker		ENUM ('HONDA','TOYOTA','NISSAN'),
    `model`		VARCHAR(100),
    `year`		MEDIUMINT(4),
    color		VARCHAR(50),
    note		TEXT
);

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
	customer_id 	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name`			NVARCHAR(100),
    phone			VARCHAR(12),
    email			VARCHAR(100),
    adderss			NVARCHAR(200),
    note			TEXT
);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
	order_id 		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    customer_id		INT UNSIGNED,
    car_id 			INT UNSIGNED,
    amount			MEDIUMINT UNSIGNED DEFAULT 1,
    sale_price		BIGINT UNSIGNED,
    order_date		DATE,
    delivery_date	DATE,
    delivery_address	VARCHAR(200),
    `status`		ENUM('0','1','2') DEFAULT '0',
    note			TEXT,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (car_id) REFERENCES car(car_id)
);

INSERT INTO car (car_id, marker, 	model, `year`, 	color, 	note)
VALUES 			(1,		'TOYOTA',	001,	2017,	'white','like new 80%'),
				(2,		'HONDA',	010,	2019,	'black','new'),
                (3,		'HONDA',	010,	2019,	'white','new'),
                (4,		'NISSAN',	002,	2020,	'red',	'new'),
                (5,		'HONDA',	011,	2018,	'blue',	'like new 90%');
INSERT INTO customer(`name`,			phone,			email,					adderss, 									note)
VALUES 				('Nguyễn Tùng Lâm',	'0956435148',	'tung78@gmail.com',		'Số 1 Phan Đình Phùng, Hà Nội',				'VIP1'),
					('Phan Thế Anh',	'0977462219',	'theanh89@gmail.com',	'Số 5 Hoàng Xuân Diệu, Hà Nội',				'NON VIP'),
                    ('Lương Mạnh Hà',	'0988562453',	'manhha99@icloud.com',	'Số 68 Đội Cấn, Hà Nội',					'VIP2'),
                    ('Lê Thị Vân Anh',	'0462345686',	'vanhle01@gmail.com',	'Số 4/78 Tổ 8 Huyền Kỳ, Hà Nội',			'NON VIP'),
                    ('Nguyễn Đắc Ngọc',	'0977462218',	'duckdollar9x@gmail.com','Số 107 Tổ 8 Huyền kỳ, Hà Nội',			'VIP2');
INSERT INTO `order` (customer_id,	car_id, amount,	sale_price,	order_date,		delivery_date,	delivery_address,				`status`,note)
VALUES 				(2,				1,		2,		856000000,	'2020-10-11',	'2021-01-01',	'Số 5 Hoàng Xuân Diệu, Hà Nội',	'2',		NULL),
					(1,				3,		1,		1756760000,	'2020-11-14',	'2020-12-15',	'Số 1 Phan Đình Phùng, Hà Nội',	'0',		'MOVE TO VIP3'),
                    (5,				2,		2,		1758880000,	'2020-09-23',	'2020-11-13',	'Số 4/78 Tổ 8 Huyền Kỳ, Hà Nội','1',		'MOVE TO VIP4'),
                    (2,				4,		1,		498980000,	'2020-11-13',	'2021-01-10',	'Số 5 Hoàng Xuân Diệu, Hà Nội',	'0',		'MOVE TO VIP1'),
                    (3,				5,		4,		5099990000,	'2020-09-29',	'2021-02-08',	'Số 68 Đội Cấn, Hà Nội',		'0',		'MOVE TO VIP7'),
                    (3,				1,		4,		899990000,	'2020-10-08',	'2020-11-02',	'Số 68 Đội Cấn, Hà Nội',		'1',		'MOVE TO VIP7');

-- Q2 lấy tên, số lượng ô tô khách đã mua và sắp xếp tăng dần

SELECT `name`, SUM(amount) AS number_of_buyed_car
FROM customer LEFT JOIN `order` USING (customer_id)
WHERE `status` IN ('1','0')
GROUP BY `name`
ORDER BY number_of_buyed_car; 

-- Q3 viết hàm trả về tên hãng sản xuất đã bán được nhiều ô tô nhất trong năm nay
DROP FUNCTION IF EXISTS func_3;
DELIMITER $$
CREATE FUNCTION func_3() RETURNS VARCHAR(100)
	BEGIN
		DECLARE x1 VARCHAR(100);
        
        WITH CTE2 AS (
			WITH CTE1 AS (
			SELECT car_id, SUM(amount) AS number_of_buyed_car
			FROM customer
					JOIN `order` USING (customer_id)
			WHERE `status` IN ('1','0') AND YEAR(order_date) = YEAR(NOW())
			GROUP BY car_id)
		
			SELECT marker, number_of_buyed_car
			FROM car
					JOIN CTE1 USING (car_id)
			WHERE car_id = ANY (SELECT car_id
								FROM CTE1
								WHERE number_of_buyed_car = (	SELECT MAX(number_of_buyed_car)
																FROM CTE1)))
		SELECT GROUP_CONCAT(marker) INTO x1
        FROM CTE2
        GROUP BY number_of_buyed_car;
        
        RETURN x1;
	END $$
DELIMITER ;

-- Q4 viết thủ tục non parameter đêa xóa các đơn hàng đã bị hủy của những năm trước. IN ra số lượng bản ghi đã xóa

DROP PROCEDURE IF EXISTS pro_4;
DELIMITER $$
CREATE PROCEDURE pro_4()
	BEGIN
		DECLARE x1 SMALLINT UNSIGNED;
        SET x1 = (SELECT
					COUNT(order_id)
				FROM `order`
                WHERE YEAR(order_date) < YEAR(NOW())
						AND `status` = '2');
        DELETE FROM `order`
        WHERE YEAR(order_date) < YEAR(NOW())
					AND `status` = '2';
        SELECT t1.record_deleted
        FROM (
			SELECT x1 AS record_deleted) AS t1;
    END $$
DELIMITER ;

-- Q5 
                    
DROP PROCEDURE IF EXISTS pro_5;
DELIMITER $$
CREATE PROCEDURE pro_5(IN id_customer INT UNSIGNED)
	BEGIN
		SELECT `name`, order_id, amount, marker
        FROM `order`
			JOIN `customer` USING (customer_id)
            JOIN car USING (car_id)
		WHERE id_customer = customer_id
				AND `status` IN ('0','1');
            
    END $$
DELIMITER ;

-- Q6 Viết triiger

DROP TRIGGER IF EXISTS trig_6;
DELIMITER $$
CREATE TRIGGER trig_6
BEFORE INSERT ON `order`
FOR EACH ROW
	BEGIN
		IF NEW.delivery_date < (SELECT (NEW.order_date + INTERVAL 15 DAY)) THEN
        SIGNAL SQLSTATE '10000'
        SET MESSAGE_TEXT = 'Ngày không hợp lệ';
        END IF;
    END $$
DELIMITER ;


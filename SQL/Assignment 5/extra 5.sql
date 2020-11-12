-- ********** EX1 SUBQUERY *************

-- ********** Q1 VIết 1 query lấy thông tin 'name' từ bảng Production. Product có name của ProductSubcategory là 'Saddles'

SELECT `name` FROM product
WHERE ProductSubCategoryID = ANY (SELECT
							ProductSubCategoryID
						FROM productsubcategory
                        WHERE `Name` = 'Saddles');

-- ********** Q2 Thay đổi câu query 1 để lấy được kết quả sau. Mệnh đề WHERE trong câu truy vấn bây giờ sẽ sử dụng chuỗi đại
-- diện 'Bo%' để so sánh.

SELECT `name` FROM product
WHERE ProductSubCategoryID = ANY (SELECT
							ProductSubCategoryID
						FROM productsubcategory
                        WHERE `Name` LIKE ('%Bo%'));
-- ********** Q3 viết truy vấn rả về tất cả các sản phẩm có cùng giá rẻ nhất (lowest ListPrice) của xe đạp touring (Touring
-- Bike, ProductSubctegoryID = 3). Sử dụng hàm tổng hợp MIN() trong câu truy vấn con để trả về giá trị nhỏ nhất của ListPrice ở
-- câu truy vấn ngoài

SELECT *
FROM product
WHERE ListPrice = (SElECT
				MIN(ListPrice)
			FROM product
            WHERE `ProductSubcategoryID` = 3);
            
-- ********** EX2 MULTI JOIN *************

-- ********** Q1 viết truy vấn liệt kê những nước và tên tỉnh trong CSDL. Hãy tìm bảng countryregion và stateprovince.
-- JOIN chúng lại và viết ra kết quả.

SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
		JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;
        
-- ********** Q2 Tiếp tục với câu truy vấn trước đó và thêm vào bộ lọc chỉ liệt kê Germany và Canada. Sắp xếp kết quả theo Province

SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
		JOIN stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` IN ('Germany','Canada')
ORDER BY Country,Province;

-- ********** Q3 Chúng ra muốn lấy thông tin về các đơn hàng. từ bảng  SalesOrderHeader chúng ta lấy SalesOrderID, OrderDate và
-- SalesPersonID. Từ bảng SalesPerson chúng ra lấy BussinessEntityID (số xác thực người bán hàng), Bonus và SalesYTD (người đó đã
-- bán được bao nhiêu trong năm nay)

SELECT s1.SalesOrderID, s1.OrderDate, s1.SalesPersonID, s2.SalesPersonID AS BussinessEntityID, s2.Bonus, s2.SalesYTD
FROM salesorderheader s1
		JOIN salesperson s2 ON s1.SalesPersonID = s2.SalesPersonID
ORDER BY s1.SalesOrderID; 


-- ********** Q4 Sử dụng câu truy vấn ở trên, thêm cột JobTitle và xóa cột SalesPersonID, BussinessEntityID. Bạn cần JOIN đến Employee

SELECT s1.SalesOrderID, s1.OrderDate, e.Title AS JobTitle, s2.Bonus, s2.SalesYTD
FROM salesorderheader s1
		JOIN salesperson s2 ON s1.SalesPersonID = s2.SalesPersonID
        JOIN employee e ON e.EmployeeID = s1. SalesPersonID
ORDER BY s1.SalesOrderID; 



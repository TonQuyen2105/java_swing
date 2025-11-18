-- Users
INSERT Users (UserName, Email, Password)
VALUES		 (N'Tôn Quyền', 'tonquyen@gmail.com', '3123411251'),
			 (N'Minh Huy', 'minhuy@gmail.com', '3123411115'),
			 (N'Phương Nhi', 'phuongnhi@gmail.com', '3123411213'),
			 (N'Đức Đạt', 'ducdat@gmailcom', '3123411065');

-- Address 
INSERT INTO Address (Address, NumberPhone, UserID)
VALUES				(N'27c Phạm Vấn' , '0937685909', 1),
					(N'513 Trần Hưng Đạo', '0787554657', 2),
					(N'217 An Dương Vương', '0881234121', 3),
					(N'60 Đoàn Văn Bơ', '0923412951', 4);

INSERT Status (Status) 
VALUES	('Shipping'),
			  ('Finish'),
			  ('Packed'),
			  ('Order');
-- Orders
INSERT Orders (OrderDate, UserID, StatusID)
VALUES		 ('2025-11-18', 1, 1),
				   ('2025-11-19', 2, 2),
				   ('2025-11-20', 3, 3),
				   ('2025-11-21', 4, 4);
--OrderDetail
INSERT OrderDetail (Quantity, OrderID, ProductVariantID)
VALUES		 (10, 1, 6),
				   (15, 2, 5),
				   (5, 3, 3),
				   (20, 4, 4);

-- Products
INSERT Products (ProductName, Price)
VALUES  (N'Giày chạy bộ ARVV001-53V', 1550000),
				(N'Giày cầu lông ARVV001-52V', 2450000),
				(N'Giày bóng rổ ARVV001-55V', 3560000),
				(N'Giày chạy bộ ARVV001-54V', 1250000);

-- ProductVariant 
INSERT ProductVariant (Stock, ProductID,ColorID, SizeID, DescriptionID, PictureID, CategoryID)
VALUES  (50, 1, 1, 1, 1, 1, 1),
				(50, 2, 2, 2, 1, 2, 2),
				(50, 3, 3, 3, 1, 3, 3),
				(50, 4, 4, 4, 1, 4, 1);

-- PicturePath
INSERT PicturePath (Path) 
VALUES		 ('C:\Users\admin\Documents\NetBeansProjects\java_swing\script\JavaSwing\src\main\resources\asset\picture\product\AYTT001-2'),
				   ('C:\Users\admin\Documents\NetBeansProjects\java_swing\script\JavaSwing\src\main\resources\asset\picture\product\AYTT001-6'),
				   ('C:\Users\admin\Documents\NetBeansProjects\java_swing\script\JavaSwing\src\main\resources\asset\picture\product\AYTT001-4'),
				   ('C:\Users\admin\Documents\NetBeansProjects\java_swing\script\JavaSwing\src\main\resources\asset\picture\product\AYTT001-5');

-- Size 
INSERT Size (Size)
VALUES (37),
	     (38),
	     (39),
	     (40),
	     (41);

-- Color
INSERT Color (Color)
VALUES (N'Xanh'),
	     (N'Đỏ'),
	     (N'Trắng'),
	     (N'Đen'),
	     (N'Vàng');

-- Description
INSERT Description (Content)
VALUES (N'Đây là sản phẩm mới nhất của cửa hàng');
  
-- Category
INSERT Category (Category)
VALUES (N'Giày bóng rổ'),
	     (N'Giày cầu lông'),
		   (N'Giày chạy bộ');

-- Cart
INSERT Carts (UserID)
VALUES (1),
       (2),
       (3),
       (4);
-- CartItem 

INSERT CartItem (AddDate, Quantity, CartID, OrderID, ProductVariantID)
VALUES          ('2025-11-18', 10, 1, 1, 3),
                ('2025-11-19', 10, 2, 2, 4),
                ('2025-11-18', 10, 1, 3, 5)

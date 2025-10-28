-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;
-- App_sale_giay.dbo.Category definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Category;

CREATE TABLE App_sale_giay.dbo.Category (
	CategoryID int IDENTITY(1,1) NOT NULL,
	CategoryName nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__Category__19093A2B3DBFE599 PRIMARY KEY (CategoryID)
);


-- App_sale_giay.dbo.Color definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Color;

CREATE TABLE App_sale_giay.dbo.Color (
	ColorID int IDENTITY(1,1) NOT NULL,
	ColorName varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__Color__8DA7676DA9041711 PRIMARY KEY (ColorID)
);


-- App_sale_giay.dbo.Description definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Description;

CREATE TABLE App_sale_giay.dbo.Description (
	DescriptionID int IDENTITY(1,1) NOT NULL,
	Content nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__Descript__A58A9FEBA9045915 PRIMARY KEY (DescriptionID)
);


-- App_sale_giay.dbo.Users definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Users;

CREATE TABLE App_sale_giay.dbo.Users (
	UsersID int IDENTITY(1,1) NOT NULL,
	Username varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Email varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Password varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK__Users__A349B0421A1670AF PRIMARY KEY (UsersID),
	CONSTRAINT UQ__Users__536C85E484C43929 UNIQUE (Username),
	CONSTRAINT UQ__Users__A9D105346C2AA98C UNIQUE (Email)
);


-- App_sale_giay.dbo.Addresses definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Addresses;

CREATE TABLE App_sale_giay.dbo.Addresses (
	AddressID int IDENTITY(1,1) NOT NULL,
	UsersID int NOT NULL,
	ReceiverName nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	PhoneNumber nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Address nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__Addresse__091C2A1B6B42FF40 PRIMARY KEY (AddressID),
	CONSTRAINT FK_Addresses_Users FOREIGN KEY (UsersID) REFERENCES App_sale_giay.dbo.Users(UsersID)
);


-- App_sale_giay.dbo.Orders definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Orders;

CREATE TABLE App_sale_giay.dbo.Orders (
	OrderID int IDENTITY(1,1) NOT NULL,
	UsersID int NOT NULL,
	AddressID int NOT NULL,
	Status nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	OrderDate date NOT NULL,
	CONSTRAINT PK__Orders__C3905BAF47996A36 PRIMARY KEY (OrderID),
	CONSTRAINT FK_Orders_Addresses FOREIGN KEY (AddressID) REFERENCES App_sale_giay.dbo.Addresses(AddressID),
	CONSTRAINT FK_Orders_Users FOREIGN KEY (UsersID) REFERENCES App_sale_giay.dbo.Users(UsersID)
);
ALTER TABLE App_sale_giay.dbo.Orders WITH NOCHECK ADD CONSTRAINT CK__Orders__Status__5FB337D6 CHECK (([Status]='finish' OR [Status]='shipping' OR [Status]='packed' OR [Status]='order'));


-- App_sale_giay.dbo.Products definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Products;

CREATE TABLE App_sale_giay.dbo.Products (
	ProductID int IDENTITY(1,1) NOT NULL,
	ProductName nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Price int NOT NULL,
	Stock int NOT NULL,
	[Size] int NOT NULL,
	PicturePath nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	ColorID int NULL,
	CategoryID int NULL,
	DescriptionID int NULL,
	CONSTRAINT PK__Products__B40CC6EDE65360F6 PRIMARY KEY (ProductID),
	CONSTRAINT FK_Products_Category FOREIGN KEY (CategoryID) REFERENCES App_sale_giay.dbo.Category(CategoryID),
	CONSTRAINT FK_Products_Color FOREIGN KEY (ColorID) REFERENCES App_sale_giay.dbo.Color(ColorID),
	CONSTRAINT FK_Products_Description FOREIGN KEY (DescriptionID) REFERENCES App_sale_giay.dbo.Description(DescriptionID)
);


-- App_sale_giay.dbo.Cart definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.Cart;

CREATE TABLE App_sale_giay.dbo.Cart (
	CartID int IDENTITY(1,1) NOT NULL,
	UsersID int NOT NULL,
	ProductID int NOT NULL,
	Quantity int NOT NULL,
	CONSTRAINT PK__Cart__51BCD797C161CD6F PRIMARY KEY (CartID),
	CONSTRAINT FK_Cart_Products FOREIGN KEY (ProductID) REFERENCES App_sale_giay.dbo.Products(ProductID),
	CONSTRAINT FK_Cart_Users FOREIGN KEY (UsersID) REFERENCES App_sale_giay.dbo.Users(UsersID)
);


-- App_sale_giay.dbo.OrderDetail definition

-- Drop table

-- DROP TABLE App_sale_giay.dbo.OrderDetail;

CREATE TABLE App_sale_giay.dbo.OrderDetail (
	OrderDetailID int IDENTITY(1,1) NOT NULL,
	OrderID int NOT NULL,
	ProductID int NOT NULL,
	Quantity int NOT NULL,
	CONSTRAINT PK__OrderDet__D3B9D30CD8C41A3F PRIMARY KEY (OrderDetailID),
	CONSTRAINT FK_OrderDetail_Orders FOREIGN KEY (OrderID) REFERENCES App_sale_giay.dbo.Orders(OrderID),
	CONSTRAINT FK_OrderDetail_Products FOREIGN KEY (ProductID) REFERENCES App_sale_giay.dbo.Products(ProductID)
);
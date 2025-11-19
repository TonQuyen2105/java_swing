IF DB_ID('DB_PTTK') IS NOT NULL
    DROP DATABASE DB_PTTK;
GO

CREATE DATABASE DB_PTTK;
GO

USE DB_PTTK;
GO

IF OBJECT_ID ('Users', 'U') IS NOT NULL DROP TABLE Users;
CREATE TABLE Users (
    UserID INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
    UserName NVARCHAR(255),
    Email NVARCHAR(255),
    Password NVARCHAR(255)
);

IF OBJECT_ID ('PicturePath', 'U') IS NOT NULL DROP TABLE PicturePath;
CREATE TABLE PicturePath (
    PictureID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Path NVARCHAR(255)
);

IF OBJECT_ID ('Size', 'U') IS NOT NULL DROP TABLE Size;
CREATE TABLE Size (
    SizeID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Size INT
);

IF OBJECT_ID ('Category', 'U') IS NOT NULL DROP TABLE Category;
CREATE TABLE Category (
    CategoryID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Category NVARCHAR(255)
);

IF OBJECT_ID ('Description', 'U') IS NOT NULL DROP TABLE Description;
CREATE TABLE Description (
    DescriptionID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Content NVARCHAR(255)
);

IF OBJECT_ID ('Color', 'U') IS NOT NULL DROP TABLE Color;
CREATE TABLE Color (
    ColorID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Color NVARCHAR(50)
);

IF OBJECT_ID ('Products', 'U') IS NOT NULL DROP TABLE Products;
CREATE TABLE Products (
    ProductID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    ProductName NVARCHAR(255),
    Price FLOAT
);

IF OBJECT_ID ('Status', 'U') IS NOT NULL DROP TABLE Status;
CREATE TABLE Status (
    StatusID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Status NVARCHAR(50)
);

IF OBJECT_ID ('Address', 'U') IS NOT NULL DROP TABLE Address;
CREATE TABLE Address (
    AddressID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Address NVARCHAR(255),
    NumberPhone NVARCHAR(255),
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

IF OBJECT_ID ('Carts', 'U') IS NOT NULL DROP TABLE Carts;
CREATE TABLE Carts (
    CartID INT IDENTITY(1,1) PRIMARY KEY NOT NULL, 
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

IF OBJECT_ID ('Orders', 'U') IS NOT NULL DROP TABLE Orders;
CREATE TABLE Orders (
    OrderID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    OrderDate DATE,
    UserID INT, 
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    StatusID INT,
    FOREIGN KEY (StatusID) REFERENCES Status(StatusID)
);

IF OBJECT_ID ('ProductVariant', 'U') IS NOT NULL DROP TABLE ProductVariant;
CREATE TABLE ProductVariant (
    ProductVariantID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Stock INT,
    ProductID INT,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    ColorID INT,
    FOREIGN KEY (ColorID) REFERENCES Color(ColorID),
    SizeID INT,
    FOREIGN KEY (SizeID) REFERENCES Size(SizeID),
    DescriptionID INT,
    FOREIGN KEY (DescriptionID) REFERENCES Description(DescriptionID),
    PictureID INT,
    FOREIGN KEY (PictureID) REFERENCES PicturePath(PictureID),
    CategoryID INT,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

IF OBJECT_ID ('OrderDetail', 'U') IS NOT NULL DROP TABLE OrderDetail;
CREATE TABLE OrderDetail (
    OrderDetailID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    Quantity INT,
    OrderID INT, 
    ProductVariantID INT, 
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductVariantID) REFERENCES ProductVariant(ProductVariantID)
);

IF OBJECT_ID ('CartItem', 'U') IS NOT NULL DROP TABLE CartItem;
CREATE TABLE CartItem (
    CartItemID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    AddDate DATE,
    Quantity INT,
    CartID INT,
    FOREIGN KEY (CartID) REFERENCES Carts(CartID),
    OrderID INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    ProductVariantID INT,
    FOREIGN KEY (ProductVariantID) REFERENCES ProductVariant(ProductVariantID)
);

CREATE TABLE BillDetail (
	BillDetailID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	BillID INT,
	FOREIGN KEY (BillID) REFERENCES Bill(BillID),
	ProductID INT,
	FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Bill (
	BillID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	CreateDate Date,
	UserID INT,
	FOREIGN KEY (UserID) REFERENCES Users(UserID),
);

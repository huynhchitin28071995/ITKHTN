-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 27, 2018 at 04:26 PM
-- Server version: 5.7.24-0ubuntu0.18.04.1
-- PHP Version: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MiniShop`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddAuthor` (`name` VARCHAR(128))  INSERT INTO Author (AuthorName) VALUES (name)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddCart` (`id` CHAR(32), `mId` BIGINT, `pId` INT, `qty` SMALLINT)  BEGIN
	INSERT INTO Cart (CartId, userId, ProductId, Quantity) VALUES (id, mId, pId, qty)
		ON DUPLICATE KEY UPDATE Quantity = Quantity + qty;
END$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddCategory` (`name` VARCHAR(128), `parent` INT)  INSERT INTO Category (CategoryName, ParentId) VALUES(name, parent)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddInvoice` (`id` CHAR(32), `puserId` BIGINT, `pEmail` VARCHAR(64), `pTel` VARCHAR(16), `pAddress` VARCHAR(128))  BEGIN
	INSERT INTO Invoice(InvoiceId, userId, Email, Tel, Address) VALUES(id, puserId, pEmail, pTel, pAddress);
	INSERT into InvoiceDetail (InvoiceId, ProductId, Quantity, Price) 
		SELECT CartId, Cart.ProductId, Cart.Quantity, Price  FROM Cart INNER JOIN Product ON Cart.ProductId = Product.ProductId
		WHERE CartId = id;
	DELETE FROM Cart WHERE CartId = id;
END$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `Adduser` (`pUsername` VARCHAR(32), `pPassword` BINARY(32), `pEmail` VARCHAR(64), `pFullname` VARCHAR(128), `pGender` TINYINT)  INSERT INTO user (userId, Username, Password, Email, Fullname, Gender)
	VALUES (RandomBigInt(), pUsername, pPassword, pEmail, pFullname, pGender)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddProduct` (`pCategoryId` INT, `pPublisherId` INT, `pAuthorId` INT, `pISBN` VARCHAR(16), `pTitle` VARCHAR(128), `pPages` SMALLINT, `pYear` SMALLINT, `pWeight` VARCHAR(32), `pSize` VARCHAR(16), `pDescription` VARCHAR(1024), `pContent` VARCHAR(2048), `pImageUrl` VARCHAR(128))  INSERT INTO Product (CategoryId, PublisherId, AuthorId, ISBN, Title, Pages, Year, Weight, Size, Description, Content, ImageUrl)
		VALUES(pCategoryId, pPublisherId, pAuthorId, pISBN, pTitle, pPages, pYear, pWeight, pSize, pDescription, pContent, pImageUrl)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddPublisher` (`name` VARCHAR(128))  INSERT INTO Publisher(PublisherName) VALUES(name)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddRole` (`name` VARCHAR(32))  INSERT INTO Role(RoleId, RoleName) 
	VALUES (RandomInt(), name)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `AddSession` (`id` CHAR(32), `puserId` BIGINT, `pDevice` VARCHAR(128), `pBrowser` VARCHAR(128), `pIP` VARCHAR(32), `pToken` BINARY(32))  INSERT INTO Session (SessionId, userId, Device, Browser, IP, Token)
		VALUES(id, puserId, pDevice, pBrowser, pIP, pToken)$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `CountCategory` ()  SELECT COUNT(*) FROM Category$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DelCategory` (`id` INT)  DELETE FROM Category WHERE CategoryId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DeleteAuthor` (`id` INT)  DELETE FROM Author WHERE AuthorId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DeleteCart` (`pCartId` CHAR(32), `pProductId` INT)  BEGIN
	DELETE FROM CartDetail WHERE CartId = pCartId AND ProductId = pProductId;
END$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DeleteCategory` (`id` INT)  DELETE FROM Category WHERE CategoryId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DeleteProduct` (`id` INT)  DELETE FROM Product WHERE ProductId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `DeletePublisher` (`id` INT)  DELETE FROM Publisher WHERE PublisherId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `EditAuthor` (`id` INT, `name` VARCHAR(128))  UPDATE Author SET AuthorName = name WHERE AuthorId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `EditCartDetail` (`pCartId` CHAR(32), `pProductId` INT, `pQuantity` INT)  BEGIN
	UPDATE CartDetail SET Quantity = pQuantity WHERE CartId = pCartId AND ProductId = pProductId;
END$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `EditCategory` (`id` INT, `name` VARCHAR(128), `parent` INT)  UPDATE Category SET CategoryName = name, ParentId = parent WHERE CategoryId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `EditPublisher` (`id` INT, `name` VARCHAR(128))  UPDATE Publisher SET PublisherName = name WHERE PublisherId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetAuthorById` (`id` INT)  SELECT * FROM Author WHERE AuthorId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetAuthors` ()  SELECT * FROM Author$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetCartById` (`id` CHAR(32))  BEGIN
	SELECT CartId, AddedDate FROM Cart WHERE CartId = id;
	SELECT CartId, CartDetail.ProductId, CartDetail.Quantity, Title, ImageUrl FROM CartDetail 
		INNER JOIN Product ON CartDetail.ProductId = Product.ProductId
		WHERE CartId = id;
END$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetCarts` (`id` CHAR(32))  SELECT CartId, Cart.ProductId, Title, ImageUrl, Quantity, Price, ImageUrl, Cart.AddedDate 
	FROM Cart INNER JOIN Product ON Cart.ProductId = Product.ProductId WHERE CartId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetCategories` (`pIndex` INT, `pSize` INT)  SELECT CategoryId, CategoryName, ParentId FROM Category LIMIT pIndex, pSize$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetCategoryById` (`id` INT)  SELECT CategoryId, CategoryName, ParentId FROM Category WHERE CategoryId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetInvoicesByuser` (`puserId` BIGINT)  SELECT InvoiceId, user.userId, Tel, Address, Invoice.AddedDate 
	FROM Invoice INNER JOIN user ON Invoice.userId = user.userId$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetuserId` (`id` CHAR(32), `pToken` BINARY(32))  SELECT user.userId FROM Session
	INNER JOIN user ON Session.userId = user.userId
	WHERE SessionId = id AND Token = pToken$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `Getusers` ()  SELECT userId, Username, Email, Fullname, Gender, AddedDate FROM user$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetProductById` (`id` INT)  SELECT ProductId, CategoryId, Product.PublisherId, Product.AuthorId, ISBN, Title, Pages, Year, Weight,
	Size, Description, Content, ImageUrl, PublisherName, AuthorName 
	FROM Product INNER JOIN Publisher ON Product.PublisherId = Publisher.PublisherId
	INNER JOIN Author ON Product.AuthorId = Author.AuthorId WHERE ProductId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetProductByISBN` (`pISBN` VARCHAR(16))  SELECT ProductId, CategoryId, Product.PublisherId, Product.AuthorId, ISBN, Title, Pages, Year, Weight,
	Size, Description, Content, ImageUrl, PublisherName, AuthorName 
	FROM Product INNER JOIN Publisher ON Product.PublisherId = Publisher.PublisherId
	INNER JOIN Author ON Product.AuthorId = Author.AuthorId WHERE ISBN = pISBN$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetProducts` ()  SELECT ProductId, CategoryId, Product.PublisherId, Product.AuthorId, ISBN, Title, Pages, Year, Weight,
	Size, Description, Content, ImageUrl, PublisherName, AuthorName 
	FROM Product INNER JOIN Publisher ON Product.PublisherId = Publisher.PublisherId
	INNER JOIN Author ON Product.AuthorId = Author.AuthorId$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetPublisherById` (`id` INT)  SELECT * FROM Publisher WHERE PublisherId = id$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetPublishers` ()  SELECT * FROM Publisher$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetRoles` ()  SELECT RoleId, RoleName FROM Role$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `GetUsername` (`id` CHAR(32), `pToken` BINARY(32))  SELECT Session.SessionId, Username FROM Session
	INNER JOIN user ON Session.userId = user.userId
	WHERE SessionId = id AND Token = pToken$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `LogOnuser` (`pUsername` VARCHAR(32), `pPassword` BINARY(32))  SELECT userId FROM user WHERE Username = pUsername AND Password = pPassword$$

CREATE DEFINER=`kaka`@`localhost` PROCEDURE `StatisticProductsByCategory` ()  SELECT Category.CategoryId, CategoryName, COUNT(ProductId) AS Total 
	FROM Category INNER JOIN Product ON Category.CategoryId = Product.CategoryId
	GROUP BY Category.CategoryId, CategoryName$$

--
-- Functions
--
CREATE DEFINER=`kaka`@`localhost` FUNCTION `RandomBigInt` () RETURNS BIGINT(20) RETURN FLOOR(RAND() * 9223372036854775807)$$

CREATE DEFINER=`kaka`@`localhost` FUNCTION `RandomInt` () RETURNS INT(11) RETURN FLOOR(RAND() * 2147483647)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Author`
--

CREATE TABLE `Author` (
  `AuthorId` int(11) NOT NULL,
  `AuthorName` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Author`
--

INSERT INTO `Author` (`AuthorId`, `AuthorName`) VALUES
(1, 'Vaskaran Sarcar'),
(2, '     Andrew Troelsen'),
(3, 'Rogers Cadenhead'),
(4, 'Johan Vos'),
(5, 'Michael R. Brzustowicz PhD'),
(6, 'Sayan Mukhopadhyay'),
(7, 'Barry A. Burd'),
(8, 'Clare Churcher'),
(9, 'Michael Coles, Rodney Landrum'),
(10, 'Adam Jorgensen, Brian Knight, Ross LoForte, Steven Wort'),
(11, 'Jay Natarajan, Michael Coles, Rudi Bruchez, Scott Shaw'),
(12, 'Aahz Maruch, Stef Maruch'),
(13, 'Thiên Long'),
(14, 'Phạm Văn Ất'),
(15, 'Pham Van Hung'),
(16, 'Grokking'),
(17, '7 Up'),
(18, 'Bill gate');

-- --------------------------------------------------------

--
-- Table structure for table `Cart`
--

CREATE TABLE `Cart` (
  `CartId` char(32) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `AddedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Cart`
--

INSERT INTO `Cart` (`CartId`, `ProductId`, `Quantity`, `userId`, `AddedDate`) VALUES
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', 1, 1, NULL, '2018-10-18 23:26:06'),
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', 4, 1, NULL, '2018-10-18 23:26:52'),
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', 5, 2, NULL, '2018-10-18 23:26:34');

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(128) NOT NULL,
  `ParentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`CategoryId`, `CategoryName`, `ParentId`) VALUES
(1, 'Web Development', NULL),
(2, 'Programming', NULL),
(3, 'Databases', NULL),
(4, 'ASP.NET2', 1),
(5, 'PHP', 1),
(6, 'HTML, CSS', 1),
(7, 'Javascript', 1),
(8, 'C#', 2),
(9, 'Java', 2),
(10, 'C & C++', 2),
(11, 'Python', 2),
(12, 'Mysql', 3),
(13, 'SQL Server', 3),
(14, 'MongoDB', 3),
(15, 'Oracle', 3),
(16, 'Postgree SQL', 3),
(17, 'Stationery', NULL),
(18, 'Student tools', 17);

-- --------------------------------------------------------

--
-- Table structure for table `Invoice`
--

CREATE TABLE `Invoice` (
  `InvoiceId` char(32) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `Email` varchar(64) NOT NULL,
  `Tel` varchar(16) NOT NULL,
  `Address` varchar(128) NOT NULL,
  `StatusId` tinyint(4) NOT NULL DEFAULT '1',
  `AddedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Invoice`
--

INSERT INTO `Invoice` (`InvoiceId`, `userId`, `Email`, `Tel`, `Address`, `StatusId`, `AddedDate`) VALUES
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', NULL, 'npthanhthai@yahoo.com.vn', '1234234', 'hcm', 1, '2018-10-17 23:37:37');

-- --------------------------------------------------------

--
-- Table structure for table `InvoiceDetail`
--

CREATE TABLE `InvoiceDetail` (
  `InvoiceId` char(32) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `InvoiceDetail`
--

INSERT INTO `InvoiceDetail` (`InvoiceId`, `ProductId`, `Quantity`, `Price`) VALUES
('af8i2wvoqY1PZwBuKucvQFZuiVhx4A3D', 1, 1, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL,
  `Username` varchar(32) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `Email` varchar(64) DEFAULT NULL,
  `Gender` tinyint(4) DEFAULT '0',
  `Tel` varchar(16) DEFAULT NULL,
  `Address` varchar(128) DEFAULT NULL,
  `AddedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ModifiedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `Username`, `Password`, `Email`, `Gender`, `Tel`, `Address`, `AddedDate`, `ModifiedDate`) VALUES
(2737717304588825839, 'son', '$2a$10$I2gIr21CXXZ13Zp6O4YbPOl4MhRK.dIHEAfoIPoH1qaJdiCcFTvoC', 'son@gmail.com', 0, '54677', 'hcm', '2018-10-19 11:00:41', NULL),
(3421842250477308203, 'admin', '$2a$10$ds4H8yR99pgTudUBI3h7T.9tpBPWIx3rSDCRQdVFn9ci2NgTgf8f6', 'admin@yahoo.com.vn', 0, '54677', 'hcm', '2018-10-09 23:31:33', NULL),
(4761811720233120523, 'admin2', '$2a$10$bSgiw2AJXZ0PsIxQgwfzjeMO8k6kCqRm9C7Kih5/qfG4/UOGyHmei', 'admin@yahoo.com.vn', 0, '54677', 'hcm', '2018-10-09 23:58:49', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userInRole`
--

CREATE TABLE `userInRole` (
  `RoleId` int(11) NOT NULL,
  `userId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userInRole`
--

INSERT INTO `userInRole` (`RoleId`, `userId`) VALUES
(1, 2737717304588825839),
(1, 4761811720233120523);

-- --------------------------------------------------------

--
-- Table structure for table `Product`
--

CREATE TABLE `Product` (
  `ProductId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  `PublisherId` int(11) NOT NULL,
  `AuthorId` int(11) NOT NULL,
  `ISBN` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `Title` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `Pages` smallint(6) NOT NULL,
  `Year` smallint(6) NOT NULL,
  `Weight` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Size` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `Content` varchar(2048) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ImageUrl` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Price` int(11) NOT NULL DEFAULT '100000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Product`
--

INSERT INTO `Product` (`ProductId`, `CategoryId`, `PublisherId`, `AuthorId`, `ISBN`, `Title`, `Pages`, `Year`, `Weight`, `Size`, `Description`, `Content`, `ImageUrl`, `Price`) VALUES
(1, 8, 1, 1, '1484236394', 'Design Patterns in C#', 455, 2018, 'PDF', '14.5 MB', 'In the first part of Design Patterns in C#, you will cover the 23 Gang of Four (GoF) design patterns, before moving onto some alternative design patterns, including the Simple Factory Pattern, the Null Object Pattern, and the MVC Pattern. The final part winds up with a conclusion and criticisms of design patterns with chapters on anti-patterns and memory leaks. By working through easy-to-follow examples, you will understand the concepts in depth and have a collection of programs to port over to your own projects.', '', 'Design-Patterns-in-C.jpg', 100000),
(2, 8, 1, 2, '1484230175', 'Pro C# 7-8th Edition', 1372, 2017, 'PDF', '29.5 MB', 'Ky la', '', 'Pro-C-7-8th-Edition.jpg', 100000),
(3, 9, 1, 3, '0672337940', 'Java in 24 Hours, Sams Teach Yourself (Covering Java 9), 8th Edition', 448, 2017, 'PDF', '5.6 MB', 'Computer programming with Java is easier than it looks. In just 24 lessons of one hour or less, you can learn to write computer programs in Java. Using a straightforward, step-by-step approach, popular author Rogers Cadenhead helps you master the skills and technology you need to create desktop', '', 'Java-in-24-Hours-Sams-Teach-Yourself-Covering-Java-9-8th-Edition-400x490.jpg', 100000),
(4, 9, 1, 4, '1484230418', 'Pro JavaFX 9, 4th Edition', 348, 2018, 'PDF', '6.2 MB', 'Use the JavaFX platform to create rich-client Java applications and discover how you can use this powerful Java-based UI platform, which is capable of handling large-scale data-driven business applications for PC as well as mobile and embedded devices. The expert authors cover the new more modular JavaFX 9 APIs', '', 'Pro-JavaFX-9-4th-Edition.jpg', 100000),
(5, 9, 2, 5, '1491934115', 'Data Science with Java', 236, 2017, 'PDF', '7.1 MB', 'Ky la', '', 'Data-Science-with-Java.jpg', 100000),
(6, 11, 1, 6, '1484234499', 'Advanced Data Analytics Using Python', 186, 2018, 'PDF', '2.1 MB', 'Ok', '', 'Advanced-Data-Analytics-Using-Python.jpg', 100000),
(7, 9, 1, 7, '1119235553', 'Java For Dummies, 7th Edition', 504, 2014, 'PDF', '12.6 MB', 'A new edition of the bestselling guide to Java\r\nIf you want to learn to speak the world’s most popular programming language like a native, Java For Dummies is your ideal companion. With a focus on reusing existing code, it quickly and easily shows you how to create basic Java objects, work with Java classes and methods, understand the value of variables, learn to control program flow with loops or decision-making statements, and so much more!\r\nJava is everywhere, runs on almost any computer, and is the engine that drives the coolest applications. Written for anyone who’s ever wanted to tackle programming with Java but never knew quite where to begin, this bestselling guide is your ticket to success! Featuring updates on everything you’ll encounter in Java 9—and brimming with tons of step-by-step instruction—it’s the perfect resource to get you up and running with Java in a jiffy!', '', 'Java-For-Dummies-7th-Edition.jpg', 100000),
(8, 13, 1, 8, '1484219546', 'Beginning SQL Queries, Second Edition', 250, 2016, 'PDF', '20.9 MB', 'Anyone who does any work at all with databases needs to know something of SQL. This is a friendly and easy-to-read guide to writing queries with the all-important – in the database world – SQL language. The author writes with exceptional clarity', '', 'Beginning-SQL-Queries.jpg', 100000),
(9, 13, 1, 9, '1430224649', 'Expert SQL Server 2008 Encryption', 320, 2009, 'PDF', '3.18 MB', 'Every day, organizations large and small fall victim to attacks on their data. Encryption provides a shield to help defend against intruders. Because of increasing pressure from government regulators, consumers, and the business community at large, the job descriptions of SQL DBAs and developers are expanding to include encryption. Expert SQL Server 2008 Encryption will show you how to efficiently implement SQL Server 2008 encryption functionality and features to secure your organizational data', '', '4056a343e83f1df.jpeg', 100000),
(10, 13, 1, 10, '9781118106884', 'Professional Microsoft SQL Server 2012 Administration', 936, 2012, 'PDF', '93.1 MB', 'Microsoft SQL Server 2012 will have major changes throughout the SQL Server and will impact how DBAs administer the database. With this book, a team of well-known SQL Server experts introduces the many new features of the most recent version of SQL Server and deciphers how these changes will affect the methods that administrators have been using for years. Loaded with unique tips, tricks, and workarounds for handling the most difficult SQL Server admin issues, this how-to guide deciphers topics such as performance tuning, backup and recovery, scaling and replication, clustering, and security.', '', '295557fd027de7f.jpg', 100000),
(11, 13, 1, 1, '9781430245964', 'Pro T-SQL 2012 Programmer’s Guide, 3rd Edition', 696, 2012, 'PDF', '18.9 MB', 'Pro T-SQL 2012 Programmer’s Guide is every developer’s key to making full use of SQL Server 2012’s powerful, built-in Transact-SQL language. Discussing new and existing features, the book takes you on an expert guided tour of Transact-SQL functionality. Fully functioning examples and downloadable source code bring technically accurate and engaging treatment of Transact-SQL into your own hands. Step-by-step explanations ensure clarity, and an advocacy of best-practices will steer you down the road to success.\r\n\r\nTransact-SQL is the language developers and DBAs use to interact with SQL Server. It’s used for everything from querying data, to writing stored procedures, to managing the database. New features in T-SQL 2012 include full support for window functions, stored sequences, the ability to throw errors, data paging, and more. All these important new features are covered in this book', '', '295557fd07764c9.jpg', 100000),
(12, 11, 2, 12, '0471778648', 'Python For Dummies', 432, 2006, 'PDF', '1.7 MB', 'Python is one of the most powerful, easy-to-read programminglanguages around, but it does have its limitations. This generalpurpose, high-level language that can be extended and embedded is asmart option for many programming problems, but a poor solution toothers.\r\nPython For Dummies is the quick-and-easy guide to gettingthe most out of this robust program. This hands-on book will showyou everything you need to know about building programs, debuggingcode, and simplifying development, as well as defining what actionsit can perform. You’ll wrap yourself around all of itsadvanced features and become an expert Python user in no time. Thisguide gives you the tools you need to', '', 'Python-For-Dummies.jpg', 100000),
(13, 18, 3, 13, '8935001810087', 'Bút Lông Bảng Thiên Long TL WB.03', 10, 2018, 'Fly', '10', 'Bút được sản xuất theo công nghệ hiện đại , đạt tiêu chuẩn an toàn quốc tế\n\nViết tốt , trơn , êm trơn bảng trắng , thủy tinh và những bề mặt nhẵn bóng\n\nBề rộng nét viết 2.5mm', '', 'cea9ce2d56b921055f39dbfbfdfc1894.jpg', 100000),
(14, 10, 4, 14, '8935095624539', 'GIÁO TRÌNH C++ VÀ LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG', 300, 2017, 'Book', '3 x 4', 'Lập trình cấu trúc là phương pháp tổ chức, phân chia chương trình thành các hàm, thủ tục, chúng được dùng để xử lý dữ liệu nhưng lại tách rời các cấu trúc dữ liệu. Thông qua các ngôn ngữ Foxpro, Pascal, C đa số những người làm Tin học đã khá quen biết với phương pháp lập trình này.\n\n \n\nLập trình hướng đối tượng dựa trên việc tổ chức chương trình thành các lớp. Khác với hàm và thủ tục, lớp là một đơn vị bao gồm cả dữ liệu và các phương thức xử lý. Vì vậy lớp có thể mô tả các thực thể một cách chân thực, đầy đủ cả phần dữ liệu và yêu cầu quản lý. Tư tưởng lập trình hướng đối tượng được áp dụng cho hầu hết các ngôn ngữ mới chạy trên môi trường Windows như Microsoft Access, Visual Basic, Visual C. Vì vậy việc nghiên cứu phương pháp lập trình mới này là rất cần thiết đối với tất cả những người quan tâm, yêu thích Tin học', '', '8935095624539.jpg', 100000),
(15, 13, 5, 15, '9786047355020', 'Big Data và ứng dụng trong kinh doanh', 350, 2018, 'Book', '20 x 30', 'Trong những năm gần đây, một thuật ngữ trong công nghệ thông tin được nhiều người quan tâm phải kể đến là Big Data (Dữ liệu lớn). Big Data là dữ liệu vượt quá khả năng xử lý của các hệ thống cơ sở dữ liệu thông thường, dữ liệu quá lớn, di chuyển quá nhanh hoặc không phù hợp với kiến trúc cơ sở dữ liệu hiện tại. Để thu được giá trị từ dữ liệu này, người ta phải chọn một cách khác để xử lý nó.', '', '2017-09-14-04-56-03_image002.jpg', 100000),
(16, 16, 6, 16, '9786045265840', 'Dijkstra - Ấn Phẩm Chuyên Đề Cho Kỹ Sư Phần Mềm Người Việt ', 30, 2018, 'Magezine', '70 x 80', 'Bạn đang cầm trên tay tập đầu tiên của ấn phẩm Dijkstra - Ấn Phẩm Chuyên Đề Cho Kỹ Sư Phần Mềm Người Việt - kết quả của một thời gian dài thai nghén ý tưởng của đội ngũ Grokking Vietnam.\n\nTrong ấn phẩm này, nhóm biên soạn sẽ cố gắng cung cấp những bài viết chuyên sâu về lĩnh vực công nghệ phần mềm, những bài phân tích kiến trúc, những bài viết về văn hóa, cộng đồng và các bài viết về kiến thức nền tảng khoa học máy tính. Để đảm bảo tính chính xác cũng như tính cập nhật, những bài viết này sẽ được viết bởi chính những kỹ sư phần mềm đang làm việc trong những công ty phần mềm tại Việt Nam hoặc nước ngoài', '', '75a3c5e390d6942c8042f36637947a5e.jpg', 100000),
(17, 18, 7, 17, '8934588843051', 'Nước ngọt Revive chai 390ml', 1, 2018, 'Chai', '390 ml', 'Nước ngọt được sản xuất trên dây chuyền hiện đại chiết xuất từ nước bão hòa CO2, đường sucrose và destrose, chất điều chỉnh độ axit, chất điện giải... không chứa chất bảo quản và hóa chất độc hại, an toàn cho người sử dụng.\nVới chất điện giải Natri, Kali... và vitamin B3, B6, B12 giúp bù nước, muối khoáng bị mất đi nhanh chóng do vận động, chơi thể thao.', '', '7up-revive-pet-390ml-2-700x467-1.jpg', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `Publisher`
--

CREATE TABLE `Publisher` (
  `PublisherId` int(11) NOT NULL,
  `PublisherName` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Publisher`
--

INSERT INTO `Publisher` (`PublisherId`, `PublisherName`) VALUES
(1, 'Appress'),
(2, 'O\'Reilly'),
(3, 'Thiên Long'),
(4, 'Ky thuat Ha Noi'),
(5, 'DHQG HCM'),
(6, 'Dong Nai'),
(7, '7 Up');

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `RoleId` int(11) NOT NULL,
  `RoleName` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`RoleId`, `RoleName`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_user');

-- --------------------------------------------------------

--
-- Table structure for table `Status`
--

CREATE TABLE `Status` (
  `StatusId` tinyint(4) NOT NULL,
  `StatusName` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Status`
--

INSERT INTO `Status` (`StatusId`, `StatusName`) VALUES
(1, 'Processing'),
(2, 'Confirm'),
(3, 'Delivered');

-- --------------------------------------------------------

--
-- Table structure for table `StatusInvoice`
--

CREATE TABLE `StatusInvoice` (
  `StatusId` tinyint(4) NOT NULL,
  `StatusName` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Author`
--
ALTER TABLE `Author`
  ADD PRIMARY KEY (`AuthorId`);

--
-- Indexes for table `Cart`
--
ALTER TABLE `Cart`
  ADD PRIMARY KEY (`CartId`,`ProductId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CategoryId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `userInRole`
--
ALTER TABLE `userInRole`
  ADD PRIMARY KEY (`RoleId`,`userId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `Product`
--
ALTER TABLE `Product`
  ADD PRIMARY KEY (`ProductId`);

--
-- Indexes for table `Publisher`
--
ALTER TABLE `Publisher`
  ADD PRIMARY KEY (`PublisherId`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`RoleId`),
  ADD UNIQUE KEY `RoleName` (`RoleName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Author`
--
ALTER TABLE `Author`
  MODIFY `AuthorId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `CategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `Product`
--
ALTER TABLE `Product`
  MODIFY `ProductId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `Publisher`
--
ALTER TABLE `Publisher`
  MODIFY `PublisherId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cart`
--
ALTER TABLE `Cart`
  ADD CONSTRAINT `Cart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `Cart_ibfk_2` FOREIGN KEY (`ProductId`) REFERENCES `Product` (`ProductId`);

--
-- Constraints for table `userInRole`
--
ALTER TABLE `userInRole`
  ADD CONSTRAINT `userInRole_ibfk_1` FOREIGN KEY (`RoleId`) REFERENCES `Role` (`RoleId`),
  ADD CONSTRAINT `userInRole_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

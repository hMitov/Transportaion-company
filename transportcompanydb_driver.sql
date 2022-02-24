-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: transportcompanydb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contractDate` date DEFAULT NULL,
  `egn` varchar(255) NOT NULL,
  `position` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `salary` decimal(19,2) DEFAULT NULL,
  `drive_license_category` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_eh6a1cp5ct5xsggo93w5o1ek2` (`egn`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'2015-03-05','5527538719',NULL,'Zdravko Simeonov',NULL,'DE'),(2,'2010-05-21','6674287652','DRIVER','Alexander Pavlov',4900.00,'D'),(3,'2007-01-14','6783088784','DRIVER','Ruslan Neshev',5500.00,'DE'),(4,'2020-09-18','7264927492','DRIVER','Preslav Kolev',4500.00,'CE'),(5,'2014-06-09','7348022854','DRIVER','Nikolay Bojidarov',5300.00,'DE'),(6,'2011-02-04','8715266378','DRIVER','Jivko Marinov',5500.00,'C1'),(7,'2018-12-19','8873522185','DRIVER','Ivan Danielov',3500.00,'C'),(8,'2014-06-13','8936777266','DRIVER','Daniel Petrov',4800.00,'D'),(9,'2012-03-01','9109276389','DRIVER','Marin Nikolov',4500.00,'C1E'),(10,'2016-07-07','9387108845','DRIVER','Vladimir Ivanov',4700.00,'D1'),(11,'2019-05-19','9393874463','DRIVER','Vasilen Petrov',3700.00,'CE');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20 13:48:03

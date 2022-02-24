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
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(15) DEFAULT NULL,
  `maxNumOfPassengers` int DEFAULT NULL,
  `model` varchar(15) DEFAULT NULL,
  `productionDate` date DEFAULT NULL,
  `regPlate` varchar(255) DEFAULT NULL,
  `typeOfVehicle` varchar(255) NOT NULL,
  `empty_veh_weight` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'Man',0,'Herpa','2013-03-03','A9912BE','TRUCK',3800.00),(2,'Scania',0,'R450','2011-06-06','A9915BE','TRUCK',3700.00),(3,'Renault',0,'480','2008-12-09','BH2920PP','TRUCK',3900.00),(4,'Man',0,'Herpa','2004-08-10','C0012CC','TRUCK',3800.00),(5,'Mercedes-Benz',30,'Tourismo','2007-09-09','C8613PP','BUS',5200.00),(6,'Scania',0,'R450','2013-03-03','CA1238BP','TRUCK',3700.00),(7,'Ford',18,'Transit','2008-09-29','CA7524AA','VAN',2200.00),(8,'Mercedes-Benz',30,'Tourismo','2004-02-04','CB3483HH','BUS',5200.00),(9,'Man',0,'Herpa','2014-12-05','CB5512AA','TRUCK',3800.00),(10,'Man',0,'Herpa','2015-01-10','CB8732PP','TRUCK',3800.00),(11,'Renault',0,'480','2009-11-03','CB8812PB','TRUCK',3900.00),(12,'Mercedes-Benz',0,'Actros','2000-05-14','E9824PH','TRUCK',3600.00),(13,'Mercedes-Benz',12,'Sprinter','2013-01-31','EH4313CA','VAN',2100.00),(14,'Mercedes-Benz',12,'Sprinter','2008-07-23','EH7298BE','VAN',2100.00),(15,'Mercedes-Benz',30,'Tourismo','2006-01-16','K2153KH','BUS',5200.00),(16,'Scania',0,'R450','2013-07-11','KH4290CP','TRUCK',3700.00);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20 13:48:02

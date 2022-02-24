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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `allPaidMoney` decimal(12,2) DEFAULT NULL,
  `contractDate` date DEFAULT NULL,
  `name` varchar(35) DEFAULT NULL,
  `owedMoney` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'2 Donka Ushlinova str., Sofia, Bulgaria',2236118.00,'2005-08-22','OMW',9100.00),(2,'8 Racho Petkov Kazandzhiyata str, Sofia, Bulgaria',444755.00,'2012-06-19','Coca-Cola',2200.00),(3,'Batajnicki Drum 14-16, Beograd, Serbia',0.00,'2012-08-05','Coca-Cola',0.00),(4,'Hristo Belchev 35, Sofia, Bulgaria',790433.00,'2012-06-06','Rad-Festa',7000.00),(5,'Ivan Momchilov 5, Gorna Oriahovitsa, Bulgaria',443700.00,'2015-02-04','Den and Night OOD',1000.00),(6,'Okolovrusten put 46, Sofia, Bulgaria',2608788.00,'2018-09-04','SofiaAuto',12100.00),(7,'Strada Paris nr. 19, Cluj-Napoca 400000, Romania',0.00,'2003-08-17','Discordia',0.00),(8,'Trakia 20, Smolyan ,Bulgaria',0.00,'2017-10-09','Rodopeya',2000.00),(9,'bul. Bulgaria 111A, Sofia, Bulgaria',0.00,'2017-12-21','Dertour',0.00);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
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

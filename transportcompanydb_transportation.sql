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
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transportation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `arrivalPoint` varchar(255) DEFAULT NULL,
  `arrivalTime` datetime DEFAULT NULL,
  `departPoint` varchar(255) DEFAULT NULL,
  `departTime` datetime DEFAULT NULL,
  `numberOfPassengers` int DEFAULT NULL,
  `price` decimal(7,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `typeOfLoad` varchar(255) DEFAULT NULL,
  `weight_in_trailer` decimal(7,2) DEFAULT NULL,
  `weight_in_truck` decimal(7,2) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `driver_id` bigint DEFAULT NULL,
  `vehicle_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKndcbfn5f0f6qgsj48x9fftfju` (`client_id`),
  KEY `FK2hhjmpw0l6nj3wvh0u6bcuhvq` (`driver_id`),
  KEY `FKsnjha50r5ecpg8nlnknexg6ng` (`vehicle_id`),
  CONSTRAINT `FK2hhjmpw0l6nj3wvh0u6bcuhvq` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`),
  CONSTRAINT `FKndcbfn5f0f6qgsj48x9fftfju` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKsnjha50r5ecpg8nlnknexg6ng` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportation`
--

LOCK TABLES `transportation` WRITE;
/*!40000 ALTER TABLE `transportation` DISABLE KEYS */;
INSERT INTO `transportation` VALUES (1,'Sofia','2020-04-05 16:40:00','Varna','2021-04-05 10:00:00',0,3000.00,'FINISHED','PETROL',2500.00,3900.00,1,1,12),(2,'Burgas','2021-05-09 11:00:00','Varna','2021-05-09 08:00:00',0,1500.00,'FINISHED','PETROL',NULL,5000.00,1,7,6),(3,'Blagoevgrad','2021-06-07 15:00:00','Varna','2021-06-07 13:00:00',0,3500.00,'FINISHED','CARS',3100.00,11000.00,6,5,10),(4,'Budapest','2021-10-03 23:30:00','Sofia','2021-10-03 07:00:00',20,7000.00,'FINISHED','PASSENGERS',NULL,NULL,4,2,8),(5,'Plovdiv','2021-10-05 11:00:00','Sofia','2021-10-05 09:00:00',0,2200.00,'FINISHED','DRINKS',NULL,3000.00,2,6,9),(6,'Vidin','2021-11-08 10:00:00','Sofia','2021-11-08 06:00:00',0,4600.00,'FINISHED','PETROL',4500.00,4000.00,1,5,6),(7,'Thessaloniki','2021-12-30 15:40:00','Sofia','2021-12-30 08:00:00',10,4300.00,'FINISHED','PASSENGERS',NULL,NULL,6,10,14),(8,'Sofia','2022-01-02 21:00:00','Thessaloniki','2022-01-02 13:00:00',12,4300.00,'FINISHED','PASSENGERS',NULL,NULL,6,10,14),(9,'Pernik','2022-01-05 16:00:00','Sofia','2022-01-05 15:00:00',0,500.00,'FINISHED','FOOD',3100.00,2000.00,5,11,7),(10,'Pernik','2022-01-10 15:00:00','Sofia','2022-01-10 12:00:00',0,500.00,'FINISHED','FOOD',NULL,2000.00,5,2,7),(15,'Varna','2022-06-05 05:05:00','Ruse','2022-02-05 05:05:00',0,2000.00,'NOT_FINISHED','FOOD',NULL,3000.00,8,4,1);
/*!40000 ALTER TABLE `transportation` ENABLE KEYS */;
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

-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
  `carport_id` int NOT NULL AUTO_INCREMENT,
  `roof_id` int NOT NULL,
  `height` int NOT NULL,
  `length` int NOT NULL,
  `width` int NOT NULL,
  `shed_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `carport_status_id` int NOT NULL,
  PRIMARY KEY (`carport_id`),
  KEY `shed_id_idx` (`shed_id`) /*!80000 INVISIBLE */,
  KEY `roof_id_idx` (`roof_id`) /*!80000 INVISIBLE */,
  KEY `fk_carport_status1_idx` (`carport_status_id`),
  KEY `fk_carport_user1_idx` (`user_id`),
  CONSTRAINT `fk_carport_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_carpot_roof1` FOREIGN KEY (`roof_id`) REFERENCES `roof` (`roof_id`),
  CONSTRAINT `fk_carpot_shed1` FOREIGN KEY (`shed_id`) REFERENCES `shed` (`shed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
INSERT INTO `carport` VALUES (71,63,250,250,250,NULL,125,2),(74,66,250,250,250,NULL,121,2),(79,71,250,250,250,NULL,121,2),(81,73,400,250,550,NULL,127,2),(83,75,250,250,400,NULL,121,2),(85,77,250,250,250,NULL,130,2),(86,78,250,250,250,NULL,132,1),(87,79,250,250,250,NULL,133,1),(88,80,400,550,450,NULL,134,1),(89,81,230,250,250,NULL,135,1),(90,82,230,250,250,NULL,121,1);
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dimensions`
--

DROP TABLE IF EXISTS `dimensions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dimensions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `height` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  `length` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dimensions`
--

LOCK TABLES `dimensions` WRITE;
/*!40000 ALTER TABLE `dimensions` DISABLE KEYS */;
INSERT INTO `dimensions` VALUES (1,230,250,250),(2,250,300,300),(3,270,350,350),(4,290,400,400),(5,310,450,450),(6,330,500,500),(7,350,550,550),(8,370,600,600),(9,390,650,650),(10,410,700,700);
/*!40000 ALTER TABLE `dimensions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `material_description` varchar(90) NOT NULL,
  `material_lenght` varchar(10) NOT NULL,
  `quantity` int DEFAULT NULL,
  `unittype_id` int NOT NULL,
  `price` double NOT NULL,
  `placemet_description` varchar(90) NOT NULL,
  PRIMARY KEY (`material_id`),
  KEY `fk_material_unittype1_idx` (`unittype_id`),
  CONSTRAINT `fk_material_unittype1` FOREIGN KEY (`unittype_id`) REFERENCES `unittype` (`unittype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (2,'25x200 mm. trykimp. Brædt','100',1,1,75,'understernbrædder	til for & bag ende'),(3,'25x125mm. trykimp. Brædt','100',1,1,75,'oversternbrædder til forenden'),(4,'38x73 mm. Lægte ubh.','100',1,1,50,'til z på bagside af dør'),(5,'45x95 mm. Reglar ub.','100',1,1,20,'løsholter til skur gavle'),(6,'45x195 mm. spærtræ ubh.','100',1,1,50,'Remme i sider, sadles ned i stolper'),(7,'97x97 mm. trykimp. Stolpe','100',1,1,30,'Stolper nedgraves 90 cm. i jord'),(8,'19x100 mm. trykimp. Brædt','100',1,1,25,'til beklædning af skur 1 på 2'),(9,'Plastmo Ecolite blåtonet','100',1,1,100,'tagplader	monteres	på spær');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `carport_id` int NOT NULL,
  `price` double NOT NULL,
  `user_id` int NOT NULL,
  `material_list` int NOT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user1_idx` (`user_id`),
  KEY `fk_order_carpot1_idx` (`carport_id`),
  KEY `fk_order_status1_idx` (`order_status_id`),
  CONSTRAINT `fk_order_carpot1` FOREIGN KEY (`carport_id`) REFERENCES `carport` (`carport_id`),
  CONSTRAINT `fk_order_status1` FOREIGN KEY (`order_status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (123,71,325,125,55,'2021-05-24 11:36:21',2),(124,74,325,121,55,'2021-05-24 11:39:34',2),(126,81,535,127,55,'2021-05-24 12:17:37',2),(127,83,777,121,55,'2021-05-24 20:51:18',2),(128,85,436,130,55,'2021-05-27 08:08:30',2);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderline` (
  `orderline_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `material_id` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`orderline_id`),
  KEY `fk_orderlines_order_idx` (`order_id`),
  KEY `fk_orderlines_materiallist1_idx` (`material_id`),
  CONSTRAINT `material_id` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roof`
--

DROP TABLE IF EXISTS `roof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roof` (
  `roof_id` int NOT NULL AUTO_INCREMENT,
  `materials` varchar(90) NOT NULL,
  PRIMARY KEY (`roof_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roof`
--

LOCK TABLES `roof` WRITE;
/*!40000 ALTER TABLE `roof` DISABLE KEYS */;
INSERT INTO `roof` VALUES (54,'Plasttrapezplader'),(55,'Plasttrapezplader'),(56,'Plasttrapezplader'),(57,'Plasttrapezplader'),(58,'Plasttrapezplader'),(59,'Plasttrapezplader'),(60,'Plasttrapezplader'),(61,'Plasttrapezplader'),(62,'Plasttrapezplader'),(63,'Plasttrapezplader'),(64,'Plasttrapezplader'),(65,'Plasttrapezplader'),(66,'Plasttrapezplader'),(67,'Plasttrapezplader'),(68,'Plasttrapezplader'),(69,'Plasttrapezplader'),(70,'Plasttrapezplader'),(71,'Plasttrapezplader'),(72,'Plasttrapezplader'),(73,'Plasttrapezplader'),(74,'Plasttrapezplader'),(75,'Plasttrapezplader'),(76,'Plasttrapezplader'),(77,'Plasttrapezplader'),(78,'Plasttrapezplader'),(79,'Plasttrapezplader'),(80,'Plasttrapezplader'),(81,'Plasttrapezplader'),(82,'Plasttrapezplader');
/*!40000 ALTER TABLE `roof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shed`
--

DROP TABLE IF EXISTS `shed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shed` (
  `shed_id` int NOT NULL AUTO_INCREMENT,
  `materials` varchar(90) DEFAULT NULL,
  `length` int DEFAULT NULL,
  `width` int DEFAULT NULL,
  PRIMARY KEY (`shed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shed`
--

LOCK TABLES `shed` WRITE;
/*!40000 ALTER TABLE `shed` DISABLE KEYS */;
INSERT INTO `shed` VALUES (15,NULL,10,10),(16,NULL,10,10),(17,NULL,10,10),(18,NULL,30,10);
/*!40000 ALTER TABLE `shed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Pending'),(2,'Accepted'),(3,'Denied');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unittype`
--

DROP TABLE IF EXISTS `unittype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unittype` (
  `unittype_id` int NOT NULL AUTO_INCREMENT,
  `unittype_name` varchar(10) NOT NULL,
  PRIMARY KEY (`unittype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unittype`
--

LOCK TABLES `unittype` WRITE;
/*!40000 ALTER TABLE `unittype` DISABLE KEYS */;
INSERT INTO `unittype` VALUES (1,'stk');
/*!40000 ALTER TABLE `unittype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tlf` int NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `address` varchar(90) NOT NULL,
  `zip` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_user_zip1_idx` (`zip`),
  CONSTRAINT `fk_user_zip1` FOREIGN KEY (`zip`) REFERENCES `zip` (`zip`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ansat','1',0,'1','employee','Julegade','3700'),(121,'Nicklas Hansen','kofoedsan@protonmail.com',666,'6','customer','Nordlyst 8','3700'),(122,'Nicklas Hansen','kofoedsan@gmail.com',42649072,'55','customer','Nordlyst 8','3700'),(123,'Nicklas Hansen','kofoedsan@protonmail.com',42649072,'55','customer','Nordlyst, 8','3700'),(124,'Nicklas Hansen','lol@lol',42649072,'88','customer','Nordlyst, 8','3700'),(125,'Nicklas','Kofoedsan@gmail.com',42649072,'66','customer','Nordlyst','3700'),(126,'Nicklas Hansen','LOOL@lol',33,'33','customer','Nordlyst 8','3700'),(127,'Nicklas Hansen','kofoedsan@protonmail.com',77,'77','customer','Nordlyst 8','3700'),(128,'Nicklas Hansen','kofoedsan@protonmail.com',88,'88','customer','Nordlyst 8','3700'),(129,'Nicklas Hansen','kofoedsan@protonmail.com',88,'99','customer','Nordlyst 8','3700'),(130,'Nicklas Hansen','kofoedsan@protonmail.com',99,'99','customer','Nordlyst 8','3700'),(131,'Nicklas Hansen','kofoedsan@protonmail.com',42649072,'44','customer','Nordlyst, 8','3700'),(132,'Nicklas','kofoedsan@protonmail.com',44,'44','customer','Nordlyst','3700'),(133,'Nicklas','kofoedsan@protonmail.com',0,'0','customer','Nordlyst','3700'),(134,'Nicklas','kofoedsan@protonmail.com',88,'88','customer','Nordlyst','3700'),(135,'Nicklas','kofoedsan@protonmail.com',55,'77','customer','Nordlyst','3700');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zip`
--

DROP TABLE IF EXISTS `zip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zip` (
  `zip` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`zip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zip`
--

LOCK TABLES `zip` WRITE;
/*!40000 ALTER TABLE `zip` DISABLE KEYS */;
INSERT INTO `zip` VALUES ('3700','Rønne'),('3790','Hasle');
/*!40000 ALTER TABLE `zip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-28 11:33:39

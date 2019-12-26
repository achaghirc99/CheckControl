-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: acme-jobs
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2a5vcjo3stlfcwadosjfq49l1` (`user_account_id`),
  CONSTRAINT `FK_2a5vcjo3stlfcwadosjfq49l1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (4,0,3);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (32,0,'2019-10-10 08:35:00.000000',NULL,'This is a description of a sample announcement','Sample Announcement 01'),(33,0,'2019-11-18 23:00:00.000000','https://www.example.com','This is a description of a another announcement','Sample Announcement 02'),(34,0,'1900-10-10 19:00:39.000000','https://www.example.com','This is a very old sample announcement','Sample very old Announcement 03'),(35,0,'2019-10-02 17:10:00.000000','https://www.example.com','This is a sample announcement','Sample Announcement 04'),(36,0,'2018-09-10 17:10:00.000000','https://www.example.com','This is a very old sample announcement','Sample very old Announcement 05');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anonymous`
--

DROP TABLE IF EXISTS `anonymous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anonymous` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6lnbc6fo3om54vugoh8icg78m` (`user_account_id`),
  CONSTRAINT `FK_6lnbc6fo3om54vugoh8icg78m` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anonymous`
--

LOCK TABLES `anonymous` WRITE;
/*!40000 ALTER TABLE `anonymous` DISABLE KEYS */;
INSERT INTO `anonymous` VALUES (2,0,1);
/*!40000 ALTER TABLE `anonymous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `justification` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `statement` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rf84q38qr35ymh5nn0dcxfdue` (`reference_number`),
  KEY `FKoa6p4s2oyy7tf80xwc4r04vh6` (`job_id`),
  KEY `FKmbjdoxi3o93agxosoate4sxbt` (`worker_id`),
  CONSTRAINT `FKmbjdoxi3o93agxosoate4sxbt` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FKoa6p4s2oyy7tf80xwc4r04vh6` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (135,0,'','2019-11-25 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB1:WOR1','Great ability to work in teams','---',0,129,13),(136,0,'','2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB1:WOR2','Great ability to work in teams','---',1,129,16),(137,0,'Sorry you don\'t have the qualifications that we need in our company','2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB2:WOR1','Great ability to work in teams','---',2,130,13),(138,0,'','2019-12-15 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB2:WOR2','Great ability to work in teams','---',0,130,16),(139,0,'','2019-12-01 21:00:00.000000','Java, C ++ and PHP developer','EMP1-JOB3:WOR1','Great ability to work in teams','---',1,134,13),(140,0,'Sorry you don\'t have the qualifications that we need in our company','2019-11-25 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB3:WOR2','Great ability to work in teams','---',2,134,16),(141,0,'','2019-12-01 21:00:00.000000','Java, C ++ and PHP developer','EMP2-JOB2:WOR1','Great ability to work in teams','---',0,132,13),(142,0,'','2019-11-30 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP2-JOB2:WOR2','Great ability to work in teams','---',1,132,16),(143,0,'','2019-12-01 21:00:00.000000','Java, C ++ and PHP developer','EMP2-JOB3:WOR1','Great ability to work in teams','---',0,133,13),(144,0,'','2019-12-05 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP2-JOB3:WOR2','Great ability to work in teams','---',1,133,16),(145,0,'','2019-12-01 21:00:00.000000','Java, C ++ and PHP developer','EMP2-JOB1:WOR1','Great ability to work in teams','---',0,131,13),(146,0,'','2019-12-05 21:00:00.000000','Java, C ++ and JavaScript Developer','EMP2-JOB1:WOR2','Great ability to work in teams','---',1,131,16);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applications` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `statement` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_922mp2ee0j5yvg146x5r5cski` (`reference_number`),
  KEY `FKj2gllxnbrvk83wdygiyxdul40` (`job_id`),
  KEY `FKfott6wy710nqog2etbl4atl2c` (`worker_id`),
  CONSTRAINT `FKfott6wy710nqog2etbl4atl2c` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FKj2gllxnbrvk83wdygiyxdul40` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applications`
--

LOCK TABLES `applications` WRITE;
/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` VALUES (892,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB1:WOR1','Great ability to work in teams','---','ACCEPTED',890,813),(893,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB1:WOR2','Great ability to work in teams','---','PENDING',890,813),(894,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB3:WOR1','Great ability to work in teams','---','REJECTED',891,813),(895,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB4:WOR1','Great ability to work in teams','---','ACCEPTED',891,813);
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_records`
--

DROP TABLE IF EXISTS `audit_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_records` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `final_mode` bit(1) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `auditor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl6b73crbwej8f95bvp1npqm8p` (`auditor_id`),
  CONSTRAINT `FKl6b73crbwej8f95bvp1npqm8p` FOREIGN KEY (`auditor_id`) REFERENCES `auditor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_records`
--

LOCK TABLES `audit_records` WRITE;
/*!40000 ALTER TABLE `audit_records` DISABLE KEYS */;
INSERT INTO `audit_records` VALUES (63,0,'This is a body',_binary '','2019-11-26 16:00:00.000000','This is a title',61);
/*!40000 ALTER TABLE `audit_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditor`
--

DROP TABLE IF EXISTS `auditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `responsibility_statement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_clqcq9lyspxdxcp6o4f3vkelj` (`user_account_id`),
  CONSTRAINT `FK_clqcq9lyspxdxcp6o4f3vkelj` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditor`
--

LOCK TABLES `auditor` WRITE;
/*!40000 ALTER TABLE `auditor` DISABLE KEYS */;
INSERT INTO `auditor` VALUES (85,0,84,'Acme-Jobs, Inc.','Don Alvaro como directivo de la empresa    Acme-Jobs, Inc. declaro bajo mi responsabilidad...'),(88,0,87,'Acme-Jobs, Inc.','Don Germán como directivo de la empresa    Acme-Jobs, Inc. declaro bajo mi responsabilidad...');
/*!40000 ALTER TABLE `auditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditors`
--

DROP TABLE IF EXISTS `auditors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditors` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `responsibility_statement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_laye9g52ri2n2qx4i16wckydb` (`user_account_id`),
  CONSTRAINT `FK_laye9g52ri2n2qx4i16wckydb` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditors`
--

LOCK TABLES `auditors` WRITE;
/*!40000 ALTER TABLE `auditors` DISABLE KEYS */;
INSERT INTO `auditors` VALUES (876,0,875,'Acme-Jobs, Inc.','Don Alvaro como directivo de la empresa    Acme-Jobs, Inc. declaro bajo mi responsabilidad...');
/*!40000 ALTER TABLE `auditors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditrecord`
--

DROP TABLE IF EXISTS `auditrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditrecord` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `auditor_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKditgyx355sc4ye86w7tj22cq6` (`auditor_id`),
  KEY `FKa5p4w0gnuwmtb07juvrg8ptn6` (`job_id`),
  CONSTRAINT `FKa5p4w0gnuwmtb07juvrg8ptn6` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKditgyx355sc4ye86w7tj22cq6` FOREIGN KEY (`auditor_id`) REFERENCES `auditor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditrecord`
--

LOCK TABLES `auditrecord` WRITE;
/*!40000 ALTER TABLE `auditrecord` DISABLE KEYS */;
INSERT INTO `auditrecord` VALUES (147,0,'This is a body','2019-11-26 16:00:00.000000',0,'This is a title',88,129),(148,0,'This is a body 2','2019-11-27 16:00:00.000000',0,'This is a title 2',88,129),(149,0,'This is a body 3','2019-11-28 16:00:00.000000',1,'This is a title 3',85,130),(150,0,'This is a body 4','2019-11-29 16:00:00.000000',1,'This is a title 4',88,130),(151,0,'This is a body 5','2019-11-30 09:00:00.000000',0,'This is a title 5',88,131),(152,0,'This is a body 6','2019-11-15 11:00:00.000000',1,'This is a title 6',88,131),(153,0,'This is a body 7','2019-11-30 09:00:00.000000',0,'This is a title 7',85,132),(154,0,'This is a body 8','2019-11-15 11:00:00.000000',1,'This is a title 8',88,132),(155,0,'This is a body 9','2019-11-30 09:00:00.000000',0,'This is a title 9',88,133),(156,0,'This is a body 10','2019-11-15 11:00:00.000000',0,'This is a title 10',88,133),(157,0,'This is a body 11','2019-11-27 16:00:00.000000',0,'This is a title 11',88,134),(158,0,'This is a body 12','2019-11-28 16:00:00.000000',1,'This is a title 12',85,134);
/*!40000 ALTER TABLE `auditrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated`
--

DROP TABLE IF EXISTS `authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authenticated` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h52w0f3wjoi68b63wv9vwon57` (`user_account_id`),
  CONSTRAINT `FK_h52w0f3wjoi68b63wv9vwon57` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated`
--

LOCK TABLES `authenticated` WRITE;
/*!40000 ALTER TABLE `authenticated` DISABLE KEYS */;
INSERT INTO `authenticated` VALUES (5,0,3),(8,0,6),(11,0,9),(14,0,12),(17,0,15),(64,0,63),(66,0,65),(68,0,67),(70,0,69),(73,0,71),(76,0,74),(86,0,84),(89,0,87);
/*!40000 ALTER TABLE `authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chaghir_bulletin`
--

DROP TABLE IF EXISTS `chaghir_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chaghir_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chaghir_bulletin`
--

LOCK TABLES `chaghir_bulletin` WRITE;
/*!40000 ALTER TABLE `chaghir_bulletin` DISABLE KEYS */;
INSERT INTO `chaghir_bulletin` VALUES (52,0,'C1 English','2019-09-09 08:00:00.000000','ChaghirBulletin','631102599'),(53,0,'C1 French','2019-08-29 08:00:00.000000','FriasBulletin','631342399'),(54,0,'C1 German','2019-01-19 09:00:00.000000','GarridoBulletin','733455445');
/*!40000 ALTER TABLE `chaghir_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `bronze_goal` varchar(255) DEFAULT NULL,
  `bronze_reward_amount` double DEFAULT NULL,
  `bronze_reward_currency` varchar(255) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `gold_goal` varchar(255) DEFAULT NULL,
  `gold_reward_amount` double DEFAULT NULL,
  `gold_reward_currency` varchar(255) DEFAULT NULL,
  `silver_goal` varchar(255) DEFAULT NULL,
  `silver_reward_amount` double DEFAULT NULL,
  `silver_reward_currency` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (25,0,'Run 1 km',5,'EUR','2020-12-12 11:00:00.000000','This is my first challenge','Run 10 km',30,'EUR','Run 5 km',20,'EUR','The Challenge 01'),(26,0,'Level C requirements',5,'EUR','2020-11-12 11:00:00.000000','This is my second challenge','Level A requirements',20,'EUR','Level B requirements',10,'EUR','The Challenge 02');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commercialbanner`
--

DROP TABLE IF EXISTS `commercialbanner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commercialbanner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `target_url` varchar(255) DEFAULT NULL,
  `sponsor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnf4j37rlbxr90ggy307pd79y4` (`sponsor_id`),
  CONSTRAINT `FKnf4j37rlbxr90ggy307pd79y4` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commercialbanner`
--

LOCK TABLES `commercialbanner` WRITE;
/*!40000 ALTER TABLE `commercialbanner` DISABLE KEYS */;
INSERT INTO `commercialbanner` VALUES (78,0,'4259909423695677','https://www.castor.es/cartel-madera-logo-castor.jpg','¡Toca madera!','https://www.castor.es/',72),(79,0,'4912713429059592','http://7thartinc.com/wp-content/uploads/7th-art-online-portfolio-fanta-banner-2.jpg','Fanta','https://www.cocacola.es/fanta/es/home/',75),(80,0,'4405425435351574','https://www.nsmshop.com/wp-content/uploads/2019_NSM_WEB_445009_PSP.jpg','Pepsi','https://pepsimax.es/',72);
/*!40000 ALTER TABLE `commercialbanner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyrecord`
--

DROP TABLE IF EXISTS `companyrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companyrecord` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `ceo` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `evaluation` int(11) DEFAULT NULL,
  `incorporated` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyrecord`
--

LOCK TABLES `companyrecord` WRITE;
/*!40000 ALTER TABLE `companyrecord` DISABLE KEYS */;
INSERT INTO `companyrecord` VALUES (18,0,'Álvaro Frías','Empresa especializada en sistemas software','acmejobs@gmail.com',5,_binary '','Acme-Jobs','+34 (123) 1234567','Computing','https://www.acme-jobs.es'),(19,0,'Amine Chaghir','Empresa especializada en sistemas software','acmejobs2@gmail.com',3,_binary '\0','Acme-Jobs2','12345678','Computing','https://www.acme-jobs2.es');
/*!40000 ALTER TABLE `companyrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumer`
--

DROP TABLE IF EXISTS `consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6cyha9f1wpj0dpbxrrjddrqed` (`user_account_id`),
  CONSTRAINT `FK_6cyha9f1wpj0dpbxrrjddrqed` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumer`
--

LOCK TABLES `consumer` WRITE;
/*!40000 ALTER TABLE `consumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card`
--

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_card` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `credit_card_number` varchar(255) DEFAULT NULL,
  `cvc` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `sponsor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4cr95y27s8ti6otoyflmma6oy` (`sponsor_id`),
  UNIQUE KEY `UK9vj3ioxk1h0wvlpcytul1jlho` (`credit_card_number`),
  CONSTRAINT `FK31l5hvh7p1nx1aw6v649gw3rc` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (77,0,'4259909423695677','123','02','Alvaro Frias','2024',72);
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptor`
--

DROP TABLE IF EXISTS `descriptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptor`
--

LOCK TABLES `descriptor` WRITE;
/*!40000 ALTER TABLE `descriptor` DISABLE KEYS */;
INSERT INTO `descriptor` VALUES (122,0,'This is an example'),(123,0,'This is an other example'),(124,0,'This is the third descriptor example'),(125,0,'This is the fourth descriptor example'),(126,0,'This is the fifth descriptor example'),(127,0,'This is the fifth descriptor example'),(128,0,'This is the fifth descriptor example');
/*!40000 ALTER TABLE `descriptor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duty`
--

DROP TABLE IF EXISTS `duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duty` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duty_title` varchar(255) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `descriptor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3cc3garl37bl7gswreqwr7pj4` (`descriptor_id`),
  CONSTRAINT `FK3cc3garl37bl7gswreqwr7pj4` FOREIGN KEY (`descriptor_id`) REFERENCES `descriptor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duty`
--

LOCK TABLES `duty` WRITE;
/*!40000 ALTER TABLE `duty` DISABLE KEYS */;
INSERT INTO `duty` VALUES (101,1,'This is the first duty','Duty 1',40,122),(102,1,'This is the second duty','Duty 2',30,122),(103,1,'This is the third duty','Duty 3',30,122),(104,1,'This is the duty number four','Duty 4',20,123),(105,1,'This is the duty number five','Duty 5',45,123),(106,1,'This is the duty number six','Duty 6',35,123),(107,1,'This is the duty number seven','Duty 7',70,124),(108,1,'This is the duty number eigth','Duty 8',10,124),(109,1,'This is the duty number nine','Duty 9',20,124),(110,1,'This is the duty number ten','Duty 10',23,125),(111,1,'This is the duty number eleven','Duty 11',37,125),(112,1,'This is the duty number twelve','Duty 12',40,125),(113,1,'This is the duty number thirteen','Duty 13',50,126),(114,1,'This is the duty number fourteen','Duty 14',10,126),(115,1,'This is the duty number fiveteen','Duty 15',40,126),(116,1,'This is the duty number sixteen','Duty 16',28,127),(117,1,'This is the duty number seventeen','Duty 17',12,127),(118,1,'This is the duty number eigtheen','Duty 18',60,127),(119,1,'This is the duty number nineteen','Duty 19',25,128),(120,1,'This is the duty number twenty','Duty 20',40,128),(121,1,'This is the duty number twenty one','Duty 21',35,128);
/*!40000 ALTER TABLE `duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_na4dfobmeuxkwf6p75abmb2tr` (`user_account_id`),
  CONSTRAINT `FK_na4dfobmeuxkwf6p75abmb2tr` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (7,0,6,'Employer 1, Inc','Sector 1'),(10,0,9,'Employer 2, Inc','Sector 2');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frias_bulletin`
--

DROP TABLE IF EXISTS `frias_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frias_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frias_bulletin`
--

LOCK TABLES `frias_bulletin` WRITE;
/*!40000 ALTER TABLE `frias_bulletin` DISABLE KEYS */;
INSERT INTO `frias_bulletin` VALUES (58,0,'Alvaro','alvfribal@alum.us.es','Arahal, Sevilla','My first bulletin!'),(59,0,'Javier','javruimun@alum.us.es','Arahal, Sevilla','My second bulletin!');
/*!40000 ALTER TABLE `frias_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (161);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `final_mode` bit(1) NOT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `salary_amount` double DEFAULT NULL,
  `salary_currency` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `descriptor_id` int(11) DEFAULT NULL,
  `employer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7jmfdvs0b0jx7i33qxgv22h7b` (`reference`),
  KEY `FKfqwyynnbcsq0htxho3vchpd2u` (`descriptor_id`),
  KEY `FK3rxjf8uh6fh2u990pe8i2at0e` (`employer_id`),
  CONSTRAINT `FK3rxjf8uh6fh2u990pe8i2at0e` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`),
  CONSTRAINT `FKfqwyynnbcsq0htxho3vchpd2u` FOREIGN KEY (`descriptor_id`) REFERENCES `descriptor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (129,0,'2030-11-12 17:00:00.000000','This is the first job of the first employer',_binary '\0','http://www.example.com','EMP1-JOB1',15000,'€',0,'Job 1',122,7),(130,0,'2020-11-12 22:59:00.000000','This is the second job of the first employer',_binary '','http://www.example.com','EMP1-JOB2',20000,'$',1,'Job 2',123,7),(131,0,'2030-11-12 22:59:00.000000','This is the first job of the second employer',_binary '','http://www.example.com','EMP2-JOB1',24000,'€',1,'Job 3',124,10),(132,0,'2030-11-12 22:59:00.000000','This is the second job of the second employer',_binary '\0','http://www.example.com','EMP2-JOB2',24000,'€',0,'Job 4',125,10),(133,0,'2020-11-12 22:59:00.000000','This is the third job of the second employer',_binary '','http://www.example.com','EMP2-JOB3',24000,'€',1,'Job 5',126,10),(134,0,'2020-11-12 22:59:00.000000','This is the third job of the first employer',_binary '','http://www.example.com','EMP1-JOB3',12000,'€',1,'Job 6',127,7);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maciasportillobulletin`
--

DROP TABLE IF EXISTS `maciasportillobulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maciasportillobulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `hobbies` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maciasportillobulletin`
--

LOCK TABLES `maciasportillobulletin` WRITE;
/*!40000 ALTER TABLE `maciasportillobulletin` DISABLE KEYS */;
INSERT INTO `maciasportillobulletin` VALUES (60,0,'Barcelona','Fotografia.','2019-09-09 09:00:00.000000','John'),(61,0,'Malaga','Cantar.','2019-09-08 14:00:00.000000','Jane'),(62,0,'Madrid','Bailar','2019-09-07 11:00:00.000000','Carlos');
/*!40000 ALTER TABLE `maciasportillobulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `accepted` bit(1) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `message_thread_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn5adlx3oqjna7aupm8gwg3fuj` (`message_thread_id`),
  CONSTRAINT `FKn5adlx3oqjna7aupm8gwg3fuj` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (96,0,_binary '','This is my first message','2019-11-25 10:00:00.000000','message, auditor01','TitleMessage01',90),(97,0,_binary '','This is my second message','2019-11-25 10:00:00.000000','message, auditor02','TitleMessage02',91),(98,0,_binary '','This is my third message','2019-11-27 10:00:00.000000','message, auditor01','TitleMessage03',90),(99,0,_binary '','This is my fourth message','2019-11-27 10:00:00.000000','message, auditor01','TitleMessage04',90),(100,0,_binary '','This is my fifth message','2019-11-27 10:00:00.000000','message, auditor02','TitleMessage05',91);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread`
--

DROP TABLE IF EXISTS `message_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr35u0eaupbx6b2w22e33u8s5u` (`creator_id`),
  CONSTRAINT `FKr35u0eaupbx6b2w22e33u8s5u` FOREIGN KEY (`creator_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread`
--

LOCK TABLES `message_thread` WRITE;
/*!40000 ALTER TABLE `message_thread` DISABLE KEYS */;
INSERT INTO `message_thread` VALUES (90,0,'2019-11-25 11:00:00.000000','TitleMessageThread01',6),(91,0,'2019-11-25 11:00:00.000000','TitleMessageThread02',9);
/*!40000 ALTER TABLE `message_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_authenticated`
--

DROP TABLE IF EXISTS `message_thread_authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_authenticated` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `messagethread_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq2vcidbbbhljef095pueqhpdk` (`messagethread_id`),
  KEY `FKga1oyn9oxkdor5spjyt2rlaur` (`user_id`),
  CONSTRAINT `FKga1oyn9oxkdor5spjyt2rlaur` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`),
  CONSTRAINT `FKq2vcidbbbhljef095pueqhpdk` FOREIGN KEY (`messagethread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_authenticated`
--

LOCK TABLES `message_thread_authenticated` WRITE;
/*!40000 ALTER TABLE `message_thread_authenticated` DISABLE KEYS */;
INSERT INTO `message_thread_authenticated` VALUES (92,0,90,6),(93,0,90,9),(94,0,90,12),(95,0,90,15);
/*!40000 ALTER TABLE `message_thread_authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_message`
--

DROP TABLE IF EXISTS `message_thread_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_message` (
  `message_thread_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  UNIQUE KEY `UK_o8pn8p2cwmh1e0br783hyhfog` (`message_id`),
  KEY `FKp1bkunf5gyu1vtt1q3f2djagy` (`message_thread_id`),
  CONSTRAINT `FKng9giq4eyafnmuev7jm3n8lyf` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`),
  CONSTRAINT `FKp1bkunf5gyu1vtt1q3f2djagy` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_message`
--

LOCK TABLES `message_thread_message` WRITE;
/*!40000 ALTER TABLE `message_thread_message` DISABLE KEYS */;
INSERT INTO `message_thread_message` VALUES (90,96),(90,98),(90,99),(91,97),(91,100);
/*!40000 ALTER TABLE `message_thread_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_user_account`
--

DROP TABLE IF EXISTS `message_thread_user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_user_account` (
  `message_thread_id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  KEY `FKnbmip5t870fxbecafgaxvyde8` (`users_id`),
  KEY `FKtchis3o5qij98x87mty6hdk4d` (`message_thread_id`),
  CONSTRAINT `FKnbmip5t870fxbecafgaxvyde8` FOREIGN KEY (`users_id`) REFERENCES `user_account` (`id`),
  CONSTRAINT `FKtchis3o5qij98x87mty6hdk4d` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_user_account`
--

LOCK TABLES `message_thread_user_account` WRITE;
/*!40000 ALTER TABLE `message_thread_user_account` DISABLE KEYS */;
INSERT INTO `message_thread_user_account` VALUES (84,78),(85,78);
/*!40000 ALTER TABLE `message_thread_user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noncommercialbanner`
--

DROP TABLE IF EXISTS `noncommercialbanner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noncommercialbanner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `optional_jingle` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `target_url` varchar(255) DEFAULT NULL,
  `sponsor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrcem4cf2s7ir1wwyaux4p9ke8` (`sponsor_id`),
  CONSTRAINT `FKrcem4cf2s7ir1wwyaux4p9ke8` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noncommercialbanner`
--

LOCK TABLES `noncommercialbanner` WRITE;
/*!40000 ALTER TABLE `noncommercialbanner` DISABLE KEYS */;
INSERT INTO `noncommercialbanner` VALUES (81,0,'https://www.youtube.com/watch?v=RcfMjohz0vU','https://www.cocacola.es/content/dam/GO/CokeZone/Spain/Coca-Cola-Full-Red-vidrio-Sabor-Original.jpg','Siente el sabor','https://www.cocacola.es/',72),(82,0,'https://www.youtube.com/watch?v=RcfMjohz0vU','https://supermercado.eroski.es/ero_banner/img/bannervideo-aquarius.jpg','Aquarius','https://www.cocacola.es/aquarius/es/home/',75),(83,0,'https://www.youtube.com/watch?v=RcfMjohz0vU','https://www.cocacola.es/content/dam/GO/powerade/spain/home/Logotipo-Powerade.jpg','Powerade','https://www.cocacola.es/powerade/es/home/',72);
/*!40000 ALTER TABLE `noncommercialbanner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `be_careful` bit(1) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `reward_amount` double DEFAULT NULL,
  `reward_currency` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iex7e8fs0fh89yxpcnm1orjkm` (`ticker`),
  KEY `IDXcp4664f36sgqsd0ihmirt0w0` (`ticker`),
  KEY `IDXq2o9psuqfuqmq59f0sq57x9uf` (`deadline`),
  KEY `IDX98uhitjm9562xrxxrb6iw1t3s` (`deadline`,`reward_amount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (30,0,_binary '\0','2020-01-15 12:00:00.000000','2019-09-09 08:00:00.000000',2500,'EUR','This is my first Offer','OAAAA-98765','Oferta 01'),(31,0,_binary '\0','2020-08-15 11:00:00.000000','2019-08-09 08:00:00.000000',1300,'EUR','This is my second Offer','OAAAB-98765','Oferta 02');
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` (`user_account_id`),
  CONSTRAINT `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `assessment` int(11) DEFAULT NULL,
  `investment_statement` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (20,0,1,'---','Register 1','Trade'),(21,0,2,'---','Register 2','Marketing'),(22,0,4,'---','Register 3','Trade'),(23,0,5,'---','Register 4','Marketing'),(24,0,3,'---','Register 5','Production');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registros_inversores`
--

DROP TABLE IF EXISTS `registros_inversores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registros_inversores` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `investment_statement` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registros_inversores`
--

LOCK TABLES `registros_inversores` WRITE;
/*!40000 ALTER TABLE `registros_inversores` DISABLE KEYS */;
/*!40000 ALTER TABLE `registros_inversores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reneses_bulletin`
--

DROP TABLE IF EXISTS `reneses_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reneses_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reneses_bulletin`
--

LOCK TABLES `reneses_bulletin` WRITE;
/*!40000 ALTER TABLE `reneses_bulletin` DISABLE KEYS */;
INSERT INTO `reneses_bulletin` VALUES (55,0,'2019-07-09 11:00:00.000000','Juan Santacruz','Spain'),(56,0,'2019-07-06 16:00:00.000000','Javier Carbonell','Portugal'),(57,0,'2019-04-02 15:00:00.000000','Alvaro Gil','Germany');
/*!40000 ALTER TABLE `reneses_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestauditor`
--

DROP TABLE IF EXISTS `requestauditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requestauditor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `accepted` bit(1) NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpn5tv9qj9g17wg89vpf4d4o22` (`user_id`),
  CONSTRAINT `FKpn5tv9qj9g17wg89vpf4d4o22` FOREIGN KEY (`user_id`) REFERENCES `authenticated` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestauditor`
--

LOCK TABLES `requestauditor` WRITE;
/*!40000 ALTER TABLE `requestauditor` DISABLE KEYS */;
INSERT INTO `requestauditor` VALUES (159,0,_binary '\0','user03',1,68),(160,0,_binary '\0','user04',1,70);
/*!40000 ALTER TABLE `requestauditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requeststore`
--

DROP TABLE IF EXISTS `requeststore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requeststore` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `reward_amount` double DEFAULT NULL,
  `reward_currency` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9sfeyr6twwvu5txdxr44e0wul` (`ticker`),
  KEY `IDXjku4alklr49l9cj5jch1kagnn` (`deadline`),
  KEY `IDXbtmrobfclj179qsaxi9n9lmld` (`deadline`,`reward_amount`),
  KEY `IDX7mpr4u7oxcyr0nrl5osmj05uh` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requeststore`
--

LOCK TABLES `requeststore` WRITE;
/*!40000 ALTER TABLE `requeststore` DISABLE KEYS */;
INSERT INTO `requeststore` VALUES (27,0,'2020-01-01 11:00:00.000000','2019-09-24 20:00:00.000000',1000,'EUR','This is my first request','RASDF-12345','Request1'),(28,0,'2020-11-25 11:00:00.000000','2019-09-25 20:00:00.000000',2500,'EUR','This is my second request','RAAAA-12345','Request2'),(29,0,'2020-10-25 11:00:00.000000','2019-06-25 20:00:00.000000',25,'EUR','This is my third request','RBBBB-12345','Request3');
/*!40000 ALTER TABLE `requeststore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shout`
--

DROP TABLE IF EXISTS `shout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shout` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shout`
--

LOCK TABLES `shout` WRITE;
/*!40000 ALTER TABLE `shout` DISABLE KEYS */;
INSERT INTO `shout` VALUES (6,0,'John Doe','2019-09-09 08:00:00.000000','I´m happy!'),(7,0,'Jane Doe','2019-08-09 13:55:00.000000','I´m the master of my room!'),(8,0,'Foo Bar','2019-09-06 22:00:00.000000','Just turning 20!');
/*!40000 ALTER TABLE `shout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spam`
--

DROP TABLE IF EXISTS `spam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spam` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `spam_word` varchar(255) DEFAULT NULL,
  `threshold` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spam`
--

LOCK TABLES `spam` WRITE;
/*!40000 ALTER TABLE `spam` DISABLE KEYS */;
INSERT INTO `spam` VALUES (37,0,'sex',NULL),(38,0,'hard core',NULL),(39,0,'viagra',NULL),(40,0,'cialis',NULL),(41,0,'nigeria',NULL),(42,0,'you\'ve won',NULL),(43,0,'million dollar',NULL),(44,0,'sexo',NULL),(45,0,'extremo',NULL),(46,0,'viagra',NULL),(47,0,'cialis',NULL),(48,0,'nigeria',NULL),(49,0,'has ganado',NULL),(50,0,'millón de dólares',NULL);
/*!40000 ALTER TABLE `spam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spam_spam_word`
--

DROP TABLE IF EXISTS `spam_spam_word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spam_spam_word` (
  `spam_id` int(11) NOT NULL,
  `spam_word` varchar(255) DEFAULT NULL,
  KEY `FKsir5u6gv9s706bvg8yo6rplbl` (`spam_id`),
  CONSTRAINT `FKsir5u6gv9s706bvg8yo6rplbl` FOREIGN KEY (`spam_id`) REFERENCES `spam` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spam_spam_word`
--

LOCK TABLES `spam_spam_word` WRITE;
/*!40000 ALTER TABLE `spam_spam_word` DISABLE KEYS */;
INSERT INTO `spam_spam_word` VALUES (6,'sex'),(6,'viagra'),(6,'cialis'),(6,'you’ve won'),(6,'nigeria'),(6,'million dollar'),(6,'hard core'),(6,'sexo'),(6,'has ganado'),(6,'nigeria'),(6,'un millón de dólares'),(6,'duro');
/*!40000 ALTER TABLE `spam_spam_word` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spamlist`
--

DROP TABLE IF EXISTS `spamlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spamlist` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `threshold` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spamlist`
--

LOCK TABLES `spamlist` WRITE;
/*!40000 ALTER TABLE `spamlist` DISABLE KEYS */;
INSERT INTO `spamlist` VALUES (51,0,1);
/*!40000 ALTER TABLE `spamlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spamlist_spam`
--

DROP TABLE IF EXISTS `spamlist_spam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spamlist_spam` (
  `spamlist_id` int(11) NOT NULL,
  `spam_list_id` int(11) NOT NULL,
  UNIQUE KEY `UK_jur3qbbyht6003wx55ijx55e1` (`spam_list_id`),
  KEY `FK99aij0v64cgb0qe4vxmq0c7s9` (`spamlist_id`),
  CONSTRAINT `FK3anop07gfx9hfevaaypwwv5y` FOREIGN KEY (`spam_list_id`) REFERENCES `spam` (`id`),
  CONSTRAINT `FK99aij0v64cgb0qe4vxmq0c7s9` FOREIGN KEY (`spamlist_id`) REFERENCES `spamlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spamlist_spam`
--

LOCK TABLES `spamlist_spam` WRITE;
/*!40000 ALTER TABLE `spamlist_spam` DISABLE KEYS */;
INSERT INTO `spamlist_spam` VALUES (51,37),(51,38),(51,39),(51,40),(51,41),(51,42),(51,43),(51,44),(51,45),(51,46),(51,47),(51,48),(51,49),(51,50);
/*!40000 ALTER TABLE `spamlist_spam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spamword`
--

DROP TABLE IF EXISTS `spamword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spamword` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `word` varchar(255) DEFAULT NULL,
  `word_spanish` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spamword`
--

LOCK TABLES `spamword` WRITE;
/*!40000 ALTER TABLE `spamword` DISABLE KEYS */;
/*!40000 ALTER TABLE `spamword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sponsor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `organisation_name` varchar(255) DEFAULT NULL,
  `credit_card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28mvxtnmfjcwiw34vs8ryqkpa` (`credit_card_id`),
  KEY `FK_20xk0ev32hlg96kqynl6laie2` (`user_account_id`),
  CONSTRAINT `FK28mvxtnmfjcwiw34vs8ryqkpa` FOREIGN KEY (`credit_card_id`) REFERENCES `credit_card` (`id`),
  CONSTRAINT `FK_20xk0ev32hlg96kqynl6laie2` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
INSERT INTO `sponsor` VALUES (72,1,71,'DP-1',77),(75,0,74,'Acme-Jobs',NULL);
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `identity_email` varchar(255) DEFAULT NULL,
  `identity_name` varchar(255) DEFAULT NULL,
  `identity_surname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_castjbvpeeus0r8lbpehiu0e4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,0,_binary '\0','john.doe@acme.com','John','Doe','$2a$05$zBs1hyTlZAD9hOjHHgsYoOLSyqJ3pX2hKqxcb2PFPxzE7bLvcrZdu','anonymous'),(3,0,_binary '','administrator@acme.com','Administrator','Acme.com','$2a$05$V/JIzztu6CVgAytkyB2zbOY6Zhn1t9dizTO21VYlrDrS86NQmoE3K','administrator'),(6,0,_binary '','employer1@acme.com','Employer','One','$2a$05$aSZRp3reQ4bAc/fh0nOsxOeRLHc5HzKubq9m2ynwtn3ow/Vb1yzqi','employer1'),(9,0,_binary '','employer2@acme.com','Employer','Two','$2a$05$filmYCyD.COl.SGqwRBMCeLrfkhQMRFRHnYV/wMpWfQ5eF5ob8VIe','employer2'),(12,0,_binary '','worker1@acme.com','Worker','One','$2a$05$mkiIKdr01JlI5VnzNB5touSwfoLF.gV51HlJ6vwPjiNKxf7tE3ihW','worker1'),(15,0,_binary '','worker2@acme.com','Worker','One','$2a$05$TXtGoKcS8Gk7biXHKyhrhulGARxmPEGc5PwQPEfxBzGyLhvGbfEoe','worker2'),(63,0,_binary '','User01@acme.com','User01','User01.com','$2a$05$oneacRXimsUEluxSM7lqKO0QrsZCup0tZWtHTPvndmPM2PPHvf.2W','user01'),(65,0,_binary '','User02@acme.com','User02','User02.com','$2a$05$7Hy9HJsgFvftBlkpfO0W2.GsULOJK5posHoAxssGdHJPDQnjoH.Cq','user02'),(67,0,_binary '','User03@acme.com','User03','User03.com','$2a$05$oJiKGvws24GWBfNiFvmxkeXEXeEUoi37CbEr57iJvnU3Pe7b0e8q2','user03'),(69,0,_binary '','User04@acme.com','User04','User04.com','$2a$05$tVTbe10wwlT/FN8nl0B6NePg98Wx0jRH2jC5lXYDelMe..S3Bn1o.','user04'),(71,0,_binary '','sponsor1@acme.com','Sponsor','One','$2a$05$9TLKBpxrWBdwWIeRosJwmurAbag3T4sA9yBjWb6kc5W8qhn1Eb0T6','sponsor1'),(74,0,_binary '','sponsor2@acme.com','Sponsor2','Two','$2a$05$r93vvyvr3zvq.sjcNmWl4eW736wAtYs1VxZmIhlNfZrvog4vhuKI2','sponsor2'),(84,0,_binary '','auditor1@acme.com','Auditor','One','$2a$05$oH0b4TfDV5FqzJsxMuqI6usXE3Csb4E138CE1rrBPr7ds5KCX1zxu','auditor1'),(87,0,_binary '','auditor2@acme.com','Auditor','Two','$2a$05$sfLoVWGj6vaOKQN1q3ei1.moQ7qQm9/3oOi0sNUbxBWThkDOcYD9K','auditor2');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l5q1f33vs2drypmbdhpdgwfv3` (`user_account_id`),
  CONSTRAINT `FK_l5q1f33vs2drypmbdhpdgwfv3` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (13,0,12,'Java, C ++, JavaScript and Angular Developer','Great ability to work in teams and development Back-End and Front-End'),(16,0,15,'Java, C ++, JavaScript, PHP, CSS3 and HTML developer ','Great ability to work in teams and development Back-End and Front-End');
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_application`
--

DROP TABLE IF EXISTS `worker_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_application` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `declaration` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tjrs9ja87pueuwmbt49e6k5sg` (`reference_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_application`
--

LOCK TABLES `worker_application` WRITE;
/*!40000 ALTER TABLE `worker_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_applications`
--

DROP TABLE IF EXISTS `worker_applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_applications` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `declaration` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ayah4mh4p8d1ly1tmjbk4039r` (`reference_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_applications`
--

LOCK TABLES `worker_applications` WRITE;
/*!40000 ALTER TABLE `worker_applications` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_applications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workerapplications`
--

DROP TABLE IF EXISTS `workerapplications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workerapplications` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `reference_number` varchar(255) DEFAULT NULL,
  `skills` varchar(255) DEFAULT NULL,
  `statement` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d5cqbqyt57sudve3ahuubrrpv` (`job_id`),
  UNIQUE KEY `UK_rcffrr42po6koxcdicygjuo1d` (`reference_number`),
  KEY `FKn5flt40w29l5e80a64s2bwwiq` (`worker_id`),
  CONSTRAINT `FKlvsypp60ubloluakm164mr8oj` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKn5flt40w29l5e80a64s2bwwiq` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workerapplications`
--

LOCK TABLES `workerapplications` WRITE;
/*!40000 ALTER TABLE `workerapplications` DISABLE KEYS */;
INSERT INTO `workerapplications` VALUES (683,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB1:WOR1','Great ability to work in teams','---','Accepted',681,623),(684,0,'2019-09-25 20:00:00.000000','Java, C ++ and JavaScript Developer','EMP1-JOB2:WOR1','Great ability to work in teams','---','Accepted',682,623);
/*!40000 ALTER TABLE `workerapplications` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-18 23:42:27

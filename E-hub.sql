-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: localhost    Database: ehub
-- ------------------------------------------------------
-- Server version	5.7.32-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `C_id` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('C101','Aniket','Fort kochi Kerala',911213411),('C102','Maitra','Kollam Kerala',821544267),('C103','Gaurav','Kollam Kerala',712452878),('C104','Bikas','Sanpad Mumbai',854297363),('C105','Pranav','Nashik Mumbai',954897363),('C106','Rishi','Chaennai TN',825368194),('C107','Rahul','Edapally Kochi',856329764),('C108','Rohith','Indore MP',986768954);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientreq`
--

DROP TABLE IF EXISTS `clientreq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientreq` (
  `proj_id` varchar(20) DEFAULT NULL,
  `proj_name` varchar(50) DEFAULT NULL,
  `client_id` varchar(20) DEFAULT NULL,
  `programmer_id` varchar(20) DEFAULT NULL,
  `leader_id` varchar(20) DEFAULT NULL,
  `due` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientreq`
--

LOCK TABLES `clientreq` WRITE;
/*!40000 ALTER TABLE `clientreq` DISABLE KEYS */;
INSERT INTO `clientreq` VALUES ('PR9','Meet app','C105','P104','3','2021-05-02');
/*!40000 ALTER TABLE `clientreq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commit`
--

DROP TABLE IF EXISTS `commit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commit` (
  `Commit_id` varchar(20) DEFAULT NULL,
  `commit_msg` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commit`
--

LOCK TABLES `commit` WRITE;
/*!40000 ALTER TABLE `commit` DISABLE KEYS */;
INSERT INTO `commit` VALUES ('P102','Added fronted to flask app'),('P102','Added backend to flask app'),('P101','Added fronted to website app'),('P101','Added Backend to website'),('PR12','Added the first two modules');
/*!40000 ALTER TABLE `commit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `proj_id` varchar(20) DEFAULT NULL,
  `proj_name` varchar(50) DEFAULT NULL,
  `client_id` varchar(10) DEFAULT NULL,
  `programmer_id` varchar(20) DEFAULT NULL,
  `leader_id` varchar(20) DEFAULT NULL,
  `due` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES ('PR10','Android app','C108','P104','1','2021-07-12'),('PR11','java app','C101','P101','3','2021-05-02'),('PR12','Vedio app','C102','P104','3','2021-05-02');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaders`
--

DROP TABLE IF EXISTS `leaders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaders` (
  `id` varchar(20) DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `specialization` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaders`
--

LOCK TABLES `leaders` WRITE;
/*!40000 ALTER TABLE `leaders` DISABLE KEYS */;
INSERT INTO `leaders` VALUES ('1','2012-03-10','Java'),('2','2019-01-07','C++'),('3','2018-02-03','JavaScript'),('4','2016-12-01','Php'),('5','2014-10-06','Python');
/*!40000 ALTER TABLE `leaders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ongoing`
--

DROP TABLE IF EXISTS `ongoing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ongoing` (
  `proj_id` varchar(20) DEFAULT NULL,
  `proj_name` varchar(50) DEFAULT NULL,
  `client_id` varchar(20) DEFAULT NULL,
  `programmer_id` varchar(20) DEFAULT NULL,
  `leader_id` varchar(20) DEFAULT NULL,
  `due` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ongoing`
--

LOCK TABLES `ongoing` WRITE;
/*!40000 ALTER TABLE `ongoing` DISABLE KEYS */;
INSERT INTO `ongoing` VALUES ('PR5','Android App','C105','P104','3','2021-06-01'),('PR7','Stud DBMS','C106','P106','1','2021-05-02'),('PR8','AUMS','C105','P103','2','2021-05-02');
/*!40000 ALTER TABLE `ongoing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pending`
--

DROP TABLE IF EXISTS `pending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pending` (
  `proj_id` varchar(20) DEFAULT NULL,
  `proj_name` varchar(50) DEFAULT NULL,
  `client_id` varchar(20) DEFAULT NULL,
  `programmer_id` varchar(20) DEFAULT NULL,
  `leader_id` varchar(20) DEFAULT NULL,
  `due` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pending`
--

LOCK TABLES `pending` WRITE;
/*!40000 ALTER TABLE `pending` DISABLE KEYS */;
INSERT INTO `pending` VALUES ('PR1','Website','C101','P101','1','2021-05-07'),('PR2','flask app','C102','P102','2','2021-03-03'),('PR3','Java App','C103','P103','2','2021-06-08'),('PR4','WebApp','C104','P101','1','2021-05-07'),('PR6','DBMS','C106','P105','3','2022-01-02');
/*!40000 ALTER TABLE `pending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programmer`
--

DROP TABLE IF EXISTS `programmer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programmer` (
  `programmer_id` varchar(20) DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `experience` varchar(100) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `specialization` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programmer`
--

LOCK TABLES `programmer` WRITE;
/*!40000 ALTER TABLE `programmer` DISABLE KEYS */;
INSERT INTO `programmer` VALUES ('P101','2015-12-10','M-Tech in CS','C Java Python C++ Golang',120000,'Golang'),('P102','2015-11-10','M-Tech in CS','C++ Rust Python C# Golang',120000,'Python'),('P103','2015-12-01','PhD in CS','C# Rust Python Haskell HTML',130000,'Haskell'),('P104','2015-11-01','PhD in CS','Rust Python Haskell Golang JS',130000,'Rust'),('P105','2016-10-21','B-Tech in CS','Rust Java Ruby',110000,'Java'),('P106','2016-08-09','B-Tech in CS','JavaScript Java Ruby',110000,'Ruby');
/*!40000 ALTER TABLE `programmer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-15 11:29:20

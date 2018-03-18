-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: grievances
-- ------------------------------------------------------
-- Server version	5.5.48

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `contact` bigint(20) unsigned NOT NULL DEFAULT '0',
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  `profile_pic` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_admin_1` (`college_id`),
  CONSTRAINT `FK_admin_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (6,'aman','aman.khullar297@gmail.com',8989768996,3,'aman.jpj');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gchat`
--

DROP TABLE IF EXISTS `gchat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gchat` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `grievance_id` int(10) unsigned NOT NULL DEFAULT '0',
  `file` varchar(200) NOT NULL DEFAULT '',
  `chat` varchar(200) NOT NULL DEFAULT '',
  `role` char(1) NOT NULL DEFAULT '',
  `date` char(15) DEFAULT NULL,
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_gchat_1` (`college_id`),
  CONSTRAINT `FK_gchat_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gchat`
--

LOCK TABLES `gchat` WRITE;
/*!40000 ALTER TABLE `gchat` DISABLE KEYS */;
INSERT INTO `gchat` VALUES (111,122,'aman','ved','a','868127400000',3),(121,122,'aman','ved','a','868127400000',1);
/*!40000 ALTER TABLE `gchat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grievance`
--

DROP TABLE IF EXISTS `grievance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grievance` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_id` int(10) unsigned NOT NULL DEFAULT '0',
  `description` varchar(200) DEFAULT NULL,
  `file` varchar(200) NOT NULL DEFAULT '',
  `date` char(15) DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '',
  `college_id` int(10) unsigned DEFAULT NULL,
  `student_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_grevance_1` (`college_id`),
  KEY `FK_grievance_2` (`student_id`),
  KEY `FK_grevance_3` (`description`) USING BTREE,
  KEY `FK_grievance_3` (`subject_id`),
  CONSTRAINT `FK_grevance_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`),
  CONSTRAINT `FK_grievance_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`enroll_id`),
  CONSTRAINT `FK_grievance_3` FOREIGN KEY (`subject_id`) REFERENCES `m_grievances_subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grievance`
--

LOCK TABLES `grievance` WRITE;
/*!40000 ALTER TABLE `grievance` DISABLE KEYS */;
INSERT INTO `grievance` VALUES (1,1,'hjjkjjkjlkj','f:\\aman\\Pic_6.jpeg','1518895007902','p',1,1234),(102,1,'dfeqqr','f:\\aman\\Pic_6.jpeg','1518897809964','p',1,1234);
/*!40000 ALTER TABLE `grievance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_branch`
--

DROP TABLE IF EXISTS `m_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_branch` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_m_branch_1` (`college_id`),
  CONSTRAINT `FK_m_branch_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_branch`
--

LOCK TABLES `m_branch` WRITE;
/*!40000 ALTER TABLE `m_branch` DISABLE KEYS */;
INSERT INTO `m_branch` VALUES (1,'cse',1),(2,'aman',1),(6,'aman',3);
/*!40000 ALTER TABLE `m_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_college`
--

DROP TABLE IF EXISTS `m_college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_college` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(100) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `contact` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_college`
--

LOCK TABLES `m_college` WRITE;
/*!40000 ALTER TABLE `m_college` DISABLE KEYS */;
INSERT INTO `m_college` VALUES (1,'Aman','C-41','amankhullar297@gmail.com',8989468996),(2,'Aman','C-41','amankhullar297@gmail.com',8989468996),(3,'Aman','C-41','amankhullar297@gmail.com',8989468996);
/*!40000 ALTER TABLE `m_college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_grievances_subject`
--

DROP TABLE IF EXISTS `m_grievances_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_grievances_subject` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT '',
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_m_grievances_subject_1` FOREIGN KEY (`id`) REFERENCES `m_college` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_grievances_subject`
--

LOCK TABLES `m_grievances_subject` WRITE;
/*!40000 ALTER TABLE `m_grievances_subject` DISABLE KEYS */;
INSERT INTO `m_grievances_subject` VALUES (1,'aman',1),(3,'aman',1);
/*!40000 ALTER TABLE `m_grievances_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `enroll_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `email` varchar(45) NOT NULL DEFAULT '',
  `contact` bigint(20) unsigned NOT NULL DEFAULT '0',
  `parent_contact` bigint(20) unsigned NOT NULL DEFAULT '0',
  `address` varchar(100) NOT NULL DEFAULT '',
  `profile_pic` varchar(200) NOT NULL DEFAULT '',
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  `branch_id` int(10) unsigned DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '' COMMENT 'verified v unverified u',
  PRIMARY KEY (`enroll_id`,`email`),
  KEY `FK_student_1` (`college_id`),
  KEY `FK_student_2` (`branch_id`),
  CONSTRAINT `FK_student_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`),
  CONSTRAINT `FK_student_2` FOREIGN KEY (`branch_id`) REFERENCES `m_branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=741259 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (101,'aman','aman.khullar297@gmail.com',8989468996,8989468996,'C-41','aman.jpj',1,1,'v'),(1234,'qawsed','qaqa@qaqa.com',789456,789456,'dssvds','aman.jpj',3,1,'v'),(1234,'hello','qqe@hjhj.com',123456,123456,'4141','aman.jpj',3,1,'u'),(23456,'gh','ghku@mjj.com',222,555,'vhj','aman.jpj',1,1,'u');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `email` varchar(50) NOT NULL DEFAULT '',
  `user_name` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  `role` char(1) NOT NULL DEFAULT '',
  `last_seen` char(15) NOT NULL DEFAULT '',
  `college_id` int(10) unsigned NOT NULL DEFAULT '0',
  `status` char(1) NOT NULL DEFAULT '' COMMENT 'verified / unverified',
  PRIMARY KEY (`email`),
  KEY `FK_user_1` (`college_id`),
  CONSTRAINT `FK_user_1` FOREIGN KEY (`college_id`) REFERENCES `m_college` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('aman.khullar297@gmail.com','aman','aman','a','836591400000',3,'u'),('aman.khullar5@gmail.com','aman','aman','a','836591400000',3,'u'),('qaqa@qaqa.com','qaqa@qaqa.com','1234','s','1518589344950',1,'v'),('qqe@hjhj.com','qqe@hjhj.com','1234','s','1518591360671',1,'u'),('r@rr.com','1','1','a','1516374707306',1,'u');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-18  1:39:50

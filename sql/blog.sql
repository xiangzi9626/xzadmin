-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cid` int unsigned DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` text,
  `status` tinyint unsigned DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (9,15,'springboot','springboot',0,'2021-05-27 08:41:41'),(10,15,'springboot','springboot',1,'2021-05-25 18:13:35'),(11,15,'springboot','springboot',1,'2021-05-25 18:14:11'),(14,15,'springboot','springboot',0,NULL),(15,15,'springboot','springboot',1,NULL),(16,15,'springboot','springboot',1,'2021-08-03 12:02:13'),(17,15,'springboot','springboot',1,'2021-08-03 12:30:44'),(18,15,'springboot','springboot',1,'2021-08-03 12:30:58'),(19,15,'springboot','springboot',1,'2021-08-03 12:31:51'),(20,15,'springboot','springboot',1,'2021-08-03 12:32:05'),(21,15,'springboot','springboot',1,'2021-08-03 12:32:18'),(22,15,'springboot','springboot',1,'2021-08-03 12:32:35'),(23,15,'springboot','springboot',1,'2021-08-03 12:33:03'),(24,15,'springboot','springboot',1,'2021-08-03 12:33:20'),(26,15,'springboot','springboot',0,'2021-08-03 12:34:05'),(27,15,'springboot','springboot',1,'2021-08-03 12:42:25'),(28,15,'springboot','springboot',1,'2021-08-03 12:45:09'),(29,15,'springboot','springboot',1,'2021-08-03 12:47:30'),(30,15,'springboot','springboot',1,'2021-08-03 12:50:45'),(31,15,'springboot','springboot',1,'2021-08-03 12:55:02'),(32,15,'springboot','springboot',1,'2021-08-03 01:01:20'),(33,15,'springboot','springboot',1,'2021-08-03 01:03:53'),(34,15,'springboot','springboot',1,'2021-08-03 01:06:04'),(35,15,'springboot','springboot',1,'2021-08-03 01:11:18'),(36,15,'java实战教程','<p>java实战教程</p>',1,'2021-08-04 11:45:48'),(37,15,'java实战教程','<p>java实战教程</p>',1,'2021-08-04 12:31:59');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `pid` int unsigned DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (15,0,'java'),(22,17,'TP0'),(23,22,'la');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power`
--

DROP TABLE IF EXISTS `power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `power` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `aid` int unsigned DEFAULT NULL COMMENT '管理员ID',
  `type` varchar(500) DEFAULT NULL COMMENT '内容类型',
  `add` tinyint unsigned DEFAULT '2' COMMENT '添加权限1有2无',
  `del` tinyint unsigned DEFAULT '2' COMMENT '删除权限1有2无',
  `edit` tinyint unsigned DEFAULT '2' COMMENT '编辑权限1有2无',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power`
--

LOCK TABLES `power` WRITE;
/*!40000 ALTER TABLE `power` DISABLE KEYS */;
/*!40000 ALTER TABLE `power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_menu`
--

DROP TABLE IF EXISTS `system_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_menu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int unsigned NOT NULL DEFAULT '0' COMMENT '父ID',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单图标',
  `href` varchar(100) NOT NULL DEFAULT '' COMMENT '链接',
  `target` varchar(20) NOT NULL DEFAULT '_self' COMMENT '链接打开方式',
  `sort` int DEFAULT '0' COMMENT '菜单排序',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态(0:禁用,1:启用)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `title` (`title`),
  KEY `href` (`href`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_menu`
--

LOCK TABLES `system_menu` WRITE;
/*!40000 ALTER TABLE `system_menu` DISABLE KEYS */;
INSERT INTO `system_menu` VALUES (1,0,'菜单管理','fa fa-building','/layuimini-2/page/menu_list.html','_self',3,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(2,0,'文章管理','fa fa-book','','_self',2,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(3,2,'文章列表','fa fa-list-alt','/layuimini-2/page/article_list.html','_self',0,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(4,2,'文章分类','fa fa-bomb','/layuimini-2/page/class_list.html','_self',0,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(5,0,'用户管理','fa fa-users','','_self',0,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(6,5,'管理员列表','fa fa-user','/layuimini-2/page/admin_list.html','_self',0,1,NULL,'2021-02-01 16:00:00',NULL,NULL),(7,5,'会员列表','fa fa-user','/layuimini-2/page/user_list.html','_self',0,1,NULL,'2021-02-01 16:00:00',NULL,NULL);
/*!40000 ALTER TABLE `system_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `level` smallint DEFAULT '3',
  `money` decimal(10,2) unsigned DEFAULT '0.00' COMMENT '余额',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','12345678900',1,0.00,'2021-02-16 18:52:30'),(5,'user02','e10adc3949ba59abbe56e057f20f883e','12345212121',3,0.00,'2021-05-26 14:50:49'),(6,'user03','e10adc3949ba59abbe56e057f20f883e','12121212121',3,0.00,'2021-05-26 14:51:48'),(13,'admin01','e10adc3949ba59abbe56e057f20f883e','12345678901',2,0.00,'2021-08-04 15:10:18');
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

-- Dump completed on 2021-08-06 10:49:42

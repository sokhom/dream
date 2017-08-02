CREATE DATABASE  IF NOT EXISTS `inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `inventory`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `carrier`
--

DROP TABLE IF EXISTS `carrier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL DEFAULT b'1',
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrier`
--

LOCK TABLES `carrier` WRITE;
/*!40000 ALTER TABLE `carrier` DISABLE KEYS */;
INSERT INTO `carrier` VALUES (1,'','Will ','Customer will Pickup',''),(2,'','Delivery','Deliver to Customer',''),(3,'','UPS','What can brown do for you?','\0'),(4,'','FedEx','The best choice for shipments that must meet deadlines reliably and on time.','\0'),(5,'','USPS','United States Post Office','\0');
/*!40000 ALTER TABLE `carrier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrier_service`
--

DROP TABLE IF EXISTS `carrier_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrier_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carrierId` int(11) DEFAULT NULL,
  `activeFlag` bit(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrier_service`
--

LOCK TABLES `carrier_service` WRITE;
/*!40000 ALTER TABLE `carrier_service` DISABLE KEYS */;
INSERT INTO `carrier_service` VALUES (1,1,'','01','Next Day Air','');
/*!40000 ALTER TABLE `carrier_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `homeCurrencyFlag` bit(1) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateModified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'','USD','US Dollar','',1,'2017-07-27 09:16:32','2017-07-26 17:00:00',NULL);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_name`
--

DROP TABLE IF EXISTS `object_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_name`
--

LOCK TABLES `object_name` WRITE;
/*!40000 ALTER TABLE `object_name` DISABLE KEYS */;
INSERT INTO `object_name` VALUES (1,'CUSTOMER_STATUS'),(2,'PO_STATUS'),(3,'PO_ITEM_STATUS'),(4,'PO_TYPE'),(5,'PO_ITEM_TYPE'),(6,'CUSTOMER_TYPE'),(7,'PART_TYPE'),(8,'ADDRESS_TYPE'),(9,'CONTACT_TYPE'),(10,'PAYMENT_TYPE'),(11,'PAYMENT_TERM_TYPE'),(12,'VENDOR_STATUS'),(13,'UOM_TYPE'),(14,'PART_TRACKING_TYPE'),(15,'RECEIPT_STATUS'),(16,'RECEIPT_TYPE'),(17,'ORDER_TYPE'),(18,'RECEIP_ITEM_STATUS'),(19,'RECEIP_ITEM_TYPE'),(20,'TAG_TYPE');
/*!40000 ALTER TABLE `object_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_status`
--

DROP TABLE IF EXISTS `object_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `objectId` int(11) NOT NULL,
  PRIMARY KEY (`id`,`objectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_status`
--

LOCK TABLES `object_status` WRITE;
/*!40000 ALTER TABLE `object_status` DISABLE KEYS */;
INSERT INTO `object_status` VALUES (10,'Normal',1),(10,'Bid Request',2),(10,'Entered',3),(10,'10	Normal',12),(10,'Entered',15),(10,'Entered',18),(20,'Preferred',1),(20,'Issued',2),(20,'Picking',3),(20,'20	Preferred',12),(20,'Reconciled',15),(20,'Reconciled',18),(30,'Hold Sales',1),(30,'Picking',2),(30,'Partial',3),(30,'30	Hold PO',12),(30,'Received',15),(30,'Received',18),(40,'Hold Shipment',1),(40,'Partial',2),(40,'Picked',3),(40,'40	Hold Receipt',12),(40,'Fulfilled',15),(40,'Fulfilled',18),(50,'Hold All',1),(50,'Picked',2),(50,'Shipped',3),(50,'50	Hold All',12),(60,'Shipped',2),(60,'Fulfilled',3),(70,'Fulfilled',2),(70,'Closed Short',3),(80,'Closed Short',2),(80,'Void',3),(90,'Void',2);
/*!40000 ALTER TABLE `object_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_type`
--

DROP TABLE IF EXISTS `object_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_type` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `objectId` int(11) NOT NULL,
  PRIMARY KEY (`id`,`objectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_type`
--

LOCK TABLES `object_type` WRITE;
/*!40000 ALTER TABLE `object_type` DISABLE KEYS */;
INSERT INTO `object_type` VALUES (1,'All',6),(1,'Cash',10),(1,'Count',13),(1,'None',17),(1,'None',19),(2,'Customer',6),(2,'Check',10),(2,'Weight',13),(3,'Customer Group',6),(3,'Length',13),(4,'American Express',10),(4,'Area',13),(5,'Discover',10),(5,'Volume',13),(6,'MasterCard',10),(6,'Time',13),(7,'Visa',10),(8,'Other credit card',10),(9,'Other',10),(10,'Standard',4),(10,'Purchase',5),(10,'Inventory',7),(10,'Ship To',8),(10,'Home',9),(10,'NET',11),(10,'Text',14),(10,'Standard',16),(10,'PO',17),(10,'StockRework',19),(10,'Location',20),(11,'Misc. Purchase',5),(11,'Gift Card',10),(12,'E-Check',10),(20,'Drop Ship',4),(20,'Credit Return',5),(20,'Service',7),(20,'Bill To',8),(20,'Work',9),(20,'COD',11),(20,'Date',14),(20,'Receive Only',16),(20,'SO',17),(20,'RejectReturn',19),(20,'Parent',20),(21,'Misc. Credit',5),(21,'Labor',7),(22,'Overhead',7),(30,'Out Sourced',5),(30,'Non-Inventory',7),(30,'Remit To',8),(30,'Mobile',9),(30,'CIA',11),(30,'Expiration Date',14),(30,'Reconcile Only',16),(30,'WO',17),(30,'ScrappedLost',19),(30,'Child',20),(40,'Shipping',5),(40,'Internal Use',7),(40,'Home',8),(40,'Fax',9),(40,'CCD',11),(40,'Serial Number',14),(40,'TO',17),(40,'Virtual',20),(50,'Capital Equipment',7),(50,'Main Office',8),(50,'Main',9),(50,'None',11),(50,'Money',14),(60,'Shipping',7),(60,'Email',9),(60,'Month',11),(60,'Quantity',14),(70,'Tax',7),(70,'Pager',9),(70,'Count',14),(80,'Misc',7),(80,'Other',9),(80,'Checkbox',14),(90,'Web',9);
/*!40000 ALTER TABLE `object_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abcCode` varchar(1) DEFAULT NULL,
  `num` varchar(20) NOT NULL,
  `details` text CHARACTER SET latin1 NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `upc` varchar(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `typeId` int(11) NOT NULL,
  `cogsCoaId` int(11) NOT NULL,
  `invCoaId` int(11) NOT NULL,
  `crapCoaId` int(11) NOT NULL,
  `adjCoaId` int(11) NOT NULL,
  `varianceCoaId` int(11) NOT NULL,
  `defaultProductId` int(11) NOT NULL,
  `defaultBomId` int(11) NOT NULL,
  `alertNote` varchar(255) DEFAULT NULL,
  `len` float DEFAULT NULL,
  `width` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `sizeUomId` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `weightUomId` int(11) DEFAULT NULL,
  `alwaysManufactureFlag` bit(1) NOT NULL,
  `pickedInUomFlag` bit(1) NOT NULL,
  `stdCost` decimal(10,0) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_category`
--

DROP TABLE IF EXISTS `part_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_category`
--

LOCK TABLES `part_category` WRITE;
/*!40000 ALTER TABLE `part_category` DISABLE KEYS */;
INSERT INTO `part_category` VALUES (1,'General','General Class Of Parts');
/*!40000 ALTER TABLE `part_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_tracking`
--

DROP TABLE IF EXISTS `part_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_tracking` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `abbr` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `seq` smallint(6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_tracking`
--

LOCK TABLES `part_tracking` WRITE;
/*!40000 ALTER TABLE `part_tracking` DISABLE KEYS */;
INSERT INTO `part_tracking` VALUES (1,'','Lot#','Lot Number',10,'',1),(2,'','Rev#','Revision Level',10,'',2),(3,'','ExpDate','Expiration Date',30,'',3),(4,'','SN(s)','Serial Number',40,'',4);
/*!40000 ALTER TABLE `part_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `editableFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES (10,'','Cash',1,'\0'),(20,'','Check',2,'\0'),(30,'','VISA',7,'\0'),(40,'','MasterCard',6,'\0'),(50,'','Discover',5,'\0'),(60,'','American Express',4,'\0'),(70,'','Generic Card',8,'\0'),(80,'','E-Check',12,'\0'),(90,'','Gift Card',11,'\0');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_term`
--

DROP TABLE IF EXISTS `payment_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `defaultTermId` int(11) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `discountDays` int(11) DEFAULT NULL,
  `netDays` int(11) DEFAULT NULL,
  `nextMonths` int(11) DEFAULT NULL,
  `readOnlyFlag` bit(1) DEFAULT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateModified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_term`
--

LOCK TABLES `payment_term` WRITE;
/*!40000 ALTER TABLE `payment_term` DISABLE KEYS */;
INSERT INTO `payment_term` VALUES (1,'','COD',20,1,NULL,NULL,NULL,NULL,'','2017-07-27 09:27:05','2017-07-26 17:00:00',NULL),(2,'','CIA',30,0,NULL,NULL,NULL,NULL,'','2017-07-27 09:27:44','2017-07-26 17:00:00',NULL),(3,'','CCD',40,0,NULL,NULL,NULL,NULL,'','2017-07-26 17:00:00','2017-07-26 17:00:00',NULL),(4,'','NET 30',10,0,NULL,NULL,30,NULL,'','2017-07-27 09:28:43','2017-07-26 17:00:00',NULL);
/*!40000 ALTER TABLE `payment_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po`
--

DROP TABLE IF EXISTS `po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `locationGroupId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `currencyId` int(11) DEFAULT NULL,
  `currencyRate` float DEFAULT NULL,
  `customerSO` varchar(50) DEFAULT NULL,
  `venderSO` varchar(50) DEFAULT NULL,
  `paymentTermId` int(11) DEFAULT NULL,
  `vendorId` int(11) DEFAULT NULL,
  `vendorContact` varchar(50) DEFAULT NULL,
  `vendorAddress` varchar(255) DEFAULT NULL,
  `vendorCity` varchar(50) DEFAULT NULL,
  `vendorCountryId` int(11) DEFAULT NULL,
  `vendorStateId` int(11) DEFAULT NULL,
  `vendorZip` varchar(20) DEFAULT NULL,
  `carrierId` int(11) DEFAULT NULL,
  `shipTermId` int(11) DEFAULT NULL,
  `shipToAddress` varchar(255) DEFAULT NULL,
  `shipToCity` varchar(50) DEFAULT NULL,
  `shipToCountryId` int(11) DEFAULT NULL,
  `shipToStateId` int(11) DEFAULT NULL,
  `shipToZip` varchar(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateIssued` datetime DEFAULT NULL,
  `dateFirstShip` datetime DEFAULT NULL,
  `dateComfirmed` datetime DEFAULT NULL,
  `dateCompleted` datetime DEFAULT NULL,
  `dateLastModified` datetime DEFAULT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po_item`
--

DROP TABLE IF EXISTS `po_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `partId` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `repairFlag` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `partNum` varchar(50) DEFAULT NULL,
  `vendorPartNum` varchar(50) DEFAULT NULL,
  `uomId` int(11) DEFAULT NULL,
  `qtyToFulfill` float DEFAULT NULL,
  `qtyPicked` float DEFAULT NULL,
  `qtyFulfilled` float DEFAULT NULL,
  `unitCost` float DEFAULT NULL,
  `taxId` int(11) DEFAULT NULL,
  `taxRate` float DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `dateScheduledFulfillment` datetime DEFAULT NULL,
  `dateLastFulfillment` datetime DEFAULT NULL,
  `seq` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po_item`
--

LOCK TABLES `po_item` WRITE;
/*!40000 ALTER TABLE `po_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `po_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `locationGroupId` int(11) NOT NULL,
  `orderTypeId` int(11) NOT NULL,
  `poId` int(11) NOT NULL,
  `soId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship_term`
--

DROP TABLE IF EXISTS `ship_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ship_term` (
  `id` int(11) NOT NULL,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `readOnlyFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship_term`
--

LOCK TABLES `ship_term` WRITE;
/*!40000 ALTER TABLE `ship_term` DISABLE KEYS */;
INSERT INTO `ship_term` VALUES (10,'','Prepaid & Billed',''),(20,'','Prepaid',''),(30,'','Freight Collect','');
/*!40000 ALTER TABLE `ship_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'','admin','admin','admin','admin',NULL,NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom`
--

DROP TABLE IF EXISTS `uom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `defaultFlag` bit(1) DEFAULT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `uomTypeId` int(11) NOT NULL,
  `readOnlyFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom`
--

LOCK TABLES `uom` WRITE;
/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
INSERT INTO `uom` VALUES (1,'','','ea','Each','A single item.',1,''),(2,'','\0','ea','Each','A single item.',1,''),(3,'','\0','ft','Foot','English measurement in Feet.',3,''),(4,'','\0','lbs','Pound','American pound.',2,''),(5,'','\0','hr','Hour','One hour.',6,''),(6,'','\0','gal','Gallon','Basic US unit of liquid volume.',5,'\0'),(7,'','\0','floz','Fluid Ounce','US unit of liquid volume.',5,'\0'),(8,'','\0','in','Inch','US unit of length.',3,'\0'),(9,'','\0','kg','Kilogram','metric unit of weight.',2,''),(10,'','\0','m','Meter','Basic metric unit of length.',3,''),(11,'','\0','L','Liter','Basic metric unit of liquid volume.',5,'\0'),(12,'','\0','mm','Millimeter','1/1000 of a meter',3,'\0'),(13,'','\0','cm','Centimeter','1/100 of a meter',3,''),(14,'','\0','km','Kilometer','1000 meters',3,'\0'),(15,'','\0','g','Gram','Metric unit of weight',2,'\0'),(16,'','\0','mg','Milligram','1/1000 of a gram',2,'\0'),(17,'','\0','mL','Milliliter','1/1000 of a Liter',5,'\0'),(18,'','\0','pr','Pair','Two of one part',1,'\0'),(19,'','\0','pk','Package','Package of 20',1,'\0'),(20,'','\0','day','Day','',6,'\0');
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom_conversion`
--

DROP TABLE IF EXISTS `uom_conversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uom_conversion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `fromUomId` int(11) NOT NULL,
  `multiply` float NOT NULL,
  `toUomId` int(11) NOT NULL,
  `factor` float NOT NULL,
  `descripton` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom_conversion`
--

LOCK TABLES `uom_conversion` WRITE;
/*!40000 ALTER TABLE `uom_conversion` DISABLE KEYS */;
INSERT INTO `uom_conversion` VALUES (1,'',7,1,2,12,'1 Foot = 12 Inch',''),(2,'',2,12,7,1,'1 Foot = 12 Inch',''),(3,'',6,1,5,128,'1 Gallon = 128 Fluid Ounce',''),(4,'',5,128,6,1,'1 Gallon = 128 Fluid Ounce',''),(5,'',8,2.2046,3,1,'1 Kilogram = 2.2046 Pound',''),(6,'',3,1,8,2.2046,'1 Kilogram = 2.2046 Pound',''),(7,'',9,3.2808,2,1,'1 Meter = 3.2808 Foot',''),(8,'',2,1,9,3.2808,'1 Meter = 3.2808 Foot',''),(9,'',5,3.7854,10,1,'1 Gallon = 3.7854 Liter',''),(10,'',10,1,5,3.7854,'1 Gallon = 3.7854 Liter',''),(11,'',11,1,9,1000,'1 Meter = 1000.0 Millimeter',''),(12,'',9,1000,11,1,'1 Meter = 1000.0 Millimeter',''),(13,'',12,1,9,100,'1 Meter = 100.0 Centimeter',''),(14,'',9,100,12,1,'1 Meter = 100.0 Centimeter',''),(15,'',13,1000,9,1,'1 Kilometer = 1000.0 Meter',''),(16,'',9,1,13,1000,'1 Kilometer = 1000.0 Meter',''),(17,'',8,1000,14,1,'1 Kilogram = 1000.0 Gram',''),(18,'',14,1,8,1000,'1 Kilogram = 1000.0 Gram',''),(19,'',15,1,14,1000,'1 Gram = 1000.0 Milligram',''),(20,'',14,1000,15,1,'1 Gallon = 1000.0 Milligram',''),(21,'',16,1,10,1000,'1 Liter = 1000.0 Milliliter',''),(22,'',10,1000,16,1,'1 Liter = 1000.0 Milliliter',''),(23,'',7,25.4,11,1,'1 Inch = 25.4 Millimeter',''),(24,'',11,1,7,25.4,'1 Inch = 25.4 Millimeter',''),(25,'',17,2,1,1,'1 Pair = 2.0 Each',''),(26,'',1,1,17,2,'1 Pair = 2.0 Each',''),(27,'',18,20,1,1,'1 Package = 20.0 Each',''),(28,'',1,1,18,20,'1 Package = 20.0 Each','');
/*!40000 ALTER TABLE `uom_conversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(100) NOT NULL,
  `note` text CHARACTER SET latin1,
  `currencyId` int(11) NOT NULL,
  `currencyRate` float NOT NULL,
  `creditLimit` decimal(10,0) NOT NULL,
  `minOrderAmount` decimal(10,0) NOT NULL,
  `leadTime` smallint(6) NOT NULL,
  `defaultPaymentTermId` int(11) NOT NULL,
  `defaultShipTermId` int(11) NOT NULL,
  `defaultCarrierId` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `taxRateId` int(11) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `dateModified` datetime NOT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_part`
--

DROP TABLE IF EXISTS `vendor_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_part` (
  `id` int(11) NOT NULL,
  `vendorId` int(11) NOT NULL,
  `partId` int(11) NOT NULL,
  `vendorPartNum` varchar(20) DEFAULT NULL,
  `qtyMin` double NOT NULL,
  `qtyMax` double NOT NULL,
  `uomId` int(11) NOT NULL,
  `leadTime` int(11) DEFAULT NULL,
  `lastCost` double DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_part`
--

LOCK TABLES `vendor_part` WRITE;
/*!40000 ALTER TABLE `vendor_part` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_part` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-27 18:30:12

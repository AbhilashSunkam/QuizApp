-- MySQL dump 10.13  Distrib 5.7.15, for osx10.11 (x86_64)
--
-- Host: localhost    Database: quizapp
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (108);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) NOT NULL DEFAULT '',
  `answer1` varchar(255) NOT NULL DEFAULT '',
  `answer2` varchar(255) NOT NULL DEFAULT '',
  `answer3` varchar(255) NOT NULL DEFAULT '',
  `answer4` varchar(255) NOT NULL DEFAULT '',
  `question_name` varchar(255) NOT NULL DEFAULT '',
  `category_id` int(11) NOT NULL,
  `difficulty_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `difficulty_id` (`difficulty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=390 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'a','Delhi','Hyderabad','Bangalore','Mumbai','What is the capital of india ',1,1),(2,'b','Behavior of human beings','Insects','The origin and history of technical and scientific terms','The formation of rocks','Entomology is the science that studies',1,1),(3,'d','Physics and Chemistry','Physiology or Medicine','Literature, Peace and Economics','All of the above','For which of the following disciplines is Nobel Prize awarded?',1,1),(4,'c','gold','copper','mica','None of the above','India has largest deposits of ____ in the world.',1,1),(5,'d','15 trillion','20 trillion','25 trillion','30 trillion','In a normal human body, the total number of red blood cells is',1,1),(6,'c','Rainy season','Spring','Winter','Summer','In which season do we need more fat?',1,1),(7,'b','1918','1928','1938','1948','India participated in Olympics Hockey in',1,1),(8,'c','increases','remains unchanged','decreases','may decrease or increase','If speed of rotation of the earth increases, weight of the body',1,1),(9,'b','Indian Development Agency','International Development Agency','Industrial Development Analyses','None of the above','IDA stands for',1,1),(10,'b','1974','1984','1994','2004','Indira Gandhi was assassinated in',1,1),(11,'b','Sugar and paper','Butter and paraffin wax','Chalk and marble','Charcoal and diamond','In which of the following pairs, the two substances forming the pair are chemically most dissimilar?',1,2),(12,'a','France and England','Greek and Persian forces','Civil war in England','None of the above','Hundred year war was fought between',1,2),(13,'d','1979-80','1980-81','1981-82','1982-83','India\'s Integrated Missiles Development Programme was started in ____ under the chairmanship of Dr. A.P.J. Abdul Kalam.',1,2),(14,'d','downward movement of water through soil','a process of tilling the land','decayed vegetable matter','cross-fertilization between two varieties','Hybridization is',1,2),(15,'c','Mumbai','Jamnagar','Coimbatore','Lonavla','INS Agrani (Petty Officers\' School) is situated at',1,2),(16,'d','Zerlina','Apsara','Purnima-I','Kamini','India\'s first fast breeder neutron reactor was',1,2),(17,'b','Surat (Gujarat)','Tarapur (Maharashtra)','Trombay (Maharashtra)','Solapur (Maharashtra)','India\'s first atomic power station was set up at',1,2),(18,'b','24 February','10 December','15 May','21 July','Human Rights Day is on',1,2),(19,'a','relative humidity','purity of milk','specific gravity of liquid','None of the above','Hygrometer is used to measure',1,2),(20,'b','INS Savitri','INS Shalki','INS Delhi','INS Vibhuti','India\'s first indigenously built submarine was',1,2),(21,'c','Squadron Leader','Air Vice-Marshal','Group Captain','Air Marshal','In Air Force, Air Commodore has one rank higher than',1,3),(22,'a','John Napier','John Doe','John Harrison','John Douglas','Logarithm tables were invented by',1,3),(23,'b','Hindi','Sanskrit','Kannada','Tamil','Modern Indo-Aryan languages are based on an ancient language called',1,3),(24,'b','Rev Father Didon','Baron Pierre de Coubertin','Norman Pitchard','None of the above','Olympic creed and oath was composed by ____ the founder of modern Olympics.',1,3),(25,'b','Uttaranchal','Uttar Pradesh','Jharkhand','Chhattisgarh','Kathak, Nauntanki, Jhora and Kajri are the important dances of',1,3),(26,'a','USA','Ukraine','Spain','Brazil','Lance Armstrong, a sportsperson of international repute, belongs to which of the following countries?',1,3),(27,'a','Khadakvasla','New Delhi','Wellington','Dehradun','National Defence Academy is situated at',1,3),(28,'c','five','six','seven','eight','Number of commands of Air Force are',1,3),(29,'b','Butter','Fish','Lettuce','Milk','Of the following foods, which one is the best source of protein?',1,3),(30,'a','Maintenance of Internal Security Act','Multinational Internal Society Authority','Movement for Indian System Act','None of the above','MISA stands for',1,3),(31,'b','Canada','Sri Lanka','Zimbabwe','East Africa','Which was the 1st non Test playing country to beat India in an international match?',2,1),(32,'a','Glamorgan','Leicestershire','Gloucestershire','Lancashire','Which county did Ravi Shastri play for?',2,1),(33,'b','Geet Sethi','Wilson Jones','Michael Ferreira','Manoj Kothari','Who was the first Indian to win the World Amateur Billiards title?',2,1),(34,'c','M.L.Valsamma','P.T.Usha','Kamaljit Sandhu','K.Malleshwari','Who is the first Indian woman to win an Asian Games gold in 400m run?',2,1),(35,'a','Northamptonshire & Worcestershire','Northamptonshire & Warwickshire','Nottinghamshire & Worcestershire','Nottinghamshire & Warwickshire','Which two counties did Kapil Dev play?',2,1),(36,'d','The Rickster','Ponts','Ponter','Punter','Ricky Ponting is also known as what?',2,1),(37,'a','1928','1932','1936','1948','India won its first Olympic hockey gold in...?',2,1),(38,'d','Subash Agrawal','Ashok Shandilya','Manoj Kothari','Mihir Sen','Who among the following is NOT associated with billiards in India?\n',2,1),(39,'c','Graham Gooch','Matthew Hayden','Brian Lara','Agarkar','Which player has scored the most runs in a single Test innings?',2,1),(40,'b','Lords','Headingley','Taunton','The Oval','Where did India play its 1st one day international match?',2,1),(41,'b','1964','1966','1970','1974','India reached the final of the Davis Cup for the first time in...?',2,2),(42,'b','Geoff Lawson','Merv Hughes','Mike Veletta','Mike Whitney','What Australian player was known as \'Fruitfly\' amongst the rest of the team?',2,2),(43,'b','Sportsmen','Coaches','Umpires','Sports Editors','The \'Dronacharya Award\' is given to...?',2,2),(44,'c','Meghalaya','Rajasthan','Manipur','West Bengal','In which Indian state did the game of Polo originate?',2,2),(45,'a','Khong Kangjei','Hiyang Tanaba','Yubi Lakpi','None of above','Which of the following is a Manipuri version of Hockey?',2,2),(46,'c','Bret Hart','Marty Jannetty','British Bulldog','Tito Santana','Who did Shawn Michaels beat to win his first Intercontinental Title?',2,2),(47,'a','A referee','An umpire','A spectator','A goalkeeper','What is the name of the person that controls a football match?',2,2),(48,'b','Vijay Hazare','C K Nayudu','Lala Amarnath','Vijay Merchant','Who was the first captain of Indian Test team?',2,2),(49,'d','New York Yankees','Chicago White Sox','Montreal Expos','Boston Red Sox','Fenway Park is the home field of what Major League Baseball team?',2,2),(50,'b','Border','Boland','Griqualand West','Gauteng','Pravin Amre and Vinod Kambli played for which province in South Africa?',2,2),(51,'a','Jim Kiick','Troy Aikman','Brett Favre','Joe Montana','Which football hero was nicknamed \"The Sundance Kid\"?',2,3),(52,'a','Australia','South Africa','Pakistan','England','Which country won the Cricket World Cup in 1999?',2,3),(53,'c','Triple H','Stone Cold Steve Austin','Mankind','Bret Hart','Who did The Rock beat to win his first WWE Title?',2,3),(54,'a','Weight Lifting','Target shooting','Athletics','Swimming','The name Kunjarani Devi is associated with...?',2,3),(55,'d','1892 between England and India','1869 between England and Australia','1883 between Australia and Wales','1844 between Canada and the USA','n what year was the first international cricket match held?',2,3),(56,'b','Syracuse','University of Cincinnati','Notre Dame','UCLA','Who beat Duke in the Great Alaskan Shootout Finals in 1998?',2,3),(57,'b','Adam Gilchrist','Jason Gillespie','Glenn McGrath','Brett Lee','\'Dizzy\' is the nickname of what Australian player?',2,3),(58,'d','Milkha Singh','P.T.Usha','Karnam Malleshwari','K.D.Jadhav','Who was the first Indian to win an individual medal in Olympics?',2,3),(59,'b','Golf','Circumnavigation of the earth by car','Formula One racing','Buggy-Jumping','With which sport is the \'Choudhury Trophy\' associated?',2,3),(60,'c','India','New zealand','South africa','Zimbabwe','Which of the following countries won the final of the triangular cricket series held in durban in februarry 1997?',2,3),(61,'b','shape','area','baring','distance','The Homolographic projection has the correct representation of',3,1),(62,'a','zones of climate','zones of oceans','zones of land','zones of cyclonic depressions','The latitudinal differences in pressure delineate a number of major pressure zones, which correspond with',3,1),(63,'d','deterioration of electronic circuits','damage of solar cells of spacecraft','adverse effect on living organisms','All of the above','The hazards of radiation belts include',3,1),(64,'c','Canada','West Africa','Australia','North America','The great Victoria Desert is located in',3,1),(65,'c','latitudes','longitudes','geographic grids','None of the above','The intersecting lines drawn on maps and globes are',3,1),(66,'c','the earth\'s atmosphere','interstellar dust','both (a) and (b)','None of the above','The light of distant stars is affected by',3,1),(67,'c','Africa','Asia','Australia','Europe','The landmass of which of the following continents is the least?',3,1),(68,'b','coral reefs','sea grass bed','hot spots','None of the above','The habitats valuable for commercially harvested species are called',3,1),(69,'b','Taiga','Savannah','Pampas','Prairies','Which of the following is tropical grassland?',3,1),(70,'a','ionosphere','exosphere','stratosphere','troposphere','The temperature increases rapidly after',3,1),(71,'d','temperature','location','weather','All of the above','The humidity of the air depends upon',3,2),(72,'c','mountain glaciers','alpine glaciers','continental glaciers','piedmont glaciers','The largest glaciers are',3,2),(73,'c','mesosphere','thermosphere','thermosphere and exosphere','thermosphere, exosphere and mesosphere','The ionosphere includes',3,2),(74,'a','northeastern zone','northwestern zone','southern zone','All of the above','The highest degree of concentration of mineral deposits are found in',3,2),(75,'b','silicate group','organic group','oxide group','hydride group','The group of minerals chemically containing hydrocarbons is',3,2),(76,'a','haematite','siderite','limonite','magnetic','The iron ore mined at Bailadila is mostly',3,2),(77,'b','Bihar','West Bengal','Kerala','Orissa','The leading state in producing paper is',3,2),(78,'c','Middle East','North Africa','both (a) and (b)','None of the above','The largest dune files are found in',3,2),(79,'a','Basalt plateau','Cinder cone','Shield volcanoes','Composite volcanoes','The least explosive type of volcano is called',3,2),(80,'a','the north-east atlantic region','the north-east pacific region','the north-west pacific region','the south-east asian region','The largest fish exporting region in the world is',3,2),(81,'a','Dead Sea','Red Sea','Black Sea','Mediterranean Sea','The highest average salinity amongst the following seas is reported from',3,3),(82,'d','Volcanic mountains','Residual mountains','Block mountains','Fold mountains','The Himalayan mountain system belongs to which of the following?',3,3),(83,'a','carbon dioxide','water vapours','carbon dioxide and water vapours','ozone','The infrared radiation by sun are strongly absorbed by',3,3),(84,'a','polygenetic landforms','structural landforms','polycyclic landforms','None of the above','The landforms that are influences by several process namely, weathering, erosion, deposition are known as',3,3),(85,'a','the Chinook','the Sirocco','the Harmattan','the Loo','The hot, dry wind on the east or leeward side of the Rocky mountains (North America) is called',3,3),(86,'c','Arctic Ocean','Atlantic Ocean','Indian Ocean','Pacific Ocean','The islands of Seychelles are located in the',3,3),(87,'a','the Sahara desert','the Atacama desert','the Kalahari desert','the Gobi desert','The highest sand dunes are found is',3,3),(88,'b','temperate grasslands','tropical moist forests','tundra regions','in hot deserts','The greatest variety of animal and plant species is fund in',3,3),(89,'d','outer core','inner core','inner mantle','outer mantle','The layer of the earth, immediately below the crust, is called',3,3),(90,'a','Gulf of Mexico','Persian Gulf','Gulf of Carpentaria','Gulf of Mannar','The largest gulf in the world is',3,3);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizquestions`
--

DROP TABLE IF EXISTS `quizquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quizquestions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `quiz_id` (`quiz_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `quizquestions_ibfk_1` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `quizquestions_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizquestions`
--

LOCK TABLES `quizquestions` WRITE;
/*!40000 ALTER TABLE `quizquestions` DISABLE KEYS */;
INSERT INTO `quizquestions` VALUES (53,48,10),(54,48,2),(55,48,9),(56,48,4),(57,48,6),(58,49,5),(59,49,3),(60,49,10),(61,49,1),(62,49,8),(63,50,3),(64,50,2),(65,50,10),(66,50,4),(67,50,7),(68,51,20),(69,51,16),(70,51,11),(71,51,14),(72,51,17),(73,52,12),(74,52,11),(75,52,17),(76,52,19),(77,52,15),(78,53,13),(79,53,14),(80,53,17),(81,53,15),(82,53,18),(83,54,26),(84,54,29),(85,54,27),(86,54,23),(87,54,30),(88,55,24),(89,55,30),(90,55,26),(91,55,23),(92,55,28),(93,56,29),(94,56,28),(95,56,21),(96,56,30),(97,56,23),(98,57,36),(99,57,35),(100,57,34),(101,57,39),(102,57,38),(103,58,36),(104,58,34),(105,58,38),(106,58,37),(107,58,35),(108,59,36),(109,59,31),(110,59,40),(111,59,38),(112,59,35),(113,60,45),(114,60,44),(115,60,47),(116,60,43),(117,60,41),(118,61,43),(119,61,41),(120,61,42),(121,61,44),(122,61,45),(123,62,49),(124,62,43),(125,62,42),(126,62,41),(127,62,47),(128,63,54),(129,63,60),(130,63,56),(131,63,58),(132,63,51),(133,64,51),(134,64,59),(135,64,54),(136,64,60),(137,64,55),(138,65,53),(139,65,57),(140,65,55),(141,65,60),(142,65,51),(143,66,65),(144,66,62),(145,66,69),(146,66,61),(147,66,68),(148,67,68),(149,67,69),(150,67,65),(151,67,67),(152,67,62),(153,68,70),(154,68,66),(155,68,68),(156,68,61),(157,68,64),(158,69,76),(159,69,71),(160,69,78),(161,69,79),(162,69,74),(163,70,73),(164,70,71),(165,70,76),(166,70,79),(167,70,77),(168,71,74),(169,71,76),(170,71,78),(171,71,72),(172,71,75),(173,72,85),(174,72,81),(175,72,82),(176,72,90),(177,72,84),(178,73,90),(179,73,89),(180,73,84),(181,73,87),(182,73,88),(183,74,81),(184,74,90),(185,74,88),(186,74,84),(187,74,86),(188,75,28),(189,75,21),(190,75,27),(191,75,24),(192,75,25),(193,76,13),(194,76,16),(195,76,15),(196,76,18),(197,76,11);
/*!40000 ALTER TABLE `quizquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizzes`
--

DROP TABLE IF EXISTS `quizzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quizzes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `difficulty_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `difficulty_id` (`difficulty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizzes`
--

LOCK TABLES `quizzes` WRITE;
/*!40000 ALTER TABLE `quizzes` DISABLE KEYS */;
INSERT INTO `quizzes` VALUES (48,1,1,'My first general quiz'),(49,1,1,'General easy - 2'),(50,1,1,'General easy - 3'),(51,1,2,'General medium -1'),(52,1,2,'General Medium - 2'),(53,1,2,'General Medium - 3'),(54,1,3,'General Hard - 1'),(55,1,3,'General Hard - 2'),(56,1,3,'General Hard - 3'),(57,2,1,'Sports easy - 1'),(58,2,1,'Sports easy - 2'),(59,2,1,'sports easy - 3'),(60,2,2,'Sports medium -1'),(61,2,2,'Sports medium - 2'),(62,2,2,'Sports medium - 3'),(63,2,3,'Sports Hard - 1'),(64,2,3,'Sports Hard - 2'),(65,2,3,'Sports Hard - 3'),(66,3,1,'geo easy -1'),(67,3,1,'geo easy - 2'),(68,3,1,'geo easy -3'),(69,3,2,'geo medium - 1'),(70,3,2,'geo medium - 2'),(71,3,2,'geo medium - 3'),(72,3,3,'geo hard - 1'),(73,3,3,'geo hard - 2'),(74,3,3,'geo hard - 3'),(75,1,3,'Ojas\' Quiz'),(76,1,2,'Test Quizzer');
/*!40000 ALTER TABLE `quizzes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL DEFAULT '',
  `score` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `quiz_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `quiz_id` (`quiz_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abhilash.sunkam@practo.com',0,NULL,NULL),(100,'abhilash.sunkam@practo.com',0,1,NULL),(102,'abhilash.sunkam@practo.com',0,1,NULL),(105,'abhilash.sunkam@practo.com',0,1,NULL),(106,'sai.chandra@practo.com',0,2,NULL),(107,'sai.chandra@practo.com',0,2,NULL),(145,'abhilash.sunkam@practo.com',0,1,NULL),(146,'abhilash.sunkam@practo.com',0,1,NULL),(188,'abhilash.sunkam@practo.com',0,1,NULL),(189,'abhilash.sunkam@practo.com',0,1,NULL),(190,'abhilash.sunkam@practo.com',0,1,NULL),(191,'abhilash.sunkam@practo.com',0,1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-26 12:01:00

--
-- Create schema talkmidb
--
-- DROP DATABASE talkmidb;
CREATE DATABASE IF NOT EXISTS talkmidb;
USE talkmidb;

--
-- Definition of table `talkers`
--

DROP TABLE IF EXISTS `talkers`;
CREATE TABLE `talkers` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` char(1) NOT NULL DEFAULT '0',
  `dob` datetime NOT NULL,
  `time_stamp` datetime NOT NULL,
  `frequency_counter` int(1) unsigned NOT NULL,
  PRIMARY KEY (`uid`,`uname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

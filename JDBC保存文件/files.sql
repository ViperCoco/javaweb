/*
MySQL Data Transfer
Source Host: localhost
Source Database: 17101db
Target Host: localhost
Target Database: 17101db
Date: 2017/11/17 15:50:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for files
-- ----------------------------
CREATE TABLE `files` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` longblob NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------

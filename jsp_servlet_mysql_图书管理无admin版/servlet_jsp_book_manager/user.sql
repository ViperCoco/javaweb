/*
MySQL Data Transfer
Source Host: localhost
Source Database: 17101db
Target Host: localhost
Target Database: 17101db
Date: 2017/12/5 21:55:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack', '123456');
INSERT INTO `user` VALUES ('2', '小明', 'abc123');
INSERT INTO `user` VALUES ('3', '小兰', 'abc123');

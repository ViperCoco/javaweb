/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : students

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2018-07-21 19:40:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` varchar(11) NOT NULL,
  `stuName` varchar(255) NOT NULL,
  `stuSex` varchar(255) NOT NULL,
  `stuAge` int(11) NOT NULL,
  `stuHobby` varchar(255) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('6', '3', '小张', '男', '20', '篮球');
INSERT INTO `student` VALUES ('7', '6', '小强', '男', '18', '乒乓球');
INSERT INTO `student` VALUES ('8', '2', '小周', '男', '12', '足球');
INSERT INTO `student` VALUES ('9', '5', '小华', '女', '10', '乒乓球');
INSERT INTO `student` VALUES ('10', '6', '小王', '男', '18', '羽毛球');

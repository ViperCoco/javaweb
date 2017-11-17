/*
MySQL Data Transfer
Source Host: localhost
Source Database: 17101db
Target Host: localhost
Target Database: 17101db
Date: 2017/11/17 15:49:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `age` int(100) NOT NULL,
  `hobby` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', '男', '20', 'JAVA');
INSERT INTO `student` VALUES ('2', '小红', '女', '20', 'Android');
INSERT INTO `student` VALUES ('3', '小兰', '女', '21', 'JAVA_WEB');
INSERT INTO `student` VALUES ('4', '小丽', '女', '20', '编程');

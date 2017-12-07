/*
MySQL Data Transfer
Source Host: localhost
Source Database: 17101db
Target Host: localhost
Target Database: 17101db
Date: 2017/12/5 21:55:26
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` double(10,5) NOT NULL DEFAULT '0.00000',
  `info` varchar(15) NOT NULL,
  `img_url` varchar(200) NOT NULL,
  `borrow_date` varchar(30) NOT NULL DEFAULT '尚未借出',
  `user` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `book` VALUES ('1', '大主宰', '6.21000', '天蚕土豆 玄幻-异世大陆 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/150.jpg', '2017-12-3 12:12:00', 'jack');
INSERT INTO `book` VALUES ('2', '莽荒纪', '6.66000', '我吃西红 仙侠-修真文明 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/151.jpg', '2017-12-05 21:53:51', 'jack');
INSERT INTO `book` VALUES ('3', '吞噬星空', '6.65000', '我吃西红 科幻-未来世界 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/152.jpg', '2017-12-1 12:12:00', '小明');
INSERT INTO `book` VALUES ('4', '凡人修仙传', '5.51000', '忘语 仙侠-幻想修仙 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/153.jpg', '尚未借出', '');
INSERT INTO `book` VALUES ('5', '完美世界', '5.52000', '辰东 玄幻-东方玄幻 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/160.jpg', '2017-12-05 21:54:04', 'jack');
INSERT INTO `book` VALUES ('6', '盘龙', '8.66000', '我吃西红 奇幻-剑与魔法 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/161.jpg', '尚未借出', '');
INSERT INTO `book` VALUES ('7', '从零开始', '8.55000', '雷云风暴 游戏-虚拟网游 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/165.jpg', '尚未借出', '');
INSERT INTO `book` VALUES ('8', '遮天', '6.91000', '辰东 仙侠-修真文明 完本', 'http://localhost:8080/servlet_jsp_book_manager/images/168.jpg', '尚未借出', '');

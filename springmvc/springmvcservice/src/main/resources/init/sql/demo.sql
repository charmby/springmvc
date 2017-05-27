/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-27 10:13:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission_role_t`
-- ----------------------------
DROP TABLE IF EXISTS `permission_role_t`;
CREATE TABLE `permission_role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_role_t
-- ----------------------------
INSERT INTO `permission_role_t` VALUES ('1', '1', '1');
INSERT INTO `permission_role_t` VALUES ('2', '1', '2');
INSERT INTO `permission_role_t` VALUES ('3', '1', '3');
INSERT INTO `permission_role_t` VALUES ('4', '1', '4');
INSERT INTO `permission_role_t` VALUES ('5', '2', '1');
INSERT INTO `permission_role_t` VALUES ('6', '2', '2');
INSERT INTO `permission_role_t` VALUES ('7', '2', '3');
INSERT INTO `permission_role_t` VALUES ('8', '3', '4');
INSERT INTO `permission_role_t` VALUES ('9', '4', '1');
INSERT INTO `permission_role_t` VALUES ('10', '1', '5');

-- ----------------------------
-- Table structure for `permission_t`
-- ----------------------------
DROP TABLE IF EXISTS `permission_t`;
CREATE TABLE `permission_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_code` varchar(255) DEFAULT NULL,
  `permission_url` varchar(255) DEFAULT NULL,
  `permission_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_t
-- ----------------------------
INSERT INTO `permission_t` VALUES ('1', '新增用户', 'user:insertUser', '/user/insertUser', '过滤新增用户的url');
INSERT INTO `permission_t` VALUES ('2', '根据用户名查询用户', 'user:selectUserByUserName', '/user/selectUserByUserName', '根据用户名查询用户');
INSERT INTO `permission_t` VALUES ('3', '根据用户名和密码获取用户信息', 'user:showUserByUserNameAndPassWord', '/user/showUserByUserNameAndPassWord', '根据用户名和密码获取用户信息');
INSERT INTO `permission_t` VALUES ('4', '删除用户', 'user:deleteUser', '/user/deleteUser', '删除用户');
INSERT INTO `permission_t` VALUES ('5', '查询所有用户', 'user:allUsers', '/user/getAllUser', '查询所有用户');
INSERT INTO `permission_t` VALUES ('6', '根据用户id获得用户', 'user:getUserById', '/user/getUserById', '根据用户id获得用户');

-- ----------------------------
-- Table structure for `role_t`
-- ----------------------------
DROP TABLE IF EXISTS `role_t`;
CREATE TABLE `role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_t
-- ----------------------------
INSERT INTO `role_t` VALUES ('1', 'sa', 'sa', '超级管理员');
INSERT INTO `role_t` VALUES ('2', 'sysadmin', 'sysadmin', '系统管理员');
INSERT INTO `role_t` VALUES ('3', 'privadmin', 'privadmin', '权限管理员');
INSERT INTO `role_t` VALUES ('4', 'normal', 'normal', '普通用户');
INSERT INTO `role_t` VALUES ('5', 'normal1', 'normal1', '普通用户');
INSERT INTO `role_t` VALUES ('6', 'normal2', 'normal2', '普通用户');
INSERT INTO `role_t` VALUES ('7', 'normal2', 'normal3', '普通用户');

-- ----------------------------
-- Table structure for `sextype`
-- ----------------------------
DROP TABLE IF EXISTS `sextype`;
CREATE TABLE `sextype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sextype
-- ----------------------------
INSERT INTO `sextype` VALUES ('1', '男');
INSERT INTO `sextype` VALUES ('2', '女');
INSERT INTO `sextype` VALUES ('3', '未知');

-- ----------------------------
-- Table structure for `tbl_account`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account` (
  `money` int(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_account
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT '',
  `email` varchar(40) DEFAULT '',
  `phone` varchar(20) DEFAULT '',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', '20', '肖东红', '', '', '');
INSERT INTO `user` VALUES ('sa', 'c4ca4238a0b923820dcc509a6f75849b', '20', '肖东红', '', '', '');
INSERT INTO `user` VALUES ('xiaodh', 'xiaodh', '20', '肖东红', '', '', '');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '孤傲苍狼', '27');
INSERT INTO `users` VALUES ('2', '白虎神皇', '27');

-- ----------------------------
-- Table structure for `user_role_t`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_t`;
CREATE TABLE `user_role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_userid` (`user_id`),
  KEY `user_role_roleid` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_t
-- ----------------------------
INSERT INTO `user_role_t` VALUES ('1', '1', '1');
INSERT INTO `user_role_t` VALUES ('2', '2', '1');
INSERT INTO `user_role_t` VALUES ('3', '3', '2');
INSERT INTO `user_role_t` VALUES ('4', '1', '3');
INSERT INTO `user_role_t` VALUES ('5', '3', '6');
INSERT INTO `user_role_t` VALUES ('6', '2', '2');
INSERT INTO `user_role_t` VALUES ('7', '4', '4');
INSERT INTO `user_role_t` VALUES ('8', '2', '5');

-- ----------------------------
-- Table structure for `user_t`
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', 'xiaodonghong', 'xiaodonghong', '20', null);
INSERT INTO `user_t` VALUES ('2', 'admin', 'admin', '18', '18765532456');
INSERT INTO `user_t` VALUES ('3', 'sa', '1', '10', '18765432436');
INSERT INTO `user_t` VALUES ('4', 'normal', 'normal', '11', '18765442436');
INSERT INTO `user_t` VALUES ('5', 'sysadmin', 'sysadmin', '12', '18765431436');
INSERT INTO `user_t` VALUES ('6', 'xiaodh', 'xiaodh', '20', '18765467898');

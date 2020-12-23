/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : db_supermarket

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 23/12/2020 22:44:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb-depot
-- ----------------------------
DROP TABLE IF EXISTS `tb-depot`;
CREATE TABLE `tb-depot`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manage` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `functional` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb-depot
-- ----------------------------

-- ----------------------------
-- Table structure for tb_basicmessage
-- ----------------------------
DROP TABLE IF EXISTS `tb_basicmessage`;
CREATE TABLE `tb_basicmessage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dept` int(255) NULL DEFAULT NULL,
  `headship` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_basicmessage
-- ----------------------------

-- ----------------------------
-- Table structure for tb_contact
-- ----------------------------
DROP TABLE IF EXISTS `tb_contact`;
CREATE TABLE `tb_contact`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `officePhone` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `fax` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `faddress` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_contact
-- ----------------------------

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `principal` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `bewrite` varchar(60) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (1, '1', '1', '1');
INSERT INTO `tb_dept` VALUES (2, '1', '1', '1');
INSERT INTO `tb_dept` VALUES (10, '1', '1', '1');

-- ----------------------------
-- Table structure for tb_headship
-- ----------------------------
DROP TABLE IF EXISTS `tb_headship`;
CREATE TABLE `tb_headship`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headshipName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_headship
-- ----------------------------

-- ----------------------------
-- Table structure for tb_joindepot
-- ----------------------------
DROP TABLE IF EXISTS `tb_joindepot`;
CREATE TABLE `tb_joindepot`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `dId` int(11) NULL DEFAULT NULL,
  `wareName` int(11) NULL DEFAULT NULL,
  `joinTime` varchar(40) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `weight` float NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_joindepot
-- ----------------------------

-- ----------------------------
-- Table structure for tb_outdepot
-- ----------------------------
DROP TABLE IF EXISTS `tb_outdepot`;
CREATE TABLE `tb_outdepot`  (
  `id` int(11) NOT NULL,
  `did` int(11) NULL DEFAULT NULL,
  `wName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `outDate` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `wight` float(255, 0) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_outdepot
-- ----------------------------

-- ----------------------------
-- Table structure for tb_provide
-- ----------------------------
DROP TABLE IF EXISTS `tb_provide`;
CREATE TABLE `tb_provide`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cName` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `address` varchar(40) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `linkman` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `linkPhone` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `faxes` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `postNum` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `bankNum` varchar(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `netAddress` varchar(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `emaillAddress` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_provide
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sell
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell`;
CREATE TABLE `tb_sell`  (
  `id` int(11) NOT NULL,
  `sellName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `linkman` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `linkPhone` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `faxNum` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `postNum` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `bankNum` varchar(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `netAddress` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `emallAddress` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_sell
-- ----------------------------

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock`  (
  `id` int(11) NOT NULL,
  `sName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `orderId` varchar(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `consignmentDate` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `baleName` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `count` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `money` float(255, 0) NULL DEFAULT NULL,
  `lairage` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_stock
-- ----------------------------

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `passWord` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES (1, 'mr', 'mrsoft');
INSERT INTO `tb_users` VALUES (2, 'root', 'root');

-- ----------------------------
-- Table structure for tb_ware
-- ----------------------------
DROP TABLE IF EXISTS `tb_ware`;
CREATE TABLE `tb_ware`  (
  `id` int(11) NOT NULL,
  `wareName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `warBewrite` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `spec` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_ware
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

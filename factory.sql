/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : factory

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 29/05/2020 08:53:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admini
-- ----------------------------
DROP TABLE IF EXISTS `admini`;
CREATE TABLE `admini`  (
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `MM` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admini
-- ----------------------------
INSERT INTO `admini` VALUES ('fangkf', '134679');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `pID` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `num` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`pID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('R1001', '产品1', 50, 400);
INSERT INTO `product` VALUES ('R1002', '产品2', 100, 400);
INSERT INTO `product` VALUES ('R2001', '产品1.1', 120, 400);
INSERT INTO `product` VALUES ('R2002', '产品3', 150, 0);

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `uName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pID` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `Num` int(10) NOT NULL,
  `Tal` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`uName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('张三', 'R2002', '2019-06-01', 20, '131********');
INSERT INTO `sale` VALUES ('李华', 'R1002', '2019-05-31', 100, '177********');
INSERT INTO `sale` VALUES ('王五', 'R1001', '2020-05-05', 10, '131********');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '小张', '男', '组装部');
INSERT INTO `staff` VALUES (2, '小明', '男', '点锡部');
INSERT INTO `staff` VALUES (3, '小李', '女', '贴膜部');

SET FOREIGN_KEY_CHECKS = 1;

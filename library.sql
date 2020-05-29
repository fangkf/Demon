/*
 Navicat Premium Data Transfer

 Source Server         : java
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 02/06/2019 20:33:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `bookDesc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `bookTypeid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '计算机组成', '白中英', '男', '关于计算机内部器件的组成及功能', 1);
INSERT INTO `book` VALUES (2, '线性代数', '李桂贞', '女', '研究关于矩阵以及行列式的数学书', 2);
INSERT INTO `book` VALUES (5, '汇编语言', '王爽', '男', '关于汇编语言的基础编程', 1);
INSERT INTO `book` VALUES (6, '概率论', '柯忠义', '男', '关于概率统计的教科书', 2);

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `bookTypeDesc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES (1, '计算机类', '包括C语言C++等一些编程类书籍');
INSERT INTO `booktype` VALUES (2, '数学类', '包括高等数学、积分等');
INSERT INTO `booktype` VALUES (3, '文学类', '一些关于古诗词、名人著作的书籍');
INSERT INTO `booktype` VALUES (4, '思想政治类', '政治类书籍');
INSERT INTO `booktype` VALUES (5, '科幻小说', '一些关于未来科技幻想的小说');
INSERT INTO `booktype` VALUES (6, '英语类', '英语书籍');
INSERT INTO `booktype` VALUES (7, '武侠小说', '讲述一个热血江湖的传奇小说');

-- ----------------------------
-- Table structure for borrba
-- ----------------------------
DROP TABLE IF EXISTS `borrba`;
CREATE TABLE `borrba`  (
  `bName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `uName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `bandb` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrba
-- ----------------------------
INSERT INTO `borrba` VALUES ('计算机组成', '方楷锋', '2019-05-31', 1);
INSERT INTO `borrba` VALUES ('线性代数', NULL, NULL, 0);
INSERT INTO `borrba` VALUES ('汇编语言', NULL, NULL, 0);
INSERT INTO `borrba` VALUES ('高等数学', NULL, NULL, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'fangkf', '123456');
INSERT INTO `user` VALUES (2, 'fkf', '134679');
INSERT INTO `user` VALUES (3, 'fff', '1111');

SET FOREIGN_KEY_CHECKS = 1;

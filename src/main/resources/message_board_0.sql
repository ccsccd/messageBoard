/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : message_board

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 17/05/2019 23:41:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES (1, '李明', '我是第一个', 0);
INSERT INTO `message_board` VALUES (2, '王刚', '我是第二个', 0);
INSERT INTO `message_board` VALUES (3, '王刚儿子', '......', 2);
INSERT INTO `message_board` VALUES (4, '王刚孙子', '......', 3);
INSERT INTO `message_board` VALUES (5, '孙明', '我我我', 0);
INSERT INTO `message_board` VALUES (7, '赵光', '啊啊啊', 0);

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : 124.71.25.233
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 124.71.25.233:3306
 Source Schema         : springcloud

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 23/02/2021 11:17:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

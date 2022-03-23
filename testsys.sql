/*
 Navicat Premium Data Transfer

 Source Server         : liee
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : 192.168.130.76:3306
 Source Schema         : testsys

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 10/03/2022 17:10:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `queID` int(11) NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `isTrue` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_answer_ques_1`(`queID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cour_test
-- ----------------------------
DROP TABLE IF EXISTS `cour_test`;
CREATE TABLE `cour_test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courID` int(11) NULL DEFAULT NULL,
  `testID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courID`(`courID`) USING BTREE,
  INDEX `fk_cour-test_test_1`(`testID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `startDate` datetime(0) NULL DEFAULT NULL COMMENT '创立日期',
  `count` int(11) NULL DEFAULT NULL COMMENT '学科人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper_ques
-- ----------------------------
DROP TABLE IF EXISTS `paper_ques`;
CREATE TABLE `paper_ques`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperID` int(11) NULL DEFAULT NULL,
  `queID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_paper-ques_testPaper_1`(`paperID`) USING BTREE,
  INDEX `fk_paper-ques_ques_1`(`queID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ques
-- ----------------------------
DROP TABLE IF EXISTS `ques`;
CREATE TABLE `ques`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL COMMENT '题目类型',
  `courID` int(11) NULL DEFAULT NULL COMMENT '该题对应的科目',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stupaper
-- ----------------------------
DROP TABLE IF EXISTS `stupaper`;
CREATE TABLE `stupaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stutestID` int(11) NOT NULL COMMENT '该学生试卷对应的考试场次',
  `queID` int(11) NULL DEFAULT NULL,
  `myanswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stutestID`(`stutestID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stutest
-- ----------------------------
DROP TABLE IF EXISTS `stutest`;
CREATE TABLE `stutest`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `singTestID` int(11) NULL DEFAULT NULL,
  `stuID` int(11) NULL DEFAULT NULL,
  `total` int(11) NULL DEFAULT NULL COMMENT '总成绩',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_testGrade_cour-test_1`(`singTestID`) USING BTREE,
  INDEX `fk_testGrade_user_1`(`stuID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `paperID` int(11) NOT NULL,
  `startTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '0表示未开始；1表示进行中；2表示已结束',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_test_testPaper_1`(`paperID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '表示试卷状态，如0表示试卷被保存但是未发布到考试，1表示已经发布到考试',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '对教师来说是工号，对学生是学号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `dep` int(11) NULL DEFAULT NULL,
  `who` int(11) NULL DEFAULT NULL COMMENT '0表示管理员；1表示教师；2表示学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '201931060001', 'aa', '1', 1, 2);

-- ----------------------------
-- Table structure for user_cour
-- ----------------------------
DROP TABLE IF EXISTS `user_cour`;
CREATE TABLE `user_cour`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NULL DEFAULT NULL,
  `courID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user-cour_user_1`(`userID`) USING BTREE,
  INDEX `fk_user-cour_course_1`(`courID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

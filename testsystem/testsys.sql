/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : testsys

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/03/2022 19:05:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `queID` int(0) NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isTrue` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `queID`(`queID`) USING BTREE,
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`queID`) REFERENCES `ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for cour_test
-- ----------------------------
DROP TABLE IF EXISTS `cour_test`;
CREATE TABLE `cour_test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `courID` int(0) NOT NULL,
  `testID` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courID`(`courID`) USING BTREE,
  INDEX `testID`(`testID`) USING BTREE,
  CONSTRAINT `cour_test_ibfk_1` FOREIGN KEY (`courID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cour_test_ibfk_2` FOREIGN KEY (`testID`) REFERENCES `test` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cour_test
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `startDate` datetime(0) NOT NULL,
  `count` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'C语言', '2022-03-01 19:35:13', 60);
INSERT INTO `course` VALUES (2, 'dd', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (3, 'dd', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (5, 'dd', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (8, 'admin', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (9, '清理大师', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (10, 'bbb', '2022-03-07 16:00:00', 0);
INSERT INTO `course` VALUES (11, '928爱拔撒库来大促！', '2022-03-09 16:00:00', 0);
INSERT INTO `course` VALUES (12, 'ddd', '2022-03-01 16:00:00', 0);
INSERT INTO `course` VALUES (13, '清理大师', '2022-03-09 16:00:00', 0);
INSERT INTO `course` VALUES (14, 'ddd', '2022-03-03 16:00:00', 0);
INSERT INTO `course` VALUES (15, '928爱拔撒库来大促！', '2022-03-10 16:00:00', 0);
INSERT INTO `course` VALUES (17, 'aaa', '2022-03-08 16:00:00', 0);

-- ----------------------------
-- Table structure for paper_ques
-- ----------------------------
DROP TABLE IF EXISTS `paper_ques`;
CREATE TABLE `paper_ques`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `paperID` int(0) NOT NULL,
  `queID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `paperID`(`paperID`) USING BTREE,
  INDEX `queID`(`queID`) USING BTREE,
  CONSTRAINT `paper_ques_ibfk_1` FOREIGN KEY (`paperID`) REFERENCES `testpaper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `paper_ques_ibfk_2` FOREIGN KEY (`queID`) REFERENCES `ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_ques
-- ----------------------------

-- ----------------------------
-- Table structure for ques
-- ----------------------------
DROP TABLE IF EXISTS `ques`;
CREATE TABLE `ques`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `problem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` int(0) NOT NULL,
  `type` int(0) NOT NULL COMMENT '该题目所属类型。如1代表单选，2代表多选等',
  `courID` int(0) NOT NULL COMMENT '该题目所属学科',
  `degree` int(0) NOT NULL COMMENT '题目的难易程度，1表示简，2表示中，3表示难',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courID`(`courID`) USING BTREE,
  CONSTRAINT `ques_ibfk_1` FOREIGN KEY (`courID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques
-- ----------------------------

-- ----------------------------
-- Table structure for stupaper
-- ----------------------------
DROP TABLE IF EXISTS `stupaper`;
CREATE TABLE `stupaper`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `stutestID` int(0) NOT NULL,
  `queID` int(0) NULL DEFAULT NULL COMMENT '单个问题的id',
  `myanswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '该学生单个问题的答案',
  `grade` int(0) NULL DEFAULT NULL COMMENT '该题的得分',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stutestID`(`stutestID`) USING BTREE,
  INDEX `queID`(`queID`) USING BTREE,
  CONSTRAINT `stupaper_ibfk_1` FOREIGN KEY (`stutestID`) REFERENCES `stutest` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stupaper_ibfk_2` FOREIGN KEY (`queID`) REFERENCES `ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stupaper
-- ----------------------------

-- ----------------------------
-- Table structure for stutest
-- ----------------------------
DROP TABLE IF EXISTS `stutest`;
CREATE TABLE `stutest`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `singTestID` int(0) NOT NULL,
  `stuID` int(0) NOT NULL,
  `total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '该学生该场考试的总成绩',
  `finTime` datetime(0) NOT NULL COMMENT '该生的交卷时间',
  `finStatus` int(0) NOT NULL COMMENT '该学生的该场考试结束后的状态，0表示已交卷未批改，1表示已交卷已批改',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `singTestID`(`singTestID`) USING BTREE,
  INDEX `stuID`(`stuID`) USING BTREE,
  CONSTRAINT `stutest_ibfk_1` FOREIGN KEY (`singTestID`) REFERENCES `test` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stutest_ibfk_2` FOREIGN KEY (`stuID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stutest
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `paperID` int(0) NOT NULL COMMENT '该场考试所用试卷的id',
  `startTime` datetime(0) NOT NULL,
  `endTime` datetime(0) NOT NULL,
  `status` int(0) NOT NULL COMMENT '考试状态说明：0表示未开始；1表示进行中；2表示已结束',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `paperID`(`paperID`) USING BTREE,
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`paperID`) REFERENCES `testpaper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int(0) NOT NULL COMMENT '表示试卷状态，如0表示试卷被保存但是未发布到考试，或者发布到考试但考试已经结束；1表示已经发布到考试；2表示试卷被封存，不能进行查看或编辑',
  `allAnswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '试卷包含的所有答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testpaper
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '对教师来说是工号，对学生来说是学号，管理员有默认值',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dep` int(0) NOT NULL COMMENT '用户所属院系，如1表示外语院，2表示马克思院等',
  `who` int(0) NOT NULL COMMENT '用户身份状态：0表示管理员；1表示教师；2表示学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '201900010001', '1', '1', 1, 1);

-- ----------------------------
-- Table structure for user_cour
-- ----------------------------
DROP TABLE IF EXISTS `user_cour`;
CREATE TABLE `user_cour`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userID` int(0) NOT NULL,
  `courID` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE,
  INDEX `courID`(`courID`) USING BTREE,
  CONSTRAINT `user_cour_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_cour_ibfk_2` FOREIGN KEY (`courID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_cour
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

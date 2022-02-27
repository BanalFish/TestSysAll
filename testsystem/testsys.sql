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

 Date: 27/02/2022 16:05:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(0) NOT NULL,
  `queID` int(0) NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isTrue` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否为正确答案，1表示是，0表示不是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_answer_ques_1`(`queID`) USING BTREE,
  CONSTRAINT `fk_answer_ques_1` FOREIGN KEY (`queID`) REFERENCES `ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for cour_test
-- ----------------------------
DROP TABLE IF EXISTS `cour_test`;
CREATE TABLE `cour_test`  (
  `id` int(0) NOT NULL,
  `courID` int(0) NULL DEFAULT NULL,
  `testID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `courID`(`courID`) USING BTREE,
  INDEX `fk_cour-test_test_1`(`testID`) USING BTREE,
  CONSTRAINT `fk_cour-test_course_1` FOREIGN KEY (`courID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_cour-test_test_1` FOREIGN KEY (`testID`) REFERENCES `test` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cour_test
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `startDate` datetime(0) NULL DEFAULT NULL COMMENT '创立日期',
  `count` int(0) NULL DEFAULT NULL COMMENT '学科人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'C语言', '2022-02-10 16:19:43', 77);

-- ----------------------------
-- Table structure for paper_ques
-- ----------------------------
DROP TABLE IF EXISTS `paper_ques`;
CREATE TABLE `paper_ques`  (
  `id` int(0) NOT NULL,
  `paperID` int(0) NULL DEFAULT NULL,
  `queID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_paper-ques_testPaper_1`(`paperID`) USING BTREE,
  INDEX `fk_paper-ques_ques_1`(`queID`) USING BTREE,
  CONSTRAINT `fk_paper-ques_ques_1` FOREIGN KEY (`queID`) REFERENCES `ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_paper-ques_testPaper_1` FOREIGN KEY (`paperID`) REFERENCES `testpaper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_ques
-- ----------------------------

-- ----------------------------
-- Table structure for ques
-- ----------------------------
DROP TABLE IF EXISTS `ques`;
CREATE TABLE `ques`  (
  `id` int(0) NOT NULL,
  `problem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` int(0) NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL COMMENT '该题目所属类型。如1代表单选，2代表多选等。',
  `courID` int(0) NULL DEFAULT NULL COMMENT '该题对应的科目',
  `degree` int(0) NOT NULL COMMENT '题目的难易程度，1表示简，2表示中，3表示难',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ques
-- ----------------------------

-- ----------------------------
-- Table structure for stupaper
-- ----------------------------
DROP TABLE IF EXISTS `stupaper`;
CREATE TABLE `stupaper`  (
  `id` int(0) NOT NULL,
  `stutestID` int(0) NOT NULL COMMENT '该学生试卷对应的考试场次',
  `queID` int(0) NULL DEFAULT NULL,
  `myanswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stutestID`(`stutestID`) USING BTREE,
  CONSTRAINT `stupaper_ibfk_1` FOREIGN KEY (`stutestID`) REFERENCES `stutest` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stupaper
-- ----------------------------

-- ----------------------------
-- Table structure for stutest
-- ----------------------------
DROP TABLE IF EXISTS `stutest`;
CREATE TABLE `stutest`  (
  `id` int(0) NOT NULL,
  `singTestID` int(0) NOT NULL,
  `stuID` int(0) NOT NULL,
  `total` int(0) NULL DEFAULT NULL COMMENT '总成绩',
  `finTime` datetime(0) NOT NULL COMMENT '该生交卷时间',
  `finStatus` int(0) NOT NULL COMMENT '该学生的该场考试结束后的状态，0表示已交卷未批改，1表示已交卷已批改',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_testGrade_cour-test_1`(`singTestID`) USING BTREE,
  INDEX `fk_testGrade_user_1`(`stuID`) USING BTREE,
  CONSTRAINT `fk_testGrade_cour-test_1` FOREIGN KEY (`singTestID`) REFERENCES `cour_test` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_testGrade_user_1` FOREIGN KEY (`stuID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stutest
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `paperID` int(0) NOT NULL,
  `startTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '0表示未开始；1表示进行中；2表示已结束',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_test_testPaper_1`(`paperID`) USING BTREE,
  CONSTRAINT `fk_test_testPaper_1` FOREIGN KEY (`paperID`) REFERENCES `testpaper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int(0) NOT NULL COMMENT '表示试卷状态，如0表示试卷被保存但是未发布到考试，或者发布到考试但考试已经结束；1表示已经发布到考试',
  `allAnswer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存储一张试卷包含的所有答案',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testpaper
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '对教师来说是工号，对学生是学号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dep` int(0) NULL DEFAULT NULL,
  `who` int(0) NULL DEFAULT NULL COMMENT '0表示管理员；1表示教师；2表示学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '201931060001', '1', '1', 1, 1);

-- ----------------------------
-- Table structure for user_cour
-- ----------------------------
DROP TABLE IF EXISTS `user_cour`;
CREATE TABLE `user_cour`  (
  `id` int(0) NOT NULL,
  `userID` int(0) NULL DEFAULT NULL,
  `courID` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user-cour_user_1`(`userID`) USING BTREE,
  INDEX `fk_user-cour_course_1`(`courID`) USING BTREE,
  CONSTRAINT `fk_user-cour_course_1` FOREIGN KEY (`courID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user-cour_user_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_cour
-- ----------------------------
INSERT INTO `user_cour` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;

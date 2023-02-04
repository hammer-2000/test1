/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : test1

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 04/02/2023 18:23:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choose_course
-- ----------------------------
DROP TABLE IF EXISTS `choose_course`;
CREATE TABLE `choose_course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生选课id',
  `student_id` int(11) NOT NULL COMMENT '学生id',
  `course_id` int(11) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of choose_course
-- ----------------------------
INSERT INTO `choose_course` VALUES (6, 14, 1);
INSERT INTO `choose_course` VALUES (10, 14, 3);
INSERT INTO `choose_course` VALUES (11, 14, 4);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程主键',
  `course_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名',
  `credit` float(255, 1) NOT NULL COMMENT '课程学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '计算机网络1', 2.5);
INSERT INTO `course` VALUES (3, '操作系统', 3.0);
INSERT INTO `course` VALUES (4, '计算机组成原理', 3.5);
INSERT INTO `course` VALUES (5, '计算机网络1', 2.0);
INSERT INTO `course` VALUES (6, 'java开发1', 3.5);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `stud_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `sex` tinyint(3) NOT NULL COMMENT '1为男，2为女',
  `grade` int(8) NULL DEFAULT NULL COMMENT '学生年级，与年级表为外键关系，在代码中限制',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, '张三', 1, 1);
INSERT INTO `student` VALUES (6, '张三', 1, 1);
INSERT INTO `student` VALUES (7, '1', 1, 1);
INSERT INTO `student` VALUES (9, '李四', 1, 1);
INSERT INTO `student` VALUES (10, '张无', 1, 2);
INSERT INTO `student` VALUES (11, '张六', 1, 2);
INSERT INTO `student` VALUES (12, '张七', 2, 3);
INSERT INTO `student` VALUES (13, '张八', 2, 3);
INSERT INTO `student` VALUES (14, '李四2', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;

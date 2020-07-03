/*
 Navicat Premium Data Transfer

 Source Server         : chen
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : csesystem

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 03/07/2020 17:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123');

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES (1, '信息工程');
INSERT INTO `departments` VALUES (2, '软件工程');
INSERT INTO `departments` VALUES (3, '机械工程');
INSERT INTO `departments` VALUES (4, '艺术学院');
INSERT INTO `departments` VALUES (5, '电气学院');
INSERT INTO `departments` VALUES (6, '材料学院');

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faculty
-- ----------------------------
INSERT INTO `faculty` VALUES (11, '艺术学院', 'ys1', '123');
INSERT INTO `faculty` VALUES (12, '软件工程', 'rj1', '123');
INSERT INTO `faculty` VALUES (13, '机械工程', 'jx1', '123');
INSERT INTO `faculty` VALUES (14, '信息工程', 'xx1', '123');
INSERT INTO `faculty` VALUES (15, '材料学院', 'cl1', '123');

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sign_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `sign_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sign_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `sign_id_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `sign_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系',
  `sign_site` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试地点',
  `sign_room` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考场',
  `sign_seat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '座位号',
  `sign_exam_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '准考证号',
  `sign_level` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试等级',
  `sign_subject` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试科目',
  `sign_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `sign_pic` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES (51, '3', '杨翠红', '女', '632724201307262187', '软件工程', '东校区', '002', '021', '101002021', '计算机等级一级', '网络安全素质教育(17)', '15117790941', 'pic/1593685714312-975913.jpeg');
INSERT INTO `sign` VALUES (54, '12', '曹烨华', '男', '450204199008191050', '软件工程', '东校区', '002', '022', '101002022', '计算机等级三级', '数据库技术(36)', '13145013078', 'pic/1593736525984-465211.jpeg');
INSERT INTO `sign` VALUES (55, '1', '吴玉朋', '男', '411724196905231473', '机械工程', '东校区', '002', '025', '101002025', '计算机等级一级', '网络安全素质教育(17)', '13931493028', 'pic/1593752491222-132587.jpeg');
INSERT INTO `sign` VALUES (56, '2', '褚俊龙', '男', '230382199103169111', '电气学院', '西校区', '002', '026', '102002026', '计算机等级二级', 'C++语言程序设计(61)', '13593097175', 'pic/1593752532960-313237.jpg');
INSERT INTO `sign` VALUES (57, '4', '姜浩天', '男', '431129196109133824', '信息工程', '西校区', '002', '027', '102002027', '计算机等级三级', '信息安全技术(38)', '13727531114', 'pic/1593752571628-176139.jpg');
INSERT INTO `sign` VALUES (58, '5', '秦宏艳', '女', '610112201009271073', '信息工程', '西校区', '002', '028', '102002028', '计算机等级三级', '数据库技术(36)', '13977728071', 'pic/1593752678787-451181.jpeg');
INSERT INTO `sign` VALUES (59, '6', '吴玉朋', '男', '140901197511124725', '信息工程', '西校区', '002', '029', '102002029', '计算机等级四级', '嵌入式系统开发工程师(45)', '13980173239', 'pic/1593752709847-791040.jpeg');
INSERT INTO `sign` VALUES (60, '7', '沈朝海', '男', '370104199608223284', '软件工程', '西校区', '003', '030', '102003030', '计算机等级二级', 'Java语言程序设计(28)', '13196786042', 'pic/1593752921473-699354.jpg');
INSERT INTO `sign` VALUES (61, '8', '周甜', '女', '140108197610115980', '软件工程', '西校区', '003', '001', '102003001', '计算机等级一级', '计算机基础及WPS Office应用(14)', '13977524979', 'pic/1593753496569-681226.jpeg');
INSERT INTO `sign` VALUES (62, '9', '秦江霞', '女', '52011519850225291X', '软件工程', '西校区', '003', '002', '102003002', '计算机等级一级', '计算机基础及Photoshop应用(16)', '13758169926', 'pic/1593752988495-458215.jpg');
INSERT INTO `sign` VALUES (63, '13', '秦显丽', '女', '140901197511124725', '艺术学院', '西校区', '003', '003', '102003003', '计算机等级三级', '网络技术(35)', '13510327233', 'pic/1593753457965-992545.jpeg');

-- ----------------------------
-- Table structure for sign2
-- ----------------------------
DROP TABLE IF EXISTS `sign2`;
CREATE TABLE `sign2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sign_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `sign_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sign_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `sign_id_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `sign_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系',
  `sign_site` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试地点',
  `sign_room` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考场',
  `sign_seat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '座位号',
  `sign_exam_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '准考证号',
  `sign_level` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试等级',
  `sign_subject` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试科目',
  `sign_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `sign_pic` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign2
-- ----------------------------
INSERT INTO `sign2` VALUES (51, '3', '杨翠红', '女', '632724201307262187', '软件工程', '东校区', '002', '021', '101002021', '计算机等级一级', '网络安全素质教育(17)', '15117790941', 'pic/1593685714312-975913.jpeg');
INSERT INTO `sign2` VALUES (54, '12', '曹烨华', '男', '450204199008191050', '软件工程', '东校区', '002', '022', '101002022', '计算机等级三级', '数据库技术(36)', '13145013078', 'pic/1593736525984-465211.jpeg');
INSERT INTO `sign2` VALUES (55, '1', '吴玉朋', '男', '411724196905231473', '机械工程', '东校区', '002', '025', '101002025', '计算机等级一级', '网络安全素质教育(17)', '13931493028', 'pic/1593752491222-132587.jpeg');
INSERT INTO `sign2` VALUES (56, '2', '褚俊龙', '男', '230382199103169111', '电气学院', '西校区', '002', '026', '102002026', '计算机等级二级', 'C++语言程序设计(61)', '13593097175', 'pic/1593752532960-313237.jpg');
INSERT INTO `sign2` VALUES (57, '4', '姜浩天', '男', '431129196109133824', '信息工程', '西校区', '002', '027', '102002027', '计算机等级三级', '信息安全技术(38)', '13727531114', 'pic/1593752571628-176139.jpg');
INSERT INTO `sign2` VALUES (58, '5', '秦宏艳', '女', '610112201009271073', '信息工程', '西校区', '002', '028', '102002028', '计算机等级三级', '数据库技术(36)', '13977728071', 'pic/1593752678787-451181.jpeg');
INSERT INTO `sign2` VALUES (59, '6', '吴玉朋', '男', '140901197511124725', '信息工程', '西校区', '002', '029', '102002029', '计算机等级四级', '嵌入式系统开发工程师(45)', '13980173239', 'pic/1593752709847-791040.jpeg');
INSERT INTO `sign2` VALUES (60, '7', '沈朝海', '男', '370104199608223284', '软件工程', '西校区', '003', '030', '102003030', '计算机等级二级', 'Java语言程序设计(28)', '13196786042', 'pic/1593752921473-699354.jpg');
INSERT INTO `sign2` VALUES (61, '8', '周甜', '女', '140108197610115980', '软件工程', '西校区', '003', '001', '102003001', '计算机等级一级', '计算机基础及WPS Office应用(14)', '13977524979', 'pic/1593753496569-681226.jpeg');
INSERT INTO `sign2` VALUES (62, '9', '秦江霞', '女', '52011519850225291X', '软件工程', '西校区', '003', '002', '102003002', '计算机等级一级', '计算机基础及Photoshop应用(16)', '13758169926', 'pic/1593752988495-458215.jpg');
INSERT INTO `sign2` VALUES (63, '13', '秦显丽', '女', '140901197511124725', '艺术学院', '西校区', '003', '003', '102003003', '计算机等级三级', '网络技术(35)', '13510327233', 'pic/1593753457965-992545.jpeg');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `student_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `student_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `student_department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生所在学院',
  `student_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `student_pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `student_sign` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报考与否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (17, '1', '吴玉朋', '男', '机械工程', '13931493028\r\n', '123', '已报名');
INSERT INTO `student` VALUES (19, '3', '杨翠红', '女', '软件工程', '15117790941\r\n', '123', '已报名');
INSERT INTO `student` VALUES (20, '5', '秦宏艳', '女', '信息工程', '13977728071\r\n', '123', '已报名');
INSERT INTO `student` VALUES (21, '6', '吴玉朋', '男', '信息工程', '13980173239\r\n', '123', '已报名');
INSERT INTO `student` VALUES (22, '11', '魏天乐', '男', '信息工程', '13531395626\r\n', '123', '未报名');
INSERT INTO `student` VALUES (23, '12', '曹烨华', '男', '软件工程', '13145013078\r\n', '123', '已报名');
INSERT INTO `student` VALUES (24, '14', '戚媛', '女', '软件工程', '13755420075\r\n', '123', '未报名');
INSERT INTO `student` VALUES (25, '15', '蒋高伟', '男', '信息工程', '13515855961\r\n', '123', '未报名');
INSERT INTO `student` VALUES (26, '16', '曹黛', '女', '软件工程', '13750147067\r\n', '123', '未报名');
INSERT INTO `student` VALUES (27, '17', '尤燕', '女', '信息工程', '13770614086\r\n', '123', '未报名');
INSERT INTO `student` VALUES (28, '8', '周甜', '女', '软件工程', '13977524979\r\n', '123', '已报名');
INSERT INTO `student` VALUES (29, '4', '姜浩天', '男', '信息工程', '13727531114\r\n', '123', '已报名');
INSERT INTO `student` VALUES (33, '123', '王鹏涛', '男', '信息工程', '13545746428\r\n', '123', '未报名');
INSERT INTO `student` VALUES (35, '7', '沈朝海', '男', '软件工程', '13196786042\r\n', '123', '已报名');
INSERT INTO `student` VALUES (36, '9', '秦江霞', '女', '软件工程', '13758169926\r\n', '123', '已报名');
INSERT INTO `student` VALUES (37, '233', '吕启华', '男', '艺术学院', '13545746428\r\n', '123', '未报名');
INSERT INTO `student` VALUES (39, '700', '杨宏', '男', '电气学院', '13971092995\r\n', '123', '未报名');
INSERT INTO `student` VALUES (40, '888', '施木林', '男', '机械工程', '13594528670\r\n', '123', '未报名');
INSERT INTO `student` VALUES (41, '2', '褚俊龙', '男', '电气学院', '13593097175', '123', '已报名');
INSERT INTO `student` VALUES (42, '13', '秦显丽', '女', '艺术学院', '13510327233', '123', '已报名');

-- ----------------------------
-- Table structure for student2
-- ----------------------------
DROP TABLE IF EXISTS `student2`;
CREATE TABLE `student2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `student_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `student_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `student_department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生所在学院',
  `student_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `student_pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `student_sign` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报考与否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student2
-- ----------------------------
INSERT INTO `student2` VALUES (17, '1', '张三', '男', '机械工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (18, '2', '李四', '男', '信息工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (19, '3', '王五', '女', '软件工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (20, '5', '黑夜', '女', '信息工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (21, '6', '白天', '男', '信息工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (22, '11', '星星', '男', '信息工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (23, '12', '太阳', '男', '软件工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (24, '14', '月亮', '女', '软件工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (25, '15', '中子星', '男', '信息工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (26, '16', '白矮星', '女', '软件工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (27, '17', '火星', '女', '信息工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (28, '8', '水星', '女', '软件工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (29, '4', '123', '男', '信息工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (33, '123', '123', '男', '信息工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (34, '666', '123', '男', '软件工程', '123', '123', '未报名');
INSERT INTO `student2` VALUES (35, '7', '123', '男', '软件工程', '123', '123', '已报名');
INSERT INTO `student2` VALUES (36, '9', '123', '女', '软件工程', '123', '123', '已报名');

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : youtinet

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2018-11-06 09:39:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accout
-- ----------------------------
DROP TABLE IF EXISTS `accout`;
CREATE TABLE `accout` (
  `account_id` varchar(12) NOT NULL COMMENT '账号',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `privilege` enum('user','admin') NOT NULL default 'user' COMMENT '角色（用户，管理员）',
  PRIMARY KEY  (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accout
-- ----------------------------
INSERT INTO `accout` VALUES ('admin', 'root', 'admin');

-- ----------------------------
-- Table structure for knowledge_point
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_point`;
CREATE TABLE `knowledge_point` (
  `knowledge_point_id` int(12) unsigned NOT NULL auto_increment COMMENT '知识点id',
  `subject_id` int(12) unsigned NOT NULL COMMENT '所属学科id',
  `knowledge_point` varchar(255) NOT NULL COMMENT '知识点',
  PRIMARY KEY  (`knowledge_point_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `knowledge_point_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_point
-- ----------------------------
INSERT INTO `knowledge_point` VALUES ('1', '1', 'c++ code');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(12) unsigned NOT NULL auto_increment COMMENT '试题id',
  `type_id` int(12) unsigned NOT NULL COMMENT '试题类型id',
  `content` varchar(255) NOT NULL COMMENT '试题内容',
  `answer` varchar(255) NOT NULL COMMENT '试题答案',
  `score` int(2) NOT NULL COMMENT '试题默认分值',
  `difficulity_degree` enum('5','4','3','2','1') NOT NULL COMMENT '难度（1~5）',
  `subject_id` int(12) unsigned NOT NULL COMMENT '所属科目id',
  `knowledge_point_id` int(12) unsigned NOT NULL COMMENT '知识点id',
  PRIMARY KEY  (`question_id`),
  KEY `type_id` (`type_id`),
  KEY `subject_id` (`subject_id`),
  KEY `knowledge_point_id` (`knowledge_point_id`),
  CONSTRAINT `question_ibfk_3` FOREIGN KEY (`knowledge_point_id`) REFERENCES `knowledge_point` (`knowledge_point_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `question_type` (`question_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '1', 'A?B?C?D?', 'A', '2', '1', '1', '1');

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `question_type_id` int(12) unsigned NOT NULL auto_increment COMMENT '问题类型id',
  `question_type` varchar(255) NOT NULL COMMENT '问题类型',
  PRIMARY KEY  (`question_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES ('1', 'choice');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(12) unsigned NOT NULL auto_increment COMMENT '学科id',
  `subject` varchar(255) NOT NULL COMMENT '学科',
  PRIMARY KEY  (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'C++');

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper` (
  `test_paper_id` int(12) unsigned NOT NULL auto_increment COMMENT '试卷id',
  `creator_id` varchar(12) NOT NULL COMMENT '创建者id',
  `subject_id` int(12) unsigned NOT NULL COMMENT '学科id',
  `title` varchar(255) default NULL COMMENT '试卷标题',
  `total_score` int(4) default NULL COMMENT '总分值',
  `difficulity_degree` enum('5','4','3','2','1') default NULL COMMENT '试卷总体难度(1~5)',
  `semester` int(1) default NULL COMMENT '学期',
  `school_year` int(4) default NULL COMMENT '学年',
  PRIMARY KEY  (`test_paper_id`),
  KEY `creator_id` (`creator_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `test_paper_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `accout` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_paper_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_paper
-- ----------------------------

-- ----------------------------
-- Table structure for test_paper_contain
-- ----------------------------
DROP TABLE IF EXISTS `test_paper_contain`;
CREATE TABLE `test_paper_contain` (
  `question_id` int(12) unsigned NOT NULL COMMENT '试题id',
  `test_paper_id` int(12) unsigned NOT NULL COMMENT '试卷id',
  `set_score` int(2) default NULL COMMENT '调整分值，默认null则取问题原本分值',
  KEY `question_id` (`question_id`),
  KEY `test_paper_id` (`test_paper_id`),
  CONSTRAINT `test_paper_contain_ibfk_2` FOREIGN KEY (`test_paper_id`) REFERENCES `test_paper` (`test_paper_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `test_paper_contain_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_paper_contain
-- ----------------------------

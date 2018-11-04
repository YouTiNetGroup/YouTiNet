/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : youtinet

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2018-11-04 16:53:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accout
-- ----------------------------
DROP TABLE IF EXISTS `accout`;
CREATE TABLE `accout` (
  `account_id` varchar(12) NOT NULL COMMENT '账号',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `privilege` enum('user','storeadmin','sysadmin') NOT NULL default 'user' COMMENT '角色（用户，题库管理员，系统管理员）',
  PRIMARY KEY  (`account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accout
-- ----------------------------

-- ----------------------------
-- Table structure for knowledge_point
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_point`;
CREATE TABLE `knowledge_point` (
  `knowledge_point_id` int(12) NOT NULL COMMENT '知识点id',
  `subject_id` int(12) NOT NULL COMMENT '所属学科id',
  `knowledge_point` varchar(255) NOT NULL COMMENT '知识点',
  PRIMARY KEY  (`knowledge_point_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_point
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(12) NOT NULL auto_increment COMMENT '试题id',
  `type_id` int(12) NOT NULL COMMENT '试题类型id',
  `content` varchar(255) NOT NULL COMMENT '试题内容',
  `answer` varchar(255) default NULL COMMENT '试题答案',
  `score` int(2) NOT NULL COMMENT '试题默认分值',
  `difficulity_degree` enum('5','4','3','2','1') NOT NULL COMMENT '难度（1~5）',
  `knowledge_point_id` int(12) NOT NULL COMMENT '知识点id',
  PRIMARY KEY  (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `question_type_id` int(12) NOT NULL COMMENT '问题类型id',
  `question_type` varchar(255) NOT NULL COMMENT '问题类型',
  PRIMARY KEY  (`question_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_type
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(12) NOT NULL COMMENT '学科id',
  `subject` varchar(255) NOT NULL COMMENT '学科',
  PRIMARY KEY  (`subject_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper` (
  `test_paper_id` int(12) NOT NULL auto_increment COMMENT '试卷id',
  `creator_id` varchar(12) NOT NULL COMMENT '创建者id',
  `subject_id` int(12) NOT NULL COMMENT '学科id',
  `title` varchar(255) default NULL COMMENT '试卷标题',
  `total_score` int(4) default NULL COMMENT '总分值',
  PRIMARY KEY  (`test_paper_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_paper
-- ----------------------------

-- ----------------------------
-- Table structure for test_paper_contain
-- ----------------------------
DROP TABLE IF EXISTS `test_paper_contain`;
CREATE TABLE `test_paper_contain` (
  `question_id` int(12) NOT NULL COMMENT '试题id',
  `test_paper_id` int(12) NOT NULL COMMENT '试卷id',
  `set_score` int(2) default NULL COMMENT '调整分值，默认null则取问题原本分值'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_paper_contain
-- ----------------------------

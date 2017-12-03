/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : web_urine

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-28 17:24:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for send_detection
-- ----------------------------
DROP TABLE IF EXISTS `send_detection`;
CREATE TABLE `send_detection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor` varchar(25) DEFAULT NULL COMMENT '申请医生',
  `checker` varchar(25) DEFAULT NULL COMMENT '校验者',
  `verifyer` varchar(25) DEFAULT NULL COMMENT '核对者',
  `send_detection_time` varchar(13) DEFAULT NULL COMMENT '送检日期，对应urine表的创建日期',
  `create_time` varchar(13) DEFAULT NULL COMMENT '创建时间也就是送检的输入日期',
  `update_time` varchar(13) DEFAULT NULL COMMENT '更新时间',
  `urine_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for urine
-- ----------------------------
DROP TABLE IF EXISTS `urine`;
CREATE TABLE `urine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `that_day_no` varchar(11) NOT NULL COMMENT '尿液检测当日号',
  `leu` varchar(50) DEFAULT NULL COMMENT '白细胞',
  `glu` varchar(50) DEFAULT NULL COMMENT '葡萄糖',
  `mca` varchar(50) DEFAULT NULL COMMENT '微量白蛋白',
  `bil` varchar(50) DEFAULT NULL COMMENT '胆红素',
  `ph` varchar(50) DEFAULT NULL COMMENT 'PH值',
  `sg` varchar(50) DEFAULT NULL COMMENT '比重',
  `ket` varchar(50) DEFAULT NULL COMMENT '酮体',
  `pro` varchar(50) DEFAULT NULL COMMENT '蛋白质',
  `nit` varchar(50) DEFAULT NULL COMMENT '亚硝酸盐',
  `uro` varchar(50) DEFAULT NULL COMMENT '胆原',
  `cre` varchar(50) DEFAULT NULL COMMENT '肌酐',
  `bld` varchar(50) DEFAULT NULL COMMENT '潜血',
  `ca` varchar(50) DEFAULT NULL COMMENT '钙离子',
  `vc` varchar(50) DEFAULT NULL COMMENT '抗坏血酸',
  `cal` varchar(50) DEFAULT NULL COMMENT 'CAL 空白',
  `paper_type` varchar(50) DEFAULT NULL COMMENT '试纸型号',
  `create_time` varchar(13) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(13) DEFAULT NULL COMMENT '更新时间',
  `user_id` int(11) DEFAULT NULL,
  `detect_date` varchar(11) NOT NULL,
  `send_detection_id` int(11) DEFAULT NULL,
  `urine_user_id` int(11) DEFAULT NULL,
  `time` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for urine_user
-- ----------------------------
DROP TABLE IF EXISTS `urine_user`;
CREATE TABLE `urine_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` varchar(3) DEFAULT NULL COMMENT '年龄',
  `case_no` varchar(25) DEFAULT NULL COMMENT '病例号',
  `sample_types` varchar(10) DEFAULT NULL COMMENT '样本种类',
  `sample_no` varchar(25) DEFAULT NULL COMMENT '样本号',
  `remarks` varchar(300) DEFAULT NULL COMMENT '对病人的备注',
  `create_time` varchar(13) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(13) DEFAULT NULL COMMENT '更新时间',
  `name` varchar(50) DEFAULT NULL,
  `urine_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL COMMENT '用户名',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(60) NOT NULL COMMENT '密码',
  `create_time` varchar(13) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(13) DEFAULT NULL COMMENT '更新时间',
  `role` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

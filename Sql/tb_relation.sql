/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : ctl

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2018-10-05 13:20:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_relation`;
CREATE TABLE `tb_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `person_id` int(11) NOT NULL COMMENT '村民id',
  `relation_id` int(11) NOT NULL COMMENT '亲属id',
  `optime` datetime DEFAULT NULL,
  `relationship` tinyint(4) NOT NULL COMMENT '1,父亲，2母亲，3配偶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_relation
-- ----------------------------
INSERT INTO `tb_relation` VALUES ('1', '1', '2', '2018-10-02 11:03:29', '1');
INSERT INTO `tb_relation` VALUES ('2', '1', '3', '2018-10-02 11:26:22', '2');

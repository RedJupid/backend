/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-01-08 20:44:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `component` varchar(255) DEFAULT NULL COMMENT '对应路由组件',
  `perms` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `type` char(2) DEFAULT '0' COMMENT '类型 0菜单 1按钮',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', '/', '//', '/sys', 'sys', '1', '2019-12-31 12:06:57', '2020-01-05 16:40:05', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', null, null, null, 'jj', null, '2019-12-31 12:07:16', '2020-01-08 19:43:35', '0');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', null, null, null, null, null, '2019-12-31 12:07:27', null, '0');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', null, null, null, null, null, '2019-12-31 12:07:38', null, '0');
INSERT INTO `sys_menu` VALUES ('5', '2', '用户查看', null, null, null, null, null, '2020-01-03 16:00:41', '2020-01-05 14:55:30', '1');
INSERT INTO `sys_menu` VALUES ('6', '2', '用户新增', null, null, null, null, null, '2020-01-03 16:00:54', '2020-01-05 14:55:32', '1');
INSERT INTO `sys_menu` VALUES ('7', '2', '用户更新', null, null, null, null, null, '2020-01-03 16:01:04', '2020-01-05 14:55:34', '1');
INSERT INTO `sys_menu` VALUES ('8', '2', '用户删除', null, null, null, null, null, '2020-01-03 16:01:14', '2020-01-05 14:55:39', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(30) DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `status` char(1) DEFAULT '1' COMMENT '状态 0锁定 1有效',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sex` char(1) DEFAULT '0' COMMENT '性别 0男 1女 2保密',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2019-12-30 14:27:22', '2019-12-30 15:36:06', '0', null, null);
INSERT INTO `sys_user` VALUES ('3', '001', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2019-12-30 16:12:51', null, '0', null, null);
INSERT INTO `sys_user` VALUES ('4', 'zhangsan', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2020-01-01 12:23:39', '2020-01-01 12:23:49', '0', null, null);
INSERT INTO `sys_user` VALUES ('5', 'lisi', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2020-01-01 12:23:55', null, '0', null, null);
INSERT INTO `sys_user` VALUES ('6', 'wangwu', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2020-01-01 12:24:05', null, '0', null, null);
INSERT INTO `sys_user` VALUES ('7', 'zhaoliu', 'fc1709d0a95a6be30bc5926fdb7f22f4', '1', '2020-01-01 12:24:15', null, '0', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

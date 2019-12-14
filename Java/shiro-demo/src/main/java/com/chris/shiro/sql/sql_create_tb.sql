SET FOREIGN_KEY_CHECKS = 0;

use db_chris_shiro;

# 用户表 users
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
  `id`            bigint(20) NOT NULL AUTO_INCREMENT,
  `username`      varchar(100) DEFAULT NULL,
  `password`      varchar(100) DEFAULT NULL,
  `password_salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_users_username` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

# 用户角色表 user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`
(
  `id`        bigint(20) NOT NULL AUTO_INCREMENT,
  `username`  varchar(100) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_roles` (`username`, `role_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 角色权限表 roles_permissions
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions`
(
  `id`         bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name`  varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_roles_permissions` (`role_name`, `permission`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 插入用户数据
INSERT INTO `users`(username, password)
VALUES ('chris', '123456'),
       ('kaly', '123456');

# 插入用户角色数据
INSERT INTO `user_roles`(username, role_name)
VALUES ('chris', 'admin'),
       ('chris', 'user'),
       ('kaly', 'admin'),
       ('kaly', 'user');

# 插入角色权限数据
INSERT INTO `roles_permissions`(role_name, permission)
VALUES ('admin', 'add'),
       ('admin', 'delete'),
       ('admin', 'update'),
       ('admin', 'select'),
       ('user', 'select');
/*创建数据库语句*/
CREATE database If Not Exists mybatis Character Set UTF8;
use mybatis;

/*创建数据表语句*/
DROP TABLE IF EXISTS `mybatis_user`;
CREATE TABLE `mybatis_user` (
  `id` int not null auto_increment,
  `name` VARCHAR(128) NOT NULL,
  `password` VARCHAR(1280) NOT NULL,
  `sex` TINYINT(1) NOT NULL,
  `birthday` VARCHAR(20) NOT NULL,
  `create_time` DATETIME NOT NULL,
  `user_type` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `mybatis_user_say`;
CREATE TABLE `mybatis_user_say` (
  `id` int not null auto_increment,
  `userId` VARCHAR(128) NOT NULL,
  `say` VARCHAR(1280) NOT NULL,
  `create_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


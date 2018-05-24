-- test_temp 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `test_temp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test_temp`;


-- 테이블 test_temp.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `email` varchar(100) NOT NULL COMMENT '계정',
  `name` varchar(50) NOT NULL COMMENT '이름',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dnq7r8jcmlft7l8l4j79l1h74` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
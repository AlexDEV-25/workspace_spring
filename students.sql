-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for students
CREATE DATABASE IF NOT EXISTS `students` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `students`;

-- Dumping structure for table students.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pw` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table students.accounts: ~2 rows (approximately)
INSERT INTO `accounts` (`id`, `pw`, `active`) VALUES
	('1', '{bcrypt}$2a$12$iIg7EtKfzCvuPMYO5lpCWeEb0bdfs2an/qkwrvY..Zu6EdpXgJ7ae', 1),
	('2', '{bcrypt}$2a$12$M9bzJX9R/QqtI3R.1g31be4TDTzjNu.nWtQL.uBALEyoX67MAy0DC', 1),
	('3', '{bcrypt}$2a$12$8Bou8BVsyVSCqCrQqWNMlO0292DvFxDCqNS0BpU8jMTnTquU0321e', 1);

-- Dumping structure for table students.authorities
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE KEY `username` (`username`,`authority`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table students.authorities: ~3 rows (approximately)
INSERT INTO `authorities` (`username`, `authority`) VALUES
	('alex', 'ROLE_TEACHER'),
	('duc', 'ROLE_ADMIN'),
	('moi', 'ROLE_MANAGER');

-- Dumping structure for table students.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE KEY `id` (`id`,`role`),
  CONSTRAINT `fk_id` FOREIGN KEY (`id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table students.roles: ~2 rows (approximately)
INSERT INTO `roles` (`id`, `role`) VALUES
	('1', 'ROLE_TEACHER'),
	('2', 'ROLE_ADMIN'),
	('3', 'ROLE_MANAGER');

-- Dumping structure for table students.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table students.students: ~3 rows (approximately)
INSERT INTO `students` (`id`, `last_name`, `first_name`, `email`) VALUES
	(1, 'hoang', 'duc', '1'),
	(3, 'tran', 'quynh', '3'),
	(5, 'moi', 'moi', '3ew');

-- Dumping structure for table students.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table students.users: ~3 rows (approximately)
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
	('alex', '{bcrypt}$2a$12$iIg7EtKfzCvuPMYO5lpCWeEb0bdfs2an/qkwrvY..Zu6EdpXgJ7ae', 1),
	('duc', '{bcrypt}$2a$12$M9bzJX9R/QqtI3R.1g31be4TDTzjNu.nWtQL.uBALEyoX67MAy0DC', 1),
	('moi', '{bcrypt}$2a$12$8Bou8BVsyVSCqCrQqWNMlO0292DvFxDCqNS0BpU8jMTnTquU0321e', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

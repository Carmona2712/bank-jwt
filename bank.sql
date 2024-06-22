-- --------------------------------------------------------
-- Host:                         146.190.152.236
-- Versión del servidor:         8.0.37-0ubuntu0.20.04.3 - (Ubuntu)
-- SO del servidor:              Linux
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bank
CREATE DATABASE IF NOT EXISTS `bank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bank`;

-- Volcando estructura para tabla bank.banks
CREATE TABLE IF NOT EXISTS `banks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gfnfs2s5a771weqm28yvb2h5` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.banks: ~3 rows (aproximadamente)
INSERT INTO `banks` (`id`, `name`) VALUES
	(1, 'Bancolombia'),
	(2, 'BBVA'),
	(3, 'DAVIVIENDA');

-- Volcando estructura para tabla bank.banks_users
CREATE TABLE IF NOT EXISTS `banks_users` (
  `banks_id` int NOT NULL,
  `users_id` int NOT NULL,
  KEY `FKdtmue5uhsopnj23t01p9r0np3` (`users_id`),
  KEY `FKlb93q2cdk0jcc8oapv9cpk6el` (`banks_id`),
  CONSTRAINT `FKdtmue5uhsopnj23t01p9r0np3` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKlb93q2cdk0jcc8oapv9cpk6el` FOREIGN KEY (`banks_id`) REFERENCES `banks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.banks_users: ~0 rows (aproximadamente)

-- Volcando estructura para tabla bank.credits
CREATE TABLE IF NOT EXISTS `credits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `number_quotes` int DEFAULT NULL,
  `bank_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt3c6cd1lq2lsiclu6bh2pux2y` (`bank_id`),
  KEY `FKdqrqgej9w17hf6mpkwcf75l1p` (`user_id`),
  CONSTRAINT `FKdqrqgej9w17hf6mpkwcf75l1p` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKt3c6cd1lq2lsiclu6bh2pux2y` FOREIGN KEY (`bank_id`) REFERENCES `banks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.credits: ~0 rows (aproximadamente)

-- Volcando estructura para tabla bank.payments
CREATE TABLE IF NOT EXISTS `payments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `value` double NOT NULL,
  `credit_id` int DEFAULT NULL,
  `quote_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdd5okjd3l4osfucs2vhq6o5yy` (`credit_id`),
  KEY `FKm0g2wkdy2bnkld4fo2wcb0j3b` (`quote_id`),
  KEY `FKj94hgy9v5fw1munb90tar2eje` (`user_id`),
  CONSTRAINT `FKdd5okjd3l4osfucs2vhq6o5yy` FOREIGN KEY (`credit_id`) REFERENCES `credits` (`id`),
  CONSTRAINT `FKj94hgy9v5fw1munb90tar2eje` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKm0g2wkdy2bnkld4fo2wcb0j3b` FOREIGN KEY (`quote_id`) REFERENCES `quotes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.payments: ~0 rows (aproximadamente)

-- Volcando estructura para tabla bank.quotes
CREATE TABLE IF NOT EXISTS `quotes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int DEFAULT NULL,
  `value` double NOT NULL,
  `credit_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm5pfx3pq08tiku3gljt1b0e5x` (`credit_id`),
  CONSTRAINT `FKm5pfx3pq08tiku3gljt1b0e5x` FOREIGN KEY (`credit_id`) REFERENCES `credits` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.quotes: ~0 rows (aproximadamente)

-- Volcando estructura para tabla bank.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.roles: ~3 rows (aproximadamente)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(3, 'ROLE_SUPERVISOR'),
	(2, 'ROLE_USER');

-- Volcando estructura para tabla bank.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `identification` varchar(12) NOT NULL,
  `lastnames` varchar(50) DEFAULT NULL,
  `names` varchar(50) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `status` int NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.users: ~5 rows (aproximadamente)
INSERT INTO `users` (`id`, `create_at`, `email`, `identification`, `lastnames`, `names`, `password`, `status`, `telephone`, `username`) VALUES
	(1, NULL, 'admin@gmail.com', '123456789', 'Ronaldo', 'Cristiano', '$2a$10$BmQbuFHbH5TXmOpP6oTSdu7nTS2yKHdEtinPD9nyjsK5DfyNzmH9O', 1, '123456789', 'admin'),
	(2, NULL, 'user@gmail.com', '123456789', 'Iker', 'Casillas', '$2a$10$BmQbuFHbH5TXmOpP6oTSdu7nTS2yKHdEtinPD9nyjsK5DfyNzmH9O', 1, '123456789', 'casillas'),
	(9, '2024-06-22 09:49:20', 'valdez@gmail.com', '123456789', 'Valdez', 'Victor', '$2a$10$BmQbuFHbH5TXmOpP6oTSdu7nTS2yKHdEtinPD9nyjsK5DfyNzmH9O', 1, '123456789', 'vvaldez'),
	(10, '2024-06-22 09:51:32', 'messi@gmail.com', '123456789', 'Messi', 'Lionel', '$2a$10$ePvW1qvFiBPqpj45mfSYWOWRXZi6XvOv2FITPhmh3AhFQs8Ez7FNi', 1, '123456789', 'messi'),
	(11, '2024-06-22 15:02:17', 'carmona@unicesar.edu.co', '123456789', 'Carmona', 'Ricardo', '$2a$10$8GZ4nURzbSw5KuIpPJQNaeOs2hc566ta6w.RXNLaJOEJ6xogS6Qdy', 1, '123456789', 'racarmona');

-- Volcando estructura para tabla bank.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `users_id` int NOT NULL,
  `roles_id` int NOT NULL,
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  KEY `FKml90kef4w2jy7oxyqv742tsfc` (`users_id`),
  CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKml90kef4w2jy7oxyqv742tsfc` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla bank.users_roles: ~6 rows (aproximadamente)
INSERT INTO `users_roles` (`users_id`, `roles_id`) VALUES
	(1, 1),
	(2, 2),
	(9, 2),
	(10, 2),
	(11, 2),
	(1, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

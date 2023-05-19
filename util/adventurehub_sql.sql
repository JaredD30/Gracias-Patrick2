CREATE TABLE `activity`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `itinerary_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKhvx3oujjdyivpostrag6mu5dj`(`itinerary_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `category`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `conversation`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `start_date` datetime(6) NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `conversation_user`  (
  `conversation_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`conversation_id`, `user_id`) USING BTREE,
  INDEX `FK7a8r5xrna8m6olvhkj8gpbea7`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `destination`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `itinerary`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `day` int NOT NULL,
  `latitude` double NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `longitude` double NULL DEFAULT NULL,
  `trip_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK22q6j4brr03x925d5x17vsvql`(`trip_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `message`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `conversation_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK6yskk3hxw5sklwgi25y6d5u1l`(`conversation_id` ASC) USING BTREE,
  INDEX `FKniyd36ew6bt4u7vkqn723knha`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `notification`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sent_date` datetime(6) NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'A',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `conversation_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK7q7kak85s8s7bk464k9ytwf6d`(`conversation_id` ASC) USING BTREE,
  INDEX `FKfhwnw6e21l4eisqi3uf5yfmfm`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `payment`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NULL DEFAULT NULL,
  `paymentDate` datetime(6) NULL DEFAULT NULL,
  `paymentMethod` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `reservation_id` bigint NOT NULL,
  -- `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKrewpj5f9v9xehy4ga8g221nw1`(`reservation_id` ASC) USING BTREE,
  -- INDEX `FKkqfrh2yp7mwo3fkqottnjdpul`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `rating`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rating` int NOT NULL,
  `trip_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKh9iqu0kywm9n2aobfh7651r4x`(`trip_id` ASC) USING BTREE,
  INDEX `FK8p9hf7gdflvjlfntqu6v4w52t`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `reservation`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number_of_people` int NULL DEFAULT NULL,
  `reservation_date` datetime(6) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `trip_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKbnq7qaveg8wkoee526abhsykn`(`trip_id` ASC) USING BTREE,
  INDEX `FKf0xcjhvt0kidlgegr8ukg6kop`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `season`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `trip`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `end_date` datetime(6) NULL DEFAULT NULL,
  `group_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `start_date` datetime(6) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `destination_id` bigint NOT NULL,
  `season_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKcb5nxtuyobn1auba9gpj7x0mx`(`category_id` ASC) USING BTREE,
  INDEX `FKbi8kx7b2oumil3iksafnbyp5o`(`destination_id` ASC) USING BTREE,
  INDEX `FKi1lpy9sp6trals566wy2xybi9`(`season_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `trip_details`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imageUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `trip_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKdy4pkxvnusikqr7cfgtnlv9tg`(`trip_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

ALTER TABLE `activity` ADD CONSTRAINT `FKhvx3oujjdyivpostrag6mu5dj` FOREIGN KEY (`itinerary_id`) REFERENCES `itinerary` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `conversation_user` ADD CONSTRAINT `FK7a8r5xrna8m6olvhkj8gpbea7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `conversation_user` ADD CONSTRAINT `FKb71b5q60yd0bfc1eb8fgwm4sk` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `itinerary` ADD CONSTRAINT `FK22q6j4brr03x925d5x17vsvql` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `message` ADD CONSTRAINT `FK6yskk3hxw5sklwgi25y6d5u1l` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `message` ADD CONSTRAINT `FKniyd36ew6bt4u7vkqn723knha` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `notification` ADD CONSTRAINT `FK7q7kak85s8s7bk464k9ytwf6d` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `notification` ADD CONSTRAINT `FKfhwnw6e21l4eisqi3uf5yfmfm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- ALTER TABLE `payment` ADD CONSTRAINT `FKkqfrh2yp7mwo3fkqottnjdpul` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `payment` ADD CONSTRAINT `FKrewpj5f9v9xehy4ga8g221nw1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `rating` ADD CONSTRAINT `FK8p9hf7gdflvjlfntqu6v4w52t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `rating` ADD CONSTRAINT `FKh9iqu0kywm9n2aobfh7651r4x` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `reservation` ADD CONSTRAINT `FKbnq7qaveg8wkoee526abhsykn` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `reservation` ADD CONSTRAINT `FKf0xcjhvt0kidlgegr8ukg6kop` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `trip` ADD CONSTRAINT `FKbi8kx7b2oumil3iksafnbyp5o` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `trip` ADD CONSTRAINT `FKcb5nxtuyobn1auba9gpj7x0mx` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `trip` ADD CONSTRAINT `FKi1lpy9sp6trals566wy2xybi9` FOREIGN KEY (`season_id`) REFERENCES `season` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `trip_details` ADD CONSTRAINT `FKdy4pkxvnusikqr7cfgtnlv9tg` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;


CREATE TABLE board (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `title` TEXT NOT NULL,
    `content` TEXT NOT NULL,
    `user_id` BIGINT(20) NOT NULL,
    `updateAt`datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `board_index` (createdAt)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `image_url` VARCHAR(200) NOT NULL,
    `provider_type` TINYINT NOT NULL,
    `updated_at`datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `user_index` (email)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO user (email, name, image_url, provider_type) values ('haha@haha.com', 'hdhdhd', 'https://www.naver.com', 1)
CREATE TABLE board (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `title` TEXT NOT NULL,
    `content` TEXT NOT NULL,
    `user_id` BIGINT(20) NOT NULL,
    `post_parent_id` BIGINT(20),
    `cnt_accu_visitor` BIGINT(20),
    `cnt_visitor` BIGINT(20),
    `board_tags` TEXT,
    `post_type` TINYINT NOT NULL,
    `modified_time`datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `board_index` (created_time)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tag (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user (
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `image_url` VARCHAR(200),
    `provider_type` TINYINT NOT NULL,
    `modified_time`datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    INDEX `user_index` (email)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO user (email, name, image_url, provider_type) values ('haha@haha.com', 'hdhdhd', 'https://www.naver.com', 1)
CREATE TABLE `account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` ENUM('WECHAT') NOT NULL,
  `ext_identifier` VARCHAR(64) NOT NULL,
  `ext_name` VARCHAR(64) NOT NULL,
  `avatar` VARCHAR(255) NULL,
  `status` ENUM('SUBSCRIBED', 'UNSUBSCRIBED') NOT NULL,
  `created_at` DATETIME(3) NOT NULL,
  `updated_at` DATETIME(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uk_type_ext_id` (`type` ASC, `ext_identifier` ASC))
  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

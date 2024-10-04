CREATE TABLE IF NOT EXISTS `user_characters` (
  `account_username` varchar(40) NOT NULL,
  `user_character` varchar(40) NOT NULL,
  PRIMARY KEY (`user_character`, `account_username`),
        CONSTRAINT `fk_users_username` FOREIGN KEY (`account_username`) REFERENCES `users` (`user_name`),
        CONSTRAINT `fk_characters_name` FOREIGN KEY (`user_character`) REFERENCES `characters` (`name`)
  );
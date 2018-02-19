SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema access_log
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `access_log` DEFAULT CHARACTER SET utf8 ;
USE `access_log` ;

-- -----------------------------------------------------
-- Table `access_log`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `access_log`.`request` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `remote_address` VARCHAR(15) NOT NULL,
  `method` VARCHAR(100) NOT NULL,
  `response_status` INT UNSIGNED NOT NULL,
  `user_agent` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `access_log`.`blocked_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `access_log`.`blocked_address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ip` VARCHAR(15) NOT NULL,
  `reason` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

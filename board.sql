-- MySQL Script generated by MySQL Workbench
-- 06/07/17 17:32:27
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`admin` ;

CREATE TABLE IF NOT EXISTS `mydb`.`admin` (
  `id` INT(6) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`type` (
  `id` INT(6) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `explain` VARCHAR(300) NULL,
  `contenttime` VARCHAR(35) NULL,
  `num` INT(8) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`music`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`music` ;

CREATE TABLE IF NOT EXISTS `mydb`.`music` (
  `id` INT(6) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `path` VARCHAR(300) NOT NULL,
  `click` INT(10) NOT NULL,
  `contentTime` VARCHAR(45) NULL,
  `explain` VARCHAR(200) NULL,
  `lid` INT(4) NULL,
  `count` INT(8) NULL,
  `type_id` INT(6) NOT NULL,
  `type_id1` INT(6) NOT NULL,
  PRIMARY KEY (`id`, `type_id`, `type_id1`),
  INDEX `fk_music_type1_idx` (`type_id1` ASC),
  CONSTRAINT `fk_music_type1`
    FOREIGN KEY (`type_id1`)
    REFERENCES `mydb`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`comment` ;

CREATE TABLE IF NOT EXISTS `mydb`.`comment` (
  `id` INT(6) NOT NULL,
  `contentText` VARCHAR(250) NULL,
  `contentTime` VARCHAR(45) NULL,
  `name` VARCHAR(45) NOT NULL,
  `pid` INT(4) NULL,
  `music_id` INT(6) NOT NULL,
  `music_type_id` INT(6) NOT NULL,
  PRIMARY KEY (`id`, `music_id`, `music_type_id`),
  INDEX `fk_comment_music1_idx` (`music_id` ASC, `music_type_id` ASC),
  CONSTRAINT `fk_comment_music1`
    FOREIGN KEY (`music_id` , `music_type_id`)
    REFERENCES `mydb`.`music` (`id` , `type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`systems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`systems` ;

CREATE TABLE IF NOT EXISTS `mydb`.`systems` (
  `id` INT(6) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `logopath` VARCHAR(300) NULL,
  `notice` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

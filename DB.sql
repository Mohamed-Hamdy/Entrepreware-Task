-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema coligo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema coligo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coligo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `coligo` ;

-- -----------------------------------------------------
-- Table `coligo`.`announcement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coligo`.`announcement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `instructor` VARCHAR(255) NULL DEFAULT NULL,
  `course_name` VARCHAR(255) NULL DEFAULT NULL,
  `course_code` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coligo`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coligo`.`hibernate_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coligo`.`quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coligo`.`quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `instructor` VARCHAR(255) NULL DEFAULT NULL,
  `course_name` VARCHAR(255) NULL DEFAULT NULL,
  `course_code` VARCHAR(255) NULL DEFAULT NULL,
  `topic` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `deadline` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `coligo`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coligo`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contact_number` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

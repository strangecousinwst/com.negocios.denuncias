-- MySQL Sdenunciacript generated by MySQL Workbench
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema efa0124_ms_denuncia
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `efa0124_ms_denuncia` ;

-- -----------------------------------------------------
-- Schema efa0124_ms_denuncia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `efa0124_ms_denuncia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `efa0124_ms_denuncia` ;

-- -----------------------------------------------------
-- Table `efa0124_ms_denuncia`.`tipo_denuncia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `efa0124_ms_denuncia`.`tipo_denuncia` ;

CREATE TABLE IF NOT EXISTS `efa0124_ms_denuncia`.`tipo_denuncia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `is_active` TINYINT DEFAULT 1,
PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `efa0124_ms_denuncia`.`denuncia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `efa0124_ms_denuncia`.`denuncia` ;

CREATE TABLE IF NOT EXISTS `efa0124_ms_denuncia`.`denuncia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NOT NULL,
  `denunciador_id` INT NOT NULL,
  `denunciado_id` INT NULL DEFAULT NULL,
  `data` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tipo_denuncia_id` INT NOT NULL,
  `is_active` TINYINT DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_denuncia_tipo_denuncia_idx` (`tipo_denuncia_id` ASC) VISIBLE,
  CONSTRAINT `fk_denuncia_tipo_denuncia`
    FOREIGN KEY (`tipo_denuncia_id`)
    REFERENCES `efa0124_ms_denuncia`.`tipo_denuncia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Inserts table `efa0124_ms_denuncia`.`denuncia`
-- -----------------------------------------------------
INSERT INTO `tipo_denuncia` (`descricao`) VALUES
('denuncia_comentario'),
('denuncia_publicacao'),
('denuncia_utilizador'),
('sinalazacao_comentario'),
('sinalizacao_publicacao'),
('sinalizacao_utilizador');

-- -----------------------------------------------------
-- Inserts table `efa0124_ms_denuncia`.`denuncia`
-- -----------------------------------------------------
INSERT INTO `denuncia` (`descricao`, `denunciador_id`, `denunciado_id`, `data`, `tipo_denuncia_id`, `is_active`) VALUES
('Usuário enviou mensagens insistentes', 103, 245, '2025-02-10 14:30:00', 1, 1),
('Postagem com conteúdo adulto inapropriado', 156, 302, '2025-02-15 09:45:22', 2, 1),
('Múltiplas mensagens promocionais não solicitadas', 124, 198, '2025-03-01 16:20:15', 3, 1),
('Tentativa de phishing através de publicação', 210, 433, '2025-03-10 11:05:37', 4, 1),
('Ameaças de violência física em comentário', 189, 267, '2025-03-12 19:50:42', 5, 1),
('Comentários racistas em publicação', 145, 321, '2025-03-20 13:25:19', 6, 1),
('Disseminação de notícia comprovadamente falsa', 178, 219, '2025-03-25 10:15:33', 7, 1),
('Utilização de bot para automação não permitida', 202, 154, '2025-04-02 08:40:11', 8, 1),
('Perfil com múltiplas violações de diretrizes', 132, 287, '2025-04-05 17:30:48', 1, 1),
('Publicação promovendo atividade ilícita', 167, 309, '2025-04-10 12:55:27', 4, 0);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

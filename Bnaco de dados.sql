-- MySQL Script generated by MySQL Workbench
-- Thu Sep  1 07:47:17 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionarios` (
  `idFuncionario` INT NOT NULL,
  `NomeFuncionario` VARCHAR(35) NOT NULL,
  `EmailFunc` VARCHAR(35) NOT NULL,
  `SenhaFunc` VARCHAR(20) NOT NULL,
  `tipoAcesso` CHAR(1) NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE INDEX `idFuncionario_UNIQUE` (`idFuncionario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Clientes` (
  `idCliente` INT NOT NULL,
  `NomeClientel` VARCHAR(35) NOT NULL,
  `CPFCliente` VARCHAR(14) NOT NULL,
  `TelefoneCliente` VARCHAR(22) NOT NULL,
  `EmailCliente` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Venda` (
  `idVenda` INT NOT NULL,
  `QuantidadeVenda` INT NOT NULL,
  `ValorVenda` DOUBLE NOT NULL,
  `FormaPagamento` VARCHAR(20) NOT NULL,
  `DataVenda` DATE NOT NULL,
  `Funcionarios_idFuncionario` INT NOT NULL,
  `Clientes_idCliente` INT NOT NULL,
  PRIMARY KEY (`idVenda`, `Funcionarios_idFuncionario`, `Clientes_idCliente`),
  UNIQUE INDEX `idVenda_UNIQUE` (`idVenda` ASC),
  INDEX `fk_Venda_Funcionarios1_idx` (`Funcionarios_idFuncionario` ASC),
  INDEX `fk_Venda_Clientes1_idx` (`Clientes_idCliente` ASC),
  CONSTRAINT `fk_Venda_Funcionarios1`
    FOREIGN KEY (`Funcionarios_idFuncionario`)
    REFERENCES `mydb`.`Funcionarios` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Clientes1`
    FOREIGN KEY (`Clientes_idCliente`)
    REFERENCES `mydb`.`Clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `idFornecedor` INT NOT NULL,
  `NomeFornecedor` VARCHAR(30) NOT NULL,
  `TelefoneFornecedor` VARCHAR(17) NOT NULL,
  `EmailFornecedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFornecedor`),
  UNIQUE INDEX `idFornecedor_UNIQUE` (`idFornecedor` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produtos` (
  `idProdutos` INT NOT NULL,
  `PrešoProduto` DOUBLE NOT NULL,
  `Nome` VARCHAR(30) NOT NULL,
  `qt_estoque` INT NOT NULL,
  `Autor` VARCHAR(25) NOT NULL,
  `Genero` VARCHAR(15) NOT NULL,
  `Fornecedor_idFornecedor` INT NOT NULL,
  PRIMARY KEY (`idProdutos`, `Fornecedor_idFornecedor`),
  UNIQUE INDEX `idProdutos_UNIQUE` (`idProdutos` ASC),
  INDEX `fk_Produtos_Fornecedor1_idx` (`Fornecedor_idFornecedor` ASC),
  CONSTRAINT `fk_Produtos_Fornecedor1`
    FOREIGN KEY (`Fornecedor_idFornecedor`)
    REFERENCES `mydb`.`Fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produtos_has_Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produtos_has_Venda` (
  `Produtos_idProdutos` INT NOT NULL,
  `Venda_idVenda` INT NOT NULL,
  PRIMARY KEY (`Produtos_idProdutos`, `Venda_idVenda`),
  INDEX `fk_Produtos_has_Venda_Venda1_idx` (`Venda_idVenda` ASC),
  INDEX `fk_Produtos_has_Venda_Produtos1_idx` (`Produtos_idProdutos` ASC),
  CONSTRAINT `fk_Produtos_has_Venda_Produtos1`
    FOREIGN KEY (`Produtos_idProdutos`)
    REFERENCES `mydb`.`Produtos` (`idProdutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_has_Venda_Venda1`
    FOREIGN KEY (`Venda_idVenda`)
    REFERENCES `mydb`.`Venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

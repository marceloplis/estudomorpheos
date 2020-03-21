SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `estudomorpheos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `estudomorpheos` ;

-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbUnidadePesquisa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbUnidadePesquisa` (
  `idUnidadePesquisa` INT NOT NULL AUTO_INCREMENT,
  `dsUnidade` VARCHAR(100) NOT NULL,
  `siglaUnidade` VARCHAR(20) NULL,
  `telUnidade` VARCHAR(13) NULL,
  `endereco` VARCHAR(100) NULL,
  `cidade` VARCHAR(100) NULL,
  `uf` CHAR(2) NULL,
  `cep` VARCHAR(10) NULL,
  `investigador` VARCHAR(100) NULL,
  `coordenador` VARCHAR(100) NULL,
  `email` VARCHAR(200) NULL,
  `nuUnidade` INT NULL,
  PRIMARY KEY (`idUnidadePesquisa`),
  UNIQUE INDEX `idUnidadePesquisa_UNIQUE` (`idUnidadePesquisa` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbPaciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbPaciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `idUnidadePesquisa` INT NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NULL,
  `iniciaisNome` VARCHAR(10) NOT NULL,
  `nuRegistroProtocolo` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `nuEndereco` INT NULL,
  `complEndereco` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(100) NULL,
  `uf` VARCHAR(2) NULL,
  `cep` VARCHAR(10) NULL,
  `telResidencial` VARCHAR(14) NULL,
  `telCelular` VARCHAR(14) NULL,
  `telTrabalho` VARCHAR(14) NULL,
  `telRecado` VARCHAR(14) NULL,
  `pessoaRecado` VARCHAR(45) NULL,
  `profissao` VARCHAR(45) NULL,
  `dtNascimento` DATE NULL,
  `escolaridade` INT NULL,
  `raca` INT NULL,
  `sexo` CHAR NULL,
  `flAtivo` CHAR NULL,
  `dtInclusao` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPaciente`),
  UNIQUE INDEX `idPaciente_UNIQUE` (`idPaciente` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  INDEX `FKPacienteUnidadePesquisa` (`idUnidadePesquisa` ASC),
  CONSTRAINT `FKPacienteUnidadePesquisa`
    FOREIGN KEY (`idUnidadePesquisa`)
    REFERENCES `estudomorpheos`.`TbUnidadePesquisa` (`idUnidadePesquisa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita` (
  `idVisita` INT NOT NULL AUTO_INCREMENT,
  `nuVisita` INT NOT NULL,
  `idPaciente` INT NOT NULL,
  `dtInclusao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dtRealizacao` DATE NOT NULL,
  `assinaturaAprovador` VARCHAR(20) NULL,
  `dtAssinaturaAprovacao` DATETIME NULL,
  `stAprovacao` CHAR(1) NULL DEFAULT 'P',
  PRIMARY KEY (`idVisita`),
  UNIQUE INDEX `idxIdVisita` (`idVisita` ASC),
  UNIQUE INDEX `idxVisita_Paciente` (`nuVisita` ASC, `idPaciente` ASC),
  INDEX `idxFKVisitaPaciente` (`idPaciente` ASC),
  CONSTRAINT `FKVisitaPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `estudomorpheos`.`TbPaciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita00`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita00` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAssinaturaTCLE` CHAR(1) NULL,
  `dtAssinaturaTCLE` DATE NULL,
  `PER_V00_CI01` CHAR(1) NULL,
  `PER_V00_CI02` CHAR(1) NULL,
  `PER_V00_CE01` CHAR(1) NULL,
  `PER_V00_CE02` CHAR(1) NULL,
  `PER_V00_CE03` CHAR(1) NULL,
  `PER_V00_CE04` CHAR(1) NULL,
  `PER_V00_CE05` CHAR(1) NULL,
  `PER_V00_CE06` CHAR(1) NULL,
  `PER_V00_CE07` CHAR(1) NULL,
  `PER_V00_CE08` CHAR(1) NULL,
  `PER_V00_CE09` CHAR(1) NULL,
  `PER_V00_CE10` CHAR(1) NULL,
  `PER_V00_AA01` DECIMAL(5,2) NULL,
  `PER_V00_AA02` DECIMAL(5,2) NULL,
  `PER_V00_AA03` DECIMAL(5,2) NULL,
  `PER_V00_AA04` INT NULL,
  `PER_V00_AA05` INT NULL,
  `PER_V00_AA06` INT NULL,
  `PER_V00_DP01` INT NULL,
  `PER_V00_DP02` INT NULL,
  `PER_V00_DP03` CHAR(1) NULL,
  `PER_V00_DP04` CHAR(1) NULL,
  `PER_V00_DP05` CHAR(1) NULL,
  `PER_V00_DP06` INT NULL,
  `PER_V00_DP07` INT NULL,
  `PER_V00_DP08` CHAR(1) NULL,
  `PER_V00_DP09` CHAR(1) NULL,
  `PER_V00_DP10` INT NULL,
  `PER_V00_DP11` CHAR(1) NULL,
  `PER_V00_DP12` CHAR(1) NULL,
  `PER_V00_DP13` CHAR(1) NULL,
  `PER_V00_DP14` INT NULL,
  INDEX `idxFKVisita00` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita00`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita02`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita02` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAdesaoTratamentoMedicamentoso` CHAR(1) NULL,
  `pcTotalAdesao` DECIMAL(5,2) NULL,
  INDEX `idxFKVisita01` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita01`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita03`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita03` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flHasControlada` CHAR(1) NULL,
  INDEX `idxFKVisita02` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita02`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita01`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita01` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAOSPoligrafia` CHAR(1) NULL,
  INDEX `idxFKVisita03` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita03`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita04`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita04` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAdesaoMedicamentos` CHAR(1) NULL,
  `pcAdesaoMedicamentos` DECIMAL(5,2) NULL,
  `flRandomizacao` CHAR(1) NULL,
  `tpGrupoRandomizacao` INT NULL,
  `flAceiteRandomizacao` CHAR(1) NULL,
  `observacao` VARCHAR(200) NULL,
  `observacaoRandomizacao` VARCHAR(200) NULL,
  INDEX `idxFKVisita04` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita04`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita05`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita05` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `pressaoCPAP` DECIMAL(5,2) NULL,
  `tpMascara` INT NULL,
  `tamMascara` CHAR(1) NULL,
  INDEX `idxFKVisita05` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita05`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita06`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita06` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAdaptacaoDoisGrupos` CHAR(1) NULL,
  `flCPAPEntregue` CHAR(1) NULL,
  `flDilatadorEntregue` CHAR(1) NULL,
  INDEX `idxFKVisita06` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita06`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita07`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita07` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita07` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita07`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita08`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita08` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita08` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita08`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita09`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita09` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita09` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita09`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita10`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita10` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita10` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita10`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita11`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita11` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita11` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita11`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita12`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita12` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita12` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita12`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita13`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita13` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita13` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita13`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita14`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita14` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita14` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita14`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita15`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita15` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita15` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita15`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita16`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita16` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flHasControlada` CHAR(1) NULL,
  INDEX `idxFKVisita16` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita16`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisita17`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisita17` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  INDEX `idxFKVisita17` (`idVisita` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `FKVisita17`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbDoencaEvento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbDoencaEvento` (
  `idDoencaEvento` INT NOT NULL AUTO_INCREMENT,
  `dsDoenca` VARCHAR(100) NOT NULL,
  `siglaDoenca` VARCHAR(10) NULL,
  PRIMARY KEY (`idDoencaEvento`),
  UNIQUE INDEX `idDoencaEvento_UNIQUE` (`idDoencaEvento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbEventoAdverso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbEventoAdverso` (
  `idEventoAdverso` INT NOT NULL AUTO_INCREMENT,
  `idDoenca` INT NOT NULL,
  `idPaciente` INT NOT NULL,
  `dtInclusao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dtInicio` DATE NULL,
  `dtFim` DATE NULL,
  `PER_E01` CHAR(1) NULL COMMENT 'O evento adverso foi considerado sério?      Sim|___|       Não|___|',
  `PER_E02` VARCHAR(300) NULL COMMENT 'Providências Tomadas: ',
  `PER_E03` VARCHAR(300) NULL COMMENT 'Evolução: ',
  `PER_E04` CHAR(1) NULL COMMENT 'O evento adverso está relacionado aos tratamentos do estudo? \n|__|Sim                                                              |__|N�' /* comment truncated */ /*o
|__|Provavelmente Sim                                  |__|Provavelmente Não*/,
  `observacao` VARCHAR(100) NULL,
  `stAprovacao` CHAR(1) NULL DEFAULT 'P',
  `assinatura` VARCHAR(20) NULL,
  `dtAssinatura` DATETIME NULL,
  `nuVisita` INT NULL,
  PRIMARY KEY (`idEventoAdverso`),
  UNIQUE INDEX `idEventoAdverso_UNIQUE` (`idEventoAdverso` ASC),
  INDEX `FkEventoDoenca` (`idDoenca` ASC),
  INDEX `FkEventoPaciente` (`idPaciente` ASC),
  CONSTRAINT `FkEventoDoenca`
    FOREIGN KEY (`idDoenca`)
    REFERENCES `estudomorpheos`.`TbDoencaEvento` (`idDoencaEvento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FkEventoPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `estudomorpheos`.`TbPaciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbSaidaEstudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbSaidaEstudo` (
  `idSaidaEstudo` INT NOT NULL AUTO_INCREMENT,
  `idPaciente` INT NOT NULL,
  `dtInclusao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nuVisita` INT(11) NULL,
  `dtSaida` DATE NOT NULL,
  `dtOcorrencia` DATE NULL,
  `motivo` INT NULL,
  `flEvolucaoObito` CHAR(1) NULL,
  `stAprovacao` CHAR(1) NULL,
  `assinatura` VARCHAR(20) NULL,
  `dtAssinatura` DATETIME NULL,
  `observacao` VARCHAR(200) NULL,
  PRIMARY KEY (`idSaidaEstudo`),
  UNIQUE INDEX `idSaidaEstudo_UNIQUE` (`idSaidaEstudo` ASC),
  INDEX `FKSaidaEstudoPaciente` (`idPaciente` ASC),
  CONSTRAINT `FKSaidaEstudoPaciente`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `estudomorpheos`.`TbPaciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbPerfilAcesso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbPerfilAcesso` (
  `idPerfilAcesso` INT NOT NULL AUTO_INCREMENT,
  `dsPerfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPerfilAcesso`),
  UNIQUE INDEX `idPerfilAcesso_UNIQUE` (`idPerfilAcesso` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbUsuarioSistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbUsuarioSistema` (
  `idUsuarioSistema` INT NOT NULL AUTO_INCREMENT,
  `idUnidadePesquisa` INT NULL,
  `idPerfil` INT NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL,
  `flSenhaTemporaria` CHAR(1) NOT NULL,
  `flAtivo` CHAR(1) NOT NULL,
  `fone` VARCHAR(14) NULL,
  `dtInclusao` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `admin` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuarioSistema`),
  UNIQUE INDEX `idUsuarioSistema_UNIQUE` (`idUsuarioSistema` ASC),
  INDEX `FKUsuarioSistemaUnidadePesquisa` (`idUnidadePesquisa` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `FKusuarioSistemaPerfilAcesso` (`idPerfil` ASC),
  CONSTRAINT `FKUsuarioSistemaUnidadePesquisa`
    FOREIGN KEY (`idUnidadePesquisa`)
    REFERENCES `estudomorpheos`.`TbUnidadePesquisa` (`idUnidadePesquisa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FKusuarioSistemaPerfilAcesso`
    FOREIGN KEY (`idPerfil`)
    REFERENCES `estudomorpheos`.`TbPerfilAcesso` (`idPerfilAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbAuditoriaEstudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbAuditoriaEstudo` (
  `idAuditoriaEstudo` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `dtModificacao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tpModificacao` CHAR(1) NOT NULL COMMENT 'U=Alteração | I=Inclusão | A=Aprovação | E=Exclusão',
  `dsModificacao` VARCHAR(200) NULL,
  `tpEntidade` CHAR(1) NOT NULL COMMENT 'V=Visita | E=Evento Adverso | S=Saída do Estudo',
  `idPaciente` INT NOT NULL,
  PRIMARY KEY (`idAuditoriaEstudo`),
  UNIQUE INDEX `idAuditoriaVisita_UNIQUE` (`idAuditoriaEstudo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestPressaoArterial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestPressaoArterial` (
  `idPressaoArterial` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_PA00` CHAR(1) NULL COMMENT 'Braço []Direito []Esquerdo',
  `PER_PA01A` VARCHAR(45) NULL COMMENT 'Pressão Arterial',
  `PER_PA01B` INT NULL COMMENT 'Frequencia Cardiaca',
  `PER_PA02A` VARCHAR(45) NULL COMMENT 'Pressão Arterial',
  `PER_PA02B` INT NULL COMMENT 'Frequencia Cardiaca',
  `PER_PA03A` VARCHAR(45) NULL COMMENT 'Pressão Arterial',
  `PER_PA03B` INT NULL COMMENT 'Frequencia Cardiaca',
  `PER_PA04A` VARCHAR(45) NULL COMMENT 'Pressão Arterial',
  `PER_PA04B` INT NULL COMMENT 'Frequencia Cardiaca',
  `PER_PA05A` VARCHAR(45) NULL COMMENT 'Pressão Arterial',
  `PER_PA05B` INT NULL COMMENT 'Frequencia Cardiaca',
  `PER_PA06` VARCHAR(45) NULL COMMENT 'Média PA',
  PRIMARY KEY (`idPressaoArterial`),
  UNIQUE INDEX `idPressaoArterial_UNIQUE` (`idPressaoArterial` ASC),
  INDEX `FKPressaoArterialVisita` (`idVisita` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  CONSTRAINT `FKPressaoArterialVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestAplicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestAplicacao` (
  `idQuestionarioAplicacao` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_QA01` INT NULL COMMENT 'Sentado e Lendo',
  `PER_QA02` INT NULL COMMENT 'Assistindo TV',
  `PER_QA03` INT NULL COMMENT 'Sentado em lugar público',
  `PER_QA04` INT NULL COMMENT 'como passageiro',
  `PER_QA05` INT NULL COMMENT 'deitnado-se para descançar à tarde',
  `PER_QA06` INT NULL COMMENT 'Sentado e conversando',
  `PER_QA07` INT NULL COMMENT 'Sentado após almoço',
  `PER_QA08` INT NULL COMMENT 'Dirigindo',
  `PER_QA09` CHAR(1) NULL COMMENT 'Sonolência diurna',
  `PER_QA10` VARCHAR(45) NULL COMMENT 'Escala de sonolencia',
  `PER_QA11` INT NULL COMMENT 'Quantas horas em média dorme por dia',
  PRIMARY KEY (`idQuestionarioAplicacao`),
  UNIQUE INDEX `idQuestionarioAplicacao_UNIQUE` (`idQuestionarioAplicacao` ASC),
  INDEX `FKQuestionarioAplicacaoVisita` (`idVisita` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  CONSTRAINT `FKQuestionarioAplicacaoVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestBerlim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestBerlim` (
  `idQuestionarioBerlim` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_QB01` INT NULL,
  `PER_QB02` INT NULL,
  `PER_QB03` INT NULL,
  `PER_QB04` INT NULL,
  `PER_QB05` CHAR(1) NULL,
  `PER_QB06` INT NULL,
  `PER_QB07` INT NULL,
  `PER_QB08` INT NULL,
  `PER_QB09A` INT NULL,
  `PER_QB09B` INT NULL,
  `PER_QB10` INT NULL,
  `PER_QB11` CHAR(1) NULL,
  `CAT_01` CHAR(1) NULL,
  `CAT_02` CHAR(1) NULL,
  `CAT_03` CHAR(1) NULL,
  `resultado` INT NULL,
  PRIMARY KEY (`idQuestionarioBerlim`),
  UNIQUE INDEX `idQuestionarioBerlim_UNIQUE` (`idQuestionarioBerlim` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKQuestionarioBerlimVisita` (`idVisita` ASC),
  CONSTRAINT `FKQuestionarioBerlimVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestCAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestCAGE` (
  `idQuestionarioCAGE` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_QC01` CHAR(1) NULL,
  `PER_QC02` CHAR(1) NULL,
  `PER_QC03` CHAR(1) NULL,
  `PER_QC04` CHAR(1) NULL,
  `flPositivo` CHAR(1) NULL,
  PRIMARY KEY (`idQuestionarioCAGE`),
  UNIQUE INDEX `idQuestionarioCAGE_UNIQUE` (`idQuestionarioCAGE` ASC),
  INDEX `FKQuestionarioCAGEVisita` (`idVisita` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  CONSTRAINT `FKQuestionarioCAGEVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestAtividadeFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestAtividadeFisica` (
  `idQuestionarioInternacional` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_QI01` CHAR(1) NULL,
  `PER_QI02` VARCHAR(5) NULL,
  `PER_QI03` INT NULL,
  `PER_QI04` INT NULL,
  `PER_QIS1A` CHAR(1) NULL,
  `PER_QIS1B` INT NULL,
  `PER_QIS1CH` INT NULL,
  `PER_QIS1CM` INT NULL,
  `PER_QIS1D` INT NULL,
  `PER_QIS1EH` INT NULL,
  `PER_QIS1EM` INT NULL,
  `PER_QIS1F` INT NULL,
  `PER_QIS1GH` INT NULL,
  `PER_QIS1GM` INT NULL,
  `PER_QIS2A` INT NULL,
  `PER_QIS2BH` INT NULL,
  `PER_QIS2BM` INT NULL,
  `PER_QIS2C` INT NULL,
  `PER_QIS2DH` INT NULL,
  `PER_QIS2DM` INT NULL,
  `PER_QIS2E` INT NULL,
  `PER_QIS2FH` INT NULL,
  `PER_QIS2FM` INT NULL,
  `PER_QIS3A` INT NULL,
  `PER_QIS3BH` INT NULL,
  `PER_QIS3BM` INT NULL,
  `PER_QIS3C` INT NULL,
  `PER_QIS3DH` INT NULL,
  `PER_QIS3DM` INT NULL,
  `PER_QIS3E` INT NULL,
  `PER_QIS3FH` INT NULL,
  `PER_QIS3FM` INT NULL,
  `PER_QIS4A` INT NULL,
  `PER_QIS4BH` INT NULL,
  `PER_QIS4BM` INT NULL,
  `PER_QIS4C` INT NULL,
  `PER_QIS4DH` INT NULL,
  `PER_QIS4DM` INT NULL,
  `PER_QIS4E` INT NULL,
  `PER_QIS4FH` INT NULL,
  `PER_QIS4FM` INT NULL,
  `PER_QIS5AH` INT NULL,
  `PER_QIS5AM` INT NULL,
  `PER_QIS5BH` INT NULL,
  `PER_QIS5BM` INT NULL,
  PRIMARY KEY (`idQuestionarioInternacional`),
  UNIQUE INDEX `idQuestionarioInternacional_UNIQUE` (`idQuestionarioInternacional` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKQuestionarioInternacionalVisita` (`idVisita` ASC),
  CONSTRAINT `FKQuestionarioInternacionalVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestMAPA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestMAPA` (
  `idQuestionarioMAPA` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `hrInicio` VARCHAR(5) NULL,
  `hrTermino` VARCHAR(5) NULL,
  `observacao` VARCHAR(200) NULL,
  `qtMedidasValidas` DECIMAL(5,2) NULL,
  `PER_QM01` VARCHAR(5) NULL,
  `PER_QM02` VARCHAR(5) NULL,
  `PER_QM03` VARCHAR(5) NULL,
  `PER_QM04` VARCHAR(5) NULL,
  `PER_QM05` VARCHAR(5) NULL,
  `PER_QM06` VARCHAR(5) NULL,
  `PER_QM07` VARCHAR(5) NULL,
  `PER_QM08` VARCHAR(5) NULL,
  `PER_QM09` VARCHAR(5) NULL,
  `PER_QM10` VARCHAR(5) NULL,
  `PER_QM11` VARCHAR(5) NULL,
  `PER_QM12` VARCHAR(5) NULL,
  `PER_QM13` VARCHAR(5) NULL,
  `PER_QM14` VARCHAR(5) NULL,
  `PER_QM15` VARCHAR(5) NULL,
  `PER_QM16` VARCHAR(5) NULL,
  `PER_QM17` VARCHAR(5) NULL,
  `PER_QM18` VARCHAR(5) NULL,
  PRIMARY KEY (`idQuestionarioMAPA`),
  UNIQUE INDEX `idQuestionarioMAPA_UNIQUE` (`idQuestionarioMAPA` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKQuestionarioMAPAVisita` (`idVisita` ASC),
  CONSTRAINT `FKQuestionarioMAPAVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestBioquimica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestBioquimica` (
  `idBioquimica` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `dtProcessamentoSoro` VARCHAR(10) NULL,
  `dtColeta` VARCHAR(10) NULL,
  `flQuatroColetas` CHAR(1) NULL,
  `PER_B01` VARCHAR(10) NULL,
  `PER_B02` VARCHAR(10) NULL,
  `PER_B03` VARCHAR(10) NULL,
  `PER_B04` VARCHAR(10) NULL,
  `PER_B05` VARCHAR(10) NULL,
  `PER_B06` VARCHAR(10) NULL,
  `PER_B07` VARCHAR(10) NULL,
  `PER_B08` VARCHAR(10) NULL,
  `PER_B09` VARCHAR(10) NULL,
  `PER_B10` VARCHAR(10) NULL,
  `PER_B11` VARCHAR(10) NULL,
  PRIMARY KEY (`idBioquimica`),
  UNIQUE INDEX `idBioquimica_UNIQUE` (`idBioquimica` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKBioquimicaVisita` (`idVisita` ASC),
  CONSTRAINT `FKBioquimicaVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestPoligrafia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestPoligrafia` (
  `idPoligrafia` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `qtdEventos` INT NOT NULL,
  `local` VARCHAR(45) NULL,
  `IAH` VARCHAR(10) NULL,
  `SatBasal` VARCHAR(10) NULL,
  `SatMedia` VARCHAR(10) NULL,
  `SatMinimo` VARCHAR(10) NULL,
  `TSMenor90` VARCHAR(10) NULL,
  `resultado` INT NULL,
  `flAOSGrave` CHAR(1) NULL,
  PRIMARY KEY (`idPoligrafia`),
  UNIQUE INDEX `idPoligrafia_UNIQUE` (`idPoligrafia` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKPolografiaVisita` (`idVisita` ASC),
  CONSTRAINT `FKPolografiaVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestPolissonografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestPolissonografia` (
  `idPolissonografia` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `qtdEventos` INT NULL,
  `latencia` VARCHAR(10) NULL,
  `TST` VARCHAR(10) NULL,
  `pcS1` VARCHAR(10) NULL,
  `pcS2` VARCHAR(10) NULL,
  `pcS3` VARCHAR(10) NULL,
  `pcREM` VARCHAR(10) NULL,
  `arquitetura` VARCHAR(10) NULL,
  `IAH` VARCHAR(10) NULL,
  `SatBasal` VARCHAR(10) NULL,
  `SatMedia` VARCHAR(10) NULL,
  `SatMinima` VARCHAR(10) NULL,
  `TSMenor90` VARCHAR(10) NULL,
  `Arousals` VARCHAR(10) NULL,
  `resultado` INT NULL,
  `pressaoCPAP` VARCHAR(10) NULL,
  `flAplicaDilatador` CHAR(1) NULL,
  `tmMascaraN` CHAR(1) NULL,
  `tmMascaraNO` CHAR(1) NULL,
  PRIMARY KEY (`idPolissonografia`),
  UNIQUE INDEX `idPolissonografia_UNIQUE` (`idPolissonografia` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKPolissonografiaVisita` (`idVisita` ASC),
  CONSTRAINT `FKPolissonografiaVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestEcocardiograma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestEcocardiograma` (
  `idEcocardiograma` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PER_CT01` VARCHAR(10) NULL,
  `PER_CT02` VARCHAR(10) NULL,
  `PER_CT03` VARCHAR(10) NULL,
  `PER_CT04` VARCHAR(10) NULL,
  `PER_CT05` VARCHAR(10) NULL,
  `PER_CT06` VARCHAR(10) NULL,
  `PER_CT07` VARCHAR(10) NULL,
  `PER_CT08` VARCHAR(10) NULL,
  `PER_CT09` VARCHAR(10) NULL,
  `PER_CT10` VARCHAR(10) NULL,
  `PER_CT11` VARCHAR(10) NULL,
  `PER_CT12` VARCHAR(10) NULL,
  `PER_CT13` VARCHAR(10) NULL,
  `PER_CT14` VARCHAR(10) NULL,
  `PER_CT15` VARCHAR(10) NULL,
  `PER_CT16` VARCHAR(10) NULL,
  `PER_CT17` VARCHAR(10) NULL,
  `PER_CT18` VARCHAR(10) NULL,
  `PER_CT19` VARCHAR(10) NULL,
  `PER_CT20` VARCHAR(10) NULL,
  `PER_CT21` VARCHAR(10) NULL,
  `PER_CT22` VARCHAR(10) NULL,
  `PER_CT23` VARCHAR(10) NULL,
  `PER_CT24` VARCHAR(10) NULL,
  `PER_CT25` VARCHAR(10) NULL,
  `PER_CT26` VARCHAR(10) NULL,
  `PER_CT27` VARCHAR(10) NULL,
  `PER_CT28` VARCHAR(10) NULL,
  `PER_CT29` VARCHAR(10) NULL,
  `PER_CT30` VARCHAR(10) NULL,
  `PER_CT31` VARCHAR(10) NULL,
  `PER_CT32` VARCHAR(10) NULL,
  `PER_CT33` VARCHAR(10) NULL,
  `PER_CT34` VARCHAR(10) NULL,
  `PER_CT35` VARCHAR(10) NULL,
  `PER_CT36` VARCHAR(10) NULL,
  `PER_CT37` VARCHAR(10) NULL,
  `PER_CT38` VARCHAR(10) NULL,
  `PER_CT39` VARCHAR(10) NULL,
  `PER_CT40` VARCHAR(10) NULL,
  `PER_CT41` VARCHAR(10) NULL,
  `PER_CT42` VARCHAR(10) NULL,
  `PER_CT43` VARCHAR(10) NULL,
  `PER_CT44` VARCHAR(10) NULL,
  `PER_CT45` VARCHAR(10) NULL,
  `PER_CT46` VARCHAR(10) NULL,
  `observacao` VARCHAR(200) NULL,
  `dtRealizacao` VARCHAR(10) NULL,
  `flRealizado` CHAR(1) NULL,
  PRIMARY KEY (`idEcocardiograma`),
  UNIQUE INDEX `idEcocardiograma_UNIQUE` (`idEcocardiograma` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKCardiogramaVisita` (`idVisita` ASC),
  CONSTRAINT `FKCardiogramaVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestSphygmocor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestSphygmocor` (
  `idSphygmocor` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `PAS` VARCHAR(10) NULL,
  `PAD` VARCHAR(10) NULL,
  `PPC` VARCHAR(10) NULL,
  `ALX` VARCHAR(10) NULL,
  `ALX75` VARCHAR(10) NULL,
  `observacao` VARCHAR(200) NULL,
  PRIMARY KEY (`idSphygmocor`),
  UNIQUE INDEX `idSphygmocor_UNIQUE` (`idSphygmocor` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKSphygmocorVisita` (`idVisita` ASC),
  CONSTRAINT `FKSphygmocorVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbGrupoMedicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbGrupoMedicamento` (
  `idGrupoMedicamento` INT NOT NULL AUTO_INCREMENT,
  `dsGrupoMedicamento` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idGrupoMedicamento`),
  UNIQUE INDEX `idGrupoMedicamento_UNIQUE` (`idGrupoMedicamento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbMedicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbMedicamento` (
  `idMedicamento` INT NOT NULL AUTO_INCREMENT,
  `dsMedicamento` VARCHAR(45) NOT NULL,
  `idGrupoMedicamento` INT NOT NULL,
  PRIMARY KEY (`idMedicamento`),
  UNIQUE INDEX `idMedicamento_UNIQUE` (`idMedicamento` ASC),
  INDEX `FKGrupoMedicamento` (`idGrupoMedicamento` ASC),
  CONSTRAINT `FKGrupoMedicamento`
    FOREIGN KEY (`idGrupoMedicamento`)
    REFERENCES `estudomorpheos`.`TbGrupoMedicamento` (`idGrupoMedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbQuestMedicamentoUso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbQuestMedicamentoUso` (
  `idVisitaMedicamentoUso` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `idMedicamento` INT NULL,
  `dose` VARCHAR(45) NULL,
  `posologia` VARCHAR(45) NULL,
  `observacao` VARCHAR(200) NULL,
  PRIMARY KEY (`idVisitaMedicamentoUso`),
  UNIQUE INDEX `idVisitaMedicamentoUso_UNIQUE` (`idVisitaMedicamentoUso` ASC),
  INDEX `FKMedicamentoUsoVisita` (`idVisita` ASC),
  INDEX `FKMedicamentoUsoMedicamento` (`idMedicamento` ASC),
  CONSTRAINT `FKMedicamentoUsoVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FKMedicamentoUsoMedicamento`
    FOREIGN KEY (`idMedicamento`)
    REFERENCES `estudomorpheos`.`TbMedicamento` (`idMedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisitaAdesaoTratamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisitaAdesaoTratamento` (
  `idAdesaoTratamento` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flAdesaoTratamento` CHAR(1) NULL,
  `pcMediaCPAP` DECIMAL(5,2) NULL,
  `pcAdesaoDilatador` DECIMAL(5,2) NULL,
  PRIMARY KEY (`idAdesaoTratamento`),
  UNIQUE INDEX `idAdesaoTratamento_UNIQUE` (`idAdesaoTratamento` ASC),
  INDEX `FKAdesaoTratamentoVisita` (`idVisita` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  CONSTRAINT `FKAdesaoTratamentoVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estudomorpheos`.`TbVisitaMudancaMedicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estudomorpheos`.`TbVisitaMudancaMedicacao` (
  `idMudancaMedicacao` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `flMudancaMedicamento` CHAR(1) NULL,
  `dsMotivo` VARCHAR(45) NULL,
  `flManterMedicamentoInicial` CHAR(1) NULL,
  `flAdesaoMedicacao` CHAR(1) NULL,
  `pcAdesaoMedicacao` DECIMAL(5,2) NULL,
  PRIMARY KEY (`idMudancaMedicacao`),
  UNIQUE INDEX `idMudancaMedicacao_UNIQUE` (`idMudancaMedicacao` ASC),
  UNIQUE INDEX `idVisita_UNIQUE` (`idVisita` ASC),
  INDEX `FKMudancaMedicacaoVisita` (`idVisita` ASC),
  CONSTRAINT `FKMudancaMedicacaoVisita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `estudomorpheos`.`TbVisita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

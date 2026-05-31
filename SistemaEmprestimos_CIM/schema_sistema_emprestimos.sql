-- =====================================================
-- Script de Criação de Banco de Dados
-- Sistema de Empréstimos de Equipamentos
-- Gerado automaticamente via M2T (Model-to-Text)
-- Acceleo Template: GenerateSQL.mtl
-- Data: 2026-05-31
-- =====================================================

-- =====================================================
-- Configuração Inicial
-- =====================================================
SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE='STRICT_TRANS_TABLES';
SET DEFAULT STORAGE_ENGINE=InnoDB;
SET CHARACTER SET utf8mb4;
SET COLLATION_CONNECTION=utf8mb4_unicode_ci;

-- =====================================================
-- TABELA: Professor
-- =====================================================
DROP TABLE IF EXISTS `Professor`;

CREATE TABLE `Professor` (
  `matricula` VARCHAR(64) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `departamento` VARCHAR(128) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Índices para otimização
CREATE INDEX `idx_Professor_matricula` ON `Professor` (`matricula`);
CREATE INDEX `idx_Professor_departamento` ON `Professor` (`departamento`);

-- =====================================================
-- TABELA: Equipamento
-- =====================================================
DROP TABLE IF EXISTS `Equipamento`;

CREATE TABLE `Equipamento` (
  `codigoTombamento` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `isDisponivel` BOOLEAN NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Índices para otimização
CREATE INDEX `idx_Equipamento_codigo` ON `Equipamento` (`codigoTombamento`);
CREATE INDEX `idx_Equipamento_disponivel` ON `Equipamento` (`isDisponivel`);

-- =====================================================
-- TABELA: Emprestimo
-- =====================================================
DROP TABLE IF EXISTS `Emprestimo`;

CREATE TABLE `Emprestimo` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `dataRetirada` TIMESTAMP NULL,
  `dataDevolucaoPrevista` TIMESTAMP NULL,
  `equipamentoCodigo` INT NULL,
  `professorMatricula` VARCHAR(64) NULL,
  
  -- Chaves Estrangeiras
  CONSTRAINT `fk_Emprestimo_Equipamento` FOREIGN KEY (`equipamentoCodigo`) 
    REFERENCES `Equipamento` (`codigoTombamento`) 
    ON DELETE RESTRICT ON UPDATE CASCADE,
  
  CONSTRAINT `fk_Emprestimo_Professor` FOREIGN KEY (`professorMatricula`) 
    REFERENCES `Professor` (`matricula`) 
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Índices para otimização
CREATE INDEX `idx_Emprestimo_id` ON `Emprestimo` (`id`);
CREATE INDEX `idx_Emprestimo_data_retirada` ON `Emprestimo` (`dataRetirada`);
CREATE INDEX `idx_Emprestimo_data_devolucao` ON `Emprestimo` (`dataDevolucaoPrevista`);
CREATE INDEX `idx_Emprestimo_equipamento` ON `Emprestimo` (`equipamentoCodigo`);
CREATE INDEX `idx_Emprestimo_professor` ON `Emprestimo` (`professorMatricula`);

-- =====================================================
-- Dados de Exemplo (Teste)
-- =====================================================

-- Professor de exemplo
INSERT INTO `Professor` (`matricula`, `nome`, `departamento`) 
VALUES 
  ('M2024001', 'Dr. João Silva', 'Engenharia de Computação'),
  ('M2024002', 'Dra. Maria Santos', 'Engenharia Elétrica'),
  ('M2024003', 'Prof. Carlos Oliveira', 'Engenharia Mecânica');

-- Equipamento de exemplo
INSERT INTO `Equipamento` (`codigoTombamento`, `nome`, `isDisponivel`) 
VALUES 
  (98765, 'Osciloscópio Digital', 1),
  (98766, 'Multímetro Digital', 1),
  (98767, 'Gerador de Funções', 0),
  (98768, 'Analisador de Espectro', 1);

-- Empréstimo de exemplo
INSERT INTO `Emprestimo` (`dataRetirada`, `dataDevolucaoPrevista`, `equipamentoCodigo`, `professorMatricula`) 
VALUES 
  ('2026-05-31 10:00:00', '2026-06-07 10:00:00', 98765, 'M2024001'),
  ('2026-05-30 14:30:00', '2026-06-06 14:30:00', 98766, 'M2024002');

-- =====================================================
-- Viewsde Suporte (Opcional)
-- =====================================================

-- View: Empréstimos Ativos
DROP VIEW IF EXISTS `vw_Emprestimos_Ativos`;
CREATE VIEW `vw_Emprestimos_Ativos` AS
SELECT 
  e.id,
  p.nome AS professor,
  eq.nome AS equipamento,
  e.dataRetirada,
  e.dataDevolucaoPrevista,
  DATEDIFF(e.dataDevolucaoPrevista, NOW()) AS dias_restantes,
  CASE 
    WHEN DATEDIFF(e.dataDevolucaoPrevista, NOW()) < 0 THEN 'ATRASADO'
    WHEN DATEDIFF(e.dataDevolucaoPrevista, NOW()) <= 2 THEN 'PRÓXIMO DE VENCER'
    ELSE 'ATIVO'
  END AS situacao
FROM `Emprestimo` e
INNER JOIN `Professor` p ON e.professorMatricula = p.matricula
INNER JOIN `Equipamento` eq ON e.equipamentoCodigo = eq.codigoTombamento
WHERE e.dataDevolucaoPrevista > NOW() OR DATEDIFF(e.dataDevolucaoPrevista, NOW()) = 0;

-- View: Equipamentos Indisponíveis
DROP VIEW IF EXISTS `vw_Equipamentos_Indisponiveis`;
CREATE VIEW `vw_Equipamentos_Indisponiveis` AS
SELECT 
  eq.codigoTombamento,
  eq.nome,
  p.nome AS responsavel,
  e.dataRetirada,
  e.dataDevolucaoPrevista
FROM `Equipamento` eq
LEFT JOIN `Emprestimo` e ON eq.codigoTombamento = e.equipamentoCodigo
LEFT JOIN `Professor` p ON e.professorMatricula = p.matricula
WHERE eq.isDisponivel = 0 OR (eq.isDisponivel = 1 AND e.id IS NOT NULL);

-- =====================================================
-- Stored Procedures (Opcional)
-- =====================================================

-- Procedure: Registrar novo empréstimo
DROP PROCEDURE IF EXISTS sp_registrar_emprestimo;
DELIMITER //

CREATE PROCEDURE sp_registrar_emprestimo(
  IN p_prof_matricula VARCHAR(64),
  IN p_equip_codigo INT,
  IN p_data_devolucao_prevista DATETIME
)
BEGIN
  DECLARE EXIT HANDLER FOR SQLEXCEPTION
  BEGIN
    ROLLBACK;
    SELECT 'Erro ao registrar empréstimo' AS mensagem;
  END;

  START TRANSACTION;
  
  -- Validar se professor existe
  IF NOT EXISTS (SELECT 1 FROM `Professor` WHERE matricula = p_prof_matricula) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Professor não encontrado';
  END IF;
  
  -- Validar se equipamento existe
  IF NOT EXISTS (SELECT 1 FROM `Equipamento` WHERE codigoTombamento = p_equip_codigo) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Equipamento não encontrado';
  END IF;
  
  -- Validar se equipamento está disponível
  IF NOT (SELECT isDisponivel FROM `Equipamento` WHERE codigoTombamento = p_equip_codigo) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Equipamento não está disponível';
  END IF;
  
  -- Inserir novo empréstimo
  INSERT INTO `Emprestimo` (dataRetirada, dataDevolucaoPrevista, equipamentoCodigo, professorMatricula)
  VALUES (NOW(), p_data_devolucao_prevista, p_equip_codigo, p_prof_matricula);
  
  -- Atualizar disponibilidade do equipamento
  UPDATE `Equipamento` SET isDisponivel = 0 WHERE codigoTombamento = p_equip_codigo;
  
  COMMIT;
  SELECT 'Empréstimo registrado com sucesso' AS mensagem;
END //

DELIMITER ;

-- =====================================================
-- Triggers (Opcional)
-- =====================================================

-- Trigger: Atualizar timestamps de modificação
DROP TRIGGER IF EXISTS tr_emprestimo_atualizar;
DELIMITER //

CREATE TRIGGER tr_emprestimo_atualizar
AFTER INSERT ON `Emprestimo`
FOR EACH ROW
BEGIN
  -- Lógica adicional pode ser adicionada aqui
  -- Ex: atualizar estatísticas, notificar, etc.
END //

DELIMITER ;

-- =====================================================
-- Ativar integridade referencial
-- =====================================================
SET FOREIGN_KEY_CHECKS=1;

-- =====================================================
-- Verificação Final
-- =====================================================
SELECT '✓ Schema do Sistema de Empréstimos criado com sucesso!' AS resultado;

SHOW TABLES;

-- =====================================================
-- Fim do script de criação
-- =====================================================

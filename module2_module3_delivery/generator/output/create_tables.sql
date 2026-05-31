-- SQL gerado automaticamente

CREATE TABLE Professor (
  matricula VARCHAR(64) PRIMARY KEY,
  nome VARCHAR(255),
  departamento VARCHAR(128)
);

CREATE TABLE Equipamento (
  codigoTombamento INT PRIMARY KEY,
  nome VARCHAR(255),
  isDisponivel BOOLEAN
);

CREATE TABLE Emprestimo (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  dataRetirada TIMESTAMP,
  dataDevolucaoPrevista TIMESTAMP,
  equipamentoCodigo INT,
  professorMatricula VARCHAR(64),
  FOREIGN KEY (equipamentoCodigo) REFERENCES Equipamento(codigoTombamento),
  FOREIGN KEY (professorMatricula) REFERENCES Professor(matricula)
);

USE baraolanchess;

CREATE TABLE Cardapio (
    NumeroCardapio INT PRIMARY KEY,
    NomeDoPedido VARCHAR(255) NOT NULL,
    Valor DECIMAL(10, 2) NOT NULL
);
CREATE TABLE mesa (
  NumeroCardapio int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  NumMesa int(11) NOT NULL,
  ValorTotal decimal(10,2) NOT NULL,
  Concluido varchar(45) DEFAULT NULL,
  KEY NumeroCardapio (NumeroCardapio),
  FOREIGN KEY (NumeroCardapio) REFERENCES cardapio (NumeroCardapio)
);

CREATE TABLE funcionarios (
  id int(11) NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  Nome varchar(255) NOT NULL,
  DataNascimento date NOT NULL,
  Cpf varchar(16) NOT NULL UNIQUE KEY,
  Email varchar(255) NOT NULL UNIQUE KEY ,
  Telefone varchar(15) DEFAULT NULL,
  Endereco varchar(255) DEFAULT NULL,
  Habilitacao varchar(45) DEFAULT NULL,
  Cargo varchar(45) DEFAULT NULL
);

CREATE TABLE cliente (
  Cpf varchar(16) NOT NULL PRIMARY KEY,
  Nome varchar(200) NOT NULL,
  DataNascimento date NOT NULL,
  Telefone varchar(15) NOT NULL,
  Endereco varchar(200) NOT NULL,
  Email varchar(200) NOT NULL UNIQUE KEY
);


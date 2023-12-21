CREATE TABLE `mesa` (
  `NumeroCardapio` int NOT NULL,
  `NomeDoPedido` varchar(45) DEFAULT NULL,
  `Quantidade` int NOT NULL,
  `NumMesa` int NOT NULL,
  `ValorTotal` decimal(10,2) NOT NULL,
  KEY `NumeroCardapio` (`NumeroCardapio`),
  CONSTRAINT `mesa_ibfk_1` FOREIGN KEY (`NumeroCardapio`) REFERENCES `cardapio` (`NumeroCardapio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funcionarios` (
  `Nome` varchar(255) NOT NULL,
  `DataNascimento` date DEFAULT NULL,
  `CPF` varchar(11) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Habilitacao` varchar(20) DEFAULT NULL,
  `Cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cliente` (
  `CPF` varchar(11) NOT NULL,
  `Nome` varchar(255) NOT NULL,
  `DataNascimento` date NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Email` varchar(255) NOT NULL,
  `NivelVip` int DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cardapio` (
  `NumeroCardapio` int NOT NULL,
  `NomeDoPedido` varchar(255) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`NumeroCardapio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE veiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(20) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL
);

CREATE TABLE posto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    localizacao VARCHAR(100) NOT NULL
);

CREATE TABLE abastecimento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    veiculo_id INT,
    posto_id INT,
    data DATE NOT NULL,
    quantidade_litros DOUBLE NOT NULL,
    quilometros_odometro DOUBLE NOT NULL,
    preco DOUBLE NOT NULL,
    tipo_combustivel VARCHAR(20) NOT NULL,
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id),
    FOREIGN KEY (posto_id) REFERENCES posto(id)
);

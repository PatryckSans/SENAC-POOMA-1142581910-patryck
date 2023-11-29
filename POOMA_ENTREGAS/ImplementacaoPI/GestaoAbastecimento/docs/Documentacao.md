# Documentação do Projeto: Controle de Abastecimento de Veículos

## 1. Visão Geral

O projeto "Controle de Abastecimento de Veículos" é uma aplicação de desktop desenvolvida em Java para gerenciar informações sobre veículos, postos de combustíveis e abastecimentos. O objetivo principal é proporcionar aos usuários um controle eficiente sobre os abastecimentos realizados em seus veículos.

## 2. Estrutura do Banco de Dados

### 2.1 Tabelas

#### 2.1.1 Veiculo
- `id` INT (Chave Primária)
- `placa` VARCHAR(20) NOT NULL
- `marca` VARCHAR(50) NOT NULL
- `modelo` VARCHAR(50) NOT NULL

#### 2.1.2 Posto
- `id` INT (Chave Primária)
- `nome` VARCHAR(50) NOT NULL
- `localizacao` VARCHAR(100) NOT NULL

#### 2.1.3 Abastecimento
- `id` INT (Chave Primária)
- `veiculo_id` INT (Chave Estrangeira referenciando Veiculo.id)
- `posto_id` INT (Chave Estrangeira referenciando Posto.id)
- `data` DATE NOT NULL
- `quantidade_litros` DOUBLE NOT NULL
- `quilometros_odometro` DOUBLE NOT NULL
- `preco` DOUBLE NOT NULL
- `tipo_combustivel` VARCHAR(20) NOT NULL

### 2.2 Relacionamentos
- A tabela `Abastecimento` possui chaves estrangeiras referenciando as tabelas `Veiculo` e `Posto`.

## 3. Estrutura do Projeto

### 3.1 Pacotes

- `GestaoAbastecimento.model`
  - Contém as classes de modelo: `Veiculo`, `Posto` e `Abastecimento`.
  
- `GestaoAbastecimento.database`
  - Contém as classes relacionadas ao banco de dados: `MySQLConnector` e `DatabaseInitializer`.

- `GestaoAbastecimento.controller`
  - Contém a classe controladora: `AbastecimentoController`.

- `GestaoAbastecimento.view`
  - Contém a classe de visualização: `AbastecimentoView`.

- `GestaoAbastecimento`
  - Contém a classe principal: `Main`.

### 3.2 Classes

#### 3.2.1 Veiculo
- Representa um veículo com atributos como placa, marca e modelo.

#### 3.2.2 Posto
- Representa um posto de combustível com informações como nome e localização.

#### 3.2.3 Abastecimento
- Representa um registro de abastecimento com detalhes como veículo associado, posto, data, quantidade de litros, quilômetros no odômetro, preço e tipo de combustível.

#### 3.2.4 MySQLConnector
- Fornece métodos para conectar e interagir com o banco de dados MySQL.

#### 3.2.5 DatabaseInitializer
- Inicializa o banco de dados com as tabelas necessárias.

#### 3.2.6 AbastecimentoController
- Controla a lógica de negócios relacionada aos abastecimentos, incluindo adição e obtenção de dados.

#### 3.2.7 AbastecimentoView
- Fornece uma interface de usuário para interação, permitindo a visualização e entrada de dados relacionados a abastecimentos.

#### 3.2.8 Main
- Classe principal que inicia a aplicação.

## 4. Funcionalidades Implementadas

- Cadastro e visualização de veículos, postos e abastecimentos.
- Cálculo da média de quilômetros por litro.
- Listagem de abastecimentos ordenados por veículo e data.

## 5. Tecnologias Utilizadas

- Linguagem de Programação: Java
- Banco de Dados: MySQL
- Arquitetura: MVC (Model-View-Controller)

## 6. Instruções de Compilação e Execução

1. Compilar o projeto:
   ```bash
   javac -cp .:lib/mssql-jdbc-12.4.2.jre11.jar src/main/GestaoAbastecimento/**/*.java
   ```

2. Executar a aplicação:
   ```bash
   java -cp .:lib/mssql-jdbc-12.4.2.jre11.jar src/main/GestaoAbastecimento/Main.java
   ```

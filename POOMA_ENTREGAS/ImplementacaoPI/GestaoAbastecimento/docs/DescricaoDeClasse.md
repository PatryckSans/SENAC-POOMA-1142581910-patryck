### 1. Classe: `Veiculo`

#### Atributos:
- `id: int` (identificador único)
- `placa: String` (placa do veículo)
- `marca: String` (marca do veículo)
- `modelo: String` (modelo do veículo)

#### Métodos:
- Construtores para inicialização de objetos.
- Métodos de acesso (getters e setters) para os atributos.

### 2. Classe: `Posto`

#### Atributos:
- `id: int` (identificador único)
- `nome: String` (nome do posto)
- `localizacao: String` (localização do posto)

#### Métodos:
- Construtores para inicialização de objetos.
- Métodos de acesso (getters e setters) para os atributos.

### 3. Classe: `Abastecimento`

#### Atributos:
- `id: int` (identificador único)
- `veiculo: Veiculo` (referência ao veículo abastecido)
- `posto: Posto` (referência ao posto de abastecimento)
- `data: Date` (data do abastecimento)
- `quantidadeLitros: double` (quantidade de litros abastecidos)
- `quilometrosOdometro: double` (quilômetros registrados no odômetro)
- `preco: double` (preço total do abastecimento)
- `tipoCombustivel: String` (tipo de combustível)

#### Métodos:
- Construtores para inicialização de objetos.
- Métodos de acesso (getters e setters) para os atributos.

### 4. Classe: `MySQLConnector`

#### Métodos Estáticos:
- `getConnection(): Connection` (obtém uma conexão com o banco de dados)

### 5. Classe: `DatabaseInitializer`

#### Métodos Estáticos:
- `initializeDatabase(): void` (inicializa o banco de dados com as tabelas necessárias)

### 6. Classe: `AbastecimentoController`

#### Atributos:
- `abastecimentos: List<Abastecimento>` (lista de abastecimentos)

#### Métodos:
- `getAbastecimentos(): List<Abastecimento>` (retorna a lista de abastecimentos)
- `adicionarAbastecimento(veiculo: Veiculo, posto: Posto, data: Date, quantidadeLitros: double, quilometrosOdometro: double): void` (adiciona um novo abastecimento)
- `calcularMediaKmPorLitro(veiculo: Veiculo): double` (calcula a média de quilômetros por litro para um veículo)

### 7. Classe: `AbastecimentoView`

#### Métodos:
- `exibirMenu(): void` (exibe o menu de opções para o usuário)
- `cadastrarVeiculo(): Veiculo` (solicita e cadastra um novo veículo)
- `cadastrarPosto(): Posto` (solicita e cadastra um novo posto)
- `registrarAbastecimento(): void` (solicita e registra um novo abastecimento)
- `visualizarAbastecimentos(): void` (exibe a lista de abastecimentos)

### 8. Classe: `Main`

#### Método Principal:
- `public static void main(String[] args): void` (inicia a aplicação)
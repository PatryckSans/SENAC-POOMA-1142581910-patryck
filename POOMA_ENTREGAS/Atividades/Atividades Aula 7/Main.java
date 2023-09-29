import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private int id;
    private int classificacao;
    private String nomeProduto;
    private double precoProduto;

    public Produto(int id, int classificacao, String nomeProduto, double precoProduto) {
        this.id = id;
        this.classificacao = classificacao;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public int getId() {
        return id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Classificação: " + classificacao + ", Nome: " + nomeProduto + ", Preço: "
                + precoProduto;
    }
}

class CadastroProdutos {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto consultarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public boolean removerProduto(int id) {
        Produto produto = consultarProduto(id);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    public boolean alterarProduto(int id, int novaClassificacao, String novoNome, double novoPreco) {
        Produto produto = consultarProduto(id);
        if (produto != null) {
            produto.setClassificacao(novaClassificacao);
            produto.setNomeProduto(novoNome);
            produto.setPrecoProduto(novoPreco);
            return true;
        }
        return false;
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
}

public class Main {
    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Inclusão de produtos");
            System.out.println("2 - Consulta um determinado produto");
            System.out.println("3 - Excluir um determinado produto");
            System.out.println("4 - Alterar um determinado produto");
            System.out.println("5 - Listar todos os produtos");
            System.out.println("6 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite a Classificação: ");
                    int classificacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o Preço do Produto: ");
                    double preco = scanner.nextDouble();
                    Produto novoProduto = new Produto(id, classificacao, nome, preco);
                    cadastro.adicionarProduto(novoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja consultar: ");
                    int idConsulta = scanner.nextInt();
                    Produto produtoConsultado = cadastro.consultarProduto(idConsulta);
                    if (produtoConsultado != null) {
                        System.out.println("Produto encontrado:");
                        System.out.println(produtoConsultado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    int idExclusao = scanner.nextInt();
                    boolean removido = cadastro.removerProduto(idExclusao);
                    if (removido) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto que deseja alterar: ");
                    int idAlteracao = scanner.nextInt();
                    System.out.print("Digite a nova Classificação: ");
                    int novaClassificacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o novo Nome do Produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo Preço do Produto: ");
                    double novoPreco = scanner.nextDouble();
                    boolean alterado = cadastro.alterarProduto(idAlteracao, novaClassificacao, novoNome, novoPreco);
                    if (alterado) {
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 5:
                    ArrayList<Produto> listaProdutos = cadastro.listarProdutos();
                    if (listaProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Lista de Produtos:");
                        for (Produto p : listaProdutos) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

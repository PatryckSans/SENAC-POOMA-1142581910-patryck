import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private int id;
    private int classificacao;
    private String nomeProduto;
    private double precoProduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID: " + id + ", Classificacao: " + classificacao + ", Nome: " + nomeProduto + ", Preco: " + precoProduto;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
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
                    Produto produto = new Produto();
                    System.out.print("Digite o ID: ");
                    produto.setId(scanner.nextInt());
                    System.out.print("Digite a Classificação: ");
                    produto.setClassificacao(scanner.nextInt());
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o Nome do Produto: ");
                    produto.setNomeProduto(scanner.nextLine());
                    System.out.print("Digite o Preço do Produto: ");
                    produto.setPrecoProduto(scanner.nextDouble());
                    produtos.add(produto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja consultar: ");
                    int idConsulta = scanner.nextInt();
                    boolean encontrado = false;
                    for (Produto p : produtos) {
                        if (p.getId() == idConsulta) {
                            System.out.println("Produto encontrado:");
                            System.out.println(p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    int idExclusao = scanner.nextInt();
                    boolean removido = false;
                    for (Produto p : produtos) {
                        if (p.getId() == idExclusao) {
                            produtos.remove(p);
                            System.out.println("Produto removido com sucesso!");
                            removido = true;
                            break;
                        }
                    }
                    if (!removido) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto que deseja alterar: ");
                    int idAlteracao = scanner.nextInt();
                    boolean alterado = false;
                    for (Produto p : produtos) {
                        if (p.getId() == idAlteracao) {
                            System.out.print("Digite a nova Classificação: ");
                            p.setClassificacao(scanner.nextInt());
                            scanner.nextLine(); // Consumir a quebra de linha
                            System.out.print("Digite o novo Nome do Produto: ");
                            p.setNomeProduto(scanner.nextLine());
                            System.out.print("Digite o novo Preço do Produto: ");
                            p.setPrecoProduto(scanner.nextDouble());
                            System.out.println("Produto alterado com sucesso!");
                            alterado = true;
                            break;
                        }
                    }
                    if (!alterado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 5:
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("Lista de Produtos:");
                        for (Produto p : produtos) {
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

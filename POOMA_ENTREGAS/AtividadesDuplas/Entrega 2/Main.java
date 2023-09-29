package entregadois;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        Cliente cliente1 = new Cliente("cliente1", "senha1", 1, "Cliente 1", "Endereço do Cliente 1");
        Cliente cliente2 = new Cliente("cliente2", "senha2", 2, "Cliente 2", "Endereço do Cliente 2");

        Funcionario funcionario1 = new Funcionario("funcionario1", "senha1", 1, "Funcionário 1", "Cargo 1");
        Funcionario funcionario2 = new Funcionario("funcionario2", "senha2", 2, "Funcionário 2", "Cargo 2");

        Fornecedor fornecedor1 = new Fornecedor(1, "Fornecedor 1");
        Fornecedor fornecedor2 = new Fornecedor(2, "Fornecedor 2");

        Produto produto1 = new Produto(1, "Produto 1", 10.0);
        Produto produto2 = new Produto(2, "Produto 2", 20.0);
        Produto produto3 = new Produto(3, "Produto 3", 15.0);

        List<Produto> produtosFornecedor1 = new ArrayList<>();
        produtosFornecedor1.add(produto1);
        produtosFornecedor1.add(produto2);
        fornecedor1.enviarProdutos(produtosFornecedor1);

        List<Produto> produtosFornecedor2 = new ArrayList<>();
        produtosFornecedor2.add(produto3);
        fornecedor2.enviarProdutos(produtosFornecedor2);

        cliente1.adicionarProduto(produto1);
        cliente1.adicionarProduto(produto2);

        cliente2.adicionarProduto(produto2);
        cliente2.adicionarProduto(produto3);

        Produto produtoEncontrado = sistema.pesquisarProduto("Produto 1");
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado.getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }

        Pedido pedidoCliente1 = sistema.finalizarPedido(cliente1, cliente1.getCarrinho());
        Pedido pedidoCliente2 = sistema.finalizarPedido(cliente2, cliente2.getCarrinho());

        funcionario1.receberPedido(pedidoCliente1);
        funcionario1.enviarPedido(pedidoCliente1);

        funcionario2.receberPedido(pedidoCliente2);
        funcionario2.enviarPedido(pedidoCliente2);
    }
}

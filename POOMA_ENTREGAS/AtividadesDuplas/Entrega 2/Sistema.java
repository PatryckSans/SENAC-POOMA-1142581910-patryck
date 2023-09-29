package entregadois;

import java.util.ArrayList;
import java.util.List;

class Sistema {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    public List<Fornecedor> fornecedores;
    public Usuario usuarioLogado;

    public boolean login(String usuario, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsuario().equals(usuario) && cliente.getSenha().equals(senha)) {
                usuarioLogado = cliente;
                return true;
            }
        }

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getUsuario().equals(usuario) && funcionario.getSenha().equals(senha)) {
                usuarioLogado = funcionario;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        usuarioLogado = null;
    }

    public Produto pesquisarProduto(String string) {
        return null;
    }

    public Pedido finalizarPedido(Cliente cliente1, Object carrinho) {
        return null;
    }
}

class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}

class Cliente extends Usuario {
    public int id;
    public String nome;
    public String endereco;
    private List<Produto> carrinho;

    public Cliente(String usuario, String senha, int id, String nome, String endereco) {
        super(usuario, senha);
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.carrinho = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        carrinho.add(produto);
    }

    public void removerProduto(Produto produto) {
        carrinho.remove(produto);
    }

    public Object getCarrinho() {
        return null;
    }
}


class Funcionario extends Usuario {
    public int id;
    public String nome;
    public String cargo;

    public Funcionario(String usuario, String senha, int id, String nome, String cargo) {
        super(usuario, senha);
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public void receberPedido(Pedido pedido) {
    }

    public void enviarPedido(Pedido pedido) {
    }
}


class Fornecedor {
    public int id;
    public String nome;
    private List<Produto> produtos;

    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void enviarProdutos(List<Produto> produtos) {
        this.produtos.addAll(produtos);
    }
}


class Produto {
    public int id;
    public String nome;
    public double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return null;
    }
}


class Pedido {
    public int id;
    public Cliente cliente;
    public List<Produto> produtos;

    public Pedido(int id, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
    }
}


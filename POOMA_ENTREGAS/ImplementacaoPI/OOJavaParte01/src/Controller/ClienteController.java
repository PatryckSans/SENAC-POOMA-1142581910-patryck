package POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.Controller;

import java.util.ArrayList;
import java.util.List;

import POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.Model.Cliente;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        this.clientes = new ArrayList<>();
    }

    public void incluirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void excluirCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public Cliente consultarCliente(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void alterarCliente(int id, Cliente novoCliente) {
        excluirCliente(id);
        incluirCliente(novoCliente);
    }

    public void mostrarListaClientes() {
        clientes.forEach(System.out::println);
    }
}

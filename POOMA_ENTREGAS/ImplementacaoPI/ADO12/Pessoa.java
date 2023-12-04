import java.util.ArrayList;
import java.util.Iterator;

public class Pessoa {
    private String nome;
    private ArrayList<Endereco> enderecos;

    public Pessoa() {
        this.enderecos = new ArrayList<>();
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirEnderecos1() {
        for (Endereco endereco : enderecos) {
            System.out.println(endereco.toString());
        }
    }

    public void imprimirEnderecos2() {
        Iterator<Endereco> iterator = enderecos.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}

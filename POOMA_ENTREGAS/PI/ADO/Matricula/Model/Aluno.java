package POOMA_ENTREGAS.PI.ADO.Matricula.Model;

public class Aluno {
    private String matricula;
    private String nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + ", Nome: " + nome;
    }
}

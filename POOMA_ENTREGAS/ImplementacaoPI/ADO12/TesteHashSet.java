import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;

public class TesteHashSet {
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TesteHashSet that = (TesteHashSet) obj;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    public static void main(String[] args) {
        Set<TesteHashSet> hashSet = new HashSet<>();

        do {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código:"));

            TesteHashSet testeHashSet = new TesteHashSet();
            testeHashSet.setCodigo(codigo);

            if (!hashSet.add(testeHashSet)) {
                JOptionPane.showMessageDialog(null, "Código já informado. Por favor, forneça outro.");
            }

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja informar mais códigos?");
            if (resposta != 0) {
                break;
            }
        } while (true);

        Iterator<TesteHashSet> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getCodigo());
        }
    }
}

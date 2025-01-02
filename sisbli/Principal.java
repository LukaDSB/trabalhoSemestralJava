
import acesso.Usuario;
import biblioteca.Funcionario;
import biblioteca.Livro;
import java.util.List;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Usuario.listar(Funcionario.class);
        List<Livro> livros = Livro.listar(Livro.class);

        // for (Funcionario funcionario : funcionarios) {
        //     System.out.println(funcionario);
        // }

        for (Livro livro : livros) {
            System.out.println("\nTitulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nEditora: " + livro.getEditora());
        }

        JOptionPane.showConfirmDialog(null, "Teste");
    }
}

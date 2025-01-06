
import acesso.Usuario;
import biblioteca.Funcionario;
import biblioteca.Livro;
import java.util.List;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        // List<Funcionario> funcionarios = Usuario.listar(Funcionario.class);
        List<Livro> livros = Livro.listar(Livro.class);
        List<Usuario> usuarios = Usuario.listar(Usuario.class);

        // for (Funcionario funcionario : funcionarios) {
        // System.out.println(funcionario);
        // }

        // for (Livro livro : livros) {
        // System.out.println("\nTitulo: " + livro.getTitulo() + "\nAutor: " +
        // livro.getAutor() + "\nEditora: "
        // + livro.getEditora());
        // }

        String usuarioLogin = JOptionPane.showInputDialog(null, "Informe o seu login:", "Entrada de Dados",
                JOptionPane.QUESTION_MESSAGE);

        String usuarioSenha = JOptionPane.showInputDialog(null, "Informe a sua senha:", "Entrada de Dados",
                JOptionPane.QUESTION_MESSAGE);

        if (usuarioLogin != null && usuarioSenha != null) {

            if (Usuario.autenticarAluno(usuarioLogin, usuarioSenha)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, " + usuarioLogin + "!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível autenticar o usuário no sistema.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum nome foi inserido.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}

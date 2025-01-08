package acesso;

import biblioteca.Aluno;
import biblioteca.Bibliotecario;
import biblioteca.Professor;
import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String login;
    private String senha;
    private List<Funcionalidade> funcionalidades;
    private static List<Usuario> usuarios;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, List<Funcionalidade> funcionalidades) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcionalidades = funcionalidades;
    }

    static {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Aluno("Aluno1", "aluno1", "123456", 00154));
        usuarios.add(new Aluno("Aluno2", "aluno2", "123456", 00624));
        usuarios.add(new Aluno("Aluno3", "aluno3", "123456", 00254));
        usuarios.add(new Bibliotecario("Joana Silva", "jsilva", "654321", "09945789632"));
        usuarios.add(new Professor("José Maria Santos", "jmsantos", "132465", "08632176245"));
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> listar(Class<T> instanciaClasse) {
        List<T> usuariosClasse = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (instanciaClasse.isInstance(usuario)) {
                usuariosClasse.add((T) usuario);
            }
        }
        return (usuariosClasse);
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }

    public static boolean autenticarAluno(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Aluno && usuario.login.equals(login) && usuario.senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }
}

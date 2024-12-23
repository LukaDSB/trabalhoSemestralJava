package acesso;

import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private List<Funcionalidade> funcionalidades;
    private static List<Usuario> usuarios;

    public Usuario(String nome, String login, String senha, List<Funcionalidade> funcionalidades) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcionalidades = funcionalidades;
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }
}

package biblioteca;

import acesso.Usuario;
import divisao.Setor;

public class Funcionario extends Usuario {

    private String cpf;
    private int pis;
    private Setor lotacao;

    public Funcionario(String nome, String login, String senha, String cpf) {
        super(nome, login, senha);
        this.cpf = cpf;
    }

    public Funcionario(String nome, String login, String senha, Setor lotacao) {
        super(nome, login, senha);
        this.lotacao = lotacao;
    }

    public Funcionario(String nome, String login, String senha, String cpf, Setor lotacao) {
        super(nome, login, senha);
        this.cpf = cpf;
        this.lotacao = lotacao;
    }

    public Funcionario(String nome, String login, String senha, String cpf, int pis, Setor lotacao) {
        super(nome, login, senha);
        this.cpf = cpf;
        this.pis = pis;
        this.lotacao = lotacao;
    }

    public Setor getLotacao() {
        return lotacao;
    }

    public void setLotacao(Setor lotacao) {
        this.lotacao = lotacao;
    }
}

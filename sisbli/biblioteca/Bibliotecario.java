package biblioteca;

import divisao.Setor;
import java.util.List;

public class Bibliotecario extends Funcionario implements ILivroReservado {

    private List<Emprestimo> emprestimos;

    public Bibliotecario(String nome, String login, String senha, String cpf, Setor lotacao) {
        super(nome, login, senha, lotacao);
    }

    public Bibliotecario(String nome, String login, String senha, String cpf) {
        super(nome, login, senha, cpf);
    }

    public void ocorreu(Reserva reserva) {

    }

    public String informaraReserva() {
        return "";
    }

    public void cadastrarEmprestimo(Reserva reserva) {
        Emprestimo emprestimo = new Emprestimo(reserva);
        emprestimos.add(emprestimo);
        System.out.println("Emprestimo cadastrado com sucesso.");
    }
}

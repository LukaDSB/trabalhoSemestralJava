package biblioteca;

import divisao.Setor;

public class Professor extends Funcionario implements ILivroReservado {
    private Reserva reserva;

    public Professor(String nome, String login, String senha, String cpf) {
        super(nome, login, senha, cpf);
    }

    public Professor(String nome, String senha, String cpf, Setor lotacao) {
        super(nome, cpf, senha, lotacao);
    }

    public void ocorreu(Reserva reserva) {

    }

    public String informaraReserva() {
        return "";
    }
}

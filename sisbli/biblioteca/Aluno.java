package biblioteca;

import java.util.List;

import acesso.Funcionalidade;
import acesso.Usuario;

public class Aluno extends Usuario implements IReservouLivro {
    private int matricula;
    private List<Reserva> reservas;
    private List<LivroReservado> consumidores;
    private List<Funcionalidade> funcionalidades;

    public Aluno(String nome, String login, String senha, int matricula) {
        super(nome, login, senha);
        this.matricula = matricula;
    }

    public List<LivroReservado> getConsumidores() {
        return consumidores;
    }

    public void cadastrarReserva(List<String> titulosLivros, String data) {

    }

    public void adicionar(LivroReservado livroReservado) {
        consumidores.add(livroReservado);
    }

    public void notificar(Reserva reserva) {
        System.out.println("sla");
    }

    public void remover(LivroReservado livroReservado) {
        if (consumidores.contains(livroReservado)) {
            consumidores.remove(livroReservado);
            System.out.println("Livro removido");
        } else {
            System.out.println("Livro não encontrado");
        }
    }
}

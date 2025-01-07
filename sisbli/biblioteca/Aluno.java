package biblioteca;

import javax.swing.*;
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

    public void setConsumidores(List<LivroReservado> consumidores) {
        this.consumidores = consumidores;
    }

    public void cadastrarReserva(List<String> titulosLivros, String data) {
        int limiteReservas = 5;

        if (reservas.size() + titulosLivros.size() > limiteReservas) {
            JOptionPane.showMessageDialog(null,
                "Limite de reservas excedido. Você pode reservar até " + limiteReservas + " livros.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reserva novaReserva = new Reserva(data, titulosLivros);
        reservas.add(novaReserva);

        for (LivroReservado consumidor : consumidores) {
            consumidor.notificar(novaReserva);
        }

        JOptionPane.showMessageDialog(null,
            "Reserva cadastrada para os livros: " + titulosLivros + " na data: " + data,
            "Reserva Cadastrada",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void adicionar(LivroReservado livroReservado) {
        consumidores.add(livroReservado);
    }

    @Override
    public void remover(LivroReservado livroReservado) {
        if (consumidores.contains(livroReservado)) {
            consumidores.remove(livroReservado);
            System.out.println("Consumidor removido.");
        } else {
            System.out.println("Consumidor não encontrado.");
        }
    }

    @Override
    public void notificar(Reserva reserva) {
        System.out.println("Notificação: " + reserva.toString());
    }
}

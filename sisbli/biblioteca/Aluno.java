package biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import acesso.Funcionalidade;
import acesso.Usuario;

public class Aluno extends Usuario implements IReservouLivro {
    private int matricula;
    private List<Reserva> reservas;
    private List<LivroReservado> consumidores;
    private List<Funcionalidade> funcionalidades;

    // Construtor
    public Aluno(String nome, String login, String senha, int matricula) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.reservas = new ArrayList<>(); 
        this.consumidores = new ArrayList<>(); 
        this.funcionalidades = new ArrayList<>(); 
    }

    public List<LivroReservado> getConsumidores() {
        return consumidores;
    }

    public void setConsumidores(List<LivroReservado> consumidores) {
        this.consumidores = consumidores;
    }

    public void cadastrarReserva(List<String> titulosLivros, String data) {
        if (reservas == null) {
            reservas = new ArrayList<>(); 
        }

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

        if (consumidores == null) {
            consumidores = new ArrayList<>(); 
        }

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
        if (consumidores == null) {
            consumidores = new ArrayList<>();
        }
        consumidores.add(livroReservado);
    }

    @Override
    public void remover(LivroReservado livroReservado) {
        if (consumidores != null && consumidores.contains(livroReservado)) {
            consumidores.remove(livroReservado);
            System.out.println("Consumidor removido.");
        } else {
            System.out.println("Consumidor não encontrado ou lista não inicializada.");
        }
    }

    @Override
    public void notificar(Reserva reserva) {
        System.out.println("Notificação: " + reserva.toString());
    }
}

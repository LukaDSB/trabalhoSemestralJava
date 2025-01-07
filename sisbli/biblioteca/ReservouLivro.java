package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ReservouLivro implements IReservouLivro {
    private List<ILivroReservado> observadores;

    public ReservouLivro() {
        this.observadores = new ArrayList<>();
    }

    @Override
    public void adicionar(ILivroReservado livroReservado) {
        this.observadores.add(livroReservado);
    }

    @Override
    public void remover(ILivroReservado livroReservado) {
        this.observadores.remove(livroReservado);
    }

    @Override
    public void notificar(Reserva reserva) {
        for (ILivroReservado observador : observadores) {
            observador.ocorreu(reserva);
        }
    }
}

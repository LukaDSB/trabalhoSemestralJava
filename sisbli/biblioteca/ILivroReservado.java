package biblioteca;

public interface ILivroReservado {
    public void ocorreu(Reserva reserva);

    void notificar(Reserva reserva);

    public String informaraReserva();
}

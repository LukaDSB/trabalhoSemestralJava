package biblioteca;

public interface IReservouLivro {
    public void adicionar(LivroReservado livroReservado);

    public void notificar(Reserva reserva);

    public void remover(LivroReservado livroReservado);
}
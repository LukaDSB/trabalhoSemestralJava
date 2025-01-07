package biblioteca;

public class LivroReservado implements ILivroReservado {
    private String tituloLivro;

    public LivroReservado(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    @Override
    public void ocorreu(Reserva reserva) {
        System.out.println("O livro " + tituloLivro + " foi reservado!");
    }

    @Override
    public void notificar(Reserva reserva) {
        System.out.println("Livro reservado: " + reserva.getData());
    }

    @Override
    public String informaraReserva() {
        return "Livro reservado: " + tituloLivro;
    }
}

package biblioteca;

import java.util.List;

public class Reserva {
    private String data;
    private List<Livro> livros;

    public Reserva(String data, List<String> titulosLivros) {
        this.data = data;

    }
}

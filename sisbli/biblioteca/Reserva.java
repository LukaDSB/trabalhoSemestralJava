package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String data; 
    private List<Livro> livros;

    public Reserva(String data, List<String> titulosLivros) {
        this.data = data;
        this.livros = carregarLivros(titulosLivros); 
    }

    public String getData() {
        return data;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Livro> carregarLivros(List<String> titulosLivros) {
        List<Livro> livros = new ArrayList<>();
        for (String titulo : titulosLivros) {
            livros.add(new Livro(titulo));
        }
        return livros;
    }
}

package biblioteca;

import java.util.List;
import java.util.Map;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private Map<Livro, List<Exemplar>> biblioteca;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public Livro(String titulo, String autor, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    // public static Livro obterLivro(String titulo) {

    // }
}

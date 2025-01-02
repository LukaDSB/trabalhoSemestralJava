package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import acesso.Usuario;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private Map<Livro, List<Exemplar>> biblioteca;
    private static List<Livro> livros;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public Livro(String titulo, String autor, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    static {
        livros = new ArrayList<Livro>();
        livros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "123456"));
        livros.add(new Livro("O Pequeno Principe", "Antoine de saint-exupéry", "654321"));
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> listar(Class<T> instanciaClasse) {
        List<T> livrosClasse = new ArrayList<>();

        for (Livro livro : livros) {
            if (instanciaClasse.isInstance(livro)) {
                livrosClasse.add((T) livro);
            }
        }
        return (livrosClasse);
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
}

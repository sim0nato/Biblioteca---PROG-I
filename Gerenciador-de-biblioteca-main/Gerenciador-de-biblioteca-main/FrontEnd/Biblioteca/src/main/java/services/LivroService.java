package services;

/**
 *
 * @author simon
 */

import entities.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private static List<Livro> listaLivros = new ArrayList<>();

    public static void cadastrarLivro(Livro livro) {
        // Verifica se já existe um livro com as mesmas características
        for (Livro livroExistente : listaLivros) {
            if (livroExistente.getTitulo().equals(livro.getTitulo()) &&
                livroExistente.getAutor().equals(livro.getAutor()) &&
                livroExistente.getGenero().equals(livro.getGenero()) &&
                livroExistente.getIdioma().equals(livro.getIdioma())) {
            
                // Livro já existe, incrementa apenas a quantidade disponível
                livroExistente.adicionarQuantidadeDisponivel();
                return; // Sai do método, pois o livro já foi encontrado
            }
        }
        listaLivros.add(livro);
        livro.adicionarQuantidadeDisponivel();
    }

    public static List<Livro> obterListaLivros() {
        return listaLivros;
    }
    
    /*public static void inicializarLivrosPadrao() {
        // Adicione livros padrão à lista
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Português");
        Livro livro2 = new Livro("Dom Quixote", "Miguel de Cervantes", "Romance", "Espanhol");
        Livro livro3 = new Livro("1984", "George Orwell", "Ficção Científica", "Inglês");

        listaLivros.add(livro1);
        listaLivros.add(livro2);
        listaLivros.add(livro3);
    }*/
}
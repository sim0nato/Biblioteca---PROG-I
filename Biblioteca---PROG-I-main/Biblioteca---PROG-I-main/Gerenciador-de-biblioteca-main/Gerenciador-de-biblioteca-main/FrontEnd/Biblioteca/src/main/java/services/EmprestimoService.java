
package services;

/**
 *
 * @author simon
 */

import entities.Livro;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private static List<Emprestimo> listaEmprestimos = new ArrayList<>();

    public static void realizarEmprestimo(Usuario usuario, Livro livro, String senha) {
        // Verifica a senha do usuário
        if (verificarSenha(usuario, senha)) {
            // Verifica se o livro está disponível
            if (livro.getQuantidadeDisponivel() > 0) {
                // Realiza o empréstimo
                usuario.adicionarLivroEmprestado(livro);
                livro.removerQuantidadeDisponivel();
                Emprestimo emprestimo = new Emprestimo(usuario, livro);
                listaEmprestimos.add(emprestimo);
            } else {
                System.out.println("Livro não disponível para empréstimo.");
            }
        } else {
            System.out.println("Senha incorreta. Empréstimo não realizado.");
        }
    }

    private static boolean verificarSenha(Usuario usuario, String senha) {
        // Verifica se a senha informada é igual à senha do usuário
        return usuario.getSenha().equals(senha);
    }

    // Outros métodos relacionados aos empréstimos podem ser adicionados aqui

    private static class Emprestimo {
        private Usuario usuario;
        private Livro livro;

        public Emprestimo(Usuario usuario, Livro livro) {
            this.usuario = usuario;
            this.livro = livro;
        }
    }
}

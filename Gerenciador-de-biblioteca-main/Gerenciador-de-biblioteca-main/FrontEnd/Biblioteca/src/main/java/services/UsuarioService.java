package services;

/**
 *
 * @author simon
 */
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    
    public static void cadastrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static List<Usuario> obterListaUsuarios() {
        return listaUsuarios;
    }
}
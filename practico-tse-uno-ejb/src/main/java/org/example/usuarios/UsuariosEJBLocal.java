package org.example.usuarios;
import javax.ejb.Local;
import java.util.List;

@Local
public interface UsuariosEJBLocal {
    List<Usuario> getUsuario();
    List<Usuario> getUsuarioByName(String name);
    void addUsuario(Usuario usuario);
}

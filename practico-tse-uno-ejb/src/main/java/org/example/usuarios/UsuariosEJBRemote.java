package org.example.usuarios;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsuariosEJBRemote {
    List<Usuario> getUsuario();
    List<Usuario> getUsuarioByName(String name);
    void addUsuario(Usuario usuario);
}

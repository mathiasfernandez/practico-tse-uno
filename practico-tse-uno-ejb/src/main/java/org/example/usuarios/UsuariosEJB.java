package org.example.usuarios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsuariosEJB implements  UsuariosEJBRemote,UsuariosEJBLocal{
    @EJB
    private UsuariosRepository repository;

    @Override
    public List<Usuario> getUsuario() {
        return repository.getUsuario();
    }

    @Override
    public List<Usuario> getUsuarioByName(String name) {
        return repository.getUsuarioByName(name);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        List<Usuario> usuarios = repository.getUsuario();
        for (Usuario i : usuarios) {
            if (i.getId() == usuario.getId()) {
                repository.addUsuario(usuario);
            }
        }
    }
}
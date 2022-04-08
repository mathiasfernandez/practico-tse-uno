package org.example.usuarios;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton

public class UsuariosRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    @Lock(LockType.WRITE)
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Lock(LockType.READ)
    public List<Usuario> getUsuario() {
        return usuarios;
    }

    @Lock(LockType.READ)
    public List<Usuario> getUsuarioByName(String name) {
        return usuarios.stream().filter((i) -> i.getNombre().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

  @PostConstruct
   public void initialize() {
        usuarios.add(new Usuario(1, "Mathias", "Fernandez", LocalDate.now()));
        usuarios.add(new Usuario(2, "Mathias2", "Fernandez2", LocalDate.now()));
  }
}
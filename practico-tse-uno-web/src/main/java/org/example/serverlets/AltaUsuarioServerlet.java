package org.example.serverlets;
import org.example.usuarios.Usuario;
import org.example.usuarios.UsuariosEJBLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet (name = "AltaUsuarioServerlet", value = "/AltaUsuarioServerlet")
public class AltaUsuarioServerlet extends HttpServlet {
    @EJB
    private UsuariosEJBLocal usuariosBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        LocalDate fechaDeNacimiento = LocalDate.parse(request.getParameter("fecha"));
        Usuario usuario = new Usuario(id, nombre, apellido, fechaDeNacimiento);
        usuariosBean.addUsuario(usuario);
        response.sendRedirect("/presentacion/index.jsp");
    }
}

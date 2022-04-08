package org.example.serverlets;
import org.example.usuarios.Usuario;
import org.example.usuarios.UsuariosEJBLocal;
import org.jetbrains.annotations.NotNull;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarUsuariosServerlet", value = "/ListarUsuariosServerlet")
public class ListarUsuariosServerlet extends HttpServlet {
    @EJB
    private UsuariosEJBLocal usuariosBean;
    
    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios;
        usuarios = usuariosBean.getUsuario();
        request.setAttribute("usuarios", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/presentacion/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

<%@ page import="org.example.usuarios.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: gabriel.azzinnari
  Date: 6/4/22
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
    String nombre = (String) request.getAttribute("nombre");
%>
<%!
    private String getDateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
%>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
        }
        thead {
            background: #163759;
            color: white;
        }
        table th {
            padding: 10px;
        }
    </style>
    <link rel="stylesheet" href="/styles/main.css">
    <title>Iniciativas - Listar</title>
</head>
<body>
<h3>Listado de Iniciativas</h3>
<form action="/ListarUsuariosServerlet" method="get">
    <input type="text" name="nombre" value="<%=(nombre != null) ? nombre : ""%>" placeholder="Buscar por nombre">
    <input type="submit" value="Buscar">
</form>
<table style="border-collapse: collapse;">
    <thead style="background: #163759; color: white;">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Fecha creación</th>
    </tr>
    </thead>
    <tbody>
    <tr><% for (Usuario i: usuarios) { %>
        <th><%=i.getId()%></th>
        <th><%=i.getNombre()%></th>
        <th><%=i.getApellido()%></th>
        <th><%=getDateString(i.getFechaNacimiento())%></th>
    </tr><% } %>
    </tbody>
</table>
</body>
</html>
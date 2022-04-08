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
%>
<%!
    private String getDateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Iniciativas - Listar</title>
</head>
<body>
<h3>Listado de Iniciativas</h3>
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
    <tr><%
    if(usuarios != null){
        for (Usuario i: usuarios) { %>
        <th><%=i.getId()%></th>
        <th><%=i.getNombre()%></th>
        <th><%=i.getApellido()%></th>
        <th><%=getDateString(i.getFechaNacimiento())%></th>
    </tr><% } }%>
    </tbody>
</table>
<form method="get" action="/presentacion/index.jsp">
    <button type="submit">Volver</button>
</form>
</body>
</html>
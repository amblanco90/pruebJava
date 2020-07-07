
<%@page import="Modelo.PQR"%>
<%@page import="ModeloDAO.PQRDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>PQRS</h1>

            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">ASUNTO</th>
                        <th class="text-center">ESTADO</th>
                        <th class="text-center">TIPO</th>
                        <th class="text-center">DOCUMENTO USUARIO</th>
                        <th class="text-center">F. CREACION</th>
                        <th class="text-center">F. LIMITE</th>

                    </tr>
                </thead>
                <%
                    PQRDAO dao = new PQRDAO();
                    int id = Integer.parseInt((String) request.getAttribute("id"));
                    List<PQR> list = dao.listarPqrId(id);
                    Iterator<PQR> iter = list.iterator();
                    PQR per = null;
                    while (iter.hasNext()) {
                        per = iter.next();%>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getAsunto()%></td>
                        <td><%= per.getEstado()%></td>
                        <td><%= per.getTipo()%></td>
                        <td><%= per.getIdUsuario()%></td>
                        <td><%= per.getFechaCreacion()%></td>
                        <td><%= per.getFechaLimite()%></td>

                    </tr>
                    <%}%>
                </tbody>
            </table>
            <a href="UsuarioControlador?accion=index">Cerrar sesión</a>
        </div>
    </body>
</html>

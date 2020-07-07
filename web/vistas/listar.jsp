
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
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
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
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PQRDAO dao = new PQRDAO();
                    List<PQR> list = dao.listar();
                    Iterator<PQR> iter = list.iterator();
                    PQR per = null;
                    while (iter.hasNext()) {
                        per = iter.next();


                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getAsunto()%></td>
                        <td><%= per.getEstado()%></td>
                        <td><%= per.getTipo()%></td>
                        <td><%= per.getIdUsuario()%></td>
                        <td><%= per.getIdUsuario()%></td>
                        <td><%= per.getFechaCreacion()%></td>
                        <td><%= per.getFechaLimite()%></td>
                        <% if (per.vencimiento(per.getFechaLimite()) == false) {%>
                        <td class="text-center">

                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId()%>">Remove</a>
                        </td>
                        <%} else {%>
                        <td class="text-center">
                            <a class="btn btn-gray" disabled>Este PQR se encuenta vencido</a>
                        </td>
                        <%}%>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            <a href="UsuarioControlador?accion=index">Cerrar sesión</a>
        </div>
    </body>
</html>

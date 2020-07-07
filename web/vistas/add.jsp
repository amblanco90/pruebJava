<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="Modelo.PQR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PQRDAO"%>
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
            <div class="col-lg-6">
                <h1>Agregar Pqr</h1>
                <form action="Controlador">

                    <div class="form-group">
                        <label for="exampleFormControlSelect2">Documento de usuario que radica el pqr:</label>
                        <select name="idUsuario" multiple class="form-control" id="exampleFormControlSelect2" required>
                            <%
                                UsuarioDAO dao = new UsuarioDAO();
                                List<Usuario> list = dao.list();
                                Iterator<Usuario> iter = list.iterator();
                                Usuario per = null;
                                while (iter.hasNext()) {
                                    per = iter.next();%>
                            <option value="<%= per.getDocumento()%>" ><%= per.getDocumento()%></option>
                            <%}%>
                        </select>
                    </div><br>
                    Asunto:<br>
                    <input class="form-control" type="text" name="Asunto"><br>
                    : <br>

                    <div class="form-group">
                        <label for="exampleFormControlSelect2">Tipo:</label>
                        <select name="Tipo" multiple class="form-control" id="exampleFormControlSelect2" required>
                            <option value="Queja" >Queja</option>
                            <option value="Peticion" >Peticion</option>
                            <option value="Reclamo" >Reclamo</option>
                        </select>
                    </div><br>

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">

                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

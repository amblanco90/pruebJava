
<%@page import="Modelo.PQR"%>
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
                <%
                    PQRDAO dao = new PQRDAO();
                    int id = Integer.parseInt((String) request.getAttribute("id"));
                    PQR p = (PQR) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">
                    Asunto:<br>
                    <input class="form-control" type="text" name="Asunto" value="<%= p.getAsunto()%>" required><br>
                    Estado actual: <%= p.getEstado()%>   <br>
                    <div class="form-group">
                        <label for="exampleFormControlSelect2">Opciones de actualizacion disponibles:</label>
                        <select name="Estado" multiple class="form-control" id="exampleFormControlSelect2" required>
                            <%if (p.getEstado().equals("Nuevo")) { %>
                            <option value="En ejecucion" >En ejecución</option>
                            <% }%>

                            <%if (p.getEstado().equals("En ejecucion")) { %>
                            <option value="Cerrado" >Cerrado</option>
                            <% }%>
                        </select>
                    </div><br>
                    <input type="hidden" name="id" value="<%= p.getId()%>">
                    <%if (p.getEstado().equals("En ejecucion") || p.getEstado().equals("Nuevo")) { %>
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <% }%>
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

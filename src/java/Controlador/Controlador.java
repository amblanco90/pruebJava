
package Controlador;

import Modelo.PQR;
import ModeloDAO.PQRDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    String listar = "vistas/listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    PQR p = new PQR();
    PQRDAO dao = new PQRDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String asunto = request.getParameter("Asunto");
            String tipo = request.getParameter("Tipo");
            String idUsuario = request.getParameter("idUsuario");

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            ;

            p.setAsunto(asunto);
            p.setTipo(tipo);
            p.setEstado("Nuevo");
            p.setIdUsuario(Integer.parseInt(idUsuario));
            p.setFechaCreacion(formatter.format(date));
            if (tipo.equals("Peticion")) {
                p.setFechaLimite(formatter.format(p.sumarRestarDiasFecha(date, 7)));
            } else if (tipo.equals("Queja")) {
                p.setFechaLimite(formatter.format(p.sumarRestarDiasFecha(date, 3)));
            } else if (tipo.equals("Reclamo")) {
                p.setFechaLimite(formatter.format(p.sumarRestarDiasFecha(date, 2)));
            }

            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String asunto = request.getParameter("Asunto");
            String estado = request.getParameter("Estado");
            p.setId(id);
            p.setAsunto(asunto);
            p.setEstado(estado);
            dao.edit(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AM BLANCO
 */
public class UsuarioControlador extends HttpServlet {

    String getUsuario = "vistas/listar.jsp";
    String login = "vistas/login.jsp";
    String listPqrUser = "vistas/pqrUser.jsp";
    String addUser = "vistas/addUser.jsp";
    String add = "vistas/listar.jsp";
    String index = "index.jsp";
    Usuario p = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
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
        if (action.equalsIgnoreCase("add")) {
            acceso = addUser;
        } else if (action.equalsIgnoreCase("index")) {
            acceso = index;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String documento = request.getParameter("Documento");
            String nombre = request.getParameter("Nombre");
            String contraseña = request.getParameter("pass");

            p.setDocumento(Integer.parseInt(documento));
            p.setNombre(nombre);
            p.setContraseña(contraseña);
            p.setRol("User");

            dao.add(p);
            System.out.println(p.getRol());

            acceso = index;
        } else if (action.equalsIgnoreCase("login")) {
            String usuario = request.getParameter("Documento");
            String pass = request.getParameter("pass");

            System.out.println(usuario);
            System.out.println(pass);

            UsuarioDAO co = new UsuarioDAO();
            try {
                if (co.list(usuario, pass).getRol().equals("Admin")) {

                    acceso = add;
                } else if (co.list(usuario, pass).getRol().equals("User")) {

                    request.setAttribute("id", co.list(usuario, pass).getDocumento().toString());

                    acceso = listPqrUser;
                }
            } catch (Exception e) {
                acceso = index;
            }

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

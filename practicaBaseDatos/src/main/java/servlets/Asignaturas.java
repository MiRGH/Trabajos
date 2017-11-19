/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;
import servicios.AsignaturasServicios;

/**
 *
 * @author daw
 */
@WebServlet(name = "Asignaturas", urlPatterns = {"/asignaturas"})
public class Asignaturas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AsignaturasServicios as = new AsignaturasServicios();

        if (request.getParameter("opcion") != null) {
            Asignatura a = new Asignatura();
            boolean error;
            String opcion = request.getParameter("opcion");
            a.setNombre(request.getParameter("nombre"));
            a.setCiclo(request.getParameter("ciclo"));
            a.setCurso(request.getParameter("curso"));

            switch (opcion) {
                case "insert":
                    as.addAsignaturas(a);
                    break;
                case "delete":
                    a.setId(Long.parseLong(request.getParameter("id")));
                    error = as.delAsignaturas(a);
                    request.setAttribute("hecho", error);
                    break;
                case "update":
                    a.setId(Long.parseLong(request.getParameter("id")));
                    error = as.updAsignaturas(a);
                    request.setAttribute("hecho", error);
                    break;
            }

        }

        request.setAttribute("asignaturas", as.getAllAsignaturas());
        request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

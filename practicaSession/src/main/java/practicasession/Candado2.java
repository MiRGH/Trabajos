/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicasession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constantes;

/**
 *
 * @author DAW
 */
@WebServlet(name = "Candado2", urlPatterns = {"/candado2"})
public class Candado2 extends HttpServlet {

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
        
        String paginaDestino = Constantes.ERROR;
        String nivelSalida = "1";
        String nivelEntrada="1";
        String nivel1="2.1";
        String nivel2="2.2";
        String nivel3="2.3";
        
        if (request.getSession().getAttribute(Constantes.ATTRIBUTE_NAME) != null) {
            //1ºnivel
            if (request.getSession().getAttribute(Constantes.ATTRIBUTE_NAME).equals(nivelEntrada)) {
                if (request.getParameter(Constantes.PASS).equals(Constantes.NIVEL_2_1)) {

                    paginaDestino = Constantes.SUPERADO;
                    nivelSalida = nivel1;
                }
            }
            //2ºnivel
            if (request.getSession().getAttribute(Constantes.ATTRIBUTE_NAME).equals(nivel1)) {
                if (request.getParameter(Constantes.PASS).equals(Constantes.NIVEL_2_2)) {

                    paginaDestino = Constantes.SUPERADO;
                    nivelSalida = nivel2;
                }
            }
            //3ºnivel
            if (request.getSession().getAttribute(Constantes.ATTRIBUTE_NAME).equals(nivel2)) {
                if (request.getParameter(Constantes.PASS).equals(Constantes.NIVEL_2_3)) {

                    paginaDestino = Constantes.SUPERADO;
                    nivelSalida = nivel3;
                }
            }

        }

        request.getSession().setAttribute(Constantes.ATTRIBUTE_NAME, nivelSalida);
        request.getRequestDispatcher(paginaDestino).forward(request, response);
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

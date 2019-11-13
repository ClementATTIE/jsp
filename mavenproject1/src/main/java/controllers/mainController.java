/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.DAO;
import DAO.DAOException;
import DAO.DataSourceFactory;
import DAO.entity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.derby.client.am.SqlException;

/**
 *
 * @author pedago
 */
@WebServlet(name = "main", urlPatterns = "/main")

public class mainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        try {
            DAO dao = new DAO(DataSourceFactory.getDataSource());

            String removeCode = request.getParameter("code");

            if (removeCode != null) {
                try {
                    dao.remove(removeCode);
                } catch (Exception e) {

                    request.setAttribute("error", e);
                    //Logger.getLogger("servlet").log(Level.SEVERE, "" + e);

                }

            }
            //Logger.getLogger("servlet").log(Level.SEVERE, "OK" + removeCode);

            String addCode = request.getParameter("addCode");
            String addTaux = request.getParameter("addTaux");

            if (addCode != null) {
                try {
                    Logger.getLogger("servlet").log(Level.SEVERE, "OK" + addCode + " " + addTaux);
                    dao.add(addCode, Double.valueOf(addTaux));
                } catch (Exception e) {
                    //Logger.getLogger("servlet").log(Level.SEVERE, "" + e);
                    request.setAttribute("error", e);

                }
            }

            List<entity> E = dao.getEntity();

            // On renseigne un attribut utilisé par la vue
            request.setAttribute("CODE", E);

            // On redirige vers la vue
            request.getRequestDispatcher("vue/mainjsp.jsp").forward(request, response);

        } catch (DAOException | IOException | SQLException | ServletException e) {
            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", e);
            // On renseigne un attribut utilisé par la vue

            // On redirige vers la page d'erreur
            request.getRequestDispatcher("vue/errorView.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

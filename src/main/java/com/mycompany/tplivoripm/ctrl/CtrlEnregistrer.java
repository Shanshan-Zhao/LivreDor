/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tplivoripm.ctrl;

import com.mycompany.tplivoripm.dao.MessageDorDao;
import com.mycompany.tplivoripm.metier.MessageDor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZssSy
 */
public class CtrlEnregistrer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recupération des paramètres
        String p = request.getParameter("pseudo");
        String m = request.getParameter("message");
        
        request.setAttribute("m", m);
        
        // texte les paramètres
        if(p.isEmpty()){
            // chainage vers "Saisir.jsp" avec message
            request.setAttribute("msg_info", "Veuillez saisir un pseudo!");
            request.getRequestDispatcher("Saisir").forward(request, response);
        }else if(m.isEmpty()){
            // chainage vers "Saisir.jsp" avec message
            request.setAttribute("msg_info", "Veuillez saisir un message!");
            request.getRequestDispatcher("Saisir").forward(request, response);
        }else{
            // creation d'un objet MessageDor
            MessageDor msg = new MessageDor(p, m);
            
            try {
                // enregistrement en BD
                MessageDorDao.creationMessage(msg);
            
                // chainaghe ou redirection
                response.sendRedirect("CtrlCentral?method=accueil");
//                request.getRequestDispatcher("Saisir").forward(request, response);
            }catch(Exception ex){
                // chainage
                request.setAttribute("msg_erreur", ex.getMessage());
                request.getRequestDispatcher("Saisir").forward(request, response);
            }   
        }
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

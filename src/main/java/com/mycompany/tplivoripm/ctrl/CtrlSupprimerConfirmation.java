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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZssSy
 */
public class CtrlSupprimerConfirmation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m = request.getParameter("choix");
        HttpSession session = request.getSession(true);
        String[] NumMsg = (String[])session.getAttribute("NumMsg");
        session.setAttribute("NumMsg", NumMsg);

        try {
            // lire la liste des messages
            ArrayList<MessageDor> liste = MessageDorDao.loadMessages();
            request.setAttribute("liste_msg", liste);
        }catch(Exception ex){
            // chainage vers "Accueil.jsp"
            request.setAttribute("msg_erreur", ex.getMessage());
        }
             
        if(NumMsg != null && NumMsg.length > 0){
            switch(m){
                case "oui":
                    try {
                        request.setAttribute("lengthv  ", NumMsg.length); 
                        for (String id : NumMsg){
                            // suppression de msg{
                            MessageDorDao.supprimer(id);
                            request.setAttribute("msg_info", "Suppression réussie");
                            request.getRequestDispatcher("SupprimerResultat").forward(request, response);
                        }
                    }catch(Exception ex){
                        // chainage
                        request.setAttribute("msg_erreur", ex.getMessage());
                        request.getRequestDispatcher("Supprimer").forward(request, response);
                    } 
                    break;
                case "non":
                    request.getRequestDispatcher("Supprimer").forward(request, response);
                    break;
            }
        }else{
            request.setAttribute("msg_erreur", "Veuillez choisir un message à supprimer!");
            request.getRequestDispatcher("Supprimer").forward(request, response);
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

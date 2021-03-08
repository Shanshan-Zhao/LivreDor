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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZssSy
 */
public class CtrlModifier extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] NumMsg = request.getParameterValues("radio");
        String p = request.getParameter("pseudo");
        String t = request.getParameter("texte");
//        String id = (String)request.getAttribute("NumMsg");
        HttpSession session = request.getSession(true);
        MessageDor msg = (MessageDor)session.getAttribute("msg");
        System.out.println("====================================");
        System.out.println(msg.getId());
//        System.out.println("====================================");
//        System.out.println(id);
        if(msg != null){
            System.out.println("0");
//            HttpSession session = request.getSession(true);
//            session.setAttribute("NumMsg", NumMsg);
            try{
                
                MessageDorDao.modifier(msg.getId(), p, t);
                System.out.println("MODIFIER");
                request.setAttribute("NumMsg", msg.getId());
                System.out.println("M2");
                request.setAttribute("msg_info", "Modification réussie !");
                System.out.println("M3");
                request.getRequestDispatcher("ModifierResultat").forward(request, response);
                System.out.println("1");
            }catch(Exception ex){
                // chainage
                
                request.setAttribute("msg_erreur", ex.getMessage());
                request.getRequestDispatcher("CtrlCentral?method=modifier").forward(request, response);
                System.out.println("2");
            } 
        }else{
            
            request.setAttribute("msg_info", "Veuillez choisir un message à modifier!");
            request.getRequestDispatcher("CtrlCentral?method=modifier").forward(request, response);
            System.out.println("3");
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

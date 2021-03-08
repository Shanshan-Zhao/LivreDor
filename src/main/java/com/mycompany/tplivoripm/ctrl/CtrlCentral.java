package com.mycompany.tplivoripm.ctrl;

import com.mycompany.tplivoripm.dao.MessageDorDao;
import com.mycompany.tplivoripm.metier.MessageDor;
import com.mycompany.tplivoripm.metier.Outil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZssSy
 */
public class CtrlCentral extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer le paramètre "method"
        String m = request.getParameter("method");
        
        // traitement 
        switch(m){
            case "saisir":
                // chainage ver la page Saisir.jsp
                request.getRequestDispatcher("Saisir").forward(request, response);
                break;
            case "afficher":
                try {
                    // lire la liste des messages
                    ArrayList<MessageDor> liste = MessageDorDao.loadMessages();
                    
                    // chainage vers la vue "Afficher.jsp" avec la liste 
                    request.setAttribute("liste_msg", liste);
                    request.getRequestDispatcher("Lecture").forward(request, response);
                }catch(Exception ex){
                    // chainage vers "Accueil.jsp"
                    request.setAttribute("msg_erreur", ex.getMessage());
                    request.getRequestDispatcher("Accueil").forward(request, response);
                }
                break;
            case "modifier":
                try {
                    // lire la liste des messages
                    ArrayList<MessageDor> liste = MessageDorDao.loadMessages();
                    
                    // chainage vers la vue "Afficher.jsp" avec la liste 
                    request.setAttribute("liste_msg", liste);
                    request.getRequestDispatcher("Modifier").forward(request, response);
                }catch(Exception ex){
                    // chainage vers "Accueil.jsp"
                    request.setAttribute("msg_erreur", ex.getMessage());
                    request.getRequestDispatcher("Accueil").forward(request, response);
                }
                break;
            case "supprimer":
                try {
                    // lire la liste des messages
                    ArrayList<MessageDor> liste = MessageDorDao.loadMessages();
                    
                    // chainage vers la vue "Afficher.jsp" avec la liste 
                    request.setAttribute("liste_msg", liste);
                    request.getRequestDispatcher("Supprimer").forward(request, response);
                }catch(Exception ex){
                    // chainage vers "Accueil.jsp"
                    request.setAttribute("msg_erreur", ex.getMessage());
                    request.getRequestDispatcher("Accueil").forward(request, response);
                }
                break;
            case "accueil":
                request.getRequestDispatcher("Accueil").forward(request, response);
                break;
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

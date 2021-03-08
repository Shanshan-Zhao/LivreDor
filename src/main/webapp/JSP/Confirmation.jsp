<%-- 
    Document   : Confirmation
    Created on : 3 mars 2021, 12:10:43
    Author     : ZssSy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Confirmer la suppresion du ou des messages suivants</h1>
        <%
            String[] NumMsg = (String[])session.getAttribute("NumMsg");
            session.setAttribute("NumMsg", NumMsg);
            if (NumMsg != null && NumMsg.length > 0){
                for(int i = 0; i< NumMsg.length; i++){
                    out.println(NumMsg[i]);
                    out.println("</br>");
                }
            }
        %>
        </br>
        <ul>
            <li><a href="CtrlSupprimerConfirmation?choix=oui"><bouton class="bouton">Oui</bouton></a></li>
            <li><a href="CtrlSupprimerConfirmation?choix=non"><bouton class="bouton">Non</bouton></a></li>
            <li><a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour menu principal</bouton></a></li>
        </ul>
                  
    </body>
</html>

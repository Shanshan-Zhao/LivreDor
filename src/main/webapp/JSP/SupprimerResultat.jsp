<%-- 
    Document   : SupprimerResultat
    Created on : 3 mars 2021, 17:00:59
    Author     : ZssSy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compte-rendu</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Compte-rendu de la suppression du ou des message(s)</h1>
        <%
            String[] NumMsg = (String[])session.getAttribute("NumMsg");
//            String length = (String) session.getAttribute("length");
            for(String s : NumMsg){
                out.println(s);
            }
        
            out.println("</br>");
        %>
        <div class="msg_info">${requestScope.msg_info}</div>
        <div class="msg_erreur">${requestScope.msg_erreur}</div>
        </br>
        <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
    </body>
</html>

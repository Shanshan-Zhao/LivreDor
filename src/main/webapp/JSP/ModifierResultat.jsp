<%-- 
    Document   : ModifierResultat
    Created on : 5 mars 2021, 15:47:11
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
        <h1>Compte-rendu de la modification du message</h1>
        <%
            out.println((int)request.getAttribute("NumMsg"));
            out.println("</br>");
        %>
        <div class="msg_info">${requestScope.msg_info}</div>
        <div class="msg_erreur">${requestScope.msg_erreur}</div>
        </br>
        <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
    </body>
</html>

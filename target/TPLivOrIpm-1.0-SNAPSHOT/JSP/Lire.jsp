<%-- 
    Document   : Lire
    Created on : 2 mars 2021, 14:31:51
    Author     : ZssSy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.tplivoripm.metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lire</title>
        <!-- Le fichier est associé à styleAccueil.css qui est chargé de la mise en forme-->
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Liste des messages</h1>
        <%
            ArrayList<MessageDor> liste = (ArrayList<MessageDor>)request.getAttribute("liste_msg");
            out.println("<table>");
            out.println("<tr><th>Pseudo</th>");
            out.println("<th>Message</th><tr>");
            for(MessageDor msg : liste){
                out.println("<tr><td>" + msg.getPseudo() + "</td>");
                out.println("<td>" + msg.getTexte() + "</td></tr>");
            }
            out.println("</table>");
        %>
        <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
    </body>
</html>

<%-- 
    Document   : Modifier
    Created on : 5 mars 2021, 14:56:59
    Author     : ZssSy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.tplivoripm.metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Modifier un message</h1>
        <form id="form" action="CtrlModifierInfos" method="post">
            <%
                String[] lst = (String[]) session.getAttribute("NumMsg");
                ArrayList<MessageDor> liste = (ArrayList<MessageDor>) request.getAttribute("liste_msg");
                out.println("<table>");
                out.println("<tr><th>Choix</th>");
                out.println("<th>Pseudo</th>");
                out.println("<th>Message</th><tr>");
                for (MessageDor msg : liste) {
                    out.println("<tr><td><input type='radio' name='radio' " + "value=" + msg.getId() + "></td>");
                    out.println("<td>" + msg.getPseudo() + "</td>");
                    out.println("<td>" + msg.getTexte() + "</td></tr>");
                }
                out.println("</table>");
            %>
            </br>
            <div class="msg_info">${requestScope.msg_info}</div>
            <div class="msg_erreur">${requestScope.msg_info}</div>
            <bouton class="bouton"><input type="submit" value="Modifier"></bouton>
            <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
        </form>
    </body>
</html>

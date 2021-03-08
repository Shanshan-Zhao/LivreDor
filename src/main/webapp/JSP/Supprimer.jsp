<%-- 
    Document   : Supprimer
    Created on : 3 mars 2021, 09:52:33
    Author     : ZssSy
--%>

<%@page import="java.util.Arrays" %>
<%@page import="com.mycompany.tplivoripm.metier.Outil" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.tplivoripm.metier.MessageDor" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>

    <body>
        <h1>Liste des messages</h1>

        <form id="form" action="CtrlSupprimer" method="post">
            <%
                String[] lst = (String[]) session.getAttribute("NumMsg");
                ArrayList<MessageDor> liste = (ArrayList<MessageDor>) request.getAttribute("liste_msg");
                out.println("<table>");
                out.println("<tr><th>Choix</th>");
                out.println("<th>Pseudo</th>");
                out.println("<th>Message</th><tr>");
                for (MessageDor msg : liste) {
                    String checked = Outil.checkLst(String.valueOf(msg.getId()), lst);
                    out.println("<tr><td><input type='checkbox' name='cb' " + "value=" + msg.getId() + " " + checked + "></td>");
                    out.println("<td>" + msg.getPseudo() + "</td>");
                    out.println("<td>" + msg.getTexte() + "</td></tr>");
                }
                out.println("</table>");
            %>
            </br>
            <div class="msg_info">${requestScope.msg_info}</div>
            <input class="bouton" type="submit" value="Supprimer">
            <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
        </form>
    </body>
</html>




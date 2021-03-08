<%-- 
    Document   : ModifierInfos
    Created on : 5 mars 2021, 15:15:41
    Author     : ZssSy
--%>

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
        <h1>Saisir des information à mettre à jour</h1>
        <form action="CtrlModifier" method="POST">
            <%
                MessageDor msg = (MessageDor)request.getAttribute("msg");
//                request.setAttribute("NumMsg", String.valueOf(msg.getId()));
                session.setAttribute("msg", msg);
                System.out.println("========================================");
                System.out.println(msg.getId());
                out.println("Pseudo <input type='text' name='pseudo' value=" + msg.getPseudo() + "><br/><br/>");
                out.println("Message <input type='text' name='texte' value=" + msg.getTexte() + "><br/><br/>");
            %>       
            <div class="msg_info">${requestScope.msg_info}</div>
            <div class="msg_erreur" style="color:red;">${requestScope.msg_erreur}</div>

            <input class="bouton" type="submit" value="Enregistrer">
            <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
        </form>
    </body>
</html>

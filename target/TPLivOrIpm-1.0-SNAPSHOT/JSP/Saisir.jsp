<%-- 
    Document   : Saisir
    Created on : 1 mars 2021, 14:16:24
    Author     : ZssSy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisir</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Veuillez saisir un message</h1>
        <form action="CtrlEnregistrer" method="GET">
            Pseudo <input type="text" name="pseudo" value="${param.pseudo}"><br/>
            <br/>
            Message <input type="text" name="message" value="${requestScope.m}"><br/>
            <br/>
            <div class="msg_info">${requestScope.msg_info}</div>
            <div class="msg_erreur" style="color:red;">${requestScope.msg_erreur}</div>

            <input class="bouton" type="submit" value="Enregistrer">
            <a href="CtrlCentral?method=accueil"><bouton class="bouton">Retour</bouton></a>
        </form>

        
    </body>
</html>

<%-- 
    Document   : Accueil
    Created on : 26 févr. 2021, 15:59:21
    Author     : ZssSy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Le livre d'or</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <h1>Le livre d'or</h1>
        <ul>
            <li><a href="CtrlCentral?method=afficher"><bouton class="bouton">Afficher<bouton></a></li>
            <li><a href="CtrlCentral?method=saisir"><bouton class="bouton">Saisir<bouton></a></li>
            <li><a href="CtrlCentral?method=modifier"><bouton class="bouton">Modifier<bouton></a></li>
            <li><a href="CtrlCentral?method=supprimer"><bouton class="bouton">Supprimer<bouton></a></li>
        </ul>
        <div>${msg_erreur}</div>
    </body>
</html>

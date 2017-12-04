<%-- 
    Document   : Index
    Created on : 30/11/2017, 01:14:00
    Author     : Rafael Andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CakePHP - Build fast, grow solid | PHP Framework | Home</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="shortcut icon " type="image/x-png" href="css/cakephp.png">
        <script src="js/progressbar.js" ></script>
    </head>
    <body>	
        <jsp:include page="Shared/Nav.jsp"/>
        <div class="ghost">
            <h1>New CakePHP 3.4 Red Velvet.</h1>
            <h3>Faster. Stronger. Tastier.</h3>
        </div>
        <div id="overlay">
            <div id="progstat"></div>
            <div id="progress"></div>
        </div>
    </body>
</html>

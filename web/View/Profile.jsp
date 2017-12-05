<%-- 
    Document   : Profile
    Created on : 04/12/2017, 20:08:22
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
        <section id="core">
            <table>
            <tbody>
                <tr>
                    <td>Name: </td>
                    <td>${userSession.name}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${userSession.email}</td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${userSession.address}</td>
                </tr>
            </tbody>
        </table>
        </section>
    </body>
</html>

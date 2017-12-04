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
        <table>
            <tbody>
                <tr>
                    <td>Name: </td>
                    <td>${sessao.nome}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${sessao.email}</td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${sessao.endereco}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>

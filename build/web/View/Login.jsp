<%-- 
    Document   : Login
    Created on : 30/11/2017, 01:45:01
    Author     : Rafael Andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CakePHP - Build fast, grow solid | PHP Framework | Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="shortcut icon " type="image/x-png" href="css/cakephp.png">
    </head>
    <body>	
        <jsp:include page="Shared/Nav.jsp"/>
        <div class="login-container">
            <div class="login-formulario">
                <form action="./ValidaLogin" method="POST">
                    <label for="email" class="label-login">
                        <span>Email</span>
                    </label>
                    <input type="text" name="txtEmail" id="email" placeholder="Ex: jose@email.com" class="input-form">
                    <label for="senha" class="label-login">
                        <span>Password</span>
                    </label>
                    <input type="password" name="txtSenha" id="senha" class="input-form">
                    <a href="./Register">Register</a>
                    <p><a href="./Index">HomePage</a></p>
                    <input onclick = "move()" type="submit" value="Entrar" id="btnSubmit">
                </form>
            </div>
        </div>
    </html>
</body>
</html>

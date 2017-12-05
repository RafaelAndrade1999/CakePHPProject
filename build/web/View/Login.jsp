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
        <script src="js/jquery-3.2.1.js" ></script>
        <script src="js/login.js" ></script>
        <script src="js/progressbar.js" ></script>
    </head>
    <body>	
        <jsp:include page="Shared/Nav.jsp"/>
        <div class="login-container">
            <div class="login-formulario">
                <form action="./LoginController" method="POST">
                    <label for="email" class="label-login">
                        <span>Email</span>
                    </label>
                    <input type="text" name="txtEmail" id="email" class="input-form">
                    <label for="password" class="label-login">
                        <span>Password</span>
                    </label>
                    <input type="password" name="txtPass" id="password" class="input-form">
                    <a href="./Register">Register</a>
                    <p><a href="./Index">HomePage</a></p>
                    <input type="submit" value="Login" id="btnSubmit">
                    <div id="overlay">
                        <div id="progstat"></div>
                        <div id="progress"></div>
                    </div>
                </form>
            </div>
        </div>
</html>
</body>
</html>

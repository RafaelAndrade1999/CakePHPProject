<%-- 
    Document   : Register
    Created on : 30/11/2017, 01:45:11
    Author     : Rafael Andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CakePHP - Build fast, grow solid | PHP Framework | Register</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="shortcut icon " type="image/x-png" href="css/cakephp.png">
        <script src="js/jquery-3.2.1.min.js" ></script>
        <script type="text/javascript" src="js/cadastro.js"></script>
        <script src="js/progressbar.js" ></script>
    </head>
    <body>	
        <jsp:include page="Shared/Nav.jsp"/>
        <div class="login-container">
            <div class = "login-topo">
                <span class="titulo-topo">Register</span>
            </div>
            <div class="login-formulario">
                <form action="./RegisterController" method="POST" id="frmCadastro">
                    <label class="label-login">Name</label>
                    <input type="text" name="txtName" id="name" class="input-form"/>
                    <label class="label-login">Address</label>
                    <input type="text" name="txtAddress" id="address" class="input-form"/>
                    <label for="email" class="label-login">
                        <span>Email</span>
                    </label>
                    <input type="text" name="txtEmail" id="email" class="input-form"/>
                    <label for="password" class="label-login">
                        <span>Password</span>
                    </label>
                    <input type="password" name="txtPass" id="password" class="input-form"/>
                    <label for="password" class="label-login">
                        <span>Repeat Password</span>
                    </label>
                    <input type="password" name="txtConfirmPass" id="confirmPass" class="input-form"/>
                    <a href="./Index">HomePage</a>
                    <input type="submit" value="Register" id="btnSubmit"/>
                </form>
            </div>
        </div>
    </body>
    <div id="overlay">
        <div id="progstat"></div>
        <div id="progress"></div>
    </div>
</html>

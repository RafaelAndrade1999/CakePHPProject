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
    </head>
    <body>	
        <jsp:include page="Shared/Nav.jsp"/>
        <div class="login-container">
            <div class = "login-topo">
                <span class="titulo-topo">Register</span>
            </div>
            <div class="login-formulario">
                <form action="./ValidaCadastro" method="POST" id="frmCadastro">
                    <label class="label-login">Name</label>
                    <input type="text" name="txtNome" id="nome" class="input-form"/>
                    <label class="label-login">Adress</label>
                    <input type="text" name="txtEndereco" id="endereco" class="input-form"/>
                    <label for="email" class="label-login">
                        <span>Email</span>
                    </label>
                    <input type="text" name="txtEmail" id="email" placeholder="Ex: jose@email.com" class="input-form"/>
                    <label for="senha" class="label-login">
                        <span>Password</span>
                    </label>
                    <input type="password" name="txtSenha" id="senha" class="input-form"/>
                    <label for="senha" class="label-login">
                        <span>Repeat Password</span>
                    </label>
                    <input type="password" name="txtConfirmaSenha" id="confirmaSenha" class="input-form"/>
                    <a href="./Login">Go Back</a>
                    <input type="submit" value="Register" id="btnSubmit"/>
                </form>
            </div>
        </div>
    </body>
</html>

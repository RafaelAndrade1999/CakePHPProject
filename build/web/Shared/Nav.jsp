<%-- 
    Document   : Nav
    Created on : 30/11/2017, 01:18:47
    Author     : Rafael Andrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="topdiv">
    <a href="./Index"><img src="css/cake-logo.svg" id="logoo"></a>
    <a href=""><div class="donate"><p class="donatetxt">DONATE</p></div></a>
    <div class="dropdown">
        <button class="first">Team</button>
    </div>
    <div class="dropdown">
        <button class="first">Road Trip</button>
        <img src="css/new-tag.svg" class="new-tag">
    </div>
    <div class="dropdown">
        <button class="first">Swag</button>
    </div>
    <div class="dropdown">
        <a href="Login"><button class="first">Login</button></a>
    </div>
    <div class="dropdown">
        <a href="Register"><button class="first">Register</button></a>
    </div>
    <div class="dropdown">
        <a href="Upload"><button class="first">Upload</button></a>
    </div>
    <form action="./Search" method="GET">
            <input type="text" name="txtProcura" />
            <a href="Search"><button class="first">Search</button></a>
    </form>
    <a href=""><div class="lines"></div></a>
</div>
<a href="">
    <div class="cookbook">
        <p class="cookbooktxt">CakePHP <strong>Cookbook</strong></p>
        <img src="css/book.png" class="book">
    </div>
</a>
<a href="">
    <div class="api">
        <p class="apitxt">CakePHP <strong>API</strong></p>
        <img src="css/tools.png" class = "tools">
    </div>
</a>

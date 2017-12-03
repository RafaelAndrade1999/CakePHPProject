/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("document").ready(function () {
    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        
        $.post('./ValidaLoginAJAX',
            {
                txtEmail: $("#email").val(), 
                txtSenha: $("#senha").val()
            },
            function(responseText){
                responseText = JSON.parse(responseText);
                alert(responseText.msg);
                if(responseText.loginValido)
                    window.location.href="./Index";
            }
        
        );

    });
});


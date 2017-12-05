$("document").ready(function () {
    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        
        $.post('./LoginController',
            {
                txtEmail: $("#email").val(), 
                txtPass: $("#password").val()
            },
            function(responseText){
                responseText = JSON.parse(responseText);
                alert(responseText.msg);
                if(responseText.validLogin)
                    window.location.href="./Index";
            }
        
        );

    });
});


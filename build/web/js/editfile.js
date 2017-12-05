/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$("document").ready(function () {

    $(".editButton").click(function () {
        var id = $(this).attr("id");
        $("#editFileModal").modal();
        $("#saveButton").click(function () {
            fileEdit(id);
        });

        function fileEdit(id) {
            var obj = {
                id: id,
                fileName: $("#txtFileName").val()
            };
            $.ajax({
                url: './FileEditController',
                data: obj,
                method: 'GET',
                success: function (response) {
                    $("#editFileModal").modal('hide');
                    if (response.sucesso) {
                        $("#foto-" + id).attr("src", response.src);
                        $("#nome-foto-" + id).html("File Name:" + response.nome);
                    }
                    alert(response.msg);
                },
            });
        }
    });

});
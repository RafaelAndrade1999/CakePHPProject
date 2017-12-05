/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$("document").ready(function () {

    $(".editButton").click(function () {
        var id = $(this).attr("id");
        $("#modalEditarArquivo").modal();
        $("#btnEditar").click(function () {
            editarArquivo(id);
        });

        function editarArquivo(id) {
            var obj = {
                id: id,
                nomeArquivo: $("#txtNomeArquivo").val()
            };
            $.ajax({
                url: './FileEditController',
                data: obj,
                method: 'GET',
                success: function (response) {
                    $("#modalEditarArquivo").modal('hide');
                    if (response.sucesso) {
                        $("#foto-" + id).attr("src", response.src);
                        $("#nome-foto-" + id).html("Nome da imagem:" + response.nome);
                    }
                    alert(response.msg);
                },
            });
        }
    });

});
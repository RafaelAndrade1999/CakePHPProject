window.onload = function () {
    document.getElementById('frmCadastro').onsubmit = function () {
        if (!validaSenhas()) {
            alert("Senhas não batem ou com menos de 5 caracteres!");
            return false;
        }
        if (!validaNome()) {
            alert("Nome muito pequeno!");
            return false;
        }
        if (!validaEndereco()) {
            alert("Endereco inválido!");
            return false;
        }
        if (!validaEmail()) {
            alert("Email invalido!");
            return false;
        }
        return true;
    }

    function validaSenhas() {
        var senha = document.getElementById('senha');
        var confirmaSenha = document.getElementById('confirmaSenha');
        console.log(senha.value + " = " + confirmaSenha.value);
        return (senha.value == confirmaSenha.value) && (senha.value.length >= 5);
    }
    function validaNome() {
        var nome = document.getElementById('nome').value;
        return nome.length > 3;
    }
    function validaEndereco() {
        var endereco = document.getElementById('endereco').value;
        return endereco.length > 3;
    }
    function validaEmail() {
        var email = document.getElementById('email').value;
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
    }


}
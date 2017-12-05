window.onload = function () {
    document.getElementById('frmCadastro').onsubmit = function () {
        if (!passController()) {
            alert("Invalid Password(s)!");
            return false;
        }
        if (!nameController()) {
            alert("Name too Short!");
            return false;
        }
        if (!addressController()) {
            alert("Invalid Address!");
            return false;
        }
        if (!emailController()) {
            alert("Invalid Email!");
            return false;
        }
        return true;
    };

    function passController() {
        var password = document.getElementById('password');
        var confirmPass = document.getElementById('confirmPassword');
        console.log(password.value + " = " + confirmPass.value);
        return (password.value === confirmPass.value) && (password.value.length >= 5);
    }
    function nameController() {
        var name = document.getElementById('name').value;
        return name.length > 3;
    }
    function addressController() {
        var address = document.getElementById('address').value;
        return address.length > 3;
    }
    function emailController() {
        var email = document.getElementById('email').value;
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
    }


};
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rafael Andrade
 */
public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private boolean administrador;
    public User(){
        
    }
    public User (String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    public User(String nome, String email, String senha,String endereco){
        this(email,senha);
        this.nome = nome;
        this.endereco = endereco;
    }
    public User(int id,String nome, String endereco, String email, String senha,boolean administrador){
        this(nome,  email, senha,endereco);
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}

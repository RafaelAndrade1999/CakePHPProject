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
public class Arquivo {

    private String nome;
    private Usuario usuario;
    private String descricao;
    private String diretorio;
    private String formato;

    public Arquivo() {

    }

    public Arquivo(String nome, Usuario usuario, String diretorio, String formato) {
        this.nome = nome;
        this.usuario = usuario;
        this.diretorio = diretorio;
        this.formato = formato;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

}

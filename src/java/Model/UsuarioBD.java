/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import BD.BancoDados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael Andrade
 */
public class UsuarioBD {
    private BancoDados bd;
    private final String GET_USUARIO_SQL = "select id,nome,email,administrador from usuario ";
    public Usuario getUsuario(String email){
        Usuario us = null;
        bd = new BancoDados();
        
        ResultSet rs;
        try {
            bd.abrir();
            rs = bd.select(GET_USUARIO_SQL+" where email='"+email+"'");
            if(rs.next()){
                us = new Usuario(rs.getInt("id"), rs.getString("nome"),"", rs.getString("email"),"",rs.getBoolean("administrador"));
                System.out.println("Id "+us.getId());
            }
            return us;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return us;
        }

    }
    public boolean validaUsuario(Usuario usuario){
        try{
            bd = new BancoDados();
            bd.abrir();
            ResultSet rs = bd.select("select email,senha from usuario where email='"+usuario.getEmail()+"'");
            if(rs.next()){
                String senha = rs.getString("senha");
                return senha.equals(usuario.getSenha());
            }
            return false;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return false;
        }finally{
            bd.fecharConexao();
        }
    }
    public boolean insereUsuario(Usuario usuario){
        boolean retorno = false;
        try{
            bd=new BancoDados();
            bd.abrir();
            retorno = bd.insert("insert into usuario (nome,email,senha,endereco)  values ('"+usuario.getNome()+"',"+
                    "'"+usuario.getEmail() +"','"+usuario.getSenha()+"','"+usuario.getEndereco()+"')") > 0;
        }catch(Exception err){
            System.out.println(err.getMessage());
            retorno = false;
        }finally{
            bd.fecharConexao();
        }
        return retorno;
    }
    public boolean ehAdministrador(Usuario usuario){
        boolean retorno = false;
        try{
            bd = new BancoDados();
            bd.abrir();
            String sql = "select administrador from usuario where email='"+usuario.getEmail()+"'";
            ResultSet rs = bd.select(sql);
            if(rs.next()){
                retorno = rs.getBoolean("administrador");
            }
            return retorno;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return retorno;
        }finally{
            bd.fecharConexao();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import DB.DataBase;
import java.sql.ResultSet;
/**
 *
 * @author Rafael Andrade
 */
public class UserDB {
    private DataBase bd;
    private final String GET_USER_SQL = "select id,nome,email,administrador,endereco from usuario ";
    public User getUser(String email){
        User us = null;
        bd = new DataBase();
        
        ResultSet rs;
        try {
            bd.openConnection();
            rs = bd.select(GET_USER_SQL+" where email='"+email+"'");
            if(rs.next()){
                us = new User(rs.getInt("id"), rs.getString("nome"),rs.getString("endereco"), rs.getString("email"),"",rs.getBoolean("administrador"));
            }
            return us;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return us;
        }

    }
    public boolean updateUser(User user){
        try{
            DataBase bd = new DataBase();
            bd.openConnection();
            String sql = "update usuario set nome = '"+user.getName()+"' where email = "+user.getEmail();
            return bd.insert(sql) > 0;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return false;
        }
    }
    public boolean userController(User user){
        try{
            bd = new DataBase();
            bd.openConnection();
            ResultSet rs = bd.select("select email,senha from usuario where email='"+user.getEmail()+"'");
            if(rs.next()){
                String password = rs.getString("senha");
                return password.equals(user.getPassword());
            }
            return false;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return false;
        }finally{
            bd.close();
        }
    }
    public boolean userInsert(User user){
        boolean retorno = false;
        try{
            bd=new DataBase();
            bd.openConnection();
            retorno = bd.insert("insert into usuario (nome,email,senha,endereco)  values ('"+user.getName()+"',"+
                    "'"+user.getEmail() +"','"+user.getPassword()+"','"+user.getAddress()+"')") > 0;
        }catch(Exception err){
            System.out.println(err.getMessage());
            retorno = false;
        }finally{
            bd.close();
        }
        return retorno;
    }
    public boolean isAdmin(User user){
        boolean retorno = false;
        try{
            bd = new DataBase();
            bd.openConnection();
            String sql = "select administrador from usuario where email='"+user.getEmail()+"'";
            ResultSet rs = bd.select(sql);
            if(rs.next()){
                retorno = rs.getBoolean("administrador");
            }
            return retorno;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return retorno;
        }finally{
            bd.close();
        }
    }
}

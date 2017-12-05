/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.DataBase;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Andrade
 */
public class FileDB {

    String sql
            = "select u.email,u.nome as nome_usuario,a.id,a.nome,a.diretorio,a.formato "
            + "from arquivos a inner join usuario u on (u.id=a.id_usuario) ";

    public boolean insertFile(File file) {
        try {
            DataBase db = new DataBase();
            db.openConnection();
            file.setDirectory(Util.getRelativeDirectory(file.getDirectory(), "uploads"));
            String sql
                    = "insert into arquivos (id_usuario,nome,diretorio,formato) values"
                    + "(" + file.getUser().getId() + ",'" + file.getName() + "','" + file.getDirectory() + "',"
                    + "'" + file.getFormat() + "')";
            return db.insert(sql) > 0;
        } catch (Exception err) {
            System.out.println("Something went wrong!");
            System.out.println(err.getMessage());
            return false;
        }
    }
    public File getFile(int id){
        File file = null;
        try{
            DataBase DB = new DataBase();
            DB.openConnection();
            sql += "where a.id = "+id;
            ResultSet rs = DB.select(sql);
            if(rs.next()){
                String userName = rs.getString("nome_usuario");
                String email = rs.getString("u.email");
                String fileName = rs.getString("a.nome");
                String directory = rs.getString("a.diretorio");
                String format = rs.getString("a.formato");
                file = new File(fileName, new User(), directory, format);
                file.setId(id);
            }
            return file;
            
        }catch(Exception err){
            System.out.println(err.getMessage());
            return null;
        }
    }
    public List<File> getFiles(String search) {
        List<File> files = new ArrayList<>();
        try {

            DataBase bd = new DataBase();
            bd.openConnection();

            if (search != null) {
                sql += "where a.nome like '%" + search + "%' ";
            }
            ResultSet rs = bd.select(sql);
            while (rs.next()) {
                int id = rs.getInt("a.id");
                String userName = rs.getString("nome_usuario");
                String email = rs.getString("u.email");
                String fileName = rs.getString("a.nome");
                String directory = rs.getString("a.diretorio");
                String format = rs.getString("a.formato");
                File fil = new File(fileName, new User(), directory, format);
                fil.setId(id);
                fil.getUser().setName(userName);
                fil.getUser().setEmail(email);
                files.add(fil);
            }
            return files;

        } catch (Exception err) {
            System.out.println(err.getMessage());
            return files;
        }

    }

    public List<File> getFiles() {
        return getFiles(null);
    }
    
    public boolean update(File file){
        try{
            DataBase db = new DataBase();
            db.openConnection();
            String sql = "update arquivos set nome = '"+file.getName()+"' where id = "+file.getId();
            return db.insert(sql) > 0;
        }catch(Exception err){
            System.out.println(err.getMessage());
            return false;
        }
    }
}

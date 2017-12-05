/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Andrade
 */
public class DataBase {

    private String USER = "root";
    private String PASSWORD = "1234";
    private String URL = "jdbc:mysql://127.0.0.1:3306/cakephp";
    private String DRIVER = "com.mysql.jdbc.Driver";
    private Connection con;

    public Connection openConnection() throws Exception {
        Class.forName(DRIVER);
        this.con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

    public void close() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet select(String sql) throws SQLException {
        Statement st = this.con.createStatement();
        return st.executeQuery(sql);
    }

    public int insert(String sql) throws SQLException {
        Statement st = this.con.createStatement();
        return st.executeUpdate(sql);
    }
}

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
    private String name;
    private String email;
    private String password;
    private String address;
    private boolean admin;
    public User(){
        
    }
    public User (String email, String password){
        this.email = email;
        this.password = password;
    }
    public User(String name, String email, String password,String address){
        this(email,password);
        this.name = name;
        this.address = address;
    }
    public User(int id,String name, String address, String email, String password,boolean admin){
        this(name,  email, password,address);
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}

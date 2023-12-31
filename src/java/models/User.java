/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Fortune Agbone
 */
public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;

    //Constructor
    public User(String email, String firstName, String lastName, String password, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }
    
    //Default Constructor
    public User(){
    }
    
    //Getters
    public String getEmail(){
        return email;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Role getRole(){
        return role;
    }
    
    //Setters
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRole(Role role){
        this.role = role;
    }
}

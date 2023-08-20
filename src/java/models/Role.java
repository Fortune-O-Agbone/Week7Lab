/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Fortune Agbone
 */
public class Role {
    private int roleId;
    private String roleName;
  
    //Constructoer
    public Role(int roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }
    
    //Default constructor
    public Role() {
        
    }
    
    //Getters
    public int getRoleId(){
        return roleId;
    }
    
    public String getRoleName(){
        return roleName;
    }
    
    //Setters
    public void setRoleId(int roleId){
        this.roleId = roleId;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
}

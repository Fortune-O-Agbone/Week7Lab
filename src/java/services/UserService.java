/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Fortune Agbone
 */
public class UserService {

    private UserDB userDB;

    public UserService() {
        userDB = new UserDB();
    }

    public List<User> getAllUsers() throws Exception {
        return userDB.getAllUsers();
    }
    

    public void addUser(String email, String firstName, String lastName, String password, int roleId) throws Exception{
        // retrieve the role object using the role id
        RoleDB rdb = new RoleDB();
        Role role = rdb.getRoleById(roleId);
        if (role != null) {
            // create the user object using all incoming information
            // and the role object
            User newUser = new User(email, firstName, lastName, password, role);
            userDB.insertUser(newUser);
        } else {
            // Handle error - Invalid role ID
            // You may throw an exception or return an error message.
        }
    }
/*
    // Logic to update an existing account
    public void updateUser(String email, String firstName, String lastName, int roleId) {
        Role role = userDB.getRoleById(roleId);
        if (role != null) {
            User user = userDB.getUserByEmail(email);
            if (user != null) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setRole(role);
                userDB.updateUser(user);
            } else {
                // Handle error - User with the specified email not found
                // You may throw an exception or return an error message.
            }
        } else {
            // Handle error - Invalid role ID
            // You may throw an exception or return an error message.
        }
    }
// Logic to delete a user by email

    public void deleteUserByEmail(String email) {
        User user = userDB.getUserByEmail(email);
        if (user != null) {
            userDB.deleteUser(user);
        } else {
            // Handle error - User with the specified email not found
            // You may throw an exception or return an error message.
                   
        }
    }

*/
}
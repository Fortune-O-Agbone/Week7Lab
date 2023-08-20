/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Fortune Agbone
 */
public class UserDB {

    public static List<User> getAllUsers() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM user";
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();

            //Create an instance of RoleDB
            RoleDB roleDB = new RoleDB();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String password = resultSet.getString("password");
                int roleID = resultSet.getInt("role");

                // call upon RoleDB to get the Role using the roleID
                // the role will be saved to the user object
                Role role = roleDB.getRoleById(roleID);

                //Instantiate the User object and add it to the list
                User user = new User(email, firstName, lastName, password, role);
                users.add(user);
            }
        } catch (Exception e) {
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(statement);
            cp.freeConnection(con);
        }

        return users;
    }

    public void insertUser(User user) throws Exception {
        // add the user to the database
        // (refer to noteDB insert method for code)
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO user (email, first_name, last_name, password, role) "
                    + "VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRole().getRoleId());

            statement.executeUpdate();
        } catch (SQLException e) {
        } finally {
            DBUtil.closeStatement(statement);
            cp.freeConnection(con);
        }
    }
}

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
public class RoleDB {
    
    public Role getRoleById(int roleId) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        Role role = null;
        
        // get the role from the database
        String sql = "SELECT * FROM userdb.role WHERE role_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, roleId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    role.setRoleName(rs.getString("role_name"));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error getting role by ID: " + e.getMessage());
        } finally {
            cp.freeConnection(con);
        }
        
        return role;
    }
    
}

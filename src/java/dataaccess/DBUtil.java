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

/**
 *
 * @author Fortune Agbone
 */
public class DBUtil {
    public static void closeStatement(PreparedStatement statement){
        if(statement != null){
            try{
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void closeResultSet(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void closeConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

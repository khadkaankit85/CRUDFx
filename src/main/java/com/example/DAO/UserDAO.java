package com.example.DAO;

import com.example.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private Connection conn;
     public void startConnection() throws SQLException {

         String url = "jdbc:mariadb://localhost:3306/university_db";
         String user = "root";
         conn = DriverManager.getConnection(url, user, null);
     }
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
    public ResultSet getPasswordQueryResultset(User user) throws SQLException {
        String query = "SELECT * FROM user where username= ?";
        try(PreparedStatement stmt= conn.prepareStatement(query)){
            stmt.setString(1,user.getUsername());

          return  stmt.executeQuery();

        }
        catch (SQLException e){
            System.out.println("error happening");
            return null;

        }
    }
}

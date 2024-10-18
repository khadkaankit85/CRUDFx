package com.example.DAO;

import com.example.model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conn;

    // Constructor to establish the connection
    public DAO() throws SQLException {
        startConnection();
    }

    // Method to start the connection
    public void startConnection() throws SQLException {
        try {
            String url = "jdbc:mariadb://localhost:3306/university_db";
            String user = "root";
            conn = DriverManager.getConnection(url, user, null);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection error occurred: " + e.getMessage());
            throw e;
        }
    }

    // Method to close the connection
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

    // Read universities from the database
    public ResultSet readUniversities() {
        List<University> universities = new ArrayList<>();
        String query = "SELECT * FROM universities";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

           return  rs;
        } catch (SQLException e) {
            System.out.println("Error reading universities: " + e.getMessage());
        }
        return null;
    }

    public boolean createUniversity(University myUni) {
        String query = "INSERT INTO universities (name, rank, location) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, myUni.getName());
            stmt.setInt(2, myUni.getRank());
            stmt.setString(3, myUni.getLocation());
            stmt.executeUpdate();
            System.out.println("University inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println("Problem inserting into the table: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUniversity(int universityId) {
        String query = "DELETE FROM universities WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, universityId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("University deleted successfully.");
                return true;
            } else {
                System.out.println("No university found with the given ID.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Problem deleting from the table: " + e.getMessage());
            return false;
        }
    }

    public boolean updateUniversity(University myUni) {
        String query = "UPDATE universities SET name = ?, rank = ?, location = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, myUni.getName());
            stmt.setInt(2, myUni.getRank());
            stmt.setString(3, myUni.getLocation());
            stmt.setInt(4, myUni.getId());

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("University updated successfully.");
                return true;
            } else {
                System.out.println("No university found with the given ID.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Problem updating the university: " + e.getMessage());
            return false;
        }
    }
}

package com.skillstorm.general;
import java.sql.*;
public class VerifyUser {
	

	    private static final String JDBC_URL = "jdbc:mysql://database-2.c3kr5ra50v1d.us-east-1.rds.amazonaws.com:3306/Project2";
	    private static final String USERNAME = "BlueAdmin";
	    private static final String PASSWORD = "8A*N2WLb^i68csDc!$&mwbbuZ5vHnt";

	    public boolean verifyUser(String username, String password) {
	        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setString(1, username);
	            statement.setString(2, password);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                return resultSet.next(); // true if user exists, false otherwise
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false; // Error occurred during verification
	        }
	    }

//	    public static void main(String[] args) {
//	        // Example usage
//	        String inputUsername = "user123";
//	        String inputPassword = "password123";
//
//	        if (verifyUser(inputUsername, inputPassword)) {
//	            System.out.println("User verified");
//	        } else {
//	            System.out.println("User not found or invalid credentials");
//	        }
//	    }
	}


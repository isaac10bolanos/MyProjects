package com.skillstorm.beans;
import java.sql.*;
public class MoviesSQL {



    private static final String URL = "jdbc:mysql://127.0.0.1:3306/zulmak";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Manrique6810!!!";

    public static void main(String[] args) {
        try {
            // Establish the database connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Prepare the SQL statement
            String query = "SELECT * FROM movies";
            Statement statement = conn.createStatement();

            // Execute the query
            ResultSet pointer = statement.executeQuery(query);

            // Process the query results
            while (pointer.next()) {
                int runtime = pointer.getInt("runtime");
                String title = pointer.getString("title");
                String genre = pointer.getString("genre");
                int releaseYear = pointer.getInt("releaseYear");

                System.out.print("[Title: " + title);
                System.out.print("] [Genre: " + genre);
                System.out.print("] [Year: " + releaseYear);
                System.out.print("] [Runtime: " + runtime + "]\n");
                System.out.println();
            }

            // Close the resources
            pointer.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


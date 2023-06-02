package com.skillstorm.general;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


    public class UserDAO {
        private final MySQLConnector connection;
        public UserDAO() {
            connection = new MySQLConnector();
        }
        public UserDAO(MySQLConnector connector) {
			connection = new MySQLConnector();
		}
//    private static final String connString = "jdbc:mysql://database-2.c3kr5ra50v1d.us-east-1.rds.amazonaws.com:3306/Project2";
//    private static final String username = "BlueAdmin";
//    private static final String password = "8A*N2WLb^i68csDc!$&mwbbuZ5vHnt";
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public List<User> findAll() {
//        List<User> users = new LinkedList<>();
//
//        try (Connection conn = DriverManager.getConnection(connString, username, password)) {
//            String sql = "SELECT * FROM job_postings;";
//
//            Statement stmt = conn.createStatement(); // your SQL statement
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                // save these to an object
//                //int id = rs.getInt("id");
//                //String name = rs.getString("first");
//                System.out.println(rs.getString("company"));
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return users;
//    }



		public void save(User user) throws SQLException {
            PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
            statement.close();
        }


    public User findByUsername(String username) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?");
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = new User(resultSet.getString("username"), resultSet.getString("password"));
        }
        resultSet.close();
        statement.close();
        return user;
    }

//    public User getById(int id) {
//        User result = new User();
//
//        try (Connection conn = DriverManager.getConnection(connString, username, password)) {
//            String sql = "SELECT * FROM users WHERE id = ?;";
//
//            PreparedStatement stmt = conn.prepareStatement(sql); // your SQL statement
//            stmt.setInt(1, id); // 1st questionmark set to id
//            ResultSet rs = stmt.executeQuery();
//
//            rs.next(); //the first thing is null
//
//            // grab user from rs same as above
//            result = new User();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return result;
//    }
}

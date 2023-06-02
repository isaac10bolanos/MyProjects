package UserService;

import Security.MySQLConnector;

import java.sql.*;

    public class UserDAO {
        private final MySQLConnector connector;

        public UserDAO(MySQLConnector connector) {
            this.connector = connector;
        }

        public MySQLConnector getConnector() {
            return connector;
        }

    public void save(User user) throws SQLException {
        PreparedStatement statement = connector.getConnection().prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
        statement.close();
    }

    public User findByUsername(String username) throws SQLException {

        PreparedStatement statement = connector.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?");
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
}

package Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySQLConnector { /// Test test

    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public MySQLConnector() {
        this.url = "jdbc:mysql://database-2.c3kr5ra50v1d.us-east-1.rds.amazonaws.com:3306/Project2";
        this.user = "BlueAdmin";
        this.password = "8A*N2WLb^i68csDc!$&mwbbuZ5vHnt";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
//        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return resultSet;
    }

    // Method to close the database connection
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}

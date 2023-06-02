package www.skillstorm.general;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySQLConnector {

    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public MySQLConnector() {
        this.url = "jdbc:mysql://127.0.0.1:3306/project";
        this.user = "root";
        this.password = "Manrique6810!!!";
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

//    public int executeUpdate(String sql) throws SQLException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        int affectedRows = 0;
//
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(sql);
//            affectedRows = statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//        return affectedRows;
//    }

    // Method to close the database connection
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}



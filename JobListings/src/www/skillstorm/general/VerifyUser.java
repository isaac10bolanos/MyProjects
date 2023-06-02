package www.skillstorm.general;
import java.sql.*;
public class VerifyUser {
	

	    private static final String URL = "jdbc:mysql://127.0.0.1:3306/project";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "Manrique6810!!!";

	    public boolean verifyUser(String username, String password) {
	        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

	        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
	}


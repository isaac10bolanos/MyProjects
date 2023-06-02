package Security;

import UserService.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.lineSeparator;

public class verifyUser {
    private MySQLConnector connector;

    public verifyUser() {
        this.connector = new MySQLConnector();
    }

    public User authenticateUser() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String username;
        do {
            lineSeparator();
            System.out.print("Enter your username: ");
            username = scanner.readLine();
            lineSeparator();
        } while (username.isEmpty());

        lineSeparator();
        System.out.print("Enter your password: ");
        String password = scanner.readLine();
        lineSeparator();
        try (Connection conn = this.connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS id, loggedin, admin FROM users WHERE username = ? AND password = ?")) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("id") > 0) {
                // Authentication successful
                boolean isAdmin = rs.getBoolean("admin");


                // Create a new User instance and set the loggedIn property to true
                User user = new User(username, password);
                user.setLoggedIn(true);

                // Set the id property based on the value retrieved from the database
                int id = rs.getInt("id");
                user.setUserID(id);

                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


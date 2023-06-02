package JobService;

import Security.verifyUser;
import UserService.User;
import UserService.UserDAO;
import Security.MySQLConnector;
import Project_2Revised.Title;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

public class Apply {
    private verifyUser userVerifier;
    private UserDAO userDAO;

    public Apply() {
        this.userVerifier = new verifyUser();
        this.userDAO = new UserDAO(new MySQLConnector());
    }

    public void applyForJob() throws SQLException, IOException {
        User user = userVerifier.authenticateUser();
        if (user == null) {
            Scanner in = new Scanner(System.in);
            Title title = new Title();
            title.begin(in);
        } else {

            System.out.print("Enter the job number you want to apply for: ");
            lineSeparator();
            Scanner scanner = new Scanner(System.in);
            int jobNumber = scanner.nextInt();

            // Perform the logic to check if the job number exists in the MySQL database
            if (isJobNumberValid(jobNumber)) {
                lineSeparator();
                // Print out the successful application message
                System.out.println("You have successfully applied for the job.");
                lineSeparator();
                // Insert the jobID and UserID into the "AppliedForTheJob" table
                insertApplication(user.getUserID(), jobNumber);
            } else {
                System.out.println("Invalid job number. Application unsuccessful.");
                lineSeparator();
            }
        }
    }

    private boolean isJobNumberValid(int jobNumber) throws SQLException {
        try (Connection conn = userDAO.getConnector().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AppliedForTheJob WHERE jobID = ?")) {
            stmt.setInt(1, jobNumber);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                lineSeparator();
                System.out.println("Sorry, the job has already been filled.");
                lineSeparator();
                System.out.println("\n \n \n \n \n");
                return false;
            } else {
                return true;
            }
        }
    }

    private void insertApplication(int id, int jobID) throws SQLException {
        try (Connection conn = userDAO.getConnector().getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO AppliedForTheJob (UserID, jobID) VALUES (?, ?)")) {
            stmt.setInt(1, id);
            stmt.setInt(2, jobID);
            stmt.executeUpdate();
        }
    }
}

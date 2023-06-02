package JobService;

import Security.MySQLConnector;

import java.util.Scanner;
import static java.lang.System.lineSeparator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JobViewer {
    private MySQLConnector connector;

    public JobViewer(MySQLConnector connector) {
        this.connector = connector;
    }

    public void displayJobs(int offset) throws SQLException {
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM job_postings LIMIT 5 OFFSET ?");
        ) {
            stmt.setInt(1, offset);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Job Listings:\n");

            while (rs.next()) {
                int jobId = rs.getInt("id");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String requirements = rs.getString("requirements");
                String city = rs.getString("city");
                String state = rs.getString("state");
                double salaryMin = rs.getDouble("salary_min");
                double salaryMax = rs.getDouble("salary_max");

                System.out.println("        Job ID: " + jobId);
                System.out.println("  Company Name: " + company);
                System.out.println("Position Title: " + title);
                System.out.println("    Located in: " + city + ", " + state);
                System.out.println("  Requirements: " + requirements);
                System.out.println("  Salary Range: $" + salaryMin + " to $" + salaryMax);
                lineSeparator();
            }

            rs.close();

            // Ask for user input
            System.out.println("Please select an option:");
            System.out.println("1. Next 5 jobs");
            System.out.println("2. Apply to a job by job ID");
            System.out.println("3. Back to main menu");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayJobs(offset + 5); // Display the next 5 jobs
                    break;
                case 2:
                    System.out.println("Enter the job ID to apply:");
                    int jobId = scanner.nextInt();
                    // TODO: applyToJob(jobId); // Apply to the job with the given job ID
                    break;
                case 3:
                    // Back to the main menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    displayJobs(offset); // Display the same set of jobs again
                    break;
            }
        }
    }

}

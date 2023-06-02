package JobService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Security.MySQLConnector;


public class JobListingService {
    private MySQLConnector connection;

    public JobListingService(MySQLConnector connector) {
        this.connection = connector;
    }

    public List<JobListing> getJobListings() throws SQLException {
        String query = "SELECT * FROM job_postings";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<JobListing> jobListings = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String company = resultSet.getString("company");
                String title = resultSet.getString("title");
                String requirements = resultSet.getString("requirements");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                double salary_min = resultSet.getDouble("salary_min");
                double salary_max = resultSet.getDouble("salary_max");
                jobListings.add(new JobListing(id, company, title, requirements, city, state, salary_min, salary_max));
            }
            return jobListings;
        }
    }

    public void addJobListing(JobListing jobListing) throws SQLException {
        String query = "INSERT INTO job_postings (title, requirements, salary_min, company) VALUES (?, ?, ?, ?)";
        try (Connection connection = this.connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, jobListing.getTitle());
            statement.setString(2, jobListing.getRequirements());
            statement.setDouble(3, jobListing.getSalaryMin());
            statement.setDouble(3, jobListing.getSalaryMax());
            statement.setString(4, jobListing.getCompany());
            statement.executeUpdate();
        }
    }
}

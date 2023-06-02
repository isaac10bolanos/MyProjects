package JobService;
import Security.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class JobListingDAO {
    private final MySQLConnector connector;

    public JobListingDAO(MySQLConnector connector) {
        this.connector = connector;
    }

    public List<JobListing> getAllJobListings() throws SQLException {
        List<JobListing> jobListings = new ArrayList<>();
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM job_postings");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                JobListing jobListing = new JobListing(
                        rs.getInt("id"),
                        rs.getString("company"),
                        rs.getString("title"),
                        rs.getString("requirements"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getDouble("salary_min"),
                        rs.getDouble("salary_max"));
                jobListings.add(jobListing);
            }
        }
        return jobListings;
    }

    public List<JobListing> searchJobListingsBySalaryMin(double selectedMinSalary) throws SQLException {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM job_postings WHERE salary_min >= ?";
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, selectedMinSalary);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    JobListing jobListing = new JobListing(rs.getInt("id"),
                            rs.getString("company"),
                            rs.getString("title"),
                            rs.getString("requirements"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getDouble("salary_min"),
                            rs.getDouble("salary_max"));

                    jobListings.add(jobListing);
                }
            }
        }
        return jobListings;
    }

//    public JobListing getJobListingById(int jobId) throws SQLException {
//        try (Connection conn = connector.getConnection();
//             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM job_postings WHERE id = ?");
//        ) {
//            stmt.setInt(1, jobId);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                JobListing jobListing = new JobListing(
//                        rs.getInt("id"),
//                        rs.getString("company"),
//                        rs.getString("title"),
//                        rs.getString("requirements"),
//                        rs.getString("city"),
//                        rs.getString("state"),
//                        rs.getDouble("salary_min"),
//                        rs.getDouble("salary_max"));
//                return jobListing;
//            } else {
//                return null; // Job listing with given ID not found
//            }
//        }
//    }


    public List<JobListing> searchJobListings(String query, String searchBy) throws SQLException {
        List<JobListing> jobListings = new ArrayList<>();
        String sql = "SELECT * FROM job_postings WHERE ";
        if (searchBy.equalsIgnoreCase("title")) {
            sql += "title LIKE ?";
            query = "%" + query + "%";
        } else if (searchBy.equalsIgnoreCase("requirements")) {
            sql += "requirements LIKE ?";
            query = "%" + query + "%";
        } else if (searchBy.equalsIgnoreCase("city")) {
            sql += "city LIKE ?";
            query = "%" + query + "%";
        } else if (searchBy.equalsIgnoreCase("state")) {
            sql += "state LIKE ?";
            query = "%" + query + "%";
        } else if (searchBy.equalsIgnoreCase("salary_range")) {
            sql += "salary_range >= ?";
        } else { // search by all
            sql += "title LIKE ? OR requirements LIKE ? OR city LIKE ? OR state LIKE ?";
            query = "%" + query + "%";
        }
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (searchBy.equalsIgnoreCase("salary_range")) {
                double salary_range = Double.parseDouble(query);
                stmt.setDouble(1, salary_range);
            } else {
                stmt.setString(1, query);
                if (searchBy.equalsIgnoreCase("all")) {
                    stmt.setString(2, query);
                    stmt.setString(3, query);
                    stmt.setString(4, query);
                }
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    JobListing jobListing = new JobListing(
                            rs.getInt("id"),
                            rs.getString("company"),
                            rs.getString("title"),
                            rs.getString("requirements"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getDouble("salary_min"),
                            rs.getDouble("salary_max"));

                    jobListings.add(jobListing);
                }
            }
        }
        return jobListings;
    }

    public List<String> getAllTitles() throws SQLException {
        List<String> titles = new ArrayList<>();
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT title FROM job_postings");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String title = rs.getString("title");
                titles.add(title);
            }
        }
        return titles;
    }

    public List<String> getAllCities() throws SQLException {
        List<String> cities = new ArrayList<>();
        String sql = "SELECT DISTINCT city FROM job_postings";
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String city = rs.getString("city");
                cities.add(city);
            }
        }
        return cities;
    }

    public List<String> getAllStates() throws SQLException {
        List<String> states = new ArrayList<>();
        String sql = "SELECT DISTINCT state FROM job_postings";
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String state = rs.getString("state");
                states.add(state);
            }
        }
        return states;
    }

    public List<String> getAllRequirements() throws SQLException {
        List<String> requirements = new ArrayList<>();
        String sql = "SELECT DISTINCT requirements FROM job_postings";
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String requirement = rs.getString("requirements");
                requirements.add(requirement);
            }
        }
        return requirements;
    }

    public List<Double> getDistinctMinSalaries() throws SQLException {
        List<Double> distinctMinSalaries = new ArrayList<>();
        String sql = "SELECT DISTINCT salary_min FROM job_postings";
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                double salaryMin = rs.getDouble("salary_min");
                distinctMinSalaries.add(salaryMin);
            }
        }
        return distinctMinSalaries;
    }

}

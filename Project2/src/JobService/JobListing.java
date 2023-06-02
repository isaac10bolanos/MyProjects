package JobService;

import Security.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobListing {
    private int id;
    private String title;
    private String requirements;
    private String city;
    private String state;
    private double salary_min;
    private double salary_max;
    private String company;

    public JobListing(int id, String company, String title, String requirements, String city, String state, double salary_min, double salary_max) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.requirements = requirements;
        this.city = city;
        this.state = state;
        this.salary_min = salary_min;
        this.salary_max = salary_max;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public double getSalaryMax() {
        return salary_max;
    }

    public double getSalaryMin() {
        return salary_min;
    }

    public String getCompany() {
        return this.company;
    }

    // Query the database for all job listings
    public static List<JobListing> getAllListings(MySQLConnector connector) throws SQLException {
        String query = "SELECT * FROM job_postings";
        ResultSet rs = connector.executeQuery(query);

        List<JobListing> listings = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String requirements = rs.getString("requirements");
            String city = rs.getString("city");
            String state = rs.getString("state");
            String company = rs.getString("company");
            double salary_min = rs.getDouble("salary_min");
            double salary_max = rs.getDouble("salary_max");
            listings.add(new JobListing(id, company, title, requirements, city, state, salary_min, salary_max));
        }

        return listings;
    }

    // Query the database for job listings based on search criteria and starting index
    public static List<JobListing> searchListings(MySQLConnector connector, String searchType, String keyword, int startIndex) throws SQLException {
        int pageSize = 5; // Number of results per page

        String query = "SELECT * FROM job_postings WHERE ";
        if (searchType.equalsIgnoreCase("all")) {
            query += "title LIKE '%" + keyword + "%' OR requirements LIKE '%" + keyword + "%' OR city LIKE '%" + keyword + "%' OR state LIKE '%" + keyword + "%'";
        } else if (searchType.equalsIgnoreCase("title")) {
            query += "title LIKE '%" + keyword + "%'";
        } else if (searchType.equalsIgnoreCase("requirements")) {
            query += "requirements LIKE '%" + keyword + "%'";
        } else if (searchType.equalsIgnoreCase("city")) {
            query += "city LIKE '%" + keyword + "%'";
        } else if (searchType.equalsIgnoreCase("state")) {
            query += "state LIKE '%" + keyword + "%'";
        }
        query += " LIMIT " + startIndex + "," + pageSize;
        ResultSet rs = connector.executeQuery(query);

        List<JobListing> listings = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String requirements = rs.getString("requirements");
            String city = rs.getString("city");
            String state = rs.getString("state");
            double salary_min = rs.getDouble("salary_min");
            double salary_max = rs.getDouble("salary_max");
            String company = rs.getString("company");
            listings.add(new JobListing(id, company, title, requirements, city, state, salary_min, salary_max));
        }
        return listings;
    }

}

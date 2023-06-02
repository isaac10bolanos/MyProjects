package www.skillstorm.general;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JobMenu {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/project";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Manrique6810!!!";

	public JobMenu(Scanner in) throws SQLException, IOException {

		try {
			System.out.println("Welcome to Job Menu!");
			// Establish the database connection
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Prepare the SQL statement
			String query = "SELECT * FROM joblistings";
			Statement statement = conn.createStatement();

			// Execute the query
			ResultSet pointer = statement.executeQuery(query);

			// Process the query results
			while (pointer.next()) {
				int id = pointer.getInt("id");
				String title = pointer.getString("title");
				String description = pointer.getString("description");
				String address = pointer.getString("address");
				String city = pointer.getString("city");
				String state = pointer.getString("state");
				int zipcode = pointer.getInt("zipcode");
	//			int salary = pointer.getInt(zipcode);
				String field = pointer.getString("field");
				String contactEmail = pointer.getString("contactemail");
				
				System.out.print("[ID: " + id);
				System.out.print("] [Title: " + title);
				System.out.print("] [Description: " + description);
				System.out.print("] [Address: " + address);
				System.out.print("] [City: " + city);
				System.out.print("] [State: " + state);
				System.out.print("] [Zipcode: " + zipcode);
//				System.out.print("] [Salary: " + salary);
				System.out.print("] [Field: " + field);
				System.out.print("] [Contact email: " + contactEmail + "]\n");
				System.out.println();
				
			}

			// Close the resources
			pointer.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

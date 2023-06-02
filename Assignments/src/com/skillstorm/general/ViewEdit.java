package com.skillstorm.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewEdit {

	private final String FOLDER = "C:\\Users\\isaac\\Documents\\GitHub\\MyProjects\\Project2\\Users";

	private final String URL = "jdbc:mysql://database-2.c3kr5ra50v1d.us-east-1.rds.amazonaws.com:3306/Project2";
	private final String USERNAME = "BlueAdmin";
	private final String PASSWORD = "8A*N2WLb^i68csDc!$&mwbbuZ5vHnt";

	public ViewEdit(Scanner in) throws SQLException, IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Pleaser enter your username to continue: ");
		String username = scanner.readLine();

		// Establish a database connection
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		// Prepare a query to check if the username exists
		String query = "SELECT COUNT(*) FROM users WHERE username = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);

		// Execute the query
		ResultSet resultSet = statement.executeQuery();

		// Retrieve the result
		resultSet.next();
		int count = resultSet.getInt(1);

		// Check if the username exists
		if (count > 0) {
			System.out.println("Authentication complete.\n");
			String txtFile = FOLDER + "\\" + username + "\\resume.txt";

			boolean cont = false;
			int choice = 0;
			while (choice != 3) {
				System.out.println("\n1. View resume");
				System.out.println("2. Edit resume");
				System.out.println("3. Return to Title Screen");

				do {
					try {
						choice = Integer.parseInt(in.nextLine().trim());
					} catch (Exception ex) {
						choice = 0;
					}
					if (choice < 1 || choice > 4) {
						System.out.println("Please select a correct number.");
						cont = true;
					} else {
						cont = false;
					}
				} while (cont);

				switch (choice) {
				case 1:
					viewResume(txtFile);
					break;
				case 2:

					editResume(txtFile, in);
					break;

				}

			}
		} else {
			System.out.println("The username does not exist.\n");
		}

		// Close resources
		resultSet.close();
		statement.close();
		connection.close();
	}

	public static void viewResume(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void editResume(String filePath, Scanner in) throws IOException {
	  BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		  // Read the existing file content
		  StringBuilder existingContent = new StringBuilder();
		  try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
		      String line;
		      while ((line = fileReader.readLine()) != null) {
		          existingContent.append(line).append("\n");
		      }
		  }
		
		  String[] lines = existingContent.toString().split("\n");
		  String name = getValue(lines, "Name: ");
		  String email = getValue(lines, "Email: ");
		  String phoneNumber = getValue(lines, "Phone number: ");
		  String workExperience = getMultilineValue(lines, "Work experience:");
		  String education = getMultilineValue(lines, "Education:");
		  String certs = getMultilineValueP(lines, "Certifications:");
		
		  System.out.print("Enter your name or press enter to leave it unchanged: ");
		  String input = scanner.readLine();
		  if (!input.isEmpty()) {
		      name = input;
		  }
		
		  System.out.print("Enter your email address or press enter to leave it unchanged: ");
		  input = scanner.readLine();
		  if (!input.isEmpty()) {
		      email = input;
		  }
		
		  System.out.print("Enter your phone number (XXX-XXX-XXXX format) or press enter to leave it unchanged: ");
		  input = scanner.readLine();
		  if (!input.isEmpty()) {
		      phoneNumber = input;
		  }
		
		  System.out.println("Enter your work experience or press enter to leave it unchanged:");
		  System.out.println("Type 'done' to finish");
		  StringBuilder allWorkExperience = new StringBuilder();
		  while (true) {
		      input = scanner.readLine();
		      if (input.equalsIgnoreCase("done")) {
		          break;
		      }
		      allWorkExperience.append(input).append("\n");
		  }
		  if (allWorkExperience.length() > 0) {
		      workExperience = allWorkExperience.toString().trim();
		  }
		
		  System.out.println("Enter your education or press enter to leave it unchanged:");
		  System.out.println("(Press enter after each degree, type 'done' to finish)");
		  StringBuilder allEducation = new StringBuilder();
		  while (true) {
		      input = scanner.readLine();
		      if (input.equalsIgnoreCase("done")) {
		          break;
		      }
		      allEducation.append("- ").append(input).append("\n");
		  }
		  if (allEducation.length() > 0) {
		      education = allEducation.toString().trim();
		  }
		
		  System.out.println("Enter your certifications or press enter to leave it unchanged:");
		  System.out.println("(Press enter after each certification, type 'done' to finish)");
		  StringBuilder allCertifications = new StringBuilder();
		  while (true) {
		      input = scanner.readLine();
		      if (input.equalsIgnoreCase("done")) {
		          break;
		      }
		      allCertifications.append("\u25C6").append(input).append("\n");
		  }
		  if (allCertifications.length() > 0) {
		      certs = allCertifications.toString().trim();
		  }
		
		  // Check if any changes were made, if not, keep the original values
		  boolean changesMade = false;
		  if (!name.isEmpty() || !email.isEmpty() || !phoneNumber.isEmpty()
		          || !workExperience.isEmpty() || !education.isEmpty() || !certs.isEmpty()) {
		      changesMade = true;
		  }
		
		  // Write the updated content to the file
		  try (FileWriter writer = new FileWriter(filePath, false)) {
		      if (changesMade) {
		          writer.write("Name: " + name + "\n\nEmail: " + email + "\n\nPhone number: " + phoneNumber
		                  + "\n\nWork experience:\n" + workExperience + "\n\nEducation:\n" + education + "\n\nCertifications:\n"
		                  + certs + "\n");
		      } else {
		          writer.write(existingContent.toString());
		      }
		      System.out.println("Resume updated successfully.");
		  }
    }

    private static String getValue(String[] lines, String field) {
        for (String line : lines) {
            if (line.startsWith(field)) {
                return line.substring(field.length()).trim();
            }
        }
        return "";
    }

    private static String getMultilineValue(String[] lines, String prefix) {
        StringBuilder value = new StringBuilder();
        boolean found = false;
        boolean sectionStarted = false;

        for (String line : lines) {
            if (line.startsWith(prefix)) {
                found = true;
                sectionStarted = true;
                value.append(line.substring(prefix.length())).append("\n");
            } else if (found && line.startsWith("- ")) {
                value.append(line).append("\n");
            } else if (found && sectionStarted && !line.startsWith("- ")) {
                break;
            }
        }

        return value.toString().trim();
    }
    private static String getMultilineValueP(String[] lines, String prefix) {
        StringBuilder value = new StringBuilder();
        boolean found = false;
        boolean sectionStarted = false;

        for (String line : lines) {
            if (line.startsWith(prefix)) {
                found = true;
                sectionStarted = true;
                value.append(line.substring(prefix.length())).append("\n");
            } else if (found && line.startsWith("\u25C6")) {
                value.append(line).append("\n");
            } else if (found && sectionStarted && !line.startsWith("- ")) {
                break;
            }
        }

        return value.toString().trim();
    }
    
//    private static String getMultilineValueN(String[] lines, String sectionIdentifier) {
//        StringBuilder value = new StringBuilder();
//        boolean found = false;
//        boolean sectionStarted = false;
//
//        for (String line : lines) {
//            if (line.startsWith(sectionIdentifier)) {
//                found = true;
//                sectionStarted = true;
//                value.append(line.substring(sectionIdentifier.length())).append("\n");
//            } else if (found && sectionStarted) {
//                if (line.startsWith(sectionIdentifier) || line.startsWith("- ")) {
//                    value.append(line).append("\n");
//                } else {
//                    break; // Exit the loop when a new section starts
//                }
//            }
//        }
//
//        return value.toString().trim();
//    }
    

	

	


	

	
	




}








	



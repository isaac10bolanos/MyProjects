package UserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Project_2Revised.Title;
import Security.MySQLConnector;
import Security.verifyUser;

public class ViewEdit {
//C:\\Users\\isaac\\Documents\\GitHub\\MyProjects\\Project2\\Users
	private final String FOLDER = "Users/";


	public ViewEdit(Scanner in) throws SQLException, IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Pleaser enter your username to continue: ");
		String username = scanner.readLine();

//        verifyUser userVerifier = new verifyUser();
//        User user = userVerifier.authenticateUser();
		// Establish a database connection
		MySQLConnector connector = new MySQLConnector();
		UserDAO userDAO = new UserDAO(connector);
		User user = userDAO.findByUsername(username);
		
		if(user != null) {
			println("Authentication complete.\n");
			String txtFile = FOLDER + "\\" + username + "\\resume.txt";

			boolean cont = false;
			int choice = 0;
			while (choice != 3) {
				lineSeperator(40);
				println("1. View resume");
				println("2. Edit resume");
				println("3. Return to Title Screen");
				lineSeperator(40);

				do {
					try {
						choice = Integer.parseInt(in.nextLine().trim());
					} catch (Exception ex) {
						choice = 0;
					}
					if (choice < 1 || choice > 4) {
						println("Please select a correct number.");
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
			println("The username does not exist.\n");

		}
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
		  StringBuilder original = new StringBuilder();
		  try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		      String line;
		      while ((line = reader.readLine()) != null) {
		          original.append(line).append("\n");
		      }
		  }
		
		  String[] lines = original.toString().split("\n");
		  String name = getValue(lines, "Name: ");
		  String email = getValue(lines, "Email: ");
		  String phoneNumber = getValue(lines, "Phone number: ");
		  String workExperience = getValueN(lines, "Work experience:");
		  String education = getValueL(lines, "Education:");
		  String certifications = getValueP(lines, "Certifications:");
		
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
		      certifications = allCertifications.toString().trim();
		  }
		
		  // Check if any changes were made, if not, keep the original values
		  boolean changesMade = false;
		  if (!name.isEmpty() || !email.isEmpty() || !phoneNumber.isEmpty()
		          || !workExperience.isEmpty() || !education.isEmpty() || !certifications.isEmpty()) {
		      changesMade = true;
		  }
		
		  // Write the updated content to the file
		  try (FileWriter writer = new FileWriter(filePath, false)) {
		      if (changesMade) {
		          writer.write("Name: " + name + "\n\nEmail: " + email + "\n\nPhone number: " + phoneNumber
		                  + "\n\nWork experience:\n" + workExperience + "\n\nEducation:\n" + education + "\n\nCertifications:\n"
		                  + certifications + "\n");
		      } else {
		          writer.write(original.toString());
		      }
		      System.out.println("Resume updated successfully.");
		  }
    }

    private static String getValue(String[] lines, String field) {
        for (String line : lines) {
        	// checks if field is found
            if (line.startsWith(field)) {
                return line.substring(field.length()).trim();
            }
        }
        return "";
    }
    
    private static String getValueN(String[] lines, String field) {
        StringBuilder value = new StringBuilder();
        boolean found = false;
        boolean eduFound = false;

        for (String line : lines) {
            if (line.startsWith(field)) {
                found = true;
                value.append(line.substring(field.length())).append("\n");
            } else if (found && !line.isEmpty()) {
                if (line.startsWith("Education:")) {
                    eduFound = true;
                }

                if (!eduFound) {
                    value.append(line).append("\n");
                }
            } else if (found && eduFound) {
                break;
            }
        }
        //line.startsWith("Education:")

        return value.toString().trim();
    }

    private static String getValueL(String[] lines, String field) {
        StringBuilder value = new StringBuilder();
        boolean found = false;

        for (String line : lines) {
            if (line.startsWith(field)) {
                found = true;
                value.append(line.substring(field.length())).append("\n");
            } else if (found && line.startsWith("- ")) {
                value.append(line).append("\n");
            } else if (found && !line.startsWith("- ")) {
                break;
            }
        }

        return value.toString().trim();
    }
    private static String getValueP(String[] lines, String field) {
        StringBuilder value = new StringBuilder();
        boolean found = false;

        for (String line : lines) {
            if (line.startsWith(field)) {
                found = true;
                value.append(line.substring(field.length())).append("\n");
            } else if (found && line.startsWith("\u25C6")) {
                value.append(line).append("\n");
            } else if (found && !line.startsWith("- ")) {
                break;
            }
        }

        return value.toString().trim();
    }
    
	private void lineSeperator(int n) {
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
        // easy for separation
		
	}

	private void println(String message) {
		System.out.println(message);
		
	}
}

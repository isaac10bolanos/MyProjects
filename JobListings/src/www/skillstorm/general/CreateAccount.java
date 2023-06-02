package www.skillstorm.general;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;


public class CreateAccount {

	public CreateAccount(Scanner in) throws SQLException, IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

		String userName;
		do {
			System.out.print("Enter your username: ");
			userName = scanner.readLine();
		} while (userName.isEmpty());

		String pword1;
		String pword2;
		do {
			System.out.print("Enter your password: ");
			pword1 = scanner.readLine();
			System.out.print("Re-enter your password for verification: ");
			pword2 = scanner.readLine();
		} while (userName.isEmpty() || !pword1.equals(pword2));

		User user = new User(userName, pword1);
		UserDAO userDAO = new UserDAO(new MySQLConnector());
		userDAO.save(user);

		File userFolder = new File("Users/" + userName);
		userFolder.mkdirs();

		String filePath = userFolder.getPath() + "/resume.csv";
		FileWriter writer = new FileWriter(filePath, false); // false to overwrite the file

		String name = "";
		String confirmation;
		do {
			System.out.print("Enter your name: ");
			name = scanner.readLine();
			// Prompt the user to confirm their input
			//	System.out.println("You entered: " + name);
			System.out.print("Is your name correct? " + name + "\n" + "(y/n): ");
			confirmation = scanner.readLine();

		} while (!confirmation.equalsIgnoreCase("y"));

		String email = "";
		do {
			System.out.print("Enter your email address: ");
			email = scanner.readLine();
			//System.out.println("Your email is: " + email);
			System.out.print("Is this the correct email address?" + email + "\n" + "(y/n): ");
			confirmation = scanner.readLine();

		} while (!confirmation.equalsIgnoreCase("y"));

		String phoneNumber = "";
		do {

			System.out.print("Enter your phone number (XXX-XXX-XXXX format): ");
			phoneNumber = scanner.readLine();
			//			System.out.println("You entered: " + phoneNumber);
			System.out.print("Is this the correct phone number?" + phoneNumber + "\n" + "(y/n): ");
			confirmation = scanner.readLine();

		} while (!confirmation.equalsIgnoreCase("y"));

		String workExperience = "";
		StringBuilder allWorkExperience = new StringBuilder();
		boolean isConfirmed = false;

		while (!isConfirmed) {
			System.out.print("Enter your work experience or type 'done' to finish: " + "\n");
			allWorkExperience.setLength(0); // clear the StringBuilder
			do {
				confirmation = scanner.readLine();
				if (!confirmation.equalsIgnoreCase("done")) {
					allWorkExperience.append("").append(confirmation).append("\n");
				}
			} while (!confirmation.equalsIgnoreCase("done"));

			workExperience = allWorkExperience.toString().trim();
			//			System.out.println("You entered: " + workExperience);
			System.out.print("Is your work experience correct?" + "\n" + workExperience + "\n " + "(y/n): ");
			confirmation = scanner.readLine();
			if (confirmation.equalsIgnoreCase("y")) {
				isConfirmed = true; // information is confirmed
			} else {
				// prompt user to enter work experience again
				System.out.println("Please enter your work experience again:");
			}
		}

		String education = "";
		StringBuilder allEducation = new StringBuilder();
		boolean Confirmed = false;

		while (!Confirmed) {
			System.out.println("Enter your education (press enter after each degree, type 'done' to finish):" + "\n");
			allEducation.setLength(0); // clear the StringBuilder
			do {
				confirmation = scanner.readLine();
				if (!confirmation.equalsIgnoreCase("done")) {
					allEducation.append(" - ").append(confirmation).append("\n");
				}
			} while (!confirmation.equalsIgnoreCase("done"));

			education = allEducation.toString().trim();
			//			System.out.println("You entered: " + education);
			System.out.print("Is your education correct?" + "\n" + education + "\n " + "(y/n): ");
			confirmation = scanner.readLine();
			if (confirmation.equalsIgnoreCase("y")) {
				Confirmed = true; // information is confirmed

				System.out.println();
				System.out.println("Here is your resume information:");
				System.out.println();
				System.out.println("Name: " + name);
				System.out.println();
				System.out.println("Email: " + email);
				System.out.println();
				System.out.println("Phone number: " + phoneNumber);
				System.out.println();
				System.out.println("Work experience: " + workExperience);
				System.out.println();
				System.out.println("Education: " + education);
			}

		}

	}
	
}

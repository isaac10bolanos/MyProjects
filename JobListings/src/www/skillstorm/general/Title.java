package www.skillstorm.general;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Title {

	Scanner ins = new Scanner(System.in);
	MySQLConnector connector = new MySQLConnector();
	UserDAO userDAO = new UserDAO(connector);
	VerifyUser verifyUser = new VerifyUser();
	
	public static void main(String[] args) throws SQLException, IOException {
		Scanner in = new Scanner(System.in);
		Title title = new Title();
		title.begin(in);
	}

	public void begin(Scanner in) throws SQLException, IOException {
		boolean cont = false;
		int choice = 0;
		
		while(choice != 4) {
		lineSeperator(40);
		println("Welcome to Jobs R US");
		println("1. Create an account");
		println("2. Returning user");
		println("3. View Job Listings");
		println("4. Exit");
		lineSeperator(40);

		do {
			try {
				choice = Integer.parseInt(in.nextLine().trim());
			} catch(Exception ex) {
				choice = 0;
			}
			if (choice < 1 || choice > 4) {
				println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		}while(cont);

		switch(choice) {

			case 1:
				// head to Class create account
				new CreateAccount(in);
				println("Your account has been created.");
				break;
			case 2:
				// log in
				println("Returning user");
				print("Enter your username: ");
				String userN = in.nextLine();
				print("Enter your password: ");
				String passW = in.nextLine();

				boolean auth = verifyUser.verifyUser(userN, passW);
				if (auth) {
					lineSeperator(40);
					println("Authentication successful");
					lineSeperator(40);
					println("");
	
					//JobMenu jobMenu = new JobMenu();
					//jobMenu.jobMenu();
				} else {
					println("");
					println("Username not in Database.");
					anythingContinue();
					lineSeperator(40);
					clearConsole();
					
					
				}
				break;
			case 3:
//				 head to Class job listings
				new JobMenu(in);
//				JobMenu jobMenu = new JobMenu(in);
//				jobMenu.jobMenu();
				println("Job Listings");
				break;
			case 4:
				// exit program
				println("End");
				System.exit(0);
				break;
			}
		}
	}
	
	public void lineSeperator(int n) {
		for(int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
		// easy for separation
	}
	
	public void println(String message) {
		System.out.println(message);
	}
	
	public void print(String message) {
		System.out.print(message);
	}
	
	public void anythingContinue() {
		System.out.println("\nEnter anything to continue...");
		ins.next();
		// good when you want user to read something
	}
	
	public void clearConsole() {
		for (int i = 0; i < 100; i++)
			System.out.println();
		// simulate new console
	}
	
}

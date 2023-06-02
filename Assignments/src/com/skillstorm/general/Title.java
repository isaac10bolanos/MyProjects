package com.skillstorm.general;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Title {

	MySQLConnector connector = new MySQLConnector();
	UserDAO userDAO = new UserDAO(connector);
//	VerifyUser verifyUser = new VerifyUser(null, null);
	VerifyUser verifyUser = new VerifyUser();
	
	public static void main(String[] args) throws SQLException, IOException {
		Scanner in = new Scanner(System.in);
		Title title = new Title();
		title.begin(in);
	}

	public void begin(Scanner in) throws SQLException, IOException {
		boolean cont = false;
		int choice = 0;
		
		while(choice != 5) {
		lineSeperator(40);
		println("Welcome to Jobs R US");
		println("1. Create an account");
		println("2. Returning user");
		println("3. View/edit resume");
		println("4. View Job Listings");
		println("5. Exit");
		lineSeperator(40);

		do {
			try {
				choice = Integer.parseInt(in.nextLine().trim());
			} catch(Exception ex) {
				choice = 0;
			}
			if (choice < 1 || choice > 5) {
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
				println("");
				println("Your account has been created.");
				break;
			case 2:
				// log in
				println("Returning user");
				println("Enter your username:");
				String userN = in.nextLine();
				println("Enter your password:");
				String passW = in.nextLine();
				boolean auth = verifyUser.verifyUser(userN, passW);
//				boolean auth = verifyUser.authenticateUser("", "");
				if (auth) {
					lineSeperator(40);
					println("Authentication successful");
					lineSeperator(40);
					println("");
	
					//JobMenu jobMenu = new JobMenu();
					//jobMenu.jobMenu();
				} else {
					println("Authentication failed. Please restart the program.");
					lineSeperator(40);
					println("");
					
				}
				break;
			case 3:
				new ViewEdit(in);
				break;
			case 4:
				// head to Class job listings
				//JobMenu jobMenu = new JobMenu();
				//jobMenu.jobMenu();
//				println("Job Listings");
				break;
			case 5:
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
	
}

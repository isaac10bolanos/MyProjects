package Project_2Revised;

import Security.MySQLConnector;
import UserService.UserDAO;
import UserService.ViewEdit;
import UserService.CreateAccount;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import Security.verifyUser;
import UserService.User;


public class Title {

    private UserDAO userDAO;

    public Title() {
        MySQLConnector connector = new MySQLConnector();
        userDAO = new UserDAO(connector);
    }

    public static void main(String[] args) throws SQLException, IOException {
        Scanner in = new Scanner(System.in);
        Title title = new Title();
        title.begin(in);
//		userDAO.findAll();
    }
    public void begin(Scanner in) throws SQLException, IOException {
        int choice = 0;
        boolean cont = false;
        while(choice != 5) {
        lineSeperator(40);
        println("1. Create an account");
        println("2. Log in as a returning user");
        println("3. View Job Listings");
        println("4. View/Edit resume");
        println("5. Exit");
        lineSeperator(40);
        
		do {
			try {
				choice = Integer.parseInt(in.nextLine().trim());
			} catch(Exception ex) {
				choice = 0;
			}
			if (choice < 1 || choice > 5) {
				println("Invalid choice. Please enter a valid option.");
				cont = true;
			} else {
				cont = false;
			}
		}while(cont);
//        do {
//            try {
//                choice = Integer.parseInt(in.nextLine().trim());
//            } catch (NumberFormatException e) {
//                println("Invalid choice. Please enter a number.");
//                continue;
//            }
//        } while(choice != 5);
            switch (choice) {
                case 1:
                    // head to Class create account
                    new CreateAccount(in);
                    println("Your account has been created.");
                    break;
                case 2:
                    println("Returning user");
                    verifyUser userVerifier = new verifyUser();
                    User user = userVerifier.authenticateUser();

                    if (user != null) {
                        lineSeperator(40);
                        println("Authentication successful");
                        lineSeperator(40);
                        JobMenu jobMenu = new JobMenu();
                        jobMenu.jobMenu();
                    } else {
                        println("Authentication failed. Please restart the program.");
                        lineSeperator(40);
                    }
                    break;
                case 3:
                    JobMenu jobMenu = new JobMenu();
                    jobMenu.jobMenu();
                    break;
                case 4:
                	new ViewEdit(in);
                    
                    break;
                case 5:
                	// exit program
                	println("End");
                	break;
                	
                default:
                    println("Invalid choice. Please enter a valid option.");
                    break;
            }
     //   } while (choice != 5);
        }
    }
    



    public void lineSeperator(int n) {
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
        // easy for separation
    }

//    public void CreateAccount(Scanner in) throws SQLException {
//        System.out.println("Enter a username:");
//        String username = in.nextLine();
//        System.out.println("Enter a password:");
//        String password = in.nextLine();
//        User user = new User(username, password);
//        userDAO.save(user);
//    }

    public void println(String message) {
        System.out.println(message);
    }
}

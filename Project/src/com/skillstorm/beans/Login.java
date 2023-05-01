package com.skillstorm.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	Scanner sc;
	String username;
	String password;
	
	public Login(Scanner sc) {
		this.sc = sc;
	}
	
	public void makeUsername() {
		System.out.println("Enter Username:");
		username = sc.nextLine();
		
		System.out.println("Enter Password:");
		password = sc.nextLine();
	}
//	Map<String, Users> account = new HashMap<>();
//	case 1:
//	File file = new File("csvFile.csv");
//	// C:\Users\isaac\Documents\GitHub\MyProjects\Project\src\com\skillstorm\beans
//	try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
//		System.out.print("Enter your full name: ");
//		String name = in.next();
//		bw.write(name + ", ");
//		System.out.print("Enter your email: ");
//		String email = in.next();
//		bw.write(email + ", ");
//		System.out.print("Enter your phone number: ");
//		long number = in.nextLong();
//		bw.write((int) number + ", ");
//		System.out.print("Enter your job ID: ");
//		long id = in.nextLong();
//		bw.write((int) id + ", ");
//		account.put(email, new Users(name, email, number, id));
//		System.out.println("Account created!");
//		break;
//		
//	} catch(IOException ex) {
//		ex.printStackTrace();
//	}
	
	
	

}

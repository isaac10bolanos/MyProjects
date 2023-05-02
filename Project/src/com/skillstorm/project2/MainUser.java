package com.skillstorm.project2;
import java.util.Scanner;
import java.io.*;

public class MainUser {
		
	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		
		boolean cont = false;
		int choice = 0;
			String name = "";
			do {
				try {
					while (name.isEmpty()) {
						System.out.print("Enter your name: ");
						name = scanner.readLine();
						System.out.println("Your name is " + name + ".\nIs that correct?");
						System.out.println("(1) Yes!");
						System.out.println("(2) No, I want to change my name.");
						choice = Integer.parseInt(in.nextLine().trim());
					}
					}catch(Exception e) {
						choice = 0;
					}
						if(choice == 1) {
							cont = false;
						} else if(choice == 2){
							cont = true;
						}
			}while(cont);	
					
			
			String email = "";
					while(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
						System.out.print("Enter your email address: ");
						email = scanner.readLine();
					}
					
					
			String phoneNumber = "";
					while(!phoneNumber.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
						System.out.print("Enter your phone number (XXX-XXX-XXXX format): ");
						phoneNumber = scanner.readLine();
					}
					
					
			String workExperience = "";
			System.out.println("Enter a work experience or type 'done' to finished");
			StringBuilder allWorkExperience = new StringBuilder();
			String ins;
			do {
				ins = scanner.readLine();
				 if (!ins.equalsIgnoreCase("done")) {
	                    allWorkExperience.append("").append(ins).append("\n");
	                   }
			} while(!ins.equalsIgnoreCase("done"));
				workExperience = allWorkExperience.toString().trim();	
		    System.out.println("Your work experice:\n" + workExperience);            
		    
		    
		    
		    String education = "";
		    System.out.println("Enter your education (press enter after each degree, type 'done' to finish):");
		    StringBuilder educationBuilder = new StringBuilder();
		    String input;
		    do {
		    	input = scanner.readLine();
		    	if (!input.equalsIgnoreCase("done")) {
	                   educationBuilder.append("- ").append(input).append("\n");
	                  }
		    }while(!input.equalsIgnoreCase("done"));
		    education = educationBuilder.toString().trim();
		    
		    

			System.out.println("Your resume information:");
			System.out.println("Name: " + name);
			System.out.println("Email: " + email);
			System.out.println("Phone number: " + phoneNumber);
			System.out.println("Work experience:\n" + workExperience);
			System.out.println("Education:\n" + education);
			
			

			// Write the data to a CSV file
			FileWriter writer = new FileWriter("resume.csv");
			writer.write("Name, Email, Phone Number, Work Experience, Education\n");
			writer.write(name + ", " + email + ", " + phoneNumber + ", " + workExperience + ", " + education + "\n");
			writer.close();
	}
}


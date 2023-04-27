package com.skillstorm.beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	private final String csvfile = "C:\\Users\\isaac\\Documents\\GitHub\\MyProjects\\Project\\src\\com\\skillstorm\\beans";
	//C:\Users\isaac\Documents\GitHub\MyProjects\Project\src\com\skillstorm\beans
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main pointer = new Main();
		
		ArrayList<Users> account1 = new ArrayList<>();
		Map<String, Users> account = new HashMap<>();
		pointer.title(account1, in);
		
		
		

		

		
		while(true) {
			
			System.out.println("Welcome to Jobs R US");
			System.out.println("1. Create an account");
			System.out.println("2. View account");
			System.out.println("3. Exit");
			
			if(in.nextInt() == 1) {
				pointer.writeCSV(account1, in);
			}
			
			int choice = in.nextInt();
			
			
			
			switch(choice) {
				
//			case 1:
//				File file = new File("csvFile.csv");
//				// C:\Users\isaac\Documents\GitHub\MyProjects\Project\src\com\skillstorm\beans
//				try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
//					System.out.print("Enter your full name: ");
//					String name = in.next();
//					bw.write(name + ", ");
//					System.out.print("Enter your email: ");
//					String email = in.next();
//					bw.write(email + ", ");
//					System.out.print("Enter your phone number: ");
//					long number = in.nextLong();
//					bw.write((int) number + ", ");
//					System.out.print("Enter your job ID: ");
//					long id = in.nextLong();
//					bw.write((int) id + ", ");
//					account.put(email, new Users(name, email, number, id));
//					System.out.println("Account created!");
//					break;
//					
//				} catch(IOException ex) {
//					ex.printStackTrace();
//				}
			
			case 1:
			File file = new File("csvFile.csv");
			// C:\Users\isaac\Documents\GitHub\MyProjects\Project\src\com\skillstorm\beans
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
					
				
					System.out.print("Enter your full name: ");
					String name = in.next();
					bw.write(name + ", ");
					System.out.print("Enter your email: ");
					String email = in.next();
					bw.write(email + ", ");
					System.out.print("Enter your phone number: ");
					long number = in.nextLong();
					bw.write((int) number + ", ");
					System.out.print("Enter your job ID: ");
					long id = in.nextLong();
					bw.write((int) id + ", ");
					account1.add(new Users(name, email, number, id));
					System.out.println("Account created!");
					System.out.println(account1);
					System.out.println("Enter anything to acknowlegde");
					in.next();
					break;	
				
			} catch(IOException ex) {
				ex.printStackTrace();
			}
				
				
			case 2:
				System.out.print("Enter your email address: ");
				String validEmail = in.next();
				if(!account.containsKey(validEmail)) {
					System.out.println("No user found");
				} else {
					account.get(validEmail);
					System.out.println(account);
				}
			}
			
		
			
		}
		
	}
	
	public void title(ArrayList<Users> people, Scanner in) {
		while(true) {
			System.out.println("Welcome to Jobs R US");
			System.out.println("1. Create an account");
			System.out.println("2. View account");
			System.out.println("3. Exit");
			
			if(in.nextInt() == 1) {
				writeCSV(people, in);
			}
		}
		
	}
	
	public void writeCSV(ArrayList<Users> people, Scanner in) {
				
				
				
					File file = new File("csvFile.csv");
					// C:\Users\isaac\Documents\GitHub\MyProjects\Project\src\com\skillstorm\beans
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
					
					System.out.print("Enter your full name: ");
					String name = in.next();
					//bw.write(name + ", ");
					System.out.print("Enter your email: ");
					String email = in.next();
					//bw.write(email + ", ");
					System.out.print("Enter your phone number: ");
					long number = in.nextLong();
					//bw.write((int) number + ", ");
					System.out.print("Enter your job ID: ");
					long id = in.nextLong();
					//bw.write((int) id + ", ");
					people.add(new Users(name, email, number, id));
					for(Users p: people) {
						bw.write(p.getName() + ", " + p.getEmail() + ", " +
								 p.getPhoneNumber() + ", " + p.getId());
						bw.newLine();
					}
					System.out.println("Account created!");
					//System.out.println(people);
					System.out.println("Enter anything to acknowlegde");
					in.next();	
				
			} catch(IOException ex) {
				ex.printStackTrace();
			}
					
				
			}

}
	


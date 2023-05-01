package com.skillstorm.beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main pointer = new Main();
		
		ArrayList<Users> account1 = new ArrayList<>();
		pointer.title(account1, in);	
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
				
					Path user = Paths.get("Users");
					File file = new File("csvFile.csv");
					if(!Files.exists(user)) {
					try {
						Files.createDirectories(user);
					} catch(IOException ex) {
						ex.printStackTrace();
					}
					}
					try(BufferedWriter bw = new BufferedWriter(new FileWriter("Users/Users.csv"))){
					
					
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
	


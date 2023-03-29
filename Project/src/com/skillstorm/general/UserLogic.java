package com.skillstorm.general;


import java.util.Scanner;

public class UserLogic {

	// for the setup i have no one really needs to access any of this
		private Player[] users;
		private int numUsers;
		static String name;

		public UserLogic() {
			// im choosing what we start with
			this.users = new Player[3];
			this.users[0] = new Master("Yoda", "Master", 10, "Green Lightsaber");
			this.users[1] = new Knight("Obi-Wan", "Knight", 8, "Blue Lightsaber");
			this.users[2] = new Sith("Vader", "Sith", 8, "Red Lightsaber");
			Master actualMaster = (Master)users[0];
			Knight actualKnight = (Knight)users[1];
			Sith actualVader = (Sith)users[2];
			
			this.numUsers = 3;
		}
		
		public Player welcome(Scanner in) {
			boolean cont = false;
			int choice;
			
			Logic.clearConsole();
			Logic.printHeading("A long time ago.....\n"
					+ "A project by Isaac Bolanos...");
			Logic.anythingContinue();
			
			Logic.clearConsole();
			Logic.lineSeperator(30);
			System.out.println("In a galaxy far far away...");
			Logic.printHeading("In a dungeon where all your fears become reality, where one mistake can\n"
					+ "cause you to perish. Run through it quickly or you may not get out.\n"
					+ "5 chances is your limit. Your one mission:  Find the \"Easter Egg\" to escape.");
			Logic.anythingContinue();
			
			
			do {
				try {
					Logic.clearConsole();
					Logic.printHeading("Please enter your name: ");
					name = in.nextLine();
					Logic.clearConsole();
					Logic.printHeading("Your name is " + name + ".\nIs that correct?");
					System.out.println("(1) Yes!");
					System.out.println("(2) No, I want to change my name.");
			
					choice = Integer.parseInt(in.nextLine().trim());
				}catch(Exception e) {
					choice = 0;
				}
				
				if (choice == 1) {
					cont = false;
				} else {
					cont = true;
				}
				
			}while(cont);
			
				return newUser(in);
			
		}		
		
		// this method will grab an existing user and return that
		public Player newUser(Scanner in) {
			
			Logic.clearConsole();
			Logic.lineSeperator(30);
			System.out.println("\nWelcome " + name + "!\n");
			
			
			boolean cont = false;
			Player user = null;
			int choice;
			do {
				try {
				Logic.printHeading("What kind of Jedi are you?");
				System.out.println("(1) Jedi Master");
				System.out.println("(2) Jedi Knight");	
				System.out.println("(3) Sith Lord");

				
				choice = Integer.parseInt(in.nextLine().trim());
				} catch(Exception ex) {
					choice = 0;
					
				} 
				if (choice < 1 || choice > 3) {
					System.out.println("Please select a user");
					cont = true;
				} else {
					user = users[choice - 1];
					
					Logic.clearConsole();
					Logic.lineSeperator(40);
					System.out.println("\"" + user.getName() + " you're shorter than I expected.\"\n");
	
					cont = false;
				}
			} while(cont);
			
			System.out.println(user.toString());
			Logic.lineSeperator(40);
			
			Logic.anythingContinue();
			
//			System.out.println("Player traits:\n" + "\nJedi type: " + user.getType()
//			+ "\nforce level: "+ user.getForce() + "\nJedi weapon: " + user.getWeapon());
					
			
			return user;
		}
		
//		public Player newUser(Scanner in) {
//		System.out.println("I have just a few questions to ask you");
//		System.out.print("What is your name?: ");
//		String name = in.nextLine();
//		
//		System.out.print("What is your Jedi type?: ");
//		String type = in.nextLine();
//		
//		System.out.println("What is your Force level?: ");
//		int force = in.nextInt();
//		
//		System.out.print("What is your weapon?: ");
//		String weapon = in.nextLine();
//		System.out.println("Processing......");
//		
//		// I need to hand a buyer a name, email, and phoneNumber
//		// so i need to ask my user for those things
//		Player user = new Player(name, type, force, weapon);
//		System.out.println("Welcome to our service, " + user.getName() + "!");
//		
//		return user;
//	}
	}
	




package com.skillstorm.general;


import java.util.Scanner;

public class SceneLogic {
	
	

	public Player door(Player user, Scanner in) {
		
		boolean cont = false; // continue on if it's false
		int choice; // user choice
		
		Logic.clearConsole();
		Logic.printHeading("Upon entering a hallway, you stumble accross three unusual doors.\n"
								+ "Your tingly feeling sends you to pick...");
		
		System.out.println();
		user.withYou();
		
		
		do {
			try {
				System.out.println("\n(1) Wooden door with number 237");
				System.out.println("(2) Red door from Insidious");
				System.out.println("(3) Breakfast club door\n");
				
				choice = Integer.parseInt(in.nextLine().trim());		
			} catch(Exception ex) { // catch it
				choice = 0;
				
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont); // continues until user answers correctly
		
		if (choice == 1) {
			
			user.right();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
			
		} else if (choice == 2) {
			
			user.twist();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else {
			
			user.strong();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
		}
		
		return user;
			
	}
	
	public Player lady(Player user, Scanner in) {
		
		boolean cont = false;
		int choice;
		
		Logic.clearConsole();
		Logic.printHeading("As you walk through the hallway, you see an old woman crying and saying,\n"
				+ "\"Mis hijos, mis hijos.\" What do you do?");
		
		System.out.println();
		user.waiting();
		
		do {
			try {
				System.out.println("\n(1) Approach her and ask her what is wrong?");
				System.out.println("(2) Ignore her and continue down the hallway");
				System.out.println("(3) Find her kids.\n");
				
				choice = Integer.parseInt(in.nextLine().trim());	
			} catch(Exception ex) {
				choice = 0;
				
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		if (choice == 1) {
			
			user.speak();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else if (choice == 2) {
			
			user.pass();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else {
			
			user.force();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
		}
		
		return user;
		
	}
	
	public Player aliens(Player user, Scanner in) {
		
		boolean cont = false;
		int choice;
		
		Logic.clearConsole();
		Logic.printHeading("Your path is blocked by a dozen aliens from that film called ALIEN,\n"
								+ "and they seem to be coming your way…what would you do?");
		System.out.println();
		user.high();
		
		do {
			try {
				System.out.println("\n(1) Fight them off with your bare hands (using the Force of course).");
				System.out.println("(2) Hide behind a wall that’s to your right.");
				System.out.println("(3) Fight them off with your " + user.getWeapon() + "!\n");
				
				choice = Integer.parseInt(in.nextLine().trim());		
			} catch(Exception ex) {
				choice = 0;
				
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		if (choice == 1) {
			
			user.size();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else if (choice == 2) {
			
			user.small();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else {
			
			user.twisted();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		}
		
		return user;
	}
	
	public Player rancor(Player user, Scanner in) {
		boolean cont = false;
		int choice;
		
		Logic.clearConsole();
		Logic.printHeading("After falling through a trapdoor, you find yourself facing Jabba's Rancor!\n"
							+ "Based on your understanding of the Force, you...");
		
		System.out.println();
		user.embarrased();
		
		do {
			try {
				System.out.println("\n(1) Attack him right away with your " + user.getWeapon() + ".");
				System.out.println("(2) Lure him under the heavy portcullis.");
				System.out.println("(3) Use the Force, and wait for the perfect time to strike.\n");
				
				choice = Integer.parseInt(in.nextLine().trim());	
			} catch(Exception ex) {
				choice = 0;
				
			}
			if (choice < 1 || choice > 3) {
				System.out.println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		if (choice == 1) {
			
			user.feeling();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else if (choice == 2) {
			
			user.clever();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else {
			
			user.quote();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
		}
		
		return user;
		
	} public Player chest(Player user, Scanner in) {
		
		boolean cont = false;
		int choice;
		
		Logic.clearConsole();
		Logic.printHeading("You enter an area where there is an odd looking box in the middle of the room.\n"
								+ "Your curiosity leads you to...");
		System.out.println();
		user.useForce();
		
		do {
			try {
				System.out.println("\n(1) Open the MYSTERY box.");
				System.out.println("(2) Slash open the crate with your " + user.getWeapon() + ".");
				System.out.println("(3) Do not engage the chest and leave.\n");
				
				choice = Integer.parseInt(in.nextLine().trim());	
			} catch(Exception ex) {
				choice = 0;
				
			}
			if(choice < 1 || choice > 3) {
				System.out.println("Please select a correct number.");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		if (choice == 1) {
			
			user.remember();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else if (choice == 2) {
			
			user.simple();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
			
		} else {
			
			user.oneWithForce();
			Logic.lineSeperator(30);
			Logic.anythingContinue();
		}
		
		return user;
		
		
	}
	
	public Player goodEnd(Player user, Scanner in) {
		
		Logic.clearConsole();
		Logic.lineSeperator(40);
		
		user.great();
		user.goodEndPlayer();
		
//		System.out.println("\nCongratulations " + UserLogic.name + "! You knew who\n"
//				+ "you were and used the Force to lead you in the right direction.\n"
//				+ "No more misteries, you have found the \"Easter Egg\" and  there's\n"
//				+ "no need to worry, SORRENTO isn't looking for you...yes too many references...");
		
		user.withYou();
		// user.chosen(); // use it in vader player END?
		
		Logic.lineSeperator(40);
		
		
		return user;
	}
	
	public Player okayEnd(Player user, Scanner in) {
		
		Logic.clearConsole();
		Logic.lineSeperator(40);
		user.gone();
		
		user.okayEndPlayer();
//		System.out.println("\nYour undeniably courageous, your fortune has not\n"
//				+ "been on your side but made a true impression of the god like\n"
//				+ "creatures that were watching you.  They will give you another\n"
//				+ "chance but on another planet good luck...\n");
		
		user.another();
		Logic.lineSeperator(40);
		
		
		return user;
	}
	
	public Player badEnd(Player user, Scanner in) {
		
		Logic.clearConsole();
		Logic.lineSeperator(40);
		user.requested();
		
		user.badEndPlayer();
		
//		System.out.println("\nBad mistakes can lead you into bad situations,\n"
//				+ "the temptatious you had were among the worst. The dungeon\n"
//				+ "has kept you, forever locked with among these creatures\n"
//				+ "and more, will you get another chance in redemption? Maybe,\n"
//				+ "maybe not...");
		
		user.fuzzball();
		
		Logic.lineSeperator(40);
		return user;
		
	}
	

}

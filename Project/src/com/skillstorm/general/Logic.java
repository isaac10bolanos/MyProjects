package com.skillstorm.general;

import java.util.Scanner;

public class Logic {
	
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void clearConsole() {
		for (int i = 0; i < 100; i++)
			System.out.println();
		// simulate new console
	}
	
	public static void lineSeperator(int n) {
		for(int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
		// easy for separation
	}
	
	public static void printHeading(String title) {
		lineSeperator(30);
		System.out.println(title);
		lineSeperator(30);
		// good for title
	}

	
	public static void anythingContinue() {
		System.out.println("\nEnter anything to continue...");
		scanner.next();
		// good when you want user to read something
	}

}

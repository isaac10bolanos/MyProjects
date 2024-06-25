package com.skillstorm.general;

import java.util.Scanner;

public class DataTypes {

	
	public static void main(String[] args) {
		
		long vinNumber = 74859090568364534L;
		byte myCars = 3;
		float outsideTemperature = 98.6F;
		boolean sunny = true;
		int year = 2023;
		String weekDay = "Tuesday";
		char grade = 'A';
		short asvabScore = 50;
		long trackingNumber = 849751905789894563l;
		double savingsAccount = 3500.24;
		int states = 50;
		
		
		
		System.out.println(vinNumber);
		System.out.println(myCars);
		System.out.println(outsideTemperature);
		System.out.println(sunny);
		System.out.println(year);
		System.out.println(weekDay);
		System.out.println(grade);
		System.out.println(asvabScore);
		System.out.println(trackingNumber);
		System.out.println(savingsAccount);
		System.out.println(states);
		
		System.out.print("What is your grade? ");
		
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		
		System.out.println(input + " is your current grade");
		
		System.out.print("Enter your tracking number: ");
		
		long number = in.nextLong();
		
		System.out.println(number + " is your tracking number");
		
		in.close();
	}
	
}

package com.skillstorm.general;

import java.util.Scanner;

public class InterestCalculatorMethod {
	
	public static void main(String[] args) {
		
		simpleInterest();
	}
	public static void simpleInterest() {
		
		double interest = 0, principal = 0, rate = 0, time = 0, accrued = 0;
		
		System.out.println("Welcome to the Simplist Interest Calculator! ");
		System.out.println("");
		System.out.println("Enter principal amount: ");
		
		Scanner in = new Scanner(System.in);
		
		principal = in.nextDouble();
		System.out.println("Enter the rate (in decimal format): ");
		
		rate = in.nextDouble();
		System.out.println("Enter amount of years: ");
		
		time = in.nextDouble();
		
		accrued = principal * (1 + rate * time);
		interest = accrued - principal;

		System.out.println("Your accrued interest is " + interest);
		
		in.close();
	}	
	
	public static void simpleCompound() {
		
	}
}
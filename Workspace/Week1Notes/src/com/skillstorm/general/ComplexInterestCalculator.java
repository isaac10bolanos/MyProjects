package com.skillstorm.general;

import java.util.Scanner;

public class ComplexInterestCalculator {
	
	public static void main(String[] args) {
		
		double accrued = 0, principal = 0, rate = 0, time = 0, interest = 0;
		
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
		
		double principal = 0.0, rate = 0.0, number = 0.0, years = 0.0;
		
		System.out.println("Enter your principal: ");
		Scanner in = new Scanner(System.in);
	}

}

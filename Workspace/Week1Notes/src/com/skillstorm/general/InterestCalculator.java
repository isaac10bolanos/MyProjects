package com.skillstorm.general;

import java.util.Scanner;

public class InterestCalculator {
	
	public static void main(String[] args) {
		
		double principal = 0.0, interest = 0.0, rate = 0.0, time = 0.0;
		
		System.out.println("Welcome to Simple Interest Calculator: ");
		System.out.println("Enter the principal amount: ");
		
		Scanner in = new Scanner(System.in);
		
		principal = in.nextDouble();
		
		System.out.println("Enter the rate: ");
		
		rate = in.nextDouble();
		
		System.out.println("Enter the years: ");
		
		time = in.nextDouble();
		
		interest = principal * rate * time / 100;
		
		System.out.print("Your accrued interest is: " + interest);
		
		in.close();
	}

}

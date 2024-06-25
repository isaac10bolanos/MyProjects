package com.skillstorm.general;

import java.util.Scanner;

public class CompoundInterest {
	
	public static void main(String[] args) {
		
		double principal = 0, rate = 0, number = 0,
		years = 0, accrued = 0, interest = 0;
					
		System.out.println("Enter your principal: ");
					
		Scanner in = new Scanner(System.in);
		principal = in.nextDouble();
				
		System.out.println("Enter the rate (in decimal format): ");
		rate = in.nextDouble();
				
		System.out.println("Enter the number of times interest is compounded per year: ");
		number = in.nextDouble();
				
		System.out.println("Enter amount of years: ");
		years = in.nextDouble();
				
		accrued = principal * (Math.pow((1 + rate/number), (number * years)));
		interest = accrued - principal;
				
		System.out.println("Your accrued interest is: " + interest);
	}

}

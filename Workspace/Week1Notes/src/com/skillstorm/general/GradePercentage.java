package com.skillstorm.general;

import java.util.Scanner;

public class GradePercentage {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Want to know your grade? "
				+ "\nEnter your grade percentage: ");
		
	
		double input = in.nextDouble();
	
		if (input >= 90.0 && input <100.0) {
			System.out.println("Congrats you got an A!");
			}else if (input >=80.0 && input < 90.0) {
				System.out.println("It's okay B is great!");
			}else if (input >= 70.0 && input < 80.0) {
				System.out.println("Good you got a C!");
			}else if (input >= 60.0 && input < 70.0) {
				System.out.println("D's get Degrees!");
			}else if (input < 60.0 && input >= 0.0) {
				System.out.println("Unfortunately you got an F.");
			}else {
				System.out.println("You did not enter a valid percentage score");
				
				
				
			

			}
		in.close();
	}
}
package com.skillstorm.general;

import java.util.ArrayList;

public class MyOwnNotes {
	
	

	public static void main(String[] args) {
		
		ternary();
	

   }
	
	public static void ternary() {
		
		
		int num = 5;
		
		int condition = 6;
		
		num = condition % 2 == 0 ? 7 : 10;
		System.out.println(num);
		
		System.out.println(condition % 2 == 9 ? "True" : "False");
		
		String logic;
		
		logic = condition < 0 && condition > 6
				? "In between 6"
				: condition <= 0 
					? "Inner logic"
					: "It's actually 6";
		System.out.println(logic);
		
		logic = condition < 0 && condition > 7 
					? "Not this"
					: condition > 5 && condition < 7
						? "It's saturday" 
						: "idk";
		System.out.println(logic);
						
		
		
		
		
	
	}





}

	




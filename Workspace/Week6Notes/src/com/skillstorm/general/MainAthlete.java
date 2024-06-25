package com.skillstorm.general;

import java.util.ArrayList;
import java.util.Arrays;


public class MainAthlete {
	
	public static void main(String[] args) {
		
		Athlete frank = new Athlete("Frank", 15, 5);
		Athlete mark = new Athlete("Mark", 20, 10);
		Athlete eric = new Athlete("Eric", 12, 7);
		Athlete john = new Athlete("John", 14, 3);
		Athlete jack = null;
		
		Athlete[] athletesArray = new Athlete[] {frank, mark, eric, john};
		ArrayList<Athlete> athletes = new ArrayList<>(Arrays.asList(athletesArray));
		
		System.out.println("***** Athletes *****");
		System.out.println(athletes);
		Athlete.AthleteComparator comparator = new Athlete.AthleteComparator();
		athletes.sort(comparator);
		System.out.println("\n***** Athletes ranked by win ratio *****");
		System.out.println(athletes);
		
		athletes.add(jack);
//		athletes.sort(comparator); // will throw a NullPointerException
		
		Athlete liam = new Athlete("Liam", 35, 15);
		Athlete noah = new Athlete("Noah", 60, 45);
		Athlete oliver = new Athlete("Oliver", 47, 23);
		Athlete william = new Athlete("William", 53, 9);
		Athlete henry = null;
		
		Athlete[] athletesArray2 = new Athlete[] {liam, noah, oliver, william};
		ArrayList<Athlete> athletes2 = new ArrayList<>(Arrays.asList(athletesArray2));
		
		System.out.println("\n***** Athletes over 30 games played *****");
		System.out.println(athletes2);
		Athlete.AthleteComparator comparator2 = new Athlete.AthleteComparator();
		athletes2.sort(comparator2);
		System.out.println("\n***** Athletes ranked by win ratio *****");
		System.out.println(athletes2);
		
		athletes2.add(henry);
//		athletes.sort(comparator2); // cannot compare athletes to null
		
	}

}

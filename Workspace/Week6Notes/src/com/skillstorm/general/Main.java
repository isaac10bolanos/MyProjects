package com.skillstorm.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		
		
		Programmer tyler = new Programmer("Tyler", "SkillStorm", "C++");
		Programmer jack = new Programmer("Jack", "Amazon", "Java");
		Programmer bob = new Programmer("Bob", "Lockheed Martin", "JavaScript");
		Programmer adam = new Programmer("Adam", "SkillStorm", "Python");
		
		jack.removeLanguage("C++"); // tried to remove a language that he doesn't have
		
		System.out.println(jack); // prints jack
		
		jack.addLanguage("Java"); // tried to add Java but already have it
		
		System.out.println(jack); // prints jack
		
		jack.addLanguage(null); // cannot add null to a language
		
		System.out.println(jack); // prints jack
		
		jack.addLanguage("JavaScript"); // added a new Language
		
		System.out.println(jack); // prints jack
		
		Programmer[] peopleArray = new Programmer[] { jack, bob, adam };
		
		ArrayList<Programmer> people = new ArrayList<>(Arrays.asList(peopleArray));
		
		System.out.println(people);
		
		people.add(tyler);
		
		Collections.sort(people);
		
		System.out.println(people);
	
	}

}

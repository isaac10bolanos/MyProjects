package com.skillstorm.general;

import java.util.HashMap;
import java.util.Map;

public class MainCountCharacters {
	
	public static void main(String[] args) {
		
		//makeCharacterSense("test");
		//makeCharacterSense("testing test");
		//makeStringSense("testing test");
		//makeStringSense("test test test");
		countCharacters("test");
		countCharacters("testing test");
		countCharacters("");	
		countCharacters(null);
		countCharacters("java is a unique language");
		countString("test test test");
		countString("test testing test");
		countString(null);
		countString("");
		
	}
	
	public static Map<Character, Integer> countCharacters(String name) {
		Map<Character, Integer> charCount = new HashMap<>();
		if(name == null || name.trim().equalsIgnoreCase("")) {
			System.out.println(charCount);
			return charCount;
		}
		char charArray[] = name.toCharArray();
		for(char key: charArray) {
			if(charCount.containsKey(key)) {
				charCount.put(key, charCount.get(key) + 1);
			} else {
				charCount.put(key, 1);
			}
		}
		System.out.println(name + ": " + charCount);
		return charCount;
	}
	
	public static Map<String, Integer> countString(String input) {
		Map<String, Integer> stringCount = new HashMap<>();
		if(input == null || input.trim().equalsIgnoreCase("")) {
			System.out.println(stringCount);
			return stringCount;
		}
		String strArray[] = input.split(" ");
		for(String key: strArray) {
			if(stringCount.containsKey(key)) {
				stringCount.put(key, stringCount.get(key) + 1);
			} else {
				stringCount.put(key, 1);
			}
		}
		System.out.println(input + ": " + stringCount);
		return stringCount;
	}
	
	public static void makeCharacterSense(String value) {
		
		// .toCharArray converts String into new character array
		char charArray[] = value.toCharArray();
		for(char c : charArray) {
			System.out.println(c);
		}
		/*
		 * c is essentially iterating through each character in the String
		 * if it's test it goes through each character
		 * t
		 * e
		 * s
		 * t
		 * 
		 * if it's testing test
		 * t
		 * e
		 * s
		 * t
		 * i
		 * n
		 * g
		 * 
		 * t
		 * e
		 * s
		 * t
		 */
	}
	
	public static void makeStringSense(String value) {
		// .split() splits each individual string or in between " "
		String stringArray[] = value.split(" ");
		for(String s: stringArray) {
			System.out.println(s);
		}
	}
}

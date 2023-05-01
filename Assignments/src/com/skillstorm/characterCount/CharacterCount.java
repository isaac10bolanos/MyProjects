package com.skillstorm.characterCount;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
	
	public static void main(String[] args) {
		
//		//characterLogic("test");
//		//characterLogic("testing test");
//		characterCountMethod("test");
//		characterCountMethod("testing test");
//		characterCountMethod(null);
//		characterCountMethod("");
//		characterCountMethod("java is a unique language");
//		stringLogic("test test");
//		stringLogic("test testing test");
		stringCountMethod("test test");
		stringCountMethod("lo lo la lo la lol la lo la");
		stringCountMethod(null);
	}
	
	public static Map<Character, Integer> characterCountMethod(String input) {
		Map<Character, Integer> charCount = new HashMap<>();
		if(input == null || input.trim().equalsIgnoreCase("")) {
			System.out.println(charCount);
			return charCount;
		}
		char[] charArray = input.toCharArray();
		for(char key: charArray) {
			if(charCount.containsKey(key)) {
				charCount.put(key, charCount.get(key) + 1);
			} else {
				charCount.put(key, 1);
			}
		}
		System.out.println(input + ": " + charCount);
		return charCount;
	}
	
	public static void characterLogic(String name) {
		
		// converts String into characters
		char[] charArray = name.toCharArray();
		for(char set: charArray) {
			System.out.println(set);
		}
	}
	
	public static Map<String, Integer> stringCountMethod(String input) {
		
		Map<String, Integer> stringCount = new HashMap<>();
		if(input == null || input.trim().equalsIgnoreCase("")) {
			System.out.println(stringCount);
			return stringCount;
		}
		String[] breakUp = input.split(" ");
		for(String key: breakUp) {
			
			if(stringCount.containsKey(key)) {
				stringCount.put(key, stringCount.get(key) + 1);
			} else {
				stringCount.put(key, 1);
			}	
		}
		System.out.println(input + ": " + stringCount);
		return stringCount;
	}
	
	public static void stringLogic(String input) {
		// .split() splits each individual string or in between " "
		String[] breakUp = input.split(" ");
		for(String up: breakUp) {
			System.out.println(up);
		}
		
	}

}

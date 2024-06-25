package com.skillstorm.general;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.skillstorm.beans.BetterInterface;
import com.skillstorm.beans.MyInterface;

public class MyOwnNotes {
	
	public static void main(String[] args) {
		

		
		
		//mapEntry();
		//myBubble();
		//dates();
		lambdas();
		
	}
	
	// Predicate - 1 parameter, return statement boolean, test()
	// Supplier - 0 parameter, return some value, get()
	// Consumer - accept(), 1 parameter, does not return nothing
	// Function - 2 parameters apply(), 1st parameter type, 2nd return
	
	public static void lambdas() {
		
		List<String> names = Arrays.asList("tim", "joe", "noel", "john");
		Predicate<List<String>> timPresent = str -> str.contains("tim");
		System.out.println(timPresent.test(names));
		Predicate<List<String>> joePre = str -> {
			System.out.println("Inside joePre");
			return str.contains("joe");
		};
		System.out.println(joePre.test(names));
		
		Random rand = new Random();
		Supplier<Integer> ranNum = () -> rand.nextInt(7);
		System.out.println(ranNum.get());
		System.out.println(ranNum.get());
		System.out.println(ranNum.get());
		
		Consumer<String> printName = str -> System.out.println(str);
		for(String name: names) {
			printName.accept(name);
		}
		
		Function<String, String> change = upper -> upper.toUpperCase();
		for(String name: names) {
			System.out.println(change.apply(name));
		}
		
		MyInterface someAct = () -> System.out.println("Some action?");
		someAct.action();
		
		BetterInterface betterInt = (a, b, c) -> {
			System.out.println(a + " is " + b + " years old, and grade average of %" + c + ".");
			System.out.println("Woah this is cool!");
			return a + b + c;
		};
		
		betterInt.action("Isaac", 30, 80);
		
		
		
		}
	
	public static void dates() {
		
		Date dateNow = new Date();
		System.out.println(dateNow);
		
		LocalDate localNow = LocalDate.now();
		System.out.println(localNow);
		
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println(localTime);
		
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E MMM dd kk:mm:ss yyyy a");
		System.out.println(localTime.format(myFormat));
			
		
		
	}
	

	
	public static void mapEntry() {
		
		Map<Character, Integer> countEntry = new HashMap<>();
		countEntry.put('c', 1);
		countEntry.put('b', 2);
		countEntry.put('d', 9);
		System.out.println(countEntry);
		
		System.out.println(countEntry.get('d')); // prints 9
		countEntry.put('d', countEntry.get('d') + 1);
		System.out.println(countEntry);
		
		
		
		
	}

}

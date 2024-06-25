package com.skillstorm.general;

// this is a comment.  the computer does not read this
// this is a single line comment

/* 
 
 anything in between the star and slash is a comment
 this is a multi-line comment
 
 
 */
public class Day1 {
	// curly braces show ownership
	// everything has to be inside of a class
	
	
	// Class names start with a capital letter, always
	// All names use camel case lowerCamelCaseWord / UpperCamelCaseWord (classes)
	// Names cannot start with numbers, but can have numbers
	// Names cannot have space, but _ and $ are okay
	// Best practice do not put _ at the start of a name
	
	// the starting point of every program
	// your code will not start without this method
	public static void main(String[] args) { // <- Memorize this!
		
		
	// on a test you may see these:
	// public static void main (String args[] {} // - valid
	// public static void main(String... args) {} // - valid
	// public static synchronized void main(String args[]) {} // - valid
		
		// every line ends with a semi-colon
		System.out.println("Hello World!"); // prints with a new line
		System.out.print("Isaac Bolanos"); // prints without a new line
		
		System.out.println("");
		// prints it to the screen as is
		System.out.print("This is my awesome ");
		System.out.print("New Program.");
		System.out.println("This is a new line!");
		System.out.print("It's shiny");
		
		
		
		// red underline means your code will not compile, it will not run
		// yellow underline means a warning, something may not work as intended
		
		// To Run Java Code from the command line
		// to compile your code run javac YourFile.java
		// This creates a YourFile.class file
		// then to run it type java YourFile
	}
}


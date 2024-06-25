package com.skillstorm.general;

public class Animal {
	
	// this class will never "run" so it doesn't need a main method
	
	// access modifiers work the exact same way on methods as they do variables
	// can only apply them outside methods
	
	// public - accessible everywhere by everything
	// protected - accessible in the class, subclasses, and the same package
	// default - accessible in the class and same package
	// private - accessible in the class
	
	public String name;
	String color; // this is default
	protected double age; // years
	private boolean fur;
	
	// constructors are special methods, if you have none Java gives you
	// the default one
	// can have as many constructors as I want
	// once you define a constructor the default on goes away
	public Animal(String name, String color, double age, boolean fur) {
		// the constructor is a method like any other, you just run it with
		// the new keyword
		int someValue = 24;
		System.out.println("My number is " + someValue);
		
		this.name = name;
		this.color = color;
		this.age = age;
		this.fur = fur;
	}
	
	// can overload my constructors
	public Animal(String name, double age, boolean fur) {
		this.name = name;
		this.age = age;
		this.fur = fur;
		
		// can default this or leave it out, both ways work the same
		// this.color = "purple";
	}
	
	// this is essentially the default constructor
	// not very useful, but does create you object.  this is valid constructor
	public Animal() {}
	
	// access modifiers are one part of encapsulation
	// getters and setters are the other part
	public void setFur(boolean fur) { // setting
		this.fur = fur;
	}
	
	public boolean hasFur() { // getting
		return this.fur;
	}
	
	public void setAge(double age) {
		// sets the local variable equal to itself
		// Java doesn't know what im talking about, the names are the same
		// for two different variables
		// age = age;
		
		// now Java knows what i'm referencing
		this.age = age;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
}

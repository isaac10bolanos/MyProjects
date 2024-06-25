package com.skillstorm.beans;

public class Tiger extends Cat{
	
	public Tiger() { }
	
	public Tiger(String name, int lifespan, boolean pet, String colorEyes, boolean pur) {
		super(name, lifespan, pet, colorEyes, pur);
	}
	
	public final void habitat() {
		System.out.println(getName() + " is a wild feline found in Asia.");
	}
	
	@Override
	public final void swim() {
		System.out.println(getName() + " is an excellent swimmer.");
	}
	
	@Override
	public void speak() {
		System.out.println(getName() + " does not say Meow, he ROARS!");
	}
	
	@Override
	public final void hunt() {
		System.out.println("There is nothing " + getName() + " loves more than hunting deer.");
		habitat();
	}

}

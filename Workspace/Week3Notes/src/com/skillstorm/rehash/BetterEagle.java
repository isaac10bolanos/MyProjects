package com.skillstorm.rehash;

// as many classes as I want extend BetterBird
// final classes cannot be extended further. you cannot inherit from a final class
public final class BetterEagle extends BetterBird{

	public BetterEagle(String name, boolean fur, double weight, double speed, double wingspan) {
		super(name, fur, weight, speed, wingspan);
	}
	
	@Override
	public void speak() {
		System.out.println("KAWWW!");
	}
	
	// you cannot override final methods
//	@Override
//	public void flap(int times) {
//		
//	}
}

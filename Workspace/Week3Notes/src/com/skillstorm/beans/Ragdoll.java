package com.skillstorm.beans;

public final class Ragdoll extends Cat{
	
	public Ragdoll() { }
	
	public Ragdoll(String name, int lifespan, boolean pet, String colorEyes, boolean pur) {
		super(name, lifespan, pet, colorEyes, pur);
	}
	
	public void affection() {
		System.out.println(getName() + " loves to be held and cuddled.");
	}

}

package com.skillstorm.beans;

import com.skillstorm.general.CatFarm;

public class Cat {
	
	private String name;
	private int lifespan;
	private boolean pet;
	private String colorEyes;
	private boolean pur;
	
	public Cat() {}
	
	public Cat(String name, int lifespan, boolean pet, String colorEyes, boolean pur) {
		this.name = name;
		this.lifespan = lifespan;
		this.pet = pet;
		this.colorEyes = colorEyes;
		this.pur = pur;
	}
	
	public void speak() {
		System.out.println(name + " likes to say Meow");
		System.out.println(name + " is an animal: " + CatFarm.ANIMAL);
	}
	
	public final void sleep(int hours) {
		System.out.println(name + " sleeps around " + hours + " hours a day." );
	}
	
	public void swim() {
		System.out.println("Despite having a fear of swimming, " + name +
				" is able to swim to save his life.");
	}
	
	public void hunt() {
		System.out.println(name + " preys on local birds and rats/mice.");
	}
	
	public void go(int run) {
		System.out.println(name + " runs at " + run + " mph.");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLifeSpan() {
		return this.lifespan;
	}
	
	public void setLifeSpan(int lifespan) {
		this.lifespan = lifespan;
	}
	
	public boolean getPet() {
		return this.pet;
	}
	
	public void setPet(boolean pet) {
		this.pet = pet;
	}
	
	public String getColorEyes() {
		return this.colorEyes;
	}
	
	public void setColorEyes(String colorEyes) {
		this.colorEyes = colorEyes;
	}
	
	public boolean getPur() {
		return this.pur;
	}
	
	public void setPur(boolean pur) {
		this.pur = pur;
	}
}

package com.skillstorm.beans;

import java.rmi.server.ServerCloneException;

// interfaces use the implements keyword
// can implement as many interfaces as I want, they are just comma separated
public class HammerHead implements Shark{
	
	private String name;
	private double length;
	private double biteForce;
	private double headSize;
	private double speed;
	
	public HammerHead(String name, double length, double biteForce, double headSize, double speed) {
		this.name = name;
		this.length = length;
		this.biteForce = biteForce;
		this.headSize = headSize;
		this.speed = speed;
	}
	
	// still need to properly encapsulate

	// I need to implement these 3 methods that are in my interface
	// or my class will not compile
	
	// I can throw either no exception or an exception that is an CloneNotSupportedException
	// I can also add in any runtime exception
	@Override
	public void swim(double distance) throws ServerCloneException{
		System.out.println(name + " is swimming " + ((distance/headSize) * biteForce)
						   + " miles at " + speed + " mph.");
	}

	// I don't need the throws clause when i override something that throws an exception
	// can't add an incompatible exceptions in the overridden class
	// Runtime exceptions are compatible with everything and can be added because they are
	// unchecked
	@Override
	public void bite() throws IndexOutOfBoundsException {
	System.out.println(name + " bit with the strength of " + biteForce + " N.");
	}

	@Override
	public void hunt() {
		try {
			swim((length/headSize) * speed);
			bite();
			System.out.println(name + " swims of into the sunset, satisfied.");
		} catch(ServerCloneException ex) {
			ex.printStackTrace(); // probably never going to happen here...
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getBiteForce() {
		return this.biteForce;
	}
	
	public void setBiteForce(double force) {
		this.biteForce = force;
	}
	
	public double getHeadSize() {
		return this.headSize;
	}
	
	public void setHeadSize(double headSize) {
		this.headSize = headSize;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

}

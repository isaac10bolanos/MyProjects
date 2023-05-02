package com.skillstorm.singleton;

public class Evolution {
	
	private static Object mutex = new Object();
	
	private static Evolution instance = null;
	
	private int generation;
	
	private Evolution() {
		this.generation = 10;
	}
	
	private Evolution(int generation) {
		this.generation = generation;
	}
	
	public static Evolution getInstance() {
		synchronized (mutex) {
			if(instance == null) {
				instance = new Evolution();
			}
			return instance;
		}
	}
	
	public static Evolution getInstance(int generation) {
		synchronized (mutex) {
			if(instance == null) {
				instance = new Evolution(generation);
			}
			return instance;
		}
	}
	
	public int getGeneration() {
		if(this.generation == 10) {
			System.out.println("EVO X");
			return this.generation;
		} else if(this.generation == 9) {
			System.out.println("EVO |X");
			return this.generation;
		} else {
			System.out.println("EVO V|||");
			return this.generation;
		}
	}

}

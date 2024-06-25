package com.skillstorm;

public class MyCounter extends Thread{
	
	/*
	 * Make a branch
	 * Implement this run method
	 * 
	 * What does run do?
	 * 	It counts from 0 to any number of your choosing
	 * 	It counts by any increment of your choosing
	 *  It prints the number out when it's finished
	 *  
	 *  I want you to merge your method into the main branch
	 *  Upload a screenshot of your file after you merge it
	 */
	
	// Isaac Bolanos
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i+=5) {
			System.out.println(i + " ");
		}
	}

}

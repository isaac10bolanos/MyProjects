package com.skillstorm.threadSum;

public class ThreadSum extends Thread{
	/*
	 * Make an application with one class that extends Thread or implements Runnable
	 * 
	 * override the run method
	 * make two threads,
	 * 	sum every number between start and end
	 *  one thread sums the even numbers
	 *  one thread sums the odd numbers
	 *  combine the result both threads came up with to get the final sum
	 */
	// my HALLPASS
	private static final Object mutex = new Object();
	private int start;
	private int end;
	private int result;
	
	// need start && end inclusive
	public ThreadSum(int start, int end) {
		this.start = start;
		this.end = end;
	}
	// gets my result
	public int getResult() {
		return this.result;
	}
	
	@Override
	public void run() {
		// my HALLPASS
		synchronized (mutex) {
			// adds 2 to skip even or odd
		for(int i = start; i <= end; i+=2) {
			// if even do this
			if(i % 2 == 0) {
				result += i;
			// if odd do this
			} else if(i % 2 != 0) {
				result += i; 
			}
				
			}
		}	
	}
	


}

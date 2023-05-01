package com.skillstorm.threadSum;

public class OddSum extends Thread{
	// my HALLPASS
	private static final Object mutex = new Object();
	private int start;
	private int end;
	private int result;
	// need start && end inclusive
	public OddSum(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		// my HALLPASS
		synchronized (mutex) {
		for(int i = start; i <= end; i++) {
			if(i % 2 != 0) {
				result += i;
			}
		}
	}
		
	}
	public int getResult() {
		return this.result;
	}
}

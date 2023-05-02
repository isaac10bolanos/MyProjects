package com.skillstorm.singleton;

public class Main {
	
	public static void main(String[] args) {
		Thread th1 = new Thread(() -> {
			Evolution ten = Evolution.getInstance();
			System.out.println(ten + ": " + ten.getGeneration());
		});
		
		Thread th2 = new Thread(() -> {
			Evolution nine = Evolution.getInstance(9);
			System.out.println(nine + ": " + nine.getGeneration());
		});
		
		Thread th3 = new Thread(() -> {
			Evolution eight = Evolution.getInstance(8);
			System.out.println(eight + ": " + eight.getGeneration());
		});
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	
	}

}

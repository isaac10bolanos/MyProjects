package com.skillstorm.threadSum;

public class MainThreadSum {
	
	public static void main(String[] args) {
		System.out.println("***** USED TWO CLASSES *****\n(0 - 10)");
		SumEven even = new SumEven(0, 10);
		OddSum odd = new OddSum(0, 10);
		
		Thread e = new Thread(even);
		Thread o = new Thread(odd);
		
		e.start();
		o.start();
		
		try {
			e.join();
			o.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Odd sumation: " + odd.getResult());
		System.out.println("Even sumation: " + even.getResult());
		int totalSum = even.getResult() + odd.getResult();
		System.out.println("Final result is: " + totalSum);
		
		System.out.println("***** USED TWO CLASSES *****\n(0 - 20)");
		SumEven even1 = new SumEven(0, 20);
		OddSum odd1 = new OddSum(0, 20);
		
		Thread e1 = new Thread(even1);
		Thread o1 = new Thread(odd1);
		
		e1.start();
		o1.start();
		
		try {
			e1.join();
			o1.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Odd sumation: " + odd1.getResult());
		System.out.println("Even sumation: " + even1.getResult());
		int totalSum1 = odd1.getResult() + even1.getResult();
		System.out.println("Final result is: " + totalSum1);
		
		System.out.println("***** USED ONE CLASS *****\n(0 - 10)");
		ThreadSum ev = new ThreadSum(0, 10);
		ThreadSum od = new ThreadSum(1, 9);
		
		ev.start();
		od.start();
		
		try {
			ev.join();
			od.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		int totalSum2 = ev.getResult() + od.getResult();
		System.out.println("Even sumation: " + ev.getResult());
		System.out.println("Odd sumation: " + od.getResult());
		System.out.println("Final result is: " + totalSum2);
		
		System.out.println("***** USED ONE CLASS *****\n(0 - 20)");
		ThreadSum ev1 = new ThreadSum(0, 20);
		ThreadSum od1 = new ThreadSum(1, 19);
		
		ev1.start();
		od1.start();
		
		try {
			ev1.join();
			od1.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		int totalSum3 = ev1.getResult() + od1.getResult();
		System.out.println("Even sumation: " + ev1.getResult());
		System.out.println("Odd sumation: " + od1.getResult());
		System.out.println("Final result is: " + totalSum3);
		
			
	}
}

package com.skillstorm.producerConsumer;

import java.util.Random;

public class MainProducerConsumer {
	
	public static void main(String[] args) {
		
		/*
		*   1. Decrease the amount that the Producer produces so that the Producer produces less than the Consumer consumes. 
		*   2. Screenshot the output.
		*	3. Increase the amount produced back to the original amount.
		*	4. Increase amount that the Consumer consumes so that the Consumer consumes more than the Producer produces. 
		*	5. Screenshot the output
		*	6. Submit the two screenshots here.
		*	
		*/
		Random rand = new Random();
		ProducerConsumer pointer = new ProducerConsumer();
		System.out.println("***** Produce: 1 - 10 Consume: 1 - 10 *****");
		Thread prodRegular = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(11 - 1) + 1;
					pointer.produce(data);
					Thread.sleep(1000);
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}	
		});
		
		Thread consRegular = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(11 - 1) + 1;
					pointer.consume(data);
					Thread.sleep(1000);
				}
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		prodRegular.start();
		consRegular.start();
		
		try {
			prodRegular.join();
			consRegular.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
		System.out.println("***** Produce: 1 - 5 Consume: 1 - 10 *****");
		Thread prodDecrease = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(6 - 1) + 1;
					pointer.produce(data);
					Thread.sleep(1000);
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}	
		});
		
		Thread consRegular2 = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(11 - 1) + 1;
					pointer.consume(data);
					Thread.sleep(1000);
				}
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		prodDecrease.start();
		consRegular2.start();
		
		try {
			prodDecrease.join();
			consRegular2.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("***** Produce: 1 - 10 Consume: 1 - 20 *****");
		Thread prodRegular2 = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(11 - 1) + 1;
					pointer.produce(data);
					Thread.sleep(1000);
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}	
		});
		
		Thread consIncrease = new Thread(() -> {
			int data;
			try {
				for(int i = 0; i < 5; i++) {
					data = rand.nextInt(21 - 1) + 1;
					pointer.consume(data);
					Thread.sleep(1000);
				}
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		prodRegular2.start();
		consIncrease.start();
		
		try {
			prodRegular2.join();
			consIncrease.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}

}

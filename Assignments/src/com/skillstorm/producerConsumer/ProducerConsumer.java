package com.skillstorm.producerConsumer;

public class ProducerConsumer {
	
	private static Object mutex = new Object();
	private int availableApples;
	
	public ProducerConsumer() {
		this.availableApples = 0;
	}
	
	public void produce(int apples) {
		synchronized (mutex) {
			System.out.println("AppleFarms stocked " + apples + " apples today.");
			availableApples += apples;
			
			mutex.notifyAll();
			// notifies threads to wake up
		}
	}
	
	public void consume(int apples) {
		
		synchronized (mutex) {
			System.out.println("Isaac wants to take home " + apples + " apples.");
			
			while(availableApples < apples) {
				System.out.println("Isaac was told to wait for restock.");
				
				try {
					// has to wait for that resource to be fulfilled
					mutex.wait();
				} catch (InterruptedException ex) {
					
					ex.printStackTrace();
				}
				System.out.println("Isaac was notified of restocking.");
			}
			
			System.out.println("Isaac took " + apples + " apples home.");
			availableApples -= apples;
		}
	}

}

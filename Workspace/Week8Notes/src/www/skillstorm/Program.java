package www.skillstorm;

import java.util.List;

import www.skillstorm.beans.MyFileReader;
import www.skillstorm.beans.Person;

public class Program {
	
	public static void main(String[] args) {
		//fileIO();
		threading();
		
		System.out.println("Program is done");
		

	}
	
	public static void threading() {
		// so far everything has been run in the main thread, every branches from
		// the main thread
		
		// multi-threading, is different
		// instead of having one thing run all of your code, you have multiple things
		// running your code. depending on how it's written it can be very fast
		// too many threads and you slow your code down again
		
		// you don't control how a thread runs, your scheduler does
		
		// if I want to make a thread:
		// creating it is easy, but when you create you need to give it a job
		// Threads are Runnables, they implement the Runnable interface
		Thread t1 = new Thread(() -> { // Thread-0
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
			
			//System.out.println("I'm a thread!");
		});
		Thread t2 = new Thread(() -> { // Thread-1
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
			//System.out.println("I'm a thread!"); 
			
		});
		Thread t3 = new Thread(() -> { // Thread-2
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
			//System.out.println("I'm a thread!");
			
		});
		
		// they don't do anything until you give them a job, and actually tell them to do that job
		// you need to call this method or nothing happens
		t1.start();
		t2.start();
		t3.start();
		
		// threads take up memory, they all have their own individual call stack
		// threads don't stop taking up memory even after they finish their job,
		// if they ever finish it
		
		// and the main thread does not wait for your threads before continuing
		try{
			// join tells your main thread to wait for these to die before continuing
			// also takes back the memory for you
			t1.join();
			t2.join();
			t3.join();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		Thread t4 = new Thread(new Runnable() {
			// can make a thread with anything that implements Runnable
			// Runnable is a functional interface, with the run method
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
				}
			}
		});
		Thread t5 = new Thread(new Runnable() {
			// can make a thread with anything that implements Runnable
			// Runnable is a functional interface, with the run method
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
				}
			}
		});
		
		System.out.println("\nRunnables vs lambdas: \n");
		t4.start();
		t5.start();
		
		try {
			t4.join();
			t5.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		/*
		 * Thread States:
		 * 	new: thread was created
		 * 	runnable: thread is either running, or ready to run
		 * 	waiting: any time you tell a thread to wait. this state releases any locks
		 * 	timed waiting: any time you tell a thread to wait for an amount of time.
		 *                 in this state locks are not releases
		 * 	terminated: the thread is finished or the program crashed
		 * 	blocked: it tried to access a resource but has to wait
		 */
		
		// will still throw an exception, but will not crash my code
		// can't catch the exception outside the thread, need to catch it inside the
		// thread. The exception never makes it out of the thread
		
		// you can name your threads, by giving it a name in the constructor
		Thread t6 = new Thread(() -> { throw new RuntimeException(); }, "Carl");
		
		try {
			t6.start();
		} catch(Exception ex) {
			System.out.println("Exception caught");
		}
		
		try {
			t6.join();
		} catch(InterruptedException ex) {
			System.out.println("Thread interrupted!");
			ex.printStackTrace();
		} catch(Exception ex) {
			System.out.println("Caught an exception");
		}
		
		// an exception in the main thread kills your program, because your program runs
		// in the main method
		// throw new RuntimeException();
		
		// your computer can only do one thing at a time
		System.out.println("I'm main thread");
	}
	
	// what our lambdas are
//	public void _() {
//		System.out.println("I'm a thread!");
//		testStuff();
//	}
	
	public static void fileIO() {
		MyFileReader reader = new MyFileReader();
		
		reader.readFile();
		reader.readFile2();
		reader.readFile3();
		reader.writeFile();
		List<Person> people = reader.readCSV();
		
		System.out.println(people);
		reader.writeCSV(people, "csvFile2.csv"); // relative path. places this file under whatever
		// folder the app is running from
		
		
		
	}

}

package com.skillstorm;

public class FunctionalInterfacePractice{
	
	public static void actOnArray(int[] num, Action action) {
		for(int i = 0; i < num.length; i++) {
			// In here, I don't know what "act" does, but I know it takes an int and doen't return anything
			action.act(num[i]);
		}
	}
	
	public static void main(String[] args) {
	
		// Down here, I'll define what action I will perform on each element of the array
		int[] nums = { 1, 2, 3, 4, 5 };
		
//		FunctionalInterfacePractice fip = new FunctionalInterfacePractice();
//		actOnArray(nums, fip);
		
		// I'm passing as the second argument, an implementation for "act"
//		Action action = num -> System.out.println("Inside lambda expression " + num);
//		actOnArray(nums, num -> System.out.println("Inside lambda expression " + num));
		
		// Java has some prebuilt methods for us
		
		/*
		 * Most functional languages have some, if not all or more of these capabilities
		 * 
		 * NONE of these methods mutate the original data
		 * 
		 * forEach - Takes a function and performs that function on every element in the stream. Does not create a new stream
		 * map - Takes a function and performs that function on every element in the stream.
		 * 		 Map takes the return of that function and creates a new stream consisting of the altered elements of the old stream
		 * reduce - Takes a function and uses it to "condense" our stream into a singular value
		 * 			You can use it as a "sum up"
		 * filter - Takes a function that returns a boolean and uses it to create a new stream only containing values that returned true
		 * 
		 * To use these, we need to create a "stream" object
		 * Think of a "stream" as a list
		 * 
		 * 
		 */
		
	}


}

package com.skillstorm.general;

public class MaxValueArray {
	
	public static void main(String[] args) {
		
		int[] array = { 72, 34, 53, 23, 43, 
				23, 45, 69, 71, 95, 52, 12, 
				34, 33, 73, 40, 50, 20, 99, 
				71, 24, 53, 24, 53, 29, 40 }; // 26 is the length
		
		int max = array[0];
		
		
		for (int i = 0; i < array.length; i++) {
		
			if (array[i] > max) { // array[9] is max the first time, array[18] is the max the second time
				max = array[i]; // first max that we i see is 95, second max is 99 that it goes through
			}	
			
		}
		
		System.out.println("Max value in the Array is: " + max);	
		
		
		
		int[] myArray = { 23, 10, 3, 24,
				27, 15, 93, 3, 49, 9 }; // length is 10
		
		int myMax = myArray[0];
		
		for (int i = 0; i < myArray.length; i++) {
			
			if (myArray[i] > myMax) {
				myMax = myArray[i];
			}
		}
		
		System.out.println(" \nMy max value in my Array is: " + myMax);
		
		}
	}

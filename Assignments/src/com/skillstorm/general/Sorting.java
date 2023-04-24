package com.skillstorm.general;

public class Sorting {
	
	public static void main(String[] args) {
		int[] nums = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
//		System.out.println("*** Insertion Sort ***");
//		print(nums);
//		insertionSort(nums);
//		System.out.print("Final: ");
//		print(nums);
		
//		System.out.println("*** Bubble Sort ***");
//		print(nums);
//		bubbleSort(nums);
//		System.out.print("Final: ");
//		print(nums);
		
//		System.out.println("*** Quicksort ***");
//		print(nums);
//		quicksort(nums, 0, nums.length - 1);
//		System.out.print("Final: ");
//		print(nums);
		
		System.out.println("*** Quicksort2 ***");
		print(nums);
		quicksort2(nums, 0, nums.length - 1);
		System.out.print("Final: ");
		print(nums);
		
		
		
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = low - 1;
		
		System.out.println("Pivot: " + pivot + ", Low: " + arr[low]);
		for(int j = low; j <= high - 1; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
			print(arr);
		}
		swap(arr, i + 1, high);
		print(arr);
		
		return i + 1;
	}
	
	public static void quicksort(int[] arr, int low, int high) {
		// low == low index
		// high == high index
		// quicksort(nums, 0, nums.length - 1);
		// 0 == first index [0]
		// nums.length - 1 == last index 
		if(low < high) {
			
			int partitionIndex = partition(arr, low, high);
			
			// we don' include "pivot"
			quicksort(arr, low, partitionIndex - 1);
			quicksort(arr, partitionIndex + 1, high);	
		}	
	}
	
	
	public static void insertionSort(int[] arr) {
		int length = arr.length;
		
		for(int i = 1; i < length; i++) {
			int value = arr[i]; // index we are comparing to
			int j = i - 1; // index we are comparing value to
			
			System.out.println("Loop: " + i + ", Checking: " + value);
			
			while(j >= 0 && arr[j] > value) {
				System.out.print("Against " + arr[j] + " -> ");
				arr[j + 1] = arr[j];
				j--;
				print(arr);
			}
			// j is now either - 1 or less than value
			arr[j + 1] = value; // we went too far, go back and place value there
			print(arr);
			
			
		}
	}
	
		// need to recheck the array multiple times
		public static void bubbleSort(int[] arr) {
		// each number bubbles up until its at the correct spot
		int length = arr.length;
				
		// need to stop before end of array because we are comparing
		// our value to the next one we can't compare to null
		for(int i = 0; i < length - 1; i++) {
			// we start from 0 on every loop
			// end half will be sorted due to bubbling so we don't check it
			
			System.out.println("Loop: " + (i + 1));
			
			for(int j = 0; j < length - i - 1; j++) {
				System.out.print("Checking: " + arr[j] + " -> ");
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				print(arr);
			}
		}			
	}
		
	public static void quicksort2(int[] arr, int lowIndex, int highIndex) {
		if (lowIndex >= highIndex) {
			return;
		}
		int pivot = arr[highIndex];
		
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			
			while(arr[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while(arr[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(arr, leftPointer, rightPointer);
			
		}
		
		swap(arr, leftPointer, highIndex);
		
		quicksort(arr, lowIndex, leftPointer - 1);
		quicksort(arr, leftPointer + 1, highIndex);
		
	}	
		
	
				
	
	// prints my array
		public static void print(int[] arr) {
			System.out.print("[ ");
			for(int val: arr) {
				System.out.print(val + " ");
			}
			System.out.println(" ]");
	}

}

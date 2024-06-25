package com.skillstorm.general;

public class MySorting {
	
	public void insertionOrder(int[] arr) {
		int length = arr.length;
		print(arr);
		for(int i = 1; i < length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
			print(arr);
		}
	}
	
	public void bubbleSort(int[] arr) {
		int length = arr.length;
		print(arr);
		for(int i = 0; i < length - 1; i++) {
			for(int j = 0; j < length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				print(arr);
			}
		}
		
	}
	
	public static void print(int[] arr) {
		System.out.print("[ ");
		for(int val: arr) {
			System.out.print(val + " ");
		}
		System.out.println("]");
	}
	


}

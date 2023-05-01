package com.skillstorm.recursion;

public class Recursion {
	
	public static void main(String[] args) {
		int[] arr = { 101, 99, 86, 50, 98, 70 };
		int[] nums = { 100, 99, 86, 50, 10, 70 };
//		containsLarger100(arr);
//		containsLarger100(nums);
//		containsLargerN(nums, 101);
//		containsLargerN(arr, 99);
		System.out.println(evenSum(0, 10));
		System.out.println(evenSum(1, 11));
		
	}
	
	public static int evenSum(int start, int end) {
		
		if(end < start) {
			throw new IllegalArgumentException("End must be greater");
		}
		
		int sum = 0;
		// when start is equal to end then we stop
		if(start == end) {
			System.out.print("= ");
			return sum;
		}
		// only do if start is even
		if(start % 2 == 0) {
			sum = sum + start;
			System.out.print("[" + sum + "] ");
			start++;
		}
		// only do if end is odd to get to even number
		// so start == end will work
		if(end % 2 == 1) {
			end++;
		}
		
		return sum + evenSum(++start, end);
		
		
		
	}
	
	public static boolean containsLarger100(int[] nums) {
		int length = nums.length;
		// if values are not null or equal to 0 then we continue
		if(nums == null || length == 0) {
			return false;
		}
		// if everything is good then we go to contains method
		// length - 1 is starting backwards
		return contains100(nums, length - 1);
	}

	private static boolean contains100(int[] nums, int i) {
		// if we go past 0 then no elements have values greater than 100
		if(i < 0) {
			System.out.println("No index has a value greater than [100]");
			return false;
		}
		
		// if some element is greater than 100 then we return true
		if(nums[i] > 100) {
			System.out.println("Index [" + i + "] has a value of [" + nums[i] + "]" );
			return true;
		}
		
		// i keeps decreasing by 1 every loop
		return contains100(nums, i - 1);
	}
	
	public static boolean containsLargerN(int[] nums, int n) {
		int length = nums.length;
		// if values are not null or equal to 0 then we continue
		if(nums == null || length == 0) {
			return false;
		}
		
		// if everything is good then we continue to containsN method
		// length - 1 start backwards
		return containsN(nums, length - 1, n);
		
	}

	private static boolean containsN(int[] nums, int i, int n) {
		// if we go past 0 then no elements have values greater than n
		if(i < 0) {
			System.out.println("No index is larger than n:[ " + n + "]");
			return false;
		}
		// if some element is greater than n then we return true
		if(nums[i] > n) {
			System.out.println("Index [" + i + "] has a value of [" + nums[i] + "]"
				+	" which is greater than n:[ " + n + "]");
			return true;
		}
		// i keeps decreasing by 1 every loop
		return containsN(nums, i - 1, n);
	}

}

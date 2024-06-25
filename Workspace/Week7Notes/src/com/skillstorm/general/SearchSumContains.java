package com.skillstorm.general;


public class SearchSumContains {
	
	public static void main(String[] args) {
		
		int[] nums = { 12, 456, 150, 99, 12, 343 };
		int[] nums2 = { 12, 9, 40, 80, 99, 70 };
		int[] nums3 = { 101, 80, 56, 99, 100, 27 };

		System.out.println("***** Contains Larger Than 100 *****\n");
		System.out.println(containsLargerThan100(nums));
		System.out.println(containsLargerThan100(nums2));
		System.out.println(containsLargerThan100(nums3));
		System.out.println("\n\n***** Contains Larger Than N *****\n");
		System.out.println(containsLargerThanN(nums2, 98));
		System.out.println(containsLargerThanN(nums2, 200));
		System.out.println("\n\n***** Even Sum *****\n");
		System.out.println(evenSum(0, 10));
		System.out.println(evenSum(10, 20));
		System.out.println(evenSum(11, 20));
		System.out.println(evenSum(11, 21));

	}
	
	public static boolean contains100(int[] nums, int i) {
		// if we go past 0 then no elements have values greater than 0
		if( i < 0 ) {
			System.out.println("No index has a value greater than [100]");
			return false;
		}
		
		// if some element is greater than 100 then we return true
		if(nums[i] > 100) {
			System.out.println("Index [" + i + "] has a value of [" + nums[i] + "]"
					+ " which is greater than [100]");
			return true;
		}
		return contains100(nums, i - 1);
	}
	
	public static boolean containsLargerThan100(int[] nums) {
		int length = nums.length;
		// if values are not null or equal to 0 then we continue
		if(nums == null || length == 0) {
			return false;
		}
		
		// if everything is good then we go to contains method
		// nums.length - 1 start backwards
		return contains100(nums, nums.length - 1);	
	}
	
	public static boolean containsN(int[] nums, int i, int n) {
		// if we go past 0 then no elements have values greater than n
		if(i < 0) {
			System.out.println("No index has a greater value than [n: " + n + "]");
			return false;
		}
		// if some element is greater than n then we return true
		if(nums[i] > n) {
			System.out.println("Index [" + i + "] has a value of [" + nums[i] +
					"] which is greater than [n: " + n + "]");
			return true;
		}
		
		return containsN(nums, i - 1, n);
	}
	
	public static boolean containsLargerThanN(int[] nums, int n) {
		int length = nums.length;
		// if values are not null or equal to 0 then we continue
		if(nums == null || length == 0) {
			return false;
		} 
		
		// if everything is good then we go to containsN method
		// nums.length - 1 start backwards
		return containsN(nums, nums.length - 1, n);	
	}
	
	public static int evenSum(int start, int end) {
		// start at 0 to add
		// end is less than start then we through exception
		
		
		int sum = 0;
		if(end < start) {
			throw new IllegalArgumentException("End must be greater");
			// when start is equal to end then we stop
		} else if (start == end) {
			System.out.print("= ");
			return sum;
		}
		
		// only do if start is even
		if(start % 2 == 0) {
			sum = sum + start++;
			System.out.print("[" + sum + "] ");
		}
		// only do if end is odd to get to even number
		// so start == end will work
		if (end % 2 == 1) {
			end++;
			
		}
		
		return sum = sum + evenSum(1 + start, end);

		}	
		
	}
	
		
		
	



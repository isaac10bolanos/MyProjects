package www.skillstorm.general;

import java.util.Deque;
import java.util.LinkedList;

public class MainStack {
	
	public static void main(String[] args) {
		
		System.out.println("***** MyStack *****");
		MyStack<Integer> myNums = new MyStack<>();
		System.out.println(myNums.isEmpty());
		myNums.push(2);
		myNums.push(4);
		myNums.push(6);
		System.out.println(myNums.isEmpty());
		System.out.println(myNums.pop());
		System.out.println(myNums.pop());
		System.out.println(myNums.pop());
		System.out.println(myNums.peek());
		System.out.println(myNums.isEmpty());
		myNums.push(2);
		System.out.println(myNums.peek());
		
		

		
		
		System.out.println("\n***** Deque *****");
		Deque<Integer> nums = new LinkedList<>();
		System.out.println(nums.isEmpty());
		nums.push(2);
		nums.push(4);
		nums.push(6);
		System.out.println(nums.isEmpty());
		System.out.println(nums.pop());
		System.out.println(nums.pop());
		System.out.println(nums.pop());
		System.out.println(nums.peek());
		System.out.println(nums.isEmpty());
		nums.push(2);
		System.out.println(nums.peek());
	
	}

}

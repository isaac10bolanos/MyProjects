package com.skillstorm.general;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack<T> {
	// Stack is Deque so think of stack of dishes
	// Last in, First out (LIFO)
	// methods I need push, pop, peek, size, isEmpty
	// nums.push(2); ----->> takes in an argument
	// nums.pop();  -----> no arguments
	// nums.peek(); ------> no arguments
	
	private int size;
	private Node<T> top;

	
	
	public MyStack() {
		this.top = null;
		this.size = 0;
	
	}
	
	// pushes elements on top of a stack like dishes
	public void push(T data) {
		Node<T> newTop = new Node<T>(data, top);
		top = newTop;
		size++;
		
	}
	
	// removes top element and returns it
	public T pop() {
		
		if(size == 0) {
			throw new IndexOutOfBoundsException("No elements to pop");
		}
		Node<T> lastTop = top;
		top = top.next;
		size--;
		return lastTop.data;
				
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	
	}
	
	// looks at whatever the top element is 
	public T peek() {
		if(size == 0) {
			return null;
		}
		return top.data;
		
	}
	
	public int size() {
		return this.size;
	}

	
	private class Node<T> {
		
		private Node<T> next;
		private T data;
		
		Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
		
		

		}
		
			
			
		
	
	
	public static void main(String[] args) {
		System.out.println("***** Deque *****\n");
		Deque<String> names = new LinkedList<>();
		names.push("Dan");
		names.push("Tim");
		names.push("Joe");
		System.out.println(names);
		names.pop();
		System.out.println(names.peek());
		System.out.println(names.size());
		
		System.out.println("***** MyStack *****");
		MyStack<String> myNames = new MyStack<>();
		myNames.push("Dan");
		myNames.push("Tim");
		myNames.push("Joe");
		System.out.println(myNames.pop());
		System.out.println(myNames.pop());
		System.out.println(myNames.pop());
		System.out.println(myNames.peek());
		System.out.println(myNames.isEmpty());
	}
}

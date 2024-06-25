package www.skillstorm.general;

// Stack is Deque so think of stack of dishes
// Last in, First out (LIFO)
// methods I need push, pop, peek, size, isEmpty
 
public class MyStack<T>{
	// T - Type
	// E - Elements
	// K - Keys
	// N - Numbers
	// V - Value
	
	// top element is generic typed looking at the top element
	private Node <T> top;
	private int size;
	
	public MyStack() {
		// top is null we don't know the top element first
		this.top = null;
		this.size = 0;
		// start size equals to 0
	}
	
	// give in a parameter like == myNums.push(2)
	// 2 is the argument you want to pass in
	public void push(T data) {
		// <T> is any type
		// new Node creates new Object
		// public Node(T data, Node<T> next) == constructor
		Node<T> newTop = new Node<>(data, top);
		top = newTop;
		size++;
		// add 1 + size each time we do push
	}
	// returning T which is the Generic
	// pop() returns and removes top element
	// if it is empty then throw out of bounds
	// myNums.pop() takes in no parameters
	public T pop() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("Stack is empty!");	
		}
		// need temporarily value to hold top value
		// lastTop is looking at the last top value
		Node<T> lastTop = top;
		// top is now looking at next value
		top = top.next;
		size--;
		// reduce size by 1 each time we do pop
		// lastTop.data is the data its holding
		return lastTop.data;
	}
	
	// return T like "Integer"
	// peek() is looking at top element
	// myNums.peek() takes in no parameters
	public T peek() {
		if(size == 0) {
			return null;
		}
		// sees top with its data
		return top.data;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	// method to get size
	public int size() {
		return this.size;
	}
	
	private class Node<T>{
		private T data; // each node knows what it's data is
		private Node<T> next; // Node knows where the next one is
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;		
		}
	}
	
/* 		inner class, only usable within MyLinkedList
 		because its only usable by MyLinkedList there isn't much of a reason to
 		use getters and setters here
	
	private class Node{
		private Node next; // each node knows where the next one in the chain is
		private T data; // each node knows what it's data is
		
		public Node(T t) {
			next = null;
			data = t;
		
}	*/

		
	
}



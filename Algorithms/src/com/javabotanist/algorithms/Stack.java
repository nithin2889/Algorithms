package com.javabotanist.algorithms;

import java.util.EmptyStackException;

/*
 Stack:
 Stack is a linear data structure used for storing data.
 It is an ordered list as it can be represented using either a linked list or an array. 
 Insertion and deletion are done at one end called a top.
 The last element inserted is the first element to be deleted. Hence it is called Last In First Out (LIFO) list.
 */

public class Stack {
	
	private ListNode top;
	private int length;
	
	private class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public Stack() {
		top = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	// method to push data onto the stack
	public void push(int value) {
		ListNode temp = new ListNode(value);
		
		temp.next = top;
		top = temp;
		length++;
	}
	
	// method to pop data from the stack
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	// method to return the top most element in the stack
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek()); // throws EmptyStackException
	}
	
}

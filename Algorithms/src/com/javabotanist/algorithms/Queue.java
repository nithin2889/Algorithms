package com.javabotanist.algorithms;

import java.util.NoSuchElementException;

/*
 	Queue:
 	1. It is a linear data structure used for storing data.
 	2. It is an ordered list.
 	3. Insertion happens at one end called the rear end, and the deletion happens at another end called the front end.
 	4. The first element inserted is the first element to be deleted. Hence, it is called as First In First Out (FIFO) list.
 	5. We keep two pointers, one is front and the other rear. The front pointer points to the first node and the rear pointer 
 	   points to the last node.
 	6. Whenever we want to insert a new node we insert at the rear end, and whenever we want to delete a node we do it at the front end.
 */

public class Queue {
	private ListNode front;
	private ListNode rear;
	private int length;

	private class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Queue() {
		this.front = null;
		this.rear = null;
		length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	// write a method to implement enqueue operation
	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if(isEmpty()) {
			front = temp;
		} else {
			rear.next = temp;
		}
		rear = temp;
		length++;
	}

	// write a method to implement dequeue operation
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		int result = front.data;
		front = front.next;
		if(front == null) {
			// we need to break the node, 
			// in order to free the node, rear pointer is made to point to null
			rear = null;
		}
		length--;
		return result;
	}
	
	// method to print the first element in the queue
	public int first() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return front.data;
	}
	
	// method to print the last element in the queue
	public int last() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return rear.data;
	}

	public void printQueue() {
		if(isEmpty()) {
			return;
		}
		ListNode current = front;
		while(current != null) {
			System.out.print(current.data+" --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(15);
		queue.printQueue();
		
		System.out.println("Front element is " + queue.first()); // prints the first element in the queue
		System.out.println("Rear element is " + queue.last()); // prints the last element in the queue
		
		int element1 = queue.dequeue();
		queue.printQueue();
		System.out.println("element removed is " + element1);
		
		int element2 = queue.dequeue();
		queue.printQueue();
		System.out.println("element removed is " + element2);
		
		int element3 = queue.dequeue();
		queue.printQueue();
		System.out.println("element removed is " + element3);
		
		/*int element4 = queue.dequeue(); // throws NoSuchElementException
		queue.printQueue();
		System.out.println("element removed is " + element4);*/
	}

}

package com.javabotanist.algorithms;

/*
 Circular Singly Linked List:
 1. It is similar to a Singly Linked List, the only difference in Circular Singly Linked List 
 is that the last node points to the first node and not to null.
 
 2. In Singly Linked List, we keep track of the head node, but in Circular Singly Linked List 
 we keep a track of the last node because it helps us in insertion and deletion of nodes in 
 constant time. That is, in Singly Linked List, if we ever had to insert a node at the end
 we had to traverse the list to reach the last node and add the new element, but in Circular
 Singly Linked List as we are keeping a track of the last node, if we have to add a node at 
 the end we can use the last pointer and add the node at the end and suppose if we want to add
 the node at the beginning then in a Circular Singly Linked List, when we do last.next we reach
 to the first node. We can directly add the node at the beginning in a constant time.
 */

public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	private static class ListNode {
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularSinglyLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0; // last == null
	}
	
	public void createCircularSinglyLinkedList() {
		ListNode first = new ListNode(3);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(16);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		// the last point created should always point to the last element in the list.
		last = fourth;
	}
	
	// traversing and printing each element in a Circular Singly Linked List
	public void printElements() {
		if(last == null) {
			return;
		}
		ListNode first = last.next;
		while(first != last) {
			System.out.print(first.data+" --> ");
			first = first.next;
		}
		System.out.println(first.data+" ");
	}

	// inserting a node at the beginning of the circular singly linked list
	public void insertFirst(int value) {
		ListNode temp = new ListNode(value);
		if(last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}
	
	// inserting a node at the end of the circular singly linked list
	public void insertLast(int value) {
		ListNode temp = new ListNode(value);
		if(last == null) {
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
		length++;
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
		// creating a circular singly linked list and printing
		csll.createCircularSinglyLinkedList();
		csll.printElements();
		
		// inserting a node at the beginning and printing
		csll.insertFirst(1);
		csll.printElements();
		
		// inserting a node at the beginning and printing
		csll.insertLast(18);
		csll.printElements();
	}

}

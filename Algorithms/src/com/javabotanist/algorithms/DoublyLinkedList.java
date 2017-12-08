package com.javabotanist.algorithms;

/*
	Doubly Linked List: 
	1. It is called a two way linked list.
	
	2. Given a node, we can navigate list in both forward and backward directions, 
		 unlike in a single linked list.
	
	3. A node in a Single Linked List can only be deleted if we have a pointer to its previous node, 
	 	 but in a Doubly Linked List we can delete a node even with out a pointer to its previous node.
*/

public class DoublyLinkedList {
	private static ListNode head;
	private static ListNode tail;
	private static int length;
	
	public static class ListNode {
		private int data;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public static boolean isEmpty() {
		return length == 0; // head == null;
	}
	
	public static int length() {
		return length;
	}
	
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		newNode.prev = tail;
		tail = newNode;
		length++;
	}
	
	// print Doubly Linked List elements in forward direction
	public void printElementsForward() {
		if(head == null) {
			return;
		}
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	// print Doubly Linked List elements in backward direction
	public void printElementsBackward() {
		if(tail == null) {
			return;
		}
		ListNode temp = tail;
		while(temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.prev;
		}
		System.out.println("null");
	}
	
	// insert at the beginning of the doubly linked list
	public static void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.prev = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	// insert at the end of the doubly linked list
	public static void insertEnd(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		length++;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertEnd(1);
		dll.insertEnd(10);
		dll.insertEnd(15);
		
		/*dll.insertFirst(1);
		dll.insertFirst(10);*/
		
		dll.printElementsForward();
		dll.printElementsBackward();
	}

}

package com.javabotanist.algorithms;

public class SingleLinkedList {
	private ListNode head; // head node holds the list

	private static class ListNode {
		private ListNode next;
		private int data;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		// Let's create a single linked list
		// 10 --> 8 --> 1 --> 11 --> null
		// 10 is head

		ListNode head = new ListNode(1);
		ListNode second = new ListNode(8);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(16);
		ListNode fifth = new ListNode(19);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		printList(head);

		/*ListNode res1 = insertAtTheBeginning(head, 20);
		printList(res1);

		ListNode res2 = insertAtTheEnd(head, 13);
		printList(res2);
		
		insertAfter(third, 22);
		printList(head);

		ListNode res3 = insertAtPosition(head, 28, 4);
		printList(res3);
		
		ListNode res4 = deleteFromBeginning(head);
		printList(res4);
		
		ListNode res5 = deleteAtTheEnd(head);
		printList(res5);
		
		ListNode res6 = deleteAtPosition(head, -1);
		printList(res6);
		
		boolean keyFound = searchAnElement(head, 33);
		if(keyFound == true)
			System.out.println("Key found");
		else
			System.out.println("Key not found");
		
		ListNode res7 = reverse(head);
		printList(res7);
		
		ListNode res8 = getMiddleNode(head);
		printList(res8); 
		
		ListNode res9 = findNthNodeFromEnd(head, 2);
		printList(res9);

		ListNode res10 = removeDuplicates(head);
		printList(res10);
		
		ListNode res11 = insertIntoSortedList(head, -1);
		printList(res11);
		
		removeKeyElementFromList(head, 8);
		printList(head); */
		
		ListNode isLoop = createALoopInLinkedList(head);
		boolean res12 = containsLoop(isLoop);
		System.out.println("It is " + res12 + " that the linked list contains a loop");
	}

	public static void printList(ListNode head) {
		if (head == null) { // if passed list is null terminate the program
			return;
		}
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print(current); // here current will be null
		
		// should pass head and not current as current is pointing to null
		System.out.println("\nLength of the list is " + length(head));
	}

	// prints the length given the head node
	public static int length(ListNode head) {
		if (head == null) {
			return 0;
		}
		ListNode current = head;
		int count = 0;

		while (current != null) {
			count += 1;
			current = current.next;
		}
		return count;
	}

	// given the head node, insert at the beginning of a linked list
	public static ListNode insertAtTheBeginning(ListNode head, int data) {
		ListNode newNode = new ListNode(data);

		if (head == null) {
			return newNode;
		}

		newNode.next = head;
		head = newNode;

		return head; // this head will be the new head having new node at the beginning
	}

	// given the head node, insert at the end of a linked list
	public static ListNode insertAtTheEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data);

		if (head == null) {
			return newNode;
		}

		// assigning the head node to a temporary curr node to traverse the list
		ListNode curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
		return head;
	}

	// insert a new node after a given node
	public static void insertAfter(ListNode previous, int data) {
		ListNode newNode = new ListNode(data);

		if (previous == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		newNode.next = previous.next;
		previous.next = newNode;
	}
	
	// given a location, insert a new node
	public static ListNode insertAtPosition(ListNode head, int data, int pos) {
		int size = length(head);
		
		if(pos > size || pos < 1) {
			System.out.println("Invalid position");
		}
		ListNode newNode = new ListNode(data);
		
		if(pos == 1) {
			newNode.next = head;
			return newNode;
		} else {
			int count = 0;
			ListNode current = head;
			while(count < pos - 1) {
				current = current.next;
				count++;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		return head;
	}
	
	// given a head node, delete the beginning node
	public static ListNode deleteFromBeginning(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		
		return head;
	}
	
	// given the head node, delete the node at the end of the list
	public static ListNode deleteAtTheEnd(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode last = head;
		ListNode prevToLast = null;
		
		while(last.next != null) {
			prevToLast = last;
			last = last.next;
		}
		prevToLast.next = null;
		return head;
	}
	
	// given a position, delete the node from the linked list
	public static ListNode deleteAtPosition(ListNode head, int pos) {
		if(head == null) {
			return head;
		}
		
		int size = length(head);
		if(pos > size || pos < 1) {
			System.out.println("Invalid position. No nodes were deleted");
			return head;
		}
		
		if(pos == 1) {
			ListNode temp = head;
			head = head.next;
			temp.next = null;
		}
		
		int count = 1;
		ListNode prev = head;
		while(count < pos - 1) {
			prev = prev.next;
			count++;
		}
		ListNode curr = prev.next;
		prev.next = curr.next;
		curr.next = null;
		
		return head;
	}
	
	// search for an element in a Linked List
	public static boolean searchAnElement(ListNode head, int searchKey) {
		if(head == null) {
			return false;
		}
		
		ListNode curr = head;
		while(curr != null) {
			if(curr.data == searchKey) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	// reverse a single linked list
	public static ListNode reverse(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	// finding middle of the linked list
	public static ListNode getMiddleNode(ListNode head) {
		if(head == null) {
			return null;
		}
		// traverse the slow pointer by one position
		ListNode slowPtr = head;
		// traverse the fast pointer by two positions
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	// given the position, find the nth node from end of the list
	public static ListNode findNthNodeFromEnd(ListNode head, int pos) {
		if(head == null) {
			return head;
		}
		
		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;
		while(count < pos) {
			refPtr = refPtr.next;
			count++;
		}
		
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}
	
	// remove duplicates from a sorted linked list
	public static ListNode removeDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode curr = head;
		while(curr != null && curr.next != null) {
			if(curr.data == curr.next.data) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}
	
	// insert a new node in a sorted single linked list
	public static ListNode insertIntoSortedList(ListNode head, int data) {
		if(head == null) {
			return head;
		}
		
		ListNode newNode = new ListNode(data);
		ListNode curr = head;
		ListNode temp = null;
		
		while(curr != null && curr.data < newNode.data) {
			temp = curr;
			curr = curr.next;
		}
		
		// this condition will be true if at we insert a node with value 0
		if(temp == null) {
			return head;
		}	
		newNode.next = curr;
		temp.next = newNode;
		
		return head;
	}
	
	// remove a key given from a linked list
	public static void removeKeyElementFromList(ListNode head, int key) {
		ListNode curr = head;
		ListNode temp = null;
		
		// edge case: if the key matches with the head node
		if(curr != null && curr.data == key) {
			head = curr.next;
			curr.next = null;
			return;
		}
		
		while(curr != null && curr.data != key) {
			temp = curr;
			curr = curr.next;
		}
		// when the key is not found then we terminate
		if(curr == null) { return; }
		// else we remove the node
		temp.next = curr.next;
	}

	// Check if a linked list contains a loop
	public static boolean containsLoop(ListNode head) {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	public static ListNode createALoopInLinkedList(ListNode head) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
		
		return head;
	}
	
}

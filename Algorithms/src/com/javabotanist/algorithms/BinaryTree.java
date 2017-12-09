package com.javabotanist.algorithms;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/*
 	Tree:
 	1. Tree is a non-linear data structure used for storing data.
 	2. Tree is made up of nodes and edges without any cyclic formation.
 	3. In a tree, each node can point to n-number of nodes.
 	4. Tree is a way of representing a hierarchical structure with a parent node called as a "root"
 	   with many levels of additional nodes.
 	5. A node in a tree having no immediate nodes are called as leaf nodes. That is, a leaf node will have no children.
 	
 	Binary Tree:
 	1. A tree is said to be a Binary Tree, if a node has no children or at most two children.
 	2. A Binary Tree can be represented by a TreeNode.
 	3. A TreeNode consists of data with a pointer to the right and left nodes. The pointers are of type TreeNode.
 	
 	In-order Binary Tree Traversal:
 	1. Traverse to the left node.
 	2. Print the current node.
 	3. Traverse to the right node.
 	
 	Pre-order Binary Tree Traversal:
 	1. Print the current node.
 	2. Traverse to the left node.
 	3. Traverse to the right node.
 	
 	Post-order Binary Tree Traversal:
 	1. Traverse to the left node.
 	2. Traverse to the right node.
 	3. Print the current node.
 */

public class BinaryTree {
	private TreeNode root;

	private class TreeNode {
		private int data; // Generic type
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public BinaryTree() {
		this.root = null;
	}

	// recursive pre-order traversal
	// In recursive method, internally stack data structure will be used.
	public void recursivePreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}

	// recursive post-order traversal
	public void recursivePostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.data + " ");
	}

	// recursive in-order traversal
	public void recursiveInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		recursiveInOrder(root.left);
		System.out.print(root.data + " ");
		recursiveInOrder(root.right);
	}

	/* iterative pre-order traversal
	   Here, we should provide a manual stack implementation so that while
	   backtracking we can fetch the elements easily. */
	public void iterativePreOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		// using stack for internal implementation
		Stack<TreeNode> stack = new Stack<>();
		// initially we will push the root element of the TreeNode.
		stack.push(root);
		
		// check if stack has elements
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			
			// print the data of the popped element
			System.out.print(temp.data + " ");
			
			// check if temp node's right element is present
			if(temp.right != null) {
				stack.push(temp.right);
			}
			
			// check if temp node's left element is present
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	// iterative post-order traversal
	public void iterativePostOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		// using stack for internal implementation
		Stack<TreeNode> stack = new Stack<>();
		// initially we will push the root element of the TreeNode.
		TreeNode temp = root;
		
		// check if stack has elements
		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = temp.right;
				// System.out.println(temp.data + " ");
				// temp = stack.pop();
			}
		}
	}

	// iterative in-order traversal
	public void iterativeInOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		// using stack for internal implementation
		Stack<TreeNode> stack = new Stack<>();
		// make temp point to the root node
		TreeNode temp = root;
		// check if stack is empty and whether temp is null
		while(!stack.isEmpty() || temp != null) {
			// check if temp is null
			if(temp != null) {
				// if not then push the element to be visited again
				stack.push(temp);
				// traverse to the next left node
				temp = temp.left;
			} else {
				// if temp is null then pop the top most element in the stack
				temp = stack.pop();
				// print the data
				System.out.print(temp.data + " ");
				// traverse the temp to the next right node
				temp = temp.right;
			}
		}
	}
	
	// Level order traversal in Binary Tree
	public void levelOrderTraversal(TreeNode root) {
		// check if root is null
		if(root == null) {
			return;
		}
		// Create a queue to store the tree nodes.
		Queue<TreeNode> queue = new LinkedList<>();
		// Insert the root element into the queue
		queue.offer(root);
		// Check queue for emptyness
		while(!queue.isEmpty()) {
			// remove and retrieve the top most element from the queue.
			TreeNode temp = queue.poll();
			// print the data
			System.out.print(temp.data + " ");
			// also store the left and right node of the root element
			if(temp.left != null) {
				// add to the queue
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				// add to the queue
				queue.offer(temp.right);
			}
		}
	}
	
	// Create a new binary tree
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);

		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
	}

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		bTree.createBinaryTree();

		System.out.println("------------------------------------");
		// recursive methods
		// printing elements in pre-order traversal
		System.out.println("recursive pre-order traversal");
		bTree.recursivePreOrder(bTree.root);
		System.out.println();
		
		// printing elements in post-order traversal
		System.out.println("recursive post-order traversal");
		bTree.recursivePostOrder(bTree.root);
		System.out.println();

		// printing elements in in-order traversal
		System.out.println("recursive in-order traversal");
		bTree.recursiveInOrder(bTree.root);
		System.out.println("\n------------------------------------");
		// iterative methods
		// printing elements in pre-order traversal
		System.out.println("iterative pre-order traversal");
		bTree.iterativePreOrder(bTree.root);
		System.out.println();
		
		// iterative methods
		// printing elements in post-order traversal
		/* System.out.println("iterative post-order traversal");
		bTree.iterativePostOrder(bTree.root);
		System.out.println(); */
		
		// iterative methods
		// printing elements in in-order traversal
		System.out.println("iterative in-order traversal");
		bTree.iterativeInOrder(bTree.root);
		System.out.println();
		System.out.println("------------------------------------");
		
		System.out.println("Level Order Traversal");
		bTree.levelOrderTraversal(bTree.root);
	}

}

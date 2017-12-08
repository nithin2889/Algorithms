package com.javabotanist.algorithms;

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
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		
		root = first;
		first.left = second;
		first.right = third;
		
		second.left = fourth;
	}
	
	// recursive pre-order traversal
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	// recursive post-order traversal
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	// recursive in-order traversal
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		bTree.createBinaryTree();
		
		// printing element in pre-order traversal
		System.out.println("pre-order traversal");
		bTree.preOrder(bTree.root);
		System.out.println();
		
		// printing element in post-order traversal
		System.out.println("post-order traversal");
		bTree.postOrder(bTree.root);
		System.out.println();
		
		// printing element in in-order traversal
		System.out.println("in-order traversal");
		bTree.inOrder(bTree.root);
	}

}

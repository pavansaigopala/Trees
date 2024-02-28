package com.BFS.SamplePracticeDay4;

public class CheckForBalancedBinaryTree {
	// Any tree is set to be balanced binary tree only when
	// height of left side nodes - height of right side nodes <= 1
	// HL - HR <= 1
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);
		root.left.left = new Node(5);
		root.left.right = new Node(4);
		root.left.left.left = new Node(7);

		int result = balancedTreeOrNotUsingRecursion(root);
		if (result == -1)
			System.out.println("Tree is not balanced");
		else
			System.out.println("Tree is balanced");

		Node root2 = new Node(1);
		root2.left = new Node(3);
		root2.right = new Node(2);
		root2.left.left = new Node(5);
		root2.left.right = new Node(4);
		root2.left.left.left = new Node(7);
		root2.left.left.right = new Node(6);

		int result2 = balancedTreeOrNotUsingRecursion(root2);
		if (result2 == -1)
			System.out.println("Tree is not balanced");
		else
			System.out.println("Tree is balanced");

		Node root3 = new Node(1);
		root3.left = new Node(2);
		root3.right = new Node(3);
		root3.right.left = new Node(4);
		root3.right.right = new Node(5);
		int result3 = balancedTreeOrNotUsingRecursion(root3);
		if (result3 == -1)
			System.out.println("Tree is not balanced");
		else
			System.out.println("Tree is balanced");
	}

	public static int balancedTreeOrNotUsingRecursion(Node node) {
		if (node == null)
			return 0;
		int left = 1 + balancedTreeOrNotUsingRecursion(node.left);
		if (left == -1)
			return -1;
		int right = 1 + balancedTreeOrNotUsingRecursion(node.right);
		if (right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right);
	}

}

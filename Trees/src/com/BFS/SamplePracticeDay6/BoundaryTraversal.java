package com.BFS.SamplePracticeDay6;

import java.util.*;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class BoundaryTraversal {

	static ArrayList<Integer> boundaryTraversal = new ArrayList<Integer>();

	public static void main(String args[]) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.left.right = new Node(4);
		root.left.left.right.left = new Node(5);
		root.left.left.right.right = new Node(6);
		root.right = new Node(7);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		root.right.right.left.left = new Node(10);
		root.right.right.left.right = new Node(11);

		boundaryTraversal = printBoundary(root);

		System.out.println("The Boundary Traversal is : ");
		for (int i = 0; i < boundaryTraversal.size(); i++) {
			System.out.print(boundaryTraversal.get(i) + " ");
		}

	}
	
	public static ArrayList<Integer> printBoundary(Node node){
		boundaryTraversal.add(node.data);
		leftBourdary(node.left);
		onlyLeaf(node);
		Stack<Integer> sta = new Stack<>();
		rightBourdary(node.right, sta);
		Iterator<Integer> value = sta.iterator(); 
        while (value.hasNext()) { 
        	boundaryTraversal.add(value.next()); 
        }
        return boundaryTraversal;
	}

	public static void leftBourdary(Node node) {

		if (isLeaf(node))
			return;

		boundaryTraversal.add(node.data);
		if (node.left != null)
			leftBourdary(node.left);
		else if (node.right != null)
			leftBourdary(node.right);
	}
	
	public static void onlyLeaf(Node node) {
		if(isLeaf(node)) {
			boundaryTraversal.add(node.data);
			return;
		}
		
		if(node.left!=null)onlyLeaf(node.left);
		if(node.right!=null)onlyLeaf(node.right);
			
	}

	public static boolean isLeaf(Node node) {
		if (node!=null && node.left == null && node.right == null)
			return true;
		else
			return false;
	}

	public static void rightBourdary(Node node, Stack<Integer> stq) {

		if (isLeaf(node))
			return ;

		stq.push(node.data);
		if (node.right != null)
			rightBourdary(node.right, stq);
		else if (node.left != null)
			rightBourdary(node.left, stq);
	}
}

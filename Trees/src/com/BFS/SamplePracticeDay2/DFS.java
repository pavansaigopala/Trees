package com.BFS.SamplePracticeDay2;

import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(6);
		postOrder(root);
		/*
		 * Stack<Node> ans = postOrderIterator(root); while(!ans.empty()) {
		 * System.out.print(ans.pop().data+", "); }
		 */
		
	}
	
	public static void postOrder(Node node) {

		if (node == null)
			return;
		
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ", ");

	}
	
	public static void preOrder(Node node) {

		if (node == null)
			return;
		
		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);

	}
	
	
	public static void inOrder(Node node) {

		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);

	}
	
	public static Stack<Node> postOrderIterator(Node root) {

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		Node node = root;
		while(!s1.empty()) {
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.left!=null) s1.push(temp.left);
			if(temp.right!=null) s1.push(temp.right);
			
		}
		
		return s2;
	}

	
	public static void preOrderIterator(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true) {

			if (node != null) {
				stack.push(node);
				System.out.println(node.data);
				node = node.left;
			} else {
				if(stack.empty())break;
				
				Node temp = stack.pop();
				node =  temp.right;
			}
		}
	}

	public static void inOrderIterator(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(true) {

			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if(stack.empty())break;
				
				Node temp = stack.pop();
				System.out.println(temp.data);
				node =  temp.right;
			}
		}
	}
	
}

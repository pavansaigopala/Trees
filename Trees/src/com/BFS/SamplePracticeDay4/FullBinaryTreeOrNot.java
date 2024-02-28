package com.BFS.SamplePracticeDay4;

import java.util.ArrayDeque;
import java.util.Queue;

public class FullBinaryTreeOrNot {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);
		root.left.left = new Node(5);
		root.left.right = new Node(4);
		root.left.left.left = new Node(7);
		boolean result = fullBinaryTreeorNot(root);
		System.out.println(result);

		Node root2 = new Node(1);
		root2.left = new Node(3);
		root2.right = new Node(2);
		root2.left.left = new Node(5);
		root2.left.right = new Node(4);
		root2.left.left.left = new Node(7);
		root2.left.left.right = new Node(6);
		boolean result2 = fullBinaryTreeorNot(root2);
		System.out.println(result2);

	}
	
	public static boolean fullBinaryTreeorNot(Node node) {

		Queue<Node> qu = new ArrayDeque<>();
		qu.add(node);
		boolean balanced = true;
		while (!qu.isEmpty()) {
			int n = qu.size();
			for (int i = 0; i < n; i++) {
				Node nod = qu.peek();
				if (nod.left != null && nod.right != null) {
					if (nod.left != null)qu.add(nod.left);
					if (nod.right != null)qu.add(nod.right);
					qu.poll();
				} else if (nod.left != null || nod.right != null) {
					balanced = false;
					break;
				}else {
					qu.poll();
				}

			}
			if (balanced == false)
				break;
		}
		return balanced;

	}

}

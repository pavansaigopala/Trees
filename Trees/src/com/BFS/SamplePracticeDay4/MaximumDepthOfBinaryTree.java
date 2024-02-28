package com.BFS.SamplePracticeDay4;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left=new Node(4);
		root.right.left.left=new Node(5);
		root.right.right= new Node(6);
		
		int max = maxDeptUsingLevelOrder(root);
		System.out.println(max);
	}
	
	public static int maxDept(Node node) {
		if(node==null) return 0;
		
		int left = 1 + maxDept(node.left);
		int right = 1 + maxDept(node.right);
		
		return Math.max(left, right);
	}
	
	public static int maxDeptUsingLevelOrder(Node node) {
		Queue<Node> qu = new ArrayDeque<>();
		qu.add(node);
		int count=0;
		while(!qu.isEmpty()) {
			count++;
			int n = qu.size();
			for(int i=0; i<n; i++) {
				if(qu.peek().left!=null)qu.add(qu.peek().left);
				if(qu.peek().right!=null)qu.add(qu.peek().right);
				qu.poll();
			}
		}
		return count;
	}

}


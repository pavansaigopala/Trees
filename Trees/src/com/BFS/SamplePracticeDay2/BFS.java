package com.BFS.SamplePracticeDay2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// One sample Binary Tree
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		//List<List<Integer>> ans = bfsLinkedList(root);
		//System.out.println(ans);
	}
	// level wise printing or accessing data of the binary tree
	public static void bfs(Node root) {
			Queue<Node> q = new ArrayDeque<>();
			q.add(root);
			
			while(!q.isEmpty()) {
				Node rt = q.peek();
				if(rt!=null) {
					if(rt.left !=null) q.add(rt.left);
					if(rt.right !=null)q.add(rt.right);
					System.out.print(rt.data+", ");
					q.poll();
				}
			}
	}	
	
	public static List<List<Integer>> bfsLinkedList(Node root) {
		Queue<Node> q = new LinkedList<>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int n = q.size();
			List<Integer> lst = new LinkedList<Integer>();
			for(int i=0; i<n; i++) {
					if(q.peek().left !=null) q.add(q.peek().left);
					if(q.peek().right !=null)q.add(q.peek().right);
					lst.add(q.poll().data);
			}
			ans.add(lst);
		}
		return ans;
	}

}

class Node{
	
	int data;
	
	Node left;
	
	Node right;
	
	Node(int x){
		this.data = x;
	}
	
}

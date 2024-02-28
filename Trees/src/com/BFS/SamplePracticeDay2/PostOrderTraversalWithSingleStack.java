package com.BFS.SamplePracticeDay2;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalWithSingleStack {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(3);
		root.left.left.right = new Node(4);
		//root.left.left.right.right = new Node(5);
		//root.left.left.right.right.right = new Node(6);
		//root.right.left=new Node(8);
		ArrayList<Integer> ans = postOrder(root);
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> postOrder(Node root) {
		
		Node cur = root;
		Stack<Node> st = new Stack<>();
		ArrayList<Integer> ll = new ArrayList<>();
		st.push(cur);
		cur=cur.left;
		Node temp;
		while(cur!=null || !st.empty()) {
			
			if(cur!=null) {
				st.push(cur);
				cur=cur.left;
			}else{
				
				temp = st.peek().right;
				System.out.println("top:"+st.peek().data);
				if(temp == null) {
					temp = st.peek();
					System.out.println("temp:"+temp.data);
					st.pop();
					ll.add(temp.data);
					while(!st.empty() && temp == st.peek().right) {
						temp = st.pop();
						ll.add(temp.data);
					}
				}else {
					cur=temp;
				}
			}
			//System.out.println(ll);
		}
		return ll;
	}
}

package com.BFS.SamplePracticeDay3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPreInPostTraversalAtOnce {

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left=new Node(6);
		root.right.right= new Node(7);
		
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 1));
		
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		
		while(!stack.empty()) {
			Pair pair  = stack.pop();
			
			if(pair.num==1) {
				pair.num=2;
				stack.push(pair);
				pre.add(pair.node.data);
				if(pair.node.left!=null) {
					stack.add(new Pair(pair.node.left, 1));
				}
			}else if(pair.num==2) {
				pair.num=3;
				stack.push(pair);
				in.add(pair.node.data);
				
				if(pair.node.right!=null) {
					stack.add(new Pair(pair.node.right, 1));
				}
			}else {
				post.add(pair.node.data);
			}
		}
		System.out.println("PreOrder: "+ pre);
		System.out.println("In Order: "+ in);
		System.out.println("Post Order: "+ post);
	}
}
class Node{
	int data;
	
	Node left;
	
	Node right;
	
	Node(int dat){
		this.data= dat;
	}
	
	Node(int data, Node left, Node right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
}

class Pair{
	int num;
	
	Node node;
	
	Pair(Node node, int num){
		this.node=node; 
		this.num=num;
	}
}

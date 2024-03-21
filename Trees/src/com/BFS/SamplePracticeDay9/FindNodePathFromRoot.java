package com.BFS.SamplePracticeDay9;

import java.util.ArrayList;

public class FindNodePathFromRoot {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left =  new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		root.right.left= new Node(90);
		root.right.right=new Node(100);
		root.right.left.right = new Node(120);
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean result = fAdvance(al, 120, root);
		System.out.print("Is target node available in given tree: "+result);
		if(result)System.out.println(al);
	}
	
	// Pre-Order Traversal
	// Data-Structure : ArrayList
	// TC: O(N)
	// SC: ArrayList -- O(H), Stack Space: O(H);
	
	public static boolean f(ArrayList<Integer> al, int targetNode, Node node) {
		if(node==null) return false;
		
		al.add(node.data);
		
		if(node.data == targetNode)return true;
		
		boolean lC = f(al, targetNode, node.left);
		boolean rC = false;
		if(!lC) {
			rC = f(al, targetNode, node.right);
		}
		if(!lC && !rC)	al.remove(al.size()-1);
		
		return (lC || rC);
	}
	
	
	public static boolean fAdvance(ArrayList<Integer> al, int targetNode, Node node) {
		if(node==null) return false;
		
		al.add(node.data);
		
		if(node.data == targetNode)return true;
		
		if(f(al, targetNode, node.left) || f(al, targetNode, node.right)) {
			return true;
		}
		
		al.remove(al.size()-1);
		
		return false;
	}

}

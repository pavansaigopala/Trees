package com.BFS.SamplePracticeDay8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RightViewBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left =  new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		root.right.left= new Node(6);
		root.right.right=new Node(7);
		
		ArrayList<Integer> al = new ArrayList<>();
		rightViewPost(root, 0, al);
		System.out.println(al);

	}
	 public static void rightViewPost(Node node, int level ,ArrayList<Integer> al){
	        if(node==null)return;

	        if(al.size()==level)al.add(node.data);

	        rightViewPost(node.right, level+1, al);
	        rightViewPost(node.left, level+1, al);
	    }
	
	   static ArrayList<Integer> rightView(Node node)
	    {
	        Queue<Paer> queue = new ArrayDeque<>();
	        Map<Integer, Integer> map= new TreeMap<>();
	        queue.add(new Paer(0,node));
	        while(!queue.isEmpty()){
	            int n =queue.size();
	            for(int i=0; i<n; i++){
	            	Paer paer = queue.poll();
	                if(paer.node!=null){
	                    map.put(paer.row, paer.node.data);
	                    if(paer.node.left!=null)queue.add(new Paer(paer.row+1, paer.node.left));
	                    if(paer.node.right!=null)queue.add(new Paer(paer.row+1, paer.node.right));
	                }
	            }
	        }
	        ArrayList<Integer> al = new ArrayList<>();
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            al.add(entry.getValue());
	        }
	        return al;
	    }
	}

 
package com.BFS.SamplePracticeDay8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LeftViewBinaryTree {

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
		leftViewPost(root, 0, al);
		System.out.println(al);

	}
	 public static void leftViewPost(Node node, int level ,ArrayList<Integer> al){
	        if(node==null)return;

	        if(al.size()==level)al.add(node.data);

	        leftViewPost(node.left, level+1, al);
	        leftViewPost(node.right, level+1, al);
	    }
	static ArrayList<Integer> leftView(Node node)
    {
        Queue<Paer> queue = new ArrayDeque<>();
        Map<Integer, Node> map= new TreeMap<>();
        queue.add(new Paer(0,node));
        while(!queue.isEmpty()){
            int n =queue.size();
            for(int i=0; i<n; i++){
            	Paer paer = queue.poll();
            	if(map.get(paer.row)==null){
            		map.put(paer.row, paer.node);
            	}
                if(paer.node.left!=null)queue.add(new Paer(paer.row+1, paer.node.left));
                if(paer.node.right!=null)queue.add(new Paer(paer.row+1, paer.node.right));
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            al.add(entry.getValue().data);
        }
        return al;
    }


}

class Paer{
    Node node;
    int row;
    Paer(int row, Node node){
        this.node=node;
        this.row=row;
    }
    Paer(){}
}

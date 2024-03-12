package com.BFS.SamplePracticeDay8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
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
		
		ArrayList<Integer> al = bottomUpView(root);
		System.out.println(al);
	}
	
	
	
	static ArrayList<Integer> bottomUpView(Node node)
    {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, Node> map= new TreeMap<>();
        queue.add(new Pair(0,node));
        while(!queue.isEmpty()){
            int n =queue.size();
            for(int i=0; i<n; i++){
                Pair pair = queue.poll();
                map.put(pair.col, pair.node);
                if(pair.node.left!=null)queue.add(new Pair(pair.col-1, pair.node.left));
                if(pair.node.right!=null)queue.add(new Pair(pair.col+1, pair.node.right));
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            al.add(entry.getValue().data);
        }
        return al;
    }
}


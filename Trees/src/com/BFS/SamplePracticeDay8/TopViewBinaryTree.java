package com.BFS.SamplePracticeDay8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left =  new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);
		root.right.left= new Node(90);
		root.right.right=new Node(100);
		ArrayList<Integer> al = topView(root);
		System.out.println(al);
	}
	
	static ArrayList<Integer> topView(Node node)
    {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, Node> map= new TreeMap<>();
        queue.add(new Pair(0,node));
        while(!queue.isEmpty()){
            int n =queue.size();
            for(int i=0; i<n; i++){
                Pair pair = queue.poll();
                if(map.get(pair.col)==null){
                    map.put(pair.col, pair.node);
                }
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

class Pair{
    Node node;
    int col;
    Pair(int col, Node node){
        this.node=node;
        this.col=col;
    }
    Pair(){}
}


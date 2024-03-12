package com.BFS.SamplePracticeDay7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
		List<List<Integer>>  ll = verticalOrderTraversal.levelOrderMapWithRowColumn(root);
		System.out.println(ll);
	}
	public List<List<Integer>> levelOrderMapWithRowColumn(TreeNode node) {
		Queue<Tuples> queue = new ArrayDeque<>();
		Tuples tuples = new Tuples(node,0,0);
		queue.offer(tuples);
		TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> levelOrderList = new TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>>();
		while(!queue.isEmpty()) {
			
			Tuples tup = queue.remove();
			int row = tup.row;
			int col = tup.col;
			int dat = tup.node.data;
			if(tup.node.left!=null)	queue.offer(new Tuples(tup.node.left, tup.row+1, tup.col-1));
			if(tup.node.right!=null) queue.offer(new Tuples(tup.node.right,tup.row+1,  tup.col+1));
			if(!levelOrderList.containsKey(col)){
				levelOrderList.put(col, new TreeMap<>());
			}
			if(!levelOrderList.get(col).containsKey(row)) {
				levelOrderList.get(col).put(row, new PriorityQueue<>());
			}
			levelOrderList.get(col).get(row).add(dat);
			
		}
		List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: levelOrderList.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
	}

}


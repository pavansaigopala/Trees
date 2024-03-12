package com.BFS.SamplePracticeDay7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class LevelOrderTraversal {
	
	public LevelOrderTraversal(){}
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
		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
		levelOrderTraversal.levelOrderMapWithRowColumn(root);
	}
	
	public void levelOrderMapWithRowColumn(TreeNode node) {
		Queue<Tuples> queue = new ArrayDeque<>();
		Tuples tuples = new Tuples(node,0,0);
		queue.offer(tuples);
		TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> levelOrderList = new TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>>();
		while(!queue.isEmpty()) {
			
			Tuples tup = queue.remove();
			int row = tup.row;
			int col = tup.col;
			int dat = tup.node.data;
			if(tup.node.left!=null)	queue.offer(new Tuples(tup.node.left,tup.col-1 , tup.row+1));
			if(tup.node.right!=null) queue.offer(new Tuples(tup.node.right, tup.col+1, tup.row+1));
			if(!levelOrderList.containsKey(row)){
				levelOrderList.put(row, new TreeMap<>());
			}
			if(!levelOrderList.get(row).containsKey(col)) {
				levelOrderList.get(row).put(col, new PriorityQueue<>());
			}
			levelOrderList.get(row).get(col).add(dat);
			
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
        System.out.println(list);
	}
	
	public void levelOrderMap(TreeNode node) {
		Queue<Tuple> queue = new ArrayDeque<>();
		Tuple tuple = new Tuple(node,0);
		queue.offer(tuple);
		List<Map<Integer, Integer>> levelOrderList = new ArrayList<Map<Integer, Integer>>();
		while(!queue.isEmpty()) {
			int n = queue.size();
			Map<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				Tuple tup = queue.remove();
				if(tup.node.left!=null)	queue.offer(new Tuple(tup.node.left, tup.row+1));
				if(tup.node.right!=null) queue.offer(new Tuple(tup.node.right, tup.row+1));
				map.put(tup.node.data, tup.row);
			}
			levelOrderList.add(map);
		}
		System.out.println(levelOrderList);
	}

	
	public void levelOrderPrint(TreeNode node) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(node);
		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		while(!queue.isEmpty()) {
			int n = queue.size();
			ArrayList<Integer> ll = new ArrayList<>();
			for(int i=0; i<n; i++) {
				TreeNode nod = queue.remove();
				if(nod.left!=null) queue.offer(nod.left);
				if(nod.right!=null) queue.offer(nod.right);
				ll.add(nod.data);
			}
			levelOrderList.add(ll);
		}
		System.out.println(levelOrderList);
	}

}

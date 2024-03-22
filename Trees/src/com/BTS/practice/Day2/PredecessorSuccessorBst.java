package com.BTS.practice.Day2;

import java.util.ArrayList;
import java.util.List;

public class PredecessorSuccessorBst {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6521171);
		root.left = new TreeNode(5650934);
		root.right = new TreeNode(9278816);
		root.left.left = new TreeNode(899375);
		root.right.left = new TreeNode(8989449);
		predecessorSuccessor(root, 9615950);
	}

	public static void predecessorSuccessor(TreeNode root, int key) {
		List<Integer> al = preSucIte(root, key, -1, -1);
		System.out.println("hello: " + al);
	}

	public static List<Integer> preSucIte(TreeNode root, int key, int pre, int suc) {
		TreeNode node = root;
		List<Integer> al = new ArrayList<>();

		while (node != null) {
			if ((node.right == null && node.left == null) || node.val == key) {
				if (node.right == null && node.left == null) {
					al.add(pre);
					al.add(suc);
					break;
				} else {
					if (node.left != null) {
						al.add(node.left.val);
					}
					if (node.right != null) {
						al.add(node.right.val);
					}
				}
				break;
			} else if (node.val > key) {
				System.out.println("left call : node: "+ node.val+ " , key: "+key);
				suc = node.val;
				node = node.left;

			} else if (node.val < key) {
				System.out.println("rigt call node: "+ node.val+ " , key: "+key);
				pre = node.val;
				node = node.right;
			}
		}
		if(al.size()==0) {
			al.add(pre);
			al.add(suc);
		}
		return al;
	}

}

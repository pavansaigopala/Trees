package com.BTS.practice.Day2;
class BstTest{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6521171);
		root.left = new TreeNode(5650934);
		root.right = new TreeNode(9278816);
		root.left.left = new TreeNode(899375);
		root.right.left = new TreeNode(8989449);
		BSTIterator bst = new BSTIterator(root);
		while(bst.hasNext()) {
			System.out.print(bst.next()+", ");
		}
		
	}
}

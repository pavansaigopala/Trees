package com.BTS.practice.Day1;


public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(17);
		boolean reu = isValidBST(root1);
		System.out.println(reu);
	}
	public static boolean isValidBST(TreeNode root) {
	        return isFun(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }

	    public static boolean isFun(TreeNode node,long min, long max){
	        if(node==null){
	            return true;
	        }

	        if(min<node.val && node.val<max){
	            boolean left = isFun(node.left, min, node.val);
	            boolean right = isFun(node.right,node.val, max);
	            return (left && right);
	        }else{
	            return false;
	        }
	    }

}

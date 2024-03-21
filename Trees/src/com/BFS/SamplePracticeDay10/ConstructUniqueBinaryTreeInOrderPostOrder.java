package com.BFS.SamplePracticeDay10;

import java.util.HashMap;

public class ConstructUniqueBinaryTreeInOrderPostOrder {

	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,6,3,7};
		int[] preorder = {1,2,4,5,3,6,7};
		TreeNode tr = buildTree(preorder, inorder);
		preOrder(tr);

	}
	
	public static void preOrder(TreeNode tr) {
		if(tr== null) return ;
		
		System.out.println(tr.val);
		preOrder(tr.left);
		preOrder(tr.right);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
	     HashMap<Integer, Integer> hMap = new HashMap<>();
	        for(int i=0; i<inorder.length; i++){
	            hMap.put(inorder[i], i);
	        }
	        return f(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, hMap);
	    }

	    public static TreeNode f(int[] inorder, int inStr, int inEnd ,int[] postorder, int postSt, int postEnd, HashMap<Integer, Integer> hMap){

	        if(inStr>inEnd || postSt>postEnd) return null;

	        TreeNode root = new TreeNode(postorder[postEnd]);
	        int rootIn = hMap.get(postorder[postEnd]);
	        int numLeft = rootIn - inStr;
	        int numRight = inEnd - rootIn;
	        root.left = f(inorder, inStr, rootIn-1, postorder, postSt, postSt+numLeft-1, hMap);
	        root.right = f(inorder, rootIn+1, inEnd, postorder, postSt+numLeft, postEnd-1, hMap);

	        return root;
	    }

}

package com.BFS.SamplePracticeDay10;

import java.util.HashMap;

public class ConstructUniqueBinaryTree {

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
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            hMap.put(inorder[i], i);
        }
        return f(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, hMap);
    }

    public static TreeNode f(int[] inorder, int inStr, int inEnd ,int[] preorder, int preSt, int preEnd, HashMap<Integer, Integer> hMap){

        if(inStr>inEnd || preSt>preEnd) return null;

        TreeNode root = new TreeNode(preorder[preSt]);
        int rootIn = hMap.get(preorder[preSt]);
        int numLeft = rootIn - inStr;
        root.left = f(inorder, inStr, rootIn-1, preorder, preSt+1, preSt+numLeft, hMap);
        root.right = f(inorder, rootIn+1, inEnd, preorder, preSt+numLeft+1, preEnd, hMap);

        return root;
    }

}

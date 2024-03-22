package com.BTS.practice.Day2;

public class ConstructBinarySearchTreefromPreorderTraversal {

	public static void main(String[] args) {
			int[] pre= {8,5,1,7,10,12};
			TreeNode node = bstFromPreorder(pre);
			System.out.println(node.val);
	}
	
	 public static TreeNode bstFromPreorder(int[] preorder) {
	       return bst(preorder, new int[]{0}, Integer.MAX_VALUE);
	    }

	    public static TreeNode bst(int[] preorder, int[] index, int upperBound){

	            if(index[0] == preorder.length || preorder[index[0]]>upperBound) return null;

	            TreeNode node = new TreeNode(preorder[index[0]++]);
	            System.out.println("index:"+index);
	            System.out.println("Node:"+node.val);
	            node.left = bst(preorder, index, node.val);
	            node.right = bst(preorder, index, upperBound);
	            
	            return node;
	    }

}

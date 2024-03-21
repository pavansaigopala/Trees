package com.BFS.SamplePracticeDay9;

import java.util.ArrayList;

public class FindCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left =  new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left= new TreeNode(90);
		root.right.right=new TreeNode(100);
		root.right.left.right = new TreeNode(120);
		
		TreeNode x = new TreeNode(100);
		TreeNode y = new TreeNode(120);
		
		TreeNode resultNode = findAncestorOpt(root, x, y);
		System.out.println(resultNode.val);
	}
	
	//optimal Approach
		public static TreeNode findAncestorOpt(TreeNode node, TreeNode x, TreeNode y){
	        if(node==null) return null;

	        if(node.val == x.val) return x;

	        if(node.val == y.val) return y;

	        TreeNode leftResult = findAncestorOpt(node.left, x, y);
	        TreeNode rightResult = findAncestorOpt(node.right, x, y);

	        if(leftResult!=null && rightResult!=null) return node;
	        else if(leftResult!=null) return leftResult;
	        else return rightResult;
	    }
	
	//optimal Approach
	// TC: O(N)
	// SC: O(H) stack
	public static int findAncestor(TreeNode node, int x, int y){
        if(node==null) return -1;

        if(node.val == x) return x;

        if(node.val == y) return y;

        int leftResult = findAncestor(node.left, x, y);
        int rightResult = findAncestor(node.right, x, y);

        if(leftResult!=-1 && rightResult!=-1) return node.val;
        else if(leftResult!=-1) return leftResult;
        else if(rightResult!=-1) return rightResult;
        else return -1;
    }
	
	// Brute Force Methode
	// TC: 2*O(N) + O(H) (for comparing nodes)
	// SC: 2*O(H)

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode x, TreeNode y) {
        ArrayList<TreeNode> xAL = new ArrayList<TreeNode>();
       ArrayList<TreeNode> yAL = new ArrayList<TreeNode>();
       findNode(xAL, x, root);
       findNode(yAL, y, root);
       int len = (xAL.size()>yAL.size())? yAL.size() : xAL.size();
       for(int i=len-1; i>=0; i--){
           if(xAL.get(i).val == yAL.get(i).val){
               return yAL.get(i);
           }
       }
       return root;
   }

   public static boolean findNode(ArrayList<TreeNode> al,TreeNode targetNode, TreeNode node){
       if(node==null) return false;

       al.add(node);
       if(node.val == targetNode.val) return true;

       if(findNode(al, targetNode, node.left) || findNode(al, targetNode, node.right)){
           return true;
       }

       al.remove(al.size()-1);

       return false;
   }

}

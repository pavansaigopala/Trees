package com.BFS.SamplePracticeDay5;

public class DiameterofBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left=new TreeNode(4);
		root.right.right= new TreeNode(6);
		root.right.left.left=new TreeNode(5);
		root.right.right.right= new TreeNode(7);
		root.right.left.left.left=new TreeNode(9);
		root.right.right.right.right= new TreeNode(8);
		int maxDiameter = diameterOfBinaryTree(root);
		System.out.println(maxDiameter);
	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1];
        dOBT(root, dia);
        return dia[0];
    }
    public static int dOBT(TreeNode root, int[] dia){
        if(root==null) return 0;

        int lH = dOBT(root.left, dia);
        int rH = dOBT(root.right, dia);

        dia[0] = Math.max(dia[0], lH+rH);
        return 1+Math.max(lH, rH);
    }
}

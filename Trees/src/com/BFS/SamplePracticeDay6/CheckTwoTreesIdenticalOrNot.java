package com.BFS.SamplePracticeDay6;

public class CheckTwoTreesIdenticalOrNot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		
		boolean postOrderResult = postOrder(root, root1);
		System.out.println(postOrderResult);
		//boolean inOrderResult = inOrder(root, root1);
		//System.out.println("Method InOrder:Do both the trees are equal:"+inOrderResult);
		//boolean result = preOrder(root, root1);
		//System.out.println("do both the trees are equal:"+result);
	}
	
	//post-order(left-right-root)
	public static boolean postOrder(TreeNode node1, TreeNode node2) {
		
		if(node1==null || node2==null) return (node1==node2);
		
		boolean leftCheck = postOrder(node1.left, node2.left);
		boolean rightCheck = postOrder(node1.right, node2.right);
		return (leftCheck == rightCheck);
	}
	
	// in-order  (left-root-right)
	public static boolean inOrder(TreeNode node1, TreeNode node2) {
		//if(node==null) return;
		if(node1==null || node2==null) {
			return (node1==node2);
		}
		boolean leftCheck = inOrder(node1.left, node2.left);
		if(node1.data!=node2.data) return false;
		boolean rightCheck = inOrder(node1.right, node2.right);
		
		return (leftCheck && rightCheck);
	}
	
	// pre-order  (root-left-right)
	public static boolean preOrder(TreeNode node1, TreeNode node2) {
		//if(node1==null) return;
		if(node1==null || node2==null) {
			return (node1==node2);
		}
		//System.out.print(node.data+", ");
		if(node1.data != node2.data) return false;
		
		boolean leftcheck = preOrder(node1.left, node2.left);
		boolean rightcheck = preOrder(node1.right, node2.right);
		
		return (leftcheck && rightcheck);
	}
	
	
}



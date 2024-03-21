package com.BTS.practice.Day1;


public class DeleteNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(17);
		inOrder(root);
		TreeNode rest = deleteNode(root, 5);
		inOrder(rest);
	}
	
	public static void inOrder(TreeNode node) {

		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.val + ", ");
		inOrder(node.right);

	}
	public static TreeNode deleteNode(TreeNode noddy, int key) {
	    if(noddy==null) return null;
	    if(noddy.val == key) return helper(noddy);
	    TreeNode root = noddy;
	    while(root!=null){
	        if(root.val > key){
	            if(root.left!=null && root.left.val == key){
	                root.left = helper(root.left);
	                break;
	            }else{
	                 root = root.left;
	            }
	        }
	        else{
	             if(root.right!=null && root.right.val == key){
	                root.right = helper(root.right);
	                break;
	            }else{
	                 root = root.right;
	            }
	        }
	    }
	    return noddy;
	   }
	    

	    public static TreeNode helper(TreeNode node){
	        if(node.left==null){
	            return node.right;
	        }else if(node.right==null){
	            return node.left;
	        }else{
	            TreeNode rightNode = node.right;
	            TreeNode lastRight = findHelperNode(node.left);
	            lastRight.right = rightNode;
	            return node.left;
	        }
	    }


	    public static TreeNode findHelperNode(TreeNode node){
	        while(node.right!=null){
	            node = node.right;
	        }
	        return node;   
	    }
	}
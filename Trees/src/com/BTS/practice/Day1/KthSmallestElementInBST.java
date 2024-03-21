package com.BTS.practice.Day1;


public class KthSmallestElementInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(17);
		int node = kthSmallest(root, 4);
		System.out.println(node);
	}
	
	public static int kthSmallest(TreeNode root, int k) {
        return fun(root, k , 0).val;
    }

    public static TreeNode fun(TreeNode root, int k , int count){
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                count++;
                if(k==count) return cur;

                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right!=cur){
                    temp = temp.right;
                }

                if(temp.right==null){
                    temp.right = cur;
                   
                    cur = cur.left;
                }else{
                    temp.right = null;
                     count++;
                    if(count==k) return cur;
                    cur = cur.right;
                }
            }
        }
        return root;
    }

}

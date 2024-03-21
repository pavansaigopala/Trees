package com.BTS.practice.Day1;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(17);
		
		List<Integer> al = inorderTraversal(root);
		System.out.println(al);

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
        return fun(root);
    }
    public static List<Integer> fun(TreeNode root){
        ArrayList<Integer> al = new ArrayList<>();

        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                al.add(cur.val);
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
                    al.add(cur.val);
                    cur = cur.right;
                }
            }
            if(cur!=null)System.out.println("cur:"+cur.val+" al: "+al);
        }
        return al;
    }
}

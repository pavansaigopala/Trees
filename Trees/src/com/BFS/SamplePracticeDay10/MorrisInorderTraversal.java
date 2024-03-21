package com.BFS.SamplePracticeDay10;

import java.util.ArrayList;
import java.util.List;


public class MorrisInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		   List<Integer> al =  fun(root);
		   System.out.println(al);
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

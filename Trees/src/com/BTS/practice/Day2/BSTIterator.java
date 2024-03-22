package com.BTS.practice.Day2;

import java.util.Stack;

public class BSTIterator {
	
	    Stack<TreeNode>  stk;
	    public BSTIterator(TreeNode root) {
	        stk =  new Stack<>();
	        pushAll(root);
	    }
	    
	    public int next() {
	        TreeNode node = stk.pop();
	        pushAll(node.right);
	        return node.val;
	    }
	    
	    public boolean hasNext() {
	      return (stk.isEmpty() == true)? false:true;
	    }

	    public void pushAll(TreeNode node){
	        while(node!=null){
	            stk.push(node);
	            node = node.left;
	        }
	    }
}





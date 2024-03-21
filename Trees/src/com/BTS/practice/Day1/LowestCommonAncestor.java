package com.BTS.practice.Day1;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(17);
		TreeNode ancestor = lowestCommonAncestor(root,new  TreeNode(6), new TreeNode(17));
		System.out.println(ancestor.val);
	}
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return fun(root, p, q);
    }
    public static TreeNode fun(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null) return null;

        if((p.val < node.val && q.val > node.val)||(p.val > node.val && q.val<node.val)) return node;
        else if(p.val> node.val && q.val > node.val){
            return fun(node.right, p, q);
        }else if(p.val< node.val && q.val < node.val){
            return fun(node.left, p, q);
        }
              return node;
        }

}

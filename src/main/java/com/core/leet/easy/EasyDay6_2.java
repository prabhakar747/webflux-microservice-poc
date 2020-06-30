package com.core.leet.easy;

import java.util.Arrays;

public class EasyDay6_2 {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
       // System.out.println("Diameter"+diameterOfBinaryTree(root));
        System.out.println("preOrderTraversal");
        preOrderTraversal(root);
        System.out.println("inOrderTraversal");
        inOrderTraversal(root);
        System.out.println("postOrderTraversal");
        postOrderTraversal(root);
    }
    
  

    static int result;

    public static int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depth(root);
        return result - 1;
    }
    public static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        result = Math.max(result, L+R+1);
        return Math.max(L, R) + 1;
    }
    
    public static void preOrderTraversal(TreeNode node) {
    	if (node == null) 
            return; 
    	System.out.println(" "+node.val);
    	preOrderTraversal(node.left);
    	preOrderTraversal(node.right);
 	   
    }
    
    public static void inOrderTraversal(TreeNode node) {
    	if (node == null) 
            return; 
 	   inOrderTraversal(node.left);
 	   System.out.println(" "+node.val);
 	   inOrderTraversal(node.right);
    }
    
    public static void postOrderTraversal(TreeNode node) {
    	if (node == null) 
            return; 
    	postOrderTraversal(node.left);
    	postOrderTraversal(node.right);
    	System.out.println(" "+node.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

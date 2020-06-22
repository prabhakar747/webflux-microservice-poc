package com.core;

import java.util.Arrays;

public class EasyDay6_2 {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Diameter"+diameterOfBinaryTree(root));
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

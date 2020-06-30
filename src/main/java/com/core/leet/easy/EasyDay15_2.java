package com.core.leet.easy;

public class EasyDay15_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode root = new TreeNode(100);
	        root.left = new TreeNode(50);
	        root.right = new TreeNode(150);
	        root.left.left = new TreeNode(30);
	        root.left.right = new TreeNode(70);
	        System.out.println("Search :"+search(70, root).val);
	        System.out.println("Search :"+insert(35, root).val);
	}
	
	public static TreeNode search(int num, TreeNode root) {
		if(root == null)
			return new TreeNode(-1);
		if(num == root.val )	
			return root;
		
		if( num < root.val)
			return search(num,root.left);

		return search(num, root.right);
	}
	
	public static TreeNode insert(int num, TreeNode root) {
		if(root == null) {
			
		}
		if(num == root.val )	
			return root;
		
		if( num < root.val)
			return search(num,root.left);

		return search(num, root.right);
	} 

}

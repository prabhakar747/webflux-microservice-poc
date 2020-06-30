package com.core.leet.easy;

public class EasyDay14_1 {

	public static void main(String[] args) {
		TreeNode s = new TreeNode(1);
		s.left = new TreeNode(2);
		s.right = new TreeNode(3);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		
		StringBuilder sBuilder = new StringBuilder();
		preOrderTraversal(s,sBuilder);
		
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		
		StringBuilder tBuilder = new StringBuilder();
		preOrderTraversal(t,tBuilder);
		
		System.out.println("sBuilder:"+sBuilder.toString());
		System.out.println("tBuilder:"+tBuilder.toString());
		
		if(sBuilder.toString().contains(tBuilder.toString()))
			System.out.println(true);
		else
			System.out.println(false);
		
	}
	
	 public static void preOrderTraversal(TreeNode node,StringBuilder builder) {
	    	if (node == null) 
	            return; 
	    	System.out.println(" "+node.val);
	    	builder.append(node.val+"");
	    	preOrderTraversal(node.left,builder);
	    	preOrderTraversal(node.right,builder);
	 	   
	    }
	
	

}


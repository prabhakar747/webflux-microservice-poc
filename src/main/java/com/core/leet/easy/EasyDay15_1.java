package com.core.leet.easy;

public class EasyDay15_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        if (image[sr][sc] == newColor )
	            return image;
	        fill(image,sr,sc,image[sr][sc],newColor);
	        return image;
	    }
	    
	    public static void fill(int[][] image, int sr, int sc, int originalcolor, int newColor){
	    	if(sr < 0 || sc < 0 || sr >= image.length || sc >= image.length || image[sr][sc] != newColor)
	    		return;
	        
	        fill(image,sr-1,sc,originalcolor,newColor);
	        fill(image,sr+1,sc,originalcolor,newColor);
	        fill(image,sr,sc-1,originalcolor,newColor);
	        fill(image,sr,sc+1,originalcolor,newColor);
	    }
	    

}

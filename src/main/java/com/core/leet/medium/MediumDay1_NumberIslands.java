package com.core.leet.medium;

public class MediumDay1_NumberIslands {

	public static void main(String[] args) {
		 
	}
	
	public static int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		int numberOfIlands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]== '1' )
					numberOfIlands += dfs(grid,i,j);
			}
			
		}
        return numberOfIlands;
    }
	
	public static int dfs(char[][] grid, int i, int j) {
		if(i < 0 || i>=grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')	
			return 0;
		grid[i][j] = '0';
		
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
		
		return 1;
	}

}

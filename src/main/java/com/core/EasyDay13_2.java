package com.core;

public class EasyDay13_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strsArray = new String[] {"aa","a"};
		System.out.println("longestCommonPrefix : "+longestCommonPrefix(strsArray));
		
	}
	
	public static String longestCommonPrefix(String[] strsArray)  {
		
		String longestPrefix = "";
		
		
		if(strsArray.length == 0)	
			return longestPrefix;
		
		int index =0;
		for(char c:strsArray[0].toCharArray()) {
			for(int i=1; i < strsArray.length; i++) {
				if (index >= strsArray[i].length() || strsArray[i].charAt(index)!=c  ) {
					return longestPrefix;
				} 
			}
			longestPrefix +=c;
			index++;
		}
		return longestPrefix;
		 
	}
	

}

package com.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EasyDay13_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strsArray = new String[] {"a","a","b","b","b","b","b","b","b","b","b","b","b","b"};
		char[] charArray = {'a','a','b','b','c','c','c'};
		System.out.println("compress : "+compress(strsArray));
		System.out.println("compress compressCharArray : "+compressCharArray(charArray));
		
		
	}
	
	public static String compress(String[] strsArray)  {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int counter = 1;
		for (String string : strsArray) {
			if(!map.containsKey(string))
				 counter = 1;
			map.put(string, counter++);
		}
		int valueSizeCounter =0;
		int keySize = map.keySet().size();
		for(String key:map.keySet()) { 
			valueSizeCounter += Integer.toString(map.get(key)).toCharArray().length;
		}
		
		String[] finalArray = new String[valueSizeCounter+keySize];
		int index = 0;
		for (Map.Entry<String, Integer> entry:map.entrySet()) {
			 finalArray[index] = entry.getKey();
			 index++;
			 for(char c:Integer.toString(entry.getValue()).toCharArray())
			 {
				 finalArray[index] = c+"";
				 index++;
			 }
		}
		
		return "";
		 
	}
	
	
	@SuppressWarnings("null")
	public static int compressCharArray(char[] chars)  {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int counter = 1;
		for (char c : chars) {
			if(!map.containsKey(c+""))
				 counter = 1;
			map.put(c+"", counter++);
		}
		int valueSizeCounter =0;
		int keySize = map.keySet().size();
		for(String key:map.keySet()) { 
			valueSizeCounter += Integer.toString(map.get(key)).toCharArray().length;
		}
		
		//String[] finalArray = new String[valueSizeCounter+keySize];
		chars = new char[valueSizeCounter+keySize] ;
		int index = 0;
		for (Map.Entry<String, Integer> entry:map.entrySet()) {
			chars[index] = entry.getKey().toString().charAt(0);
			 index++;
			 for(char c:Integer.toString(entry.getValue()).toCharArray())
			 {
				 chars[index] = c;
				 index++;
			 }
		}
		
		return chars.length;
		 
	}
	
	
	
	

}

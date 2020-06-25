package com.core;

import java.util.HashMap;
import java.util.Iterator;

import com.sun.beans.decoder.ValueObject;

public class EasyDay12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		System.out.println("is String Palindrome: "+firstUniqChar(s));
		
	}
	
	public static int firstUniqChar(String s) {
		
		HashMap<Character, Integer>  map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
		}
		
		for (int i = 0; i <  s.length(); i++) {
			if(map.get(s.charAt(i))==1)
				return i;
		}
		return -1;
		
		 
	}
	

}

package com.core;

import java.util.Iterator;

import com.sun.beans.decoder.ValueObject;

public class EasyDay12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		System.out.println("is String Palindrome: "+isStringPalindorme(s));
		System.out.println("is String Palindrome: "+isStringPalindormeWithBuilder(s));
		
	}
	
	public static boolean isStringPalindorme(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		s = s.replaceAll("\\s", "");
		s = s.toLowerCase();
		System.out.println("string:"+s);
		char[] charArray = s.toCharArray();
		int i=0 ; boolean isPalindrome = true;
		for (int j = charArray.length-1; j >= charArray.length/2 ;j--) {
			if(charArray[i]   != charArray[j]) {
				isPalindrome =  false;
				return isPalindrome;
			}
			i++;
		}
		return isPalindrome;
	}
	
	public static boolean isStringPalindormeWithBuilder(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (char ch : s.toCharArray()) {
			if(Character.isLetterOrDigit(ch))
				builder.append(Character.toLowerCase(ch));
		}
		String string = builder.toString();
		String reversedString = builder.reverse().toString();
		if(string.equals(reversedString))
			return true;
		else
			return false;
	}
	
	
	

}

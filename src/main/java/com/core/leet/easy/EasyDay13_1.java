package com.core.leet.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EasyDay13_1 {

	public static void main(String[] args) {
		int[] nums = new int[] {4};
		System.out.println("single Number : "+singleNumber(nums));
		
		
	}
	
	public static int singleNumber(int[] nums)  {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int counter = 1;
		for (Integer n : nums) {
			if(!map.containsKey(n))
				 counter = 1;
			map.put(n, counter++);
		}
		 
		for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
			  if(entry.getValue()==1)
				  return entry.getKey();
		}
		
		return -1;
	}
	
}

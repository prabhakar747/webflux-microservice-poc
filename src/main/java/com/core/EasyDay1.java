package com.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class EasyDay1 {

    public static int[] twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target =9;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] + nums[i] == target ) {
                        return new int[] { i, j };
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
    }

    public static boolean isValidParentheses(){
        String input = "()[]{}";
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        Stack<Character> stack = new Stack<Character>();

        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            if(map.containsKey(c)){
                Character topChar = stack.empty() ? '#' : stack.pop();
                if(topChar != map.get(c))
                    return  false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String args[]){
        // System.out.println(Arrays.toString(twoSum()));
        System.out.println(isValidParentheses());
    }

}

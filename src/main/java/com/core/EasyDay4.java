package com.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EasyDay4{



    public static void main(String args[]){
       System.out.println( "Max profit:"+BestTimeToBuyShare(nums));
        String num1 = "999";
        String num2 = "999";
        System.out.println("addStrings :"+addStrings(num1,num2));
        System.out.println("addStrings2 :"+addStrings2(num1,num2));
    }
        public static String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();

            while(i >= 0 || j >= 0) {
                int current1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int current2 = j < 0 ? 0 : num2.charAt(j) - '0';
                int currentSum = current1 + current2 + carry;

                carry = currentSum / 10;
                sb.insert(0, Integer.toString(currentSum % 10));
                i--;
                j--;
            }

            if (carry > 0) {
                sb.insert(0, Integer.toString(carry));
            }

            return sb.toString();
        }

        public static String addStrings2(String num1, String num2){
            int index1 = num1.length()-1;
            int index2 = num2.length()-1;
            int sum = 0;
            int carry = 0;
            StringBuilder ans = new StringBuilder();
            while(index1>=0 || index2>=0){
                int n1 = index1>=0?(num1.charAt(index1)-'0'):0;
                int n2 = index2>=0?(num2.charAt(index2)-'0'):0;
                sum = (n1+n2+carry)%10;
                carry = (n1+n2+carry)/10;
                ans.insert(0,sum);
                index1--;
                index2--;
            }
            if(carry!=0){
                ans.insert(0,carry);
            }
            return ans.toString();
        }
        public static int[] nums = new int[]{7,1,5,3,6,4};
        public static int BestTimeToBuyShare(int[] nums){
            int difference = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int profit = nums[j] - nums[i];
                    if (profit > difference)
                        difference = profit;
                }
            }
            return difference;
        }



}

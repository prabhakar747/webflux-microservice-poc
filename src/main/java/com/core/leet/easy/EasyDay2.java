package com.core.leet.easy;

import java.util.*;

public class EasyDay2 {

    public  static Integer indexCounter =0 ;
    public static String[] logs= new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    public static int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    public static String[] reorderLogFiles() {
        int logSize = logs.length;
        String[] finalLogs = new String[logSize];
        processLoop(logs, finalLogs,"let");
        processLoop(logs, finalLogs,"dig");
        return finalLogs;
    }

    public  static void processLoop(String[] logs,String[] finalLogs,String beginWith){
        for (int i=0;i<logs.length;i++){
            if(logs[i].startsWith(beginWith)){
                finalLogs[indexCounter] = logs[i];
                System.out.println("indexCounter:"+indexCounter+" finalLogs"+ Arrays.toString(finalLogs));
                indexCounter++;
            }

        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        int len = logs.length;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
        Collections.sort(letterList, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                }
            }
            return 0;
        });

        for (int i = 0; i < len; i++) {
            if (i < letterList.size())
                logs[i] = letterList.get(i);
            else logs[i] = digitList.get(i - letterList.size());
        }
        return logs;
    }


        public  static int crossSum(int[] nums, int left, int right, int p) {
            if (left == right) return nums[left];

            int leftSubsum = Integer.MIN_VALUE;
            int currSum = 0;
            for(int i = p; i > left - 1; --i) {
                currSum += nums[i];
                leftSubsum = Math.max(leftSubsum, currSum);
            }

            int rightSubsum = Integer.MIN_VALUE;
            currSum = 0;
            for(int i = p + 1; i < right + 1; ++i) {
                currSum += nums[i];
                rightSubsum = Math.max(rightSubsum, currSum);
            }

            return leftSubsum + rightSubsum;
        }

        public  static int helper(int[] nums, int left, int right) {
            if (left == right) return nums[left];

            int p = (left + right) / 2;

            int leftSum = helper(nums, left, p);
            int rightSum = helper(nums, p + 1, right);
            int crossSum = crossSum(nums, left, right, p);

            return Math.max(Math.max(leftSum, rightSum), crossSum);
        }

        public static int maxSubArray(int[] nums) {
            return  helper(nums, 0, nums.length - 1);
        }




    public static void main(String args[]){
        // System.out.println(Arrays.toString(twoSum()));
        //System.out.println(Arrays.toString(reorderLogFiles(logs)));
        System.out.println(maxSubArray(nums));
    }



}

package com.core;

import java.util.Arrays;

public class EasyDay5 {

    static int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
    static int[] num2 = new int[]{2, 5, 6};


    public static void main(String args[]) {
        int num1_length = num1.length - 1;
        int num2_length = num2.length - 1;
        System.out.println("mergeTwoSortedArrays :" + mergeTwoArrays2(num1, num1_length, num2, num2_length));
    }

    public static int[] mergeTwoArrays2(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
        return nums1;
    }


    public static String mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {


        int[] output = new int[m];
        System.arraycopy(num1, 0, output, 0, m);

        int p = 0;
        int p1 = 0;
        int p2 = 0;

        while ((p1 < m) && (p2 < n)) {
            output[p++] = (nums1[p1] < nums2[p2]) ? nums1[p1++] : nums2[p2++];
        }

        if (p1 < m)
            System.arraycopy(nums1, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        return  null;

    }

}

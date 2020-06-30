package com.core.leet.easy;

import java.util.Arrays;

public class EasyDay8_1 {
    public  static void main(String[] args){
        int[] nums = new int[]{0,1,0,3,12};
        moveZerosToEnd(nums,nums.length);
        System.out.println("output:"+Arrays.toString(nums));
    }

    // Function to move all zeroes at
    // the end of array
    static void moveZerosToEnd(int arr[], int n) {
        int j = 0, i;

        // Traverse the array. If arr[i] is
        // non-zero and arr[j] is zero,
        // then swap both the element
        for (i = 0; i < n; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                arr = swap(arr, i, j);
            }
            if (arr[j] != 0)
                j += 1;
        }
    }

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}

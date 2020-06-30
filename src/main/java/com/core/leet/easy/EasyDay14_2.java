package com.core.leet.easy;

public class EasyDay14_2 {

	public static void main(String[] args) {
		int[] A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("maxSubArray Sum:" + maxSubArray(A));

	}

	/*
	 * public static int maxSubArray(int[] nums) { int max = nums[0]; int sum =
	 * nums[0];
	 * 
	 * for (int i = 1; i < nums.length; i++) { if(sum < 0) sum = nums[i]; else sum
	 * += nums[i]; } max = Math.max(max, sum); return max; }
	 */

	public static int maxSubArray(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public static int helper(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];
		int p = (left + right) / 2;

		int leftSum = helper(nums, left, p);
		int rightSum = helper(nums, p + 1, right);
		int crossSum = corssSum(nums, left, right, p);
		
		return Math.max(Math.max(leftSum, rightSum), crossSum);
	}

	public static int corssSum(int[] nums, int left, int right, int p) {
		if (left == right)
			return nums[left];

		int leftSubSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = p; i > left-1; --i) {
			currentSum += nums[i];
			leftSubSum = Math.max(leftSubSum, currentSum);
		}

		int rightSubSum = Integer.MIN_VALUE;
		currentSum = 0;
		for (int i = p+1; i < right + 1; ++i) {
			currentSum += nums[i];
			rightSubSum = Math.max(rightSubSum, currentSum);
		}

		return leftSubSum + rightSubSum;

	}
}

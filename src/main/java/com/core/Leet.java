/*
package com.java.core;

public class Leet {

	*/
/**
	 * @param args
	 *//*

	

	public static int findMaxConsecutiveOnes() {

		int nums[] = new int[] { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 };

		int run = 0, maxLen = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				run++;
			} else {
				maxLen = Math.max(maxLen, run);
				run = 0;
			}
		}
		maxLen = Math.max(maxLen, run);

		return maxLen;
	}

	public static int findNumbers() {
		int nums[] = new int[] { 555, 901, 482, 1771 };
		int result = 0;
		int remainder = 0;
		int finalResult = 0;
		for (int i = 0; i < nums.length; i++) {
			int noOfDigits = 0;
			int temp = nums[i];
			while (true) {
				if (nums[i] > 9) {
					remainder = temp / 10;
					noOfDigits++;
					temp = remainder;
				}
				if (remainder < 10) {
					noOfDigits = noOfDigits + 1;
					break;
				}
			}
			finalResult = (noOfDigits % 2 == 0) ? (finalResult + 1) : finalResult;
			System.out.println("no of digits for " + nums[i] + " are " + noOfDigits);
		}
		System.out.println("Result:" + finalResult);
		return finalResult;

	}

	public static int[] sortedSquares() {

		int nums[] = new int[] { -3, 0, 2 };
		int temp;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		System.out.println("Result:" + Arrays.toString(nums));
		return nums;

		*/
/*
		 * for (int i = 0; i < nums.length; i++) { System.out.println("i :" + i +
		 * " value :" + Arrays.toString(nums));
		 * 
		 * if (nums.length == 2 & i < 2) { if (nums[i] > nums[i + 1]) { temp = nums[i];
		 * nums[i] = nums[i + 1]; nums[i + 1] = temp; System.out.println("Result:" +
		 * Arrays.toString(nums)); } return nums; }
		 * 
		 * for (int j = i + 1; j < (nums.length - 1); j++) {
		 * System.out.println("Before J:" + j + " value :" + Arrays.toString(nums)); if
		 * (nums[i] > nums[j]) { temp = nums[i]; nums[i] = nums[j]; nums[j] = temp; }
		 * System.out.println("After j:" + j + " value :" + Arrays.toString(nums)); }
		 * 
		 * } System.out.println("Result:" + Arrays.toString(nums)); return nums;
		 *//*


	}

	public static void duplicateZeros() {
		// for loop to iterate
		// if check to find 0 or not
		// if 0, then taht index will be starting index. So pass Star index and Lenght
		// of array as parameter to other function
		// where we will implement the actual array shifting of elements
		int[] nums = new int[] { 8,4,5,0,0,0,0,7};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for(int j=(nums.length-1);j>i;j--) {
					nums[j]=nums[j-1];
					System.out.println("Result:" + Arrays.toString(nums));
					
				}
				i = i+1;
			}				
		}
		//Time limit exceeeeeeeeeeeeeeeeeedddddddddddddddddddddddddddddd

	}
	
	
	
	public static void duplicateZeros1() {
		int[] nums = new int[] { 8,4,5,0,0,0,0,7};
		int duplicates = 0;
		int l = nums.length-1;
		//Find no of zero's
		for (int i = 0; i < l-duplicates; i++) {
			if (nums[i] == 0) {
				if(i == l-duplicates) {
					nums[l]=0;
					l -=1;
					break;
				}
				duplicates++;
			}
		}
		
		int last = l - duplicates;
		for(int i=last;i>0;i--) {
			if(nums[i]==0) {
				nums[i + duplicates] = 0;
				duplicates--;
				nums[i + duplicates] = 0;
			}else {
				nums[i+duplicates]=nums[i];
			}
			
			
		}
	}
	
	
	public static void mergeSortedArray() {
		int[] nums1 = new int[] { 1, 2, 3,0,0,0};
		int[] nums2 = new int[] { 2, 5, 6};
		
		int m = nums1.length;int n = nums2.length;
		
		int[] nums3 = new int[m]; 
		
		int i=0; int j=0; int k=0;
		
		while(i<m && j<n) {
			if(nums1[i]<nums2[j]) {
				if(nums1[i] == 0)
					i++;
				else 
					nums3[k++]= nums1[i++];
			}else {
				if(nums2[j] == 0)
					j++;
				else  
					nums3[k++] =nums2[j++];
			}
				
		}
		while(i<m) {
			nums3[k++]= nums1[i++];
		}
		while(j<n) {
			nums3[k++]= nums2[j++];
		}
		System.out.println("Final array :"+Arrays.toString(nums3));
	}
	
	
	public static int removeElement() {
		    int i = 0; int[] nums = new int[] { 3,2,2,3};int val=3;
		    for (int j = 0; j < nums.length; j++) {
		        if (nums[j] != val) {
		            nums[i] = nums[j];
		            i++;
		        }
		    }
		    
		    System.out.println("Final array :"+i);
		    return i;
	}
	
	
	
	public static int removeDuplicates() {
		 int[] nums = new int[] {1,1,2};
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    System.out.println("Final array :"+(i+1));
	    return i + 1;
	}
	
	public static boolean search1() {
		 int[] nums = new int[] {0,0};
		 boolean result = false;
		 for (int i = 0; i < nums.length; i++) {
			int value = nums[i]*2;
			if(value !=0 ) {
				for (int j = 0; j < nums.length; j++) {
					if(nums[j]==value) {
						result =  true;
						System.err.println("Result:"+result);
						return result;
					}
				}
			}else if(nums.length ==2 && nums[0]==0 && nums[1]==0) {
				return true;
			}
		}
		 System.err.println("Result:"+result);
		 return result;
	}
	
	public static boolean validMountainArray() {
		 int[] nums = new int[] {0,3,2,1};	
		 int length = nums.length;
		 if(length<3) return false;
		 //travel and search for 
		 
		return false;
	}
	
	public static void main(String[] args) {

		validMountainArray();
	}
}
*/

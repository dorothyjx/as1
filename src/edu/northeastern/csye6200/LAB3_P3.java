package edu.northeastern.csye6200;

import java.util.Arrays;

public class LAB3_P3 {
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,5};
		System.out.println("Original nums: " + Arrays.toString(nums));
		
		int k = removeDuplicates(nums);
		
		System.out.println("Final nums: " + Arrays.toString(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		
		int rst = 1;
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[rst] = nums[i];
				rst += 1;
			}
		}
		//update the return value rather than return 0
		return rst;
	}

}


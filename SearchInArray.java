package com.Aug2020;


//Time Complexity : O(log n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :
//there are several occasions where manipulating start, middle and end element was a problem.
//how to make the solution work using one-stack only to avoid extra stack.


class SearchInArray {
	public int search(int[] nums, int target) {
		int n = nums.length - 1;
		int low = 0, high = n;
		int mid = -1;
		/*
		 * while(low<high){ int mid= (high + low)/2; System.out.println("  mid => " +
		 * mid + " low => " + low + " high => " + high);; if(nums[mid] == target){
		 * return mid;
		 * 
		 * } if(target > nums[mid]){ high = mid - 1; } else { low = mid + 1;
		 * System.out.println(low); }
		 * 
		 * }
		 */

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				if (nums[low] > target) {
					low = low + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (nums[high] < target) {
					high = high - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}

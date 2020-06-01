// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class Solution {
	
	public int search(int[] nums, int target) {
		
		int low = 0, high = nums.length-1;
		
		return binarySearch(nums, low, high, target);
		
	}
	
	private int binarySearch(int[] nums, int low, int high, int target) {
		
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high - low)/2;
		
		if(nums[mid] == target) {
			return mid;
		} else if(nums[low] <= nums[mid]) {
			if(nums[low] <= target && target <= nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		} else {
			if(nums[mid] < target && target <= nums[high]) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
		}
	
		return binarySearch(nums, low, high, target);
		
	}
}

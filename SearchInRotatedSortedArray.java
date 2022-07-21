// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target == nums[mid])
				return mid;
			else if (target < nums[mid]) { // if the target is less than element in array, the target can still be
											// either left or right of mid of array
				if (target < nums[0] && nums[0] <= nums[mid]) { // Searching in right half of array based on comparison
																// of first and mid element, if not satisfied search
																// element in left half of array
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (target > nums[nums.length - 1] && nums[mid] <= nums[nums.length - 1]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}

		return -1;
	}
}
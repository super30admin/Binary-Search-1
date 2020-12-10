package nov18th2020;

// Problem 5
// Source Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// https://github.com/super30admin/Binary-Search-1

public class searchRotatedArray33 {
	public int search(int[] nums, int target) {
		// base case
		if (nums == null || nums.length == 0)
			return 0;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] >= nums[low]) {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] <= nums[high]) {
				if (target <= nums[high] && target > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	// Time Complexity O(log n)
	// space insertion O(1)
}

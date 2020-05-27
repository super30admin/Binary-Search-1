// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Search_Rotated_Sorted_Array {
	// Function Takes in 2 parameters- nums(array) and target value
	public int search(int[] nums, int target) {
		// If the nums array is empty we return -1
		if (nums == null || nums.length == 0) {
			return -1;
		}
		// Assigning left to start index of array and right to end index
		int left = 0;
		int right = nums.length - 1;
		// While loop executes till we find the smallest element present in the array
		while (left < right) {
			// Integer Overflow is avoided
			int midpoint = left + (right - left) / 2;
			// If the element at mid index is greater than element at last index we
			// increment left to mid+1, else we assign right to mid
			if (nums[midpoint] > nums[right]) {
				left = midpoint + 1;
			} else {
				right = midpoint;
			}
		}
		// start holds the index of the smallest element in the array
		// we assign left to 0 and right to length-1
		int start = left;
		left = 0;
		right = nums.length - 1;

		// Here we check if we have to search on the left side of the smallest element
		// in the array or on the other side of the smallest element in the array
		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		} else {
			right = start;
		}
		// Regular Binary Search is performed
		while (left <= right) {
			int midpoint = left + (right - left) / 2;
			if (nums[midpoint] == target) {
				return midpoint;
			} else if (nums[midpoint] < target) {
				left = midpoint + 1;
			} else {
				right = midpoint - 1;
			}
		}
		return -1;
	}
}
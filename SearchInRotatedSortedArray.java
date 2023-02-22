// Time Complexity : o log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
// split rotated sorted array into two parts using two pointer approach
// any one of the side will be sorted, so find and process only the sorted array and start moving pointer  
// which reduces the size of the array and easier to find the target 
// NOTE: if rotated sorted array is split into two with mid, one of the side will be sorted either left sorted or right sorted

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {

		if (null == nums || nums.length == 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			// mid
			if (nums[mid] == target)
				return mid;
			else if (nums[low] <= nums[mid]) {
				// left
				if (nums[low] <= target && nums[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] <= nums[high]) {
				// right
				if (nums[mid] < target && nums[high] >= target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}

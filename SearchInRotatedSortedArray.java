// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 1, 2, 3 };
		int target = 2;
		//should return 5
		System.out.println("Target element found at index : " + search(nums, target));
		
		//should return -1
		target = 10;
		System.out.println("Target element found at index : " + search(nums, target));
	}

	public static int search(int[] nums, int target) {

		if (null == nums || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[low] <= nums[mid]) { // left is sorted
				if (nums[low] <= target && nums[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else { // right is sorted
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


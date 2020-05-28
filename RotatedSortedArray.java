package Day_3;

/*
 * Time complexity - O(log(n))
 * Space Complexity - O(1)
 * 
 * Used binary search. Checked if the element is at mid. 
 * If not, then check for sorted array and ajdust low and high variables.
 */

public class RotatedSortedArray {

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && nums[mid] >= target) {
					high = mid - 1;
				} else
					low = mid + 1;
			} else {
				if (nums[high] >= target && nums[mid] <= target) {
					low = mid + 1;
				} else
					high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		RotatedSortedArray obj = new RotatedSortedArray();
		int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(obj.search(arr, 0));

	}

}

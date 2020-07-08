package Day_3;

/*
 * Time Complexity - O(log(n))
 * Space Complexity - O(1)
 * 
 * Applied binary search for finding first and last index searately.
 */

public class FirstAndLastPosition {

	public int[] searchRange(int[] nums, int target) {
		int n1 = firstIndex(nums, target);
		int n2 = lastIndex(nums, target);

		return new int[] { n1, n2 };
	}

	private int firstIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == low || nums[mid - 1] < nums[mid])
					return mid;
				// still go left
				else
					high = mid - 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return -1;
	}

	private int lastIndex(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == high || nums[mid + 1] > target)
					return mid;
				else
					low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstAndLastPosition obj = new FirstAndLastPosition();
		int[] arr = new int[] { 5, 7, 7, 8, 8, 10 };
		int[] ans = obj.searchRange(arr, 8);
		System.out.println(ans[0] + "," + ans[1]);
	}

}

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			int[] arr = { -1, -1 };
			return arr;
		} else {
			int first = binarySearchLeft(nums, target);
			int last = binarySearchRight(nums, target);

			return new int[] { first, last };

		}

	}

	private int binarySearchRight(int[] nums, int target) {
		// TODO Auto-generated method stub
		// int mid = -1;
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				if ( (mid == nums.length -1) || nums[mid] < nums[mid + 1])
					return mid;
				else
					low = mid + 1;

			} else if (nums[mid] < target) {
				low = mid + 1;

			} else
				high = mid - 1;

		}
		return -1;
	}

	private int binarySearchLeft(int[] nums, int target) {
		// TODO Auto-generated method stub

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				if (mid == 0 || nums[mid - 1] < nums[mid])
					return mid;
				else
					high = mid - 1;

			} else if (nums[mid] > target) {
				high = mid - 1;

			} else
				low = mid + 1;
		}
		return -1;
	}
}

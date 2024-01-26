package day4;

class Solution {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int middle = 0;

		while (left <= right) {
			middle = left + (right - left) / 2;
			if (nums[middle] == target)
				return middle;
			if (left <= middle) {
				// sorted
				if (target >= nums[left] && target < nums[middle])
					right = middle - 1;
				else
					left = middle + 1;
			} else {
				if (target > nums[middle] && target <= nums[right])
					left = middle + 1;
				else
					right = middle - 1;
			}
		}
		return -1;
	}
}

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		Solution s = new Solution();
		System.out.println(s.search(nums, 0));

	}

}

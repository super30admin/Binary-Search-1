// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem2;

public class SearchRSArray {
	// Modify binary search to narrow the scope of search
	public int search(int[] nums, int target) {
		int beg = 0, end = nums.length - 1;
		int mid;
		while (beg <= end) {
			mid = beg + (end - beg) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < nums[end]) {
				if (nums[mid] <= target && nums[end] >= target) {
					beg = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (nums[beg] <= target && nums[mid] >= target) {
					end = mid - 1;
				} else {
					beg = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchRSArray obj = new SearchRSArray();
		int[] arr = { 4, 5, 6, 8, 13, 45, 756, 1, 2, 3 };
		int x = obj.search(arr, 13);
		System.out.println("Searching for element 13 -- " + (x > 0 ? "Found in index " + x : "Not Found"));
		x = obj.search(arr, 47);
		System.out.println("Searching for element 47 -- " + (x > 0 ? "Found in index " + x : "Not Found"));
	}

}

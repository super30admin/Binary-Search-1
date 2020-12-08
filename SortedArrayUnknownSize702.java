package nov18th2020;

// Problem 6
// Source Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// https://github.com/super30admin/Binary-Search-1

public class SortedArrayUnknownSize702 {

	public int search(ArrayReader reader, int target) {

		int low = 0;
		int high = 1;
		while (target > reader.get(high)) {
			low = high;
			high = 2 * high;
		}
		return binarySearch(reader, target, low, high);
	}

	public int binarySearch(ArrayReader reader, int target, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == reader.get(mid)) {
				return mid;
			} else if (target < reader.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
 

// Time complexity : O (log n )
// Space complexity : O (1)

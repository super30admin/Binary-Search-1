// Time Complexity : O(log k), k-> Max possible Index of search value
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

package problem3;

// Just for reference purposes. Not the actual implementation.
interface ArrayReader {
	final int[] arr = { 1, 2, 3, 4, 5, 6, 8, 13, 45, 57, 78, 79, 234, 345, 732, 756 };

	public default int get(int index) {
		return arr[index];
	}
}

public class SearchInfiniteSortedArray {
	// Binary Search to find the elements.
	// Since all elements are unique and sorted, the maximum position of end index
	// would be target - arr[0]
	public int search(ArrayReader reader, int target) {
		if (reader.get(0) == target) {
			return 0;
		}

		int left = 0, right = target - reader.get(0);

		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (reader.get(mid) == target) {
				return mid;
			} else if (reader.get(mid) < target) {
				mid = left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}

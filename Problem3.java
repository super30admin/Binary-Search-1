package BinarySearch;
/*
 * Two pointer approach used here to find a high and low index such that target lies between those and then binary search is performed in that range
 * Time Complexity :
 * O(logN)
 * 
 * Space Complexity :
 * Space complexity is O(1)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 * 
 */

public class Problem3 {

	public int search(ArrayReader reader, int target) {
		int highPointer = 1;
		int lowPointer = 0;

		while (reader.get(highPointer) <= target) {
			lowPointer = highPointer;
			highPointer = 2 * highPointer;
		}

		return binarySearch(reader, target, lowPointer, highPointer);

	}

	public int binarySearch(ArrayReader reader, int target, int low, int high) {
		while (high <= low) {
			int mid = low + (high - low) / 2;
			if (reader.get(mid) == target) {
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

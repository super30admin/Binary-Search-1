// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, since premium question
// Any problem you faced while coding this : Yes, referred Google for help with question and not sure about constraints

// Your code here along with comments explaining your approach in three sentences only
/*
 * Stared with low= 0 and right = 1 and then kept increasing the right by doubling till target is in range then then doing binary search
 * If index out of bound implemented try and catch and decresed the end by -1 
 */

// Java code to implement the approach

public class InfiniteSortedArray {

	private int findTargetPosition(int[] arr, int target) {

		int start = 0;
		int end = 1;

		while (target > arr[end]) {
			int temp = end + 1;
			end = end + (end - start + 1) * 2;
			end = getValidEndindex(arr, start, end);
			start = temp;
		}
		return binarySearch(arr, target, start, end);
	}

	//handles Out of Bound Exception for End Index
	private int getValidEndindex(int[] arr,
	int start, int end) {
		try {
			int value = arr[end];
			return end;	
		} catch (Exception e) {
			if ( end > start && end >= 1) {
				end -= 1;
				return getValidEndindex(arr, start, end);
			} else {
				return end;
			}
		}
	}

	private int binarySearch(int[] arr, int target,
			int left, int right) {
		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 9, 10, 10, 10, 90,
				100, 130, 140, 160, 170 };
		int target = 170;

		InfiniteSortedArray iSA = new InfiniteSortedArray();
		int ans = iSA.findTargetPosition(arr, target);
		if (ans == -1) {
			System.out.println("Target not found");
		} else {
			System.out.println("Traget found at index "
					+ ans);
		}
	}
}

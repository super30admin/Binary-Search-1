// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Could not find problem on leetcode
// Any problem you faced while coding this : No
public class Infinite_Sorted_Array {

	// Resular Binary Search
	public static int binary_search(int arr[], int low, int high, int target) {
		if (low <= high) {
			int midpoint = low + (high - low) / 2;
			if (arr[midpoint] == target) {
				return midpoint;
			} else if (arr[midpoint] < target) {
				binary_search(arr, midpoint + 1, high, target);
			} else {
				binary_search(arr, low, midpoint - 1, target);
			}
		}
		return -1;
	}

	/*
	 * This function takes in 2 paramters arr(array) and Key and finds the start and
	 * end index of the array, where the key would lie in between the start and end
	 * index
	 */
	public static int find_pos(int arr[], int key) {
		int start = 0; // Initializing the start index
		int end = 1; // Initializing the end index
		int val = arr[0]; // Initially assigning val to the first element
		/*
		 * This while loop runs until we find end index within which the key would be
		 * present
		 */
		while (val < key) {
			start = end; // Updating value of start
			// Since the array is of infinite length, if val<key,
			// we would keep on multiplying end with 2
			if ((2 * end) < arr.length) {
				end = end * 2;
			} else {
				end = arr.length - 1;
			}
			// Updating val to arr[end]
			val = arr[end];
		}
		// Binary Search function is called
		return binary_search(arr, start, end, key);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10, 11, 12 };
		int result = find_pos(arr, 10);
		// If we get result as -1, then the element is not present in the array
		if (result == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element found at index: " + result);
		}
	}
}
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


/* Binary Search Approach having 2 pointers to find the range
 * The Second pointer will be incremented in 2^p and first pointer will be replaced by second*/


public class Search_In_Unknown_Size_SortedArray {
	
	
	private static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int low = 0, high = 1;
		while(nums[high] < target) {
			low = high;			//The first pointer is replaced by second
			high = 2 * high;	// The second pointer is multiplied by 2 till the target lays within range. 
		}
		return binarySearch(nums, low, high, target);
	}
	
	private static int binarySearch(int[] nums, int low, int high, int target) {
		while(low <= high) {
			int mid = low + (high-low) /2;
			if(nums[mid] == target)
				return mid;
			else if(target < nums[mid])
				high = mid -1;
			else
				low = mid +1;
		}
		return -1;
	}
	
	public static void main (String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		int target = 0;
		int index = search(nums, target);
		if(index == -1)
			System.out.println("Not found");
		else
			System.out.println("Found at index " +index);
	}

}

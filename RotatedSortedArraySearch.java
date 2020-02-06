// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Approach: On observing the rotated sorted array, it is clear that there are 3 cases possible: 1. The pivot is in the middle which means 
 * that both the left and right sides of pivot will be in sorted order. 2. The pivot is in the left side which means that the right side of
 * the middle element will be in sorted order. 3. The pivot is in the right side which means that the left side of the middle element will 
 * be in sorted order.
 * We can do a binary search considering one side to be always sorted. If the element is on the other end of the middle element, the 
 * also this assumption will hold good. We can iteratively keep checking if the binary search properties are met or not ( element at mid 
 * should be greater than element at low; and element at high should be greater than element at mid). 
 * If the condition is not met on one side, we can start our search on the other side. 
 * The function returns the position once it finds the target. If target element is not found, -1 is returned.
 */

class RotatedSortedArraySearch {
	
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while(low <= high) {
			// find middle element
			int mid = low + (high-low)/2;
			if(nums[mid] == target) {
				return mid; //return when target element matches the element at mid
			}
			if(nums[low] < nums[mid]) {
				// check if binary search property holds true
				if(nums[low] <= target && nums[mid] > target) {
					high = mid-1;
				}
				//if above conditions are not met, search on the other side of mid
				else {
					low = mid+1;
				}
			}
			else {
				// similar comparison as above for right side of the middle element
				if(nums[mid] < target && nums[high] >= target) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
			}
		}
        return -1; //return -1 if element not found in array
    }
	
	public static void main(String[] args) {
		RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
		int result;
		int[] nums = {4,5,6,7,0,1,2};
		int target = 1;
		result = obj.search(nums, target);
		System.out.println(result);
	}
}
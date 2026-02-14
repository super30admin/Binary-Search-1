// 33. Search in Rotated Sorted Array
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// 

// Your code here along with comments explaining your approach in three sentences only

//Approach 
// 1) find the mid element
// 2) Sort the left oarray of the mid element
// 3) Sort the right array of mid element
// 4) return if found the target 

public class BinarySearch2 {
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;

        // Left half sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        // Right half sorted
        else {
            if (target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    return -1;
    }
}
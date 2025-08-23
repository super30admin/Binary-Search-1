// Time Complexity : O(log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only
/**
 * When dividing the data by pivot to search for, either left or right subarray will always be sorted
 * Focusing on the sorted array and trying to find if the data belongs in that window
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // target found
            if (nums[mid] == target)
                return mid;

            // left subarray is sorted
            else if (nums[left] <= nums[mid]) {
                // if the target belongs left sub-half
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                // if the target belongs to right sub-half
                else
                    left = mid + 1;
            }

            // right subarray is sorted
            else {
                // if the target belongs to right sub-half
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                // if the target belongs to left sub-half
                else
                    right = mid - 1;
            }
        }

        // no match found
        return -1;
    }
}
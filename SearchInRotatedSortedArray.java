// Problem: Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity: O(log N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // We use this to prevent integer overflow 
            // when adding values closer to Integer.MAX_VALUE then adding both these number would result in integer overflow
            // low + (high - low)/2 results to bring the numbers in bound 
            int mid = low + (high - low) / 2;

            // Check if target is the middle item if yes then return index of target
            if (nums[mid] == target)
                return mid;
    
            // Check if it's left sorted
            if (nums[low] <= nums[mid]) {
                // Check if the values lies in the range
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Below we are use right is sorted as if didn't pass
            else {
                // Check if the values lies in the range
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
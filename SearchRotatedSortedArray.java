// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The overall approach is to consider the first element as 0th index (low) and last element as high Index in the array.
 * The idea is whenever we find a pivot index in the array, either left or right side is sorted.
 * Based on the sorted and unsorted part, we apply binary search.
 */


class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        
        int low = 0;
        int high = length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (mid+1 <= high && nums[mid+1] <= nums[high]) {
                // right part is sorted
                if (target >= nums[mid+1] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                
            } else {
                // left part is sorted
                if (mid-1 >= 0 && target >= nums[low] && target <= nums[mid-1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }
}
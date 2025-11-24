// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// No major issues—just had to correctly identify which half of the array is sorted
// and avoid getting stuck in infinite loops when adjusting boundaries.

// I use binary search and determine which side of the array is sorted at every step.
// Once I know the sorted half, I check if the target lies inside that range and narrow the search accordingly.
// This guarantees O(log n) search time even when the original sorted array has been rotated.class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Check which side is sorted
            if (nums[left] <= nums[mid]) { 
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // target in left side
                } else {
                    left = mid + 1;  // search right side
                }
            } else { 
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // target in right side
                } else {
                    right = mid - 1; // search left side
                }
            }
        }

        return -1; // not found
    }
}


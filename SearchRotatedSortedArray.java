// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        if (nums == null || nums.length ==0) {
            return -1;
        }

        while (low <= high) {
            mid = low + (high - low)/2;

            // If target is the middle element
            if (nums[mid] == target) {
                return mid;
            }

            // is left side sorted ?
            if(nums[low] <= nums[mid]) {
                // If target in the left sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                // right side is sorted
                // Check if target in the right sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
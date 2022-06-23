// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoiding integer overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) // checking which part of the array is sorted (left part is sorted)
            {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right part of the array is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;

    }
}
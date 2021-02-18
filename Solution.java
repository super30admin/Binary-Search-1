// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Search in a rotated sorted array.
 */
class Solution {
    //1. Init
    //2. Do Binary search
    //  2.1 Check if left is sorted
    //  2.2 Check if right is sorted
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {

            int mid = i + (j - i) / 2;

            if (nums[mid] == target) return mid;

            if (nums[i] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[i])
                    j = mid - 1;
                else
                    i = mid + 1;
            }

            if (nums[mid] <= nums[j]) {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                }
                else
                    j = mid - 1;
            }
        }
        return -1;
    }
}
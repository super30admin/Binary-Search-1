// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target)
                return mid;
            else {
                // check if left side is sorted
                if (nums[low] <= nums[mid]) {
                    // check if target is in this range
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }
                }
                else {
                    // check if right side is sorted
                    if (nums[mid] <= nums[high]) {
                        // check if target is in this range
                        if (target > nums[mid] && target <= nums[high]) {
                            low = mid + 1;
                        }
                        else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
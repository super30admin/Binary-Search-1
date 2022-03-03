// Time Complexity : O(log n) where n is the size of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    if (target == nums[mid]) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    if (target == nums[mid]) {
                        return mid;
                    }
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    if (target == nums[mid]) {
                        return mid;
                    }
                    low = mid + 1;
                } else {
                    if (target == nums[mid]) {
                        return mid;
                    }
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
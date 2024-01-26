/* Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach in three sentences only
Eliminated half of array with each pass; Running binary search on a half only if it is
sorted and the target lies in the range.
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            // prevent memory overflow
            mid = low + (high - low) / 2;
            if (target == nums[mid])
                return mid;

            // try to find in whichever side is sorted
            // left side is sorted
            if (nums[low] <= nums[mid]) {
                // target exists in the range
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right side is sorted
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}
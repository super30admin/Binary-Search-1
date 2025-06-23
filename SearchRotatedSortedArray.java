// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Used binary search to locate the target in a rotated sorted array.
// At each step, determine which half of the array is sorted (left or right).
// Narrow the search space based on where the target could possibly lie.

class Solution {
    public int search(int[] nums, int target) {
        // Edge case: empty input
        if (nums == null || nums.length == 0 ) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            // Found the target
            if (target == nums[mid]){
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                // Target lies within the sorted left half
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else { // Target is in right half
                    low = mid + 1;
                }
            }
            else { // Right half is sorted
                // Target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {  // Target is in left half
                    high = mid - 1;
                }
            }
        }
        // Target not found
        return -1;
    }
}
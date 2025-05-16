/*
 * Searches for a target in a rotated sorted array using modified binary search.
 * 1. Standard binary search is adjusted to account for the rotated pivot.
 * 2. At each step, determines if the left or right half is sorted.
 * 3. Narrows search range based on whether the target lies in the sorted half.

 * - If nums[mid] >= nums[l]: left half is sorted → check if target lies in [l, mid), otherwise search right
 * - Else: right half is sorted  → check if target lies in (mid, r], otherwise search left
 */

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        // If there's only one element, check it directly
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            // If target is found at mid
            if (nums[mid] == target)
                return mid;

            // If left half is sorted
            if (nums[mid] >= nums[l]) {
                // Check if target lies in the left half
                if (nums[mid] > target && nums[l] <= target)
                    r = mid - 1; // move left
                else
                    l = mid + 1; // move right
            } else {
                // Right half is sorted
                // Check if target lies in the right half
                if (nums[mid] < target && nums[r] >= target)
                    l = mid + 1; // move right
                else
                    r = mid - 1; // move left
            }
        }

        // Target not found
        return -1;
    }
}

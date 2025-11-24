// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Understanding how to expand boundaries safely using the reader.get()
// and avoiding overflow or infinite loops while searching.

// I first expand the search window exponentially until the right bound is guaranteed to be >= target.
// After determining the proper search range, I apply a standard binary search using reader.get().
// This ensures O(log n) performance even though the length of the array is unknown.
class Solution {
    public int search(ArrayReader reader, int target) {

        // 1. Expand search bounds exponentially until target is within range
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        // 2. Now apply binary search between left and right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = reader.get(mid);

            if (val == target) return mid;

            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }
}


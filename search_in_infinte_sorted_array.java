// Time Complexity : O(log k), where k is the index of the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

 /**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // First expand the search boundary exponentially until high is large enough to include the target.
        // Then perform binary search within that range to find the target efficiently.
        // This works well for unknown-sized sorted arrays because it avoids needing the array length.
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = reader.get(mid);

            if (value == target) return mid;
            if (value > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
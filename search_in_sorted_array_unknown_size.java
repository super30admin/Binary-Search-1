/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Space Complexity: O(1)
// Time Complexity: O(log(N))
// Did this code successfully run on Leetcode : Yes
 class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        if (reader.get(left) == Integer.MAX_VALUE) {
            return -1;
        }

        // Point right to the maximum possible value of the array
        // as provided in the "constraints"
        int right = 10000;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int midElement = reader.get(mid);

            // Target found
            if (target == midElement) {
                return mid;
            }
            // Target lesser than mid, search left space
            else if (target < midElement) {
                right = mid - 1;
            }
            // Target greater than mid, search right space
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
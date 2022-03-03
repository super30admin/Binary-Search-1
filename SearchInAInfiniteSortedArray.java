// Time Complexity : O(log n to the base 2) where n is the number for elements present in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int i = 0;
        while (target >= reader.get(i)) {
            i = (int) Math.pow(2, i);
        }
        int low = 0, high = i, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;

            if (reader.get(mid) < target) {
                low = mid + 1;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
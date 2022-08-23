/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time complexity: O(logn)
// Space complexity: O(1)
// Approach - we basically take our low as 0 and high as 1. Then we check if the high element is less than the target. If so, we double are target and make low as are previous high. This way we will find the search space where our element lies. Then perform regular binary search.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (target > reader.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
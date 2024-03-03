// Time Complexity : O(logm + logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/description/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        int l = 0;
        int r = 1;
        while (reader.get(r) < target) {
            l = r;
            r = 2*r;
        }
        while (l <= r) {
            int mid = l + (r-l) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}


// Time complexity O(logn)
// Space complexity O(1)

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int lo = 0;
        int hi = 1;

        while (reader.get(hi) != INT_MAX) {
            hi = hi*2;
        }

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
};
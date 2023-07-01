// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
//To find out the range of the target element, I would start my range with low = 0 and high =1
// Then iterate making low equal to high and by doubling high every time
//When we find the range, we start with binary search on that range

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 1;
        while (reader.get(r) < target) {
            l = r;
            r = r * 2;
        }
        int mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
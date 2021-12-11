
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
 

class Solution {
public int search(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }

        int l = 0;
        int r = 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int medianNum = reader.get(m);

            if (medianNum == 2147483647 || medianNum > target) {
                r = m - 1;
            } else if (medianNum < target) {
                l = m + 1;
                r = l + r;
            } else {
                return m;
            }
        }
        return -1;
    }
}
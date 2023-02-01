/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) {
            return 0;
        }
        int l = 0, r = 1;
        while(reader.get(r) < target) {
            l = r;
            r = r * 2;
        }

        while(l <= r) {
            int m = l + (r - l) / 2;
            int num = reader.get(m);
            if(num == target) {
                return m;
            } else if(num < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        return search(reader, target, 0, 9999);
    }

    private int search(ArrayReader reader, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = i + (j - i)/2;

        int midval = reader.get(mid);
        if (midval == target) {
            return mid;
        } else if (midval == 2147483647
                   || (reader.get(i) <= target && midval > target)) {
            return search(reader, target, i, mid - 1);
        } else {
            return search(reader, target, mid + 1, j);
        }
    }
}

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time - O(log n)
// space - O(1)
// double the search space each time untill target lies in it. Then binary search.
class Solution {

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (target > reader.get(high)) {
            low = high;
            high = 2 * high;
        }

        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

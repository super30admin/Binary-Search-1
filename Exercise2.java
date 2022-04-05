/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
//Time Complexity O(logn)
//Space Complexity O(1)

class Solution2 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        return binarySeach(reader, low, high, target);
    }

    private int binarySeach(ArrayReader reader, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
/*
 * Time Complexity : O(Log N)
 * Space Complexity: O(1)
 * */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
public class SearchInUnknowArraySize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (reader.get(middle) == target) {
                return middle;
            } else if (reader.get(middle) < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}

public class SearchUnknownSortedArray {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * public int get(int index) {}
     * }
     */

        public int search(ArrayReader reader, int target) {
            int low = 0;
            int high = 1;

            while (reader.get(high) < target) {
                low = high;
                high = high * 2;
            }

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (reader.get(mid) == target)
                    return mid;
                if (reader.get(mid) > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }
    }

/**
 * Time Complexity: O(log N)
 * The high index doubles each time (high = high * 2), creating an exponentially growing search range.
 * This phase runs in O(log N) time, where N is the position of the target or the length of the array.
 * <p>
 * Space Complexity: O(1) - Only a few integer variables (low, high, mid) are used,
 * requiring constant space.
 */
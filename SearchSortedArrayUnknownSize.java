// Time Complexity : O(log m + log n) [m->Find Range  n->Binary Search]
// Space Complexity : O(1)

public class SearchSortedArrayUnknownSize {
    /**
     * This is ArrayReader's API interface.
     * You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * public int get(int index) {}
     * }
     */

    class Solution {
        public int search(ArrayReader reader, int target) {
            int low = 0;
            int high = 1;
            while (reader.get(high) < target) {
                low = high;
                high = 2 * high;
            }

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (reader.get(mid) == target) {
                    return mid;
                }
                if (reader.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}

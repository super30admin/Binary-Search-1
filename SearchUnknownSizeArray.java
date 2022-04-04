// Time Complexity : log(n) for both
// Space Complexity : O(1) for both
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I could not come up with the fast pointer solution, had to see the hint

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
public class SearchUnknownSizeArray {
    /*
     * This is simple solution assuming the end of the array would be
     * INTEGER.MAX_VALUE. Otherwise this would not work
     */

    public int searchIntegerMaxArray(ArrayReader reader, int target) {
        int i = 0, j = Integer.MAX_VALUE;
        if (reader.get(j) < target)
            return Integer.MAX_VALUE;

        while (i < j) {
            int mid = i + (j - i) / 2;
            if (reader.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return reader.get(i) == target ? i : -1;
    }

    /*
     * fast pointer approach - one pointer will run 2x places ahead to search the
     * correct window in which the element might exist
     */
    public int search(ArrayReader reader, int target) {

        if (reader.get(0) == target)
            return 0;

        // search right window
        int left = 0, right = 1;
        while (reader.get(right) < target) {

            // Fastforward the pointer to 2x
            right *= 2;
            // move left pointer to start of the next window
            left = right + 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (reader.get(mid) == target)
                return mid;
            if (reader.get(mid) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}

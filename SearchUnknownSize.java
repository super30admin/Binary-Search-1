/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : No, Premium required
 * // Any problem you faced while coding this : No
 */

public class SearchUnknownSize {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi * 2;
        }
        int low = hi / 2;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if ( val > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

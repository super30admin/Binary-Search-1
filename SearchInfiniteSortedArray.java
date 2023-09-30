// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : unable to expand the search space gradually by 2
/**
 * Brute Force: Either use lo = 0, hi = INT_MAX => apply Binary Search
 * TC: O(log INT_MAX) => very high and always high
 * 
 * Better: lo = 0,
 * if target > hi => expand hi as hi * 2
 * if target < hi => apply Binary search [0, hi]
 * TC: O(2 log hi)
 * 
 * Optimal: lo = 0,
 * if target > hi => lo = hi, hi = hi * 2
 * if target < hi => apply Binary search [lo, hi]
 * TC: O(log hi) + O(log k) => k = [lo, hi]
 * therefore, TC: O(log hi)
 */
/**
 * SC: O(1)
 */
public class SearchInfiniteSortedArray {

    public SearchInfiniteSortedArray() {

    }

    public int search(ArrayReader reader, int target) {
        int lo = 0;
        int hi = 1;
        int mid;
        /**
         * TC: O(log hi)
         */
        while (lo <= hi) {
            if (reader.get(hi) < target) {
                lo = hi;
                hi = (1 << hi);
            } else {
                break;
            }
        }
        /**
         * TC: O(log k)
         * 
         * k = hi - lo
         */
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }

            if (reader.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

}
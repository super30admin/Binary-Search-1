// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {

        if(reader.get(0) == target) return 0;

        int low = 0, high = 1;
        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while(low <= high) {

            int mid = low +(high - low) / 2;

            if(reader.get(mid) == target) {
                return mid;
            } else if(target > reader.get(mid)) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}

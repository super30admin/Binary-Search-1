// Time Complexity : O(log(target) + log(high - low))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//  identifying a feasible search range exponentially by factor of 2 to fond the probable high value and
//  using binary search to locate the target
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Problem3 {

    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target)
        {
            high = high * 2;
        }
        return binarySearch(reader, target, low, high);
    }

    public int binarySearch(ArrayReader reader, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(reader.get(mid) == target) {
                return mid;
            }
            else if(target < reader.get(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
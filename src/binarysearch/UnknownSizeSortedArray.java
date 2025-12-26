/*
Double the high index until the target is within range.
Perform binary search between low and high.
Time Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */

package binarysearch;

public class UnknownSizeSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while ( reader.get(high) <target ) {
            low = high;
            high = high *2;
        }
        while (low <= high) {
            int mid = low + (high - low)/2;
            int val = reader.get(mid);
            if (val == target) return mid;
            if (reader.get(mid) >= target) {
                high = mid - 1;
            }
            else if (reader.get(mid) <= target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}

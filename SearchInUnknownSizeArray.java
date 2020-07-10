// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I do
// Any problem you faced while coding this : no, I do not have a premium leetcode account


// Your code here along with comments explaining your approach
// we don't know the size of the given array, so low and high are unknown.
// so, I keep two pointers fast and slow at the begin of the array and increment fast and slow by some range,
// each time checking if target lies within the current range.
// Now I can't  keep incrementing fast and slow one element at a time, instead I double the range,
// so that the number of comparisons to find actual range of values is low.

public class SearchInUnknownSizeArray {
    int searchInUnknownSizeArray(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (low <= high) {
            if (reader.get(high) < target) {
                low = high;
                high = high * 2;
            }
        }

        return searchTarget(reader, low, high, target);
    }

    private int searchTarget(ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

interface ArrayReader {
    public int get(int index);
}

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : log(n)+log(n) = O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Instead of breaking the array into half, double the size of the array repeatedly starting from 2 to find its low and high.
// They apply regular binary search with these low and high

public class SearchInSortedArrOfUnknownSize {

    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while(low <= high) {

            int mid = low + (high-low)/2;

            if(reader.get(mid) == target)
                return mid;
            else if(target < reader.get(mid))
                high = mid -1;
            else
                low = mid + 1;
        }

        return -1;
    }
}

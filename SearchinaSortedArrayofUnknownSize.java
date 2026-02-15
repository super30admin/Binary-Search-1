// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
We need to find the range of low and high by iteratively comparing the array's high value to target through
reader API call by starting at small values set to low and high and then slowly multipliying the high
by 2 because we want to maintain the range find logic and search logic later in a balanced way at log n
complexity. Once we find the range, we do regular binary search to check the target and return its index.
 */
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target)
                return mid;
            else if(target < reader.get(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
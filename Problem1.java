/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        //increase high pointer two times to find the range where target value resides
        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        //apply binary search when we find the range of target value, if we dont find it return -1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
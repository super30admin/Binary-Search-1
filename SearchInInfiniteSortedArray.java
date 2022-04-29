// Time Complexity : O(log N). To be precise O(T) T = index of target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        //identify the boundary in which element lies
        int left = 0;
        int right= 1;
        while(reader.get(right) < target) {
            left = right;
            right <<=1;
        }
        
        // perform binary search with in the boundary
        int mid;
        int num;
        while(left <= right) {
            mid = left + (right - left) / 2;
            num = reader.get(mid);
            if(num > target) {
                right = mid-1;
            } else if(num < target) {
                left  = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 
 class Solution {
    public int search(ArrayReader reader, int target) {
        // 1. find range
        // increase right pointer by 2, whenever target is not found, and set left to right
        // 2. do normal BS on left and right
        int left = 0, right = 1;
        while(reader.get(right) < target)
        {
            left = right;
            right *= 2;
        }
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            if(reader.get(mid) < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }
}
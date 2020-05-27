/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log K) where K is the index of target in Array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class Solution {
    public int search(ArrayReader reader, int target) {
        //base case
        int l = 0;
        int r = 1;
        while(reader.get(r) < target) {
            l = r;
            r = r * 2;
        }
        //binary search
        while ( l <= r ) {
            int mid = l + (r - l) / 2;
            int inp = reader.get(mid);
            if(inp == target) return mid;
            else if (inp < target) l = mid + 1;
            else r = mid - 1;
        }
        //return when no element matches
        return -1;
    }
}



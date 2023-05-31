// Time Complexity : O(log(n))
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

        // we need an idx where element > target
        int r = 1;
        while (reader.get(r)<=target) r = r*2; // this will get r in O(log(n))

        int l = r/2;

        while (l<=r) {
            int mid = (r-l)/2 + l;

            if (reader.get(mid) == target) return mid;

            if (reader.get(mid) > target) r = mid-1;
            else l = mid+1; 
        }

        return -1;
    }
}
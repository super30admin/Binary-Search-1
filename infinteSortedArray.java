// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //if item found at 0, return 0
        if(reader.get(0) == target) return 0;
        
        int l=0, r=1;

        //if target greater than item at r, increase l and r
        while(reader.get(r) < target) {
            l = r;
            r = r*2;
        }
        
        int mid,n;

        //binary search
        while(l<=r) {
            mid = l + (r-l)/2;
            
            n=reader.get(mid);
            
            if(target == n) {
                return mid;
            } 
            
            if(target > n) {
                l = mid+1;
            } else {
                r = mid -1;
            }
        }
        
        return -1;
    }
}
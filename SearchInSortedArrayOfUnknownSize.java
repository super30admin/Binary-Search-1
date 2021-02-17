// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
		// Initialize left to 0 and right to 1
        int l=0, r=1;
		// We do this to find where our target lies between l and r
        while(reader.get(r) < target){
            l=r;
            r=r*2;
        }
		// Binary search process in the above found values l and r
        while(l <= r){
            int mid = l + (r-l)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
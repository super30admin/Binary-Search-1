// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(logn), where n is 10^4. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution3 {
    public int search(ArrayReader reader, int target) {
        //since the constraints specify secret.length can be between 1 and 10^4, setting the low to 0 and high to 9999 and performed binary search. 
        int low = 0, high = 9999;
        while(low<=high) {
            int mid = low + (high-low)/2;
            int val = reader.get(mid);
            if (val == target)
                return mid;
            if(val == Integer.MAX_VALUE - 1 || target < val) high = mid-1;
            else low=mid+1;
        }
        return -1;
    }
}
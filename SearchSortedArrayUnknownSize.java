// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// The idea is to find the last valid element from the reader using Binary Search and the given constraint
// Once the last valid element is found, use that element as the the end element of the array and perform Binary Search to find the target element in the given range.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 10000;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) != 2147483647) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }               
        }
        
        int end = low - 1;
        low = 0;
        
        while(low <= end) {
            int mid = low + (end-low)/2;
            
            if(reader.get(mid) == target)
                return mid;
            
            if(reader.get(mid) < target) {
                low = mid + 1; 
            } else {
                end = mid - 1;
            }               
        }
        
        return -1;
    }
}
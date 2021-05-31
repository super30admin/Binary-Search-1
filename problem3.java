// Time Complexity : O(logn)
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
        
        int low = 0, high = 1;
        
        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;    // double the search space
        }
        return binarySearch(reader, target, low, high);
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        
        while(low <= high) {
            
            int mid = low + (high-low)/2;
            
            if(reader.get(mid) == target)  //if we found the target
                return mid;
            else if(reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
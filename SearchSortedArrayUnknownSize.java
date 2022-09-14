// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == Integer.MAX_VALUE)
            return -1;
        
        int low = 0;
        int high = 1;
        
        while(reader.get(high) <= target){
            low = high;
            high = high * 2;
        }
        
        return binarySearch(reader, target, high, low);
    }
    
    private int binarySearch(ArrayReader reader, int target, int high, int low){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == reader.get(mid))
                return mid;
            else if(target > reader.get(mid)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}

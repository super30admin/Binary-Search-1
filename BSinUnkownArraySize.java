//Searching an array of unknown size
// Time Complexity : O(logn)
// Space Complexity :
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
        
        int low = 0;
        int high = Integer.MAX_VALUE; // took the max integer value for end element index
        
        while(low <= low){
            int mid = low + (high - low)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid) < target){
                low = mid +1;
            }
            else{
                 high = mid -1;
               
            }
        }
        return -1;
}
}
// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
// Search in Infinite sorted array
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
        int high = 1;
        int mid;
        if(reader.get(0) == target){
            return 0;
        }
        while (reader.get(high) < target){
            low = high;
            high = high*2;
        }
        while(low <= high){
            mid = low + (high - low) / 2;
            if (target == reader.get(mid)){
                return mid;
            }
            if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
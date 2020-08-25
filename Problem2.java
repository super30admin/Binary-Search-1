
// Problem2 - 702. Search in a Sorted Array of Unknown Size

// Time Complexity : O(log n) where n is the index of target 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had an idea about 
// the approach since it was already discusses in class.


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
        while(target >= reader.get(high)){
            low = high;
            high = high * 2;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(target == reader.get(mid)){
                return mid;
            }
            if( reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }return -1;
    }
}
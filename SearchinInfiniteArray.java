/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 /*
Approach: In a rotated sorted array one side of the mid will always be sorted! 
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // loop through until you find and element greater than target
        while(reader.get(high) < target){
            low = high;
            high = high * 2; // to have balanced operations
        }

        // binary search to find target
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target){
                low = mid + 1;
            }
            else 
                high = mid - 1;
        }
        return - 1;
    }
}
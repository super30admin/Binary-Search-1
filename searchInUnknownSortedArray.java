/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
 

/**
 * Double the search space untill the target is lesser then high pointer.
 * Then implement binary search based on low and high pointers.
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high) < target){
            low = high + 1;
            high *= 2;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            int currValue = reader.get(mid);
            if(currValue == target){
                return mid;
            }else if(currValue > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }
}

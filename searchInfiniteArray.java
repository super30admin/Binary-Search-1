 /** Time Complexity: O(log n)
    Space Complexity: O(1)
    Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
  */

  /**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
 
 /**Approach
  * 1st check is to check if array contains only 1 element
 to implement binary search here, we start with low = lowest index ie 0 
 and since we do not know where the array ends, we start with high = 1.
 each time we go thru the array, we check 
 1. if the element to be found the target is greater than the value at index high
 if the value is greater then we increase our range by two times
 2. Once the range is found, we perform binary search on the array  */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0; //1 element in the array
        int low = 0, high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
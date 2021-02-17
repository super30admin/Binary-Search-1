/*Time Complexity :O(log(n))
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No
Your code here along with comments explaining your approach
The most important step here is to find the range for the binary search.
we know the array[0] value and the target. Since the arrays is sorted that means that 
the target would be withing target-array[0] as we are increasing one by one until we reach the target.

*/
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int start = reader.get(low);
        int high = target - reader.get(low);

        while(low <= high){

            int mid = low + (high -low)/2;
            if(reader.get(mid)==target)return mid;
            else if(reader.get(mid) > target)high = mid -1;
            else low = mid + 1;
        }
        return -1;
        
        
    }
};
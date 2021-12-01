
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Here we start from high = 1 and low = 0. And we find appropriate high which is equal to target or before which target can lie. 
 * 2. While doing this we multiply high by 2 in order to search in log time. We also store previous high in low. 
 *    This reduces total number of elements in which final search is to be done.
 * 3. Once high and low pointers are finalized, i.e. once high > target we finalize high and low. Or else if high == target, we simply return high.
 * 4. But if not found yet, then we apply binary search between low to high, inclusive which gives us ans in log time.


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
        
        while(high <= 10000){
            if(reader.get(high) == target)return high;
            else if(reader.get(high) > target)break;
            else{
		low = high;
                high = high * 2;
            }
        }
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(reader.get(mid) == target)return mid;
            else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return -1;
        
    }
}
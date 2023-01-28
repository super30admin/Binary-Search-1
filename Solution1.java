// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// I initially set low to be equal to 0 and high as 1. Until target is less then element at index high, low is set to high and high is multipled into 2, then we perform binary search. If element doesn't exist, we return -1.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution1 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high)<target)
        {
            low = high;  
            high = high*2;
            
        }

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid)>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}
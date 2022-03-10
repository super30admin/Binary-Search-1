/**
// Time Complexity : O(logn) 
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int low=0, high = 1;
        
        while(target > reader.get(high))
        {
            low = high;
            high = 2*high;
        }
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(target==reader.get(mid))
                return mid;
            else if (target < reader.get(mid))
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
        
    }
}
// Time Complexity : O(Log(Index))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution 
{
    public:
        int search(const ArrayReader& reader, int target) 
        {
            int low = 0;
            int high = 1;
            
			if(reader.get(low)==target)
                return low;
			
            // get search space first
            while(reader.get(high)<target)
            {
                low = high;
                high = high<<1;
            }
            
			
			// do binary search in above search space
            while(low <=high)
            {
                int mid = low+ (high-low)/2;
                
                int val = reader.get(mid);
                if(val == target)
                    return mid;
                
                if(val>target)
                    high = mid-1;
                
                else
                    low = mid+1;
            }
            
            return -1;
        }
};
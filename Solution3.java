// Leetcode problem : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * I first set low as 0 and high as 1. I run a loop until reader.get(high)<target and in each iteration I set low = high and high = high * 2. I then perform Binary search with low and high as the limits of the
 * boundary.
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high)<target)
        {
            low = high;
            high *=2;
        }
        return bsearch(reader,target,low,high);
    }

    public int bsearch(ArrayReader reader, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}
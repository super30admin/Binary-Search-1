// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// We need to find high and low pointers to do a subsequent binary search
// We move the high pointer by a factor 2x till we reach a point where we know the target is within that range

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0; int high=1;
        while(reader.get(high)<target) 
        {
            low = high; //ignore elements prior to high as we know array is sorted
            high = high*2; //move high pointer by 2x
        }

        while(low<=high){ //binary search
            int mid = low+ (high-low)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                low = mid+1;
            else
                high = mid-1;

        }
        return -1;
    }
}
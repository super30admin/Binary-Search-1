// Time Complexity :log m
// Space Complexity : (log m + log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The two pointers low and high, point to first two elements, which if not greater than or equal to target will be increasing the search space
// by double. And once the high and low are set to the range where the target can lie, binary search can be applied to find the key.


class Solution {
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high =1;

        while(reader.get(high)<target){
            low = high;
            high = 2*high;
        }

        while(low<=high){
            int mid = low+(high - low)/2;

            if(reader.get(mid)==target){
                return mid;
            } else if(target< reader.get(mid)){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
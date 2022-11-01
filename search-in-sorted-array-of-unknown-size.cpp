// Time Complexity : O(log(10^4))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Logic: had to find the limits in log time coz BS was log time

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        //find the limits
        int l = 0, r = 1;
        int outOfBoundary = ((long)(1<<31) - 1);
        while(reader.get(r) != outOfBoundary)   {
            if(target >= reader.get(r)) l = r;
            r *= 2;
        }
        
        //do binary search
        while(l <= r)   {
            int mid = l+(r-l)/2;
            int value = reader.get(mid);
            if(value == target)   return mid;
            else if(value == outOfBoundary || target < value)    r = mid-1;
            else    l = mid+1;
        }
        return -1;
    }
};
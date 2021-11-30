//Time Complexity: O(logn)
//Space Complexity: constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;
        int lo = 0;
        int hi = 1;
        while(reader.get(hi) < target){
            lo = hi + 1;
            hi = 2*hi;
        }
        while(lo <= hi){
            int mid = lo + (hi -lo)/2;
            int val = reader.get(mid);
            if( val == target)
                return mid;
            if(val > target)
                hi = mid -1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}

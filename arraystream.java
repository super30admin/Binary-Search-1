// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
  public int search(ArrayReader reader, int target) {
    int lo = 0,hi = 1;
    if(reader.get(0)==target)
        return 0;
    while(reader.get(hi) < target)
        {
            lo = hi;
            hi = 2*hi;
        }
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(reader.get(mid)==target)
            return mid;
        else if(reader.get(mid) > target)
            hi = mid -1;
        else
            lo = mid+1;
    }
    return -1;
    
  }
}

// Time Complexity :O(log n ) 
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r=1;
        int mid;

        //finding max size
       while (reader.get(r) < target){
           //adding l= r missing condition
           l = r;
           r = r * 2;
              }

        //finding minimum
        while(l<=r)
        {
            mid = (l+r)/2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (reader.get(mid) >= target) 
            r = mid-1;
            else 
            l = mid+1 ;      
        }
         return -1;

}}

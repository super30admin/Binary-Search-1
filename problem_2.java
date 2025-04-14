// Time Complexity : O(lgn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes

import java.util.*;
class Solution {
    public int search(ArrayReader reader, int target) {
        int r = findRight(reader);
        int l=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
    
    public int findRight(ArrayReader reader) {
        int l=0;
        int r = 10000;
        int mid=0;
        while(l<r){
            mid = l+(r-l)/2;
            if(reader.get(mid)==Integer.MAX_VALUE)
            {
                r=mid;
            }
            else
                l=mid+1;
        }
        return mid;
    }
}

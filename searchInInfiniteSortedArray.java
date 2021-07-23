// Time Complexity : O(Log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class Solution {
    public int search(ArrayReader reader, int target) {
        
        int r = 1;
        while (reader.get(r) < target)
         r *= 2;
     
        int l = r/2;

        while (l <= r) {
            int m = l+(r-l)/2;

            if (reader.get(m) == target)
             return m;
            else if (reader.get(m) < target)
             l = m+1;
            else r = m-1;
        }
        return -1;
    }
}
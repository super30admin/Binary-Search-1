// Time Complexity : O(logn) actually O(2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// keep doubling r and update l until r is greater than target. Now use binary search to find target between l and r.

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 1;
        while(l<=r){
            if(target > reader.get(r)){
                l = r;
                r *= 2;
            } else {
                int mid = l + (r-l)/2;
                if(target == reader.get(mid)) return mid;
                if(target > reader.get(mid)) l = mid+1;
                else r = mid -1;
            }
        }
        return -1;
    }
}
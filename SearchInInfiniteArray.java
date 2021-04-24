// Time Complexity : O(log n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Didn't have Leetcode Premiuim, so couldn't try
// Any problem you faced while coding this : No

/*
    We increasse the search space by 2X, each time we are unable to find the target in the range.
    Once we know that the target lies in the range we run a binary search to find the index.
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        
        if (nums == null || nums.length == 0) return -1;
        
        int low = 0; 
        int high = 1;
        
        while (reader.get(high) != Integer.MAX_VALUE && target < reader.get(high)){
            low = high;
            high = low*2;
        }
        
        while (low<=high){
            mid = low+(high-low)/2;
            int val = reader.get(mid);

            if(val > target) high = mid - 1;
            else if(val < target) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
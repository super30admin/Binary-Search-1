// Time Complexity : O(log m) - m is the position of the target.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much, once the idea to find the search place is cracked, it was a straight binary search on the space.

// Your code here along with comments explaining your approach


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(reader.get(high) < target){
            low = high ;
            high = high * 2;
        }
        //binary search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
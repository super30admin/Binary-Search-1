// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach in three sentences only
//double the space when target is not found
//move the low to high
//do binary search in the given space when the range is found. Adding a safety check so that the loop wont break and throw error.

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) != Integer.MAX_VALUE && reader.get(high) <= target){
            low = high;
            high = 2* low;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if (target == reader.get(mid)){
                return mid;
            }else if (target > reader.get(mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
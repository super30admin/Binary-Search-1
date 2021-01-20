// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        
        // increase high pointer 2x to get to upper bound of search array
        while (reader.get(hi) < target) {
            hi = hi * 2;
        }
        // target will be betwenn high last value and current value so low = high/2
        int low = hi / 2;
        
        // Do binary search on array
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if ( val > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

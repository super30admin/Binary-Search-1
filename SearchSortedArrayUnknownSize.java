// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The approach is to apply binary search starting with low = 0 and high = 0.
 * We increase the high index if we need to need to search forward but we cut down the search space in half based on the decision.
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int midNumber = reader.get(mid);
            
            if (midNumber == Integer.MAX_VALUE) {
                high = mid - 1;
                continue;
            }
            
            if (midNumber == target) {
                return mid;
            } else if (target > midNumber) {
                low = mid + 1;
                high = (mid + 1) * 2;
            } else {
                // target < midNumber
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Keep 2 pointer low and high. Double the high index till the value at high becomes greater than or equal to target
// Perform binary search from low to the high index
// If the mid is out of bounds reject right half

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) {
                return mid;
            }
            else if(reader.get(mid) > target) {
                high = mid - 1;
            }
            else {
                low = mid +1;
            }
        }
        return -1;
    }
}
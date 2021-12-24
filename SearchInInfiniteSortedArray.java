class Solution {
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - start with low = 0 and high = 1, and till reader.get(high) is not less than target, make low equal to high and
    //high equal to twice of high. After doing this, we have a search window in which target can be found.
    //Perform Binary search on the search window. Return -1 is target not found in the search window.
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = 2*high;
        }

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
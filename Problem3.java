
//Problem 3:Search in an infinite sorted array

// Time Complexity : O(log n) + O(range) ;  range = high - low , n = number of steps
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach : Binary search
class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (reader.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1; 
    }
}

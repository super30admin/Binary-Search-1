// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Its a LC premium problem
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0, high=1;
        // Adjust your search space by manipulating low and high indexes
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        // Binary search
        while (low <= high) {
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if (target < reader.get(mid)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        // If we are unable to find the target
        return -1;
    }
}
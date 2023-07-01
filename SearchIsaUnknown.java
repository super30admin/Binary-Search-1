// Time Complexity : O(logm + logn) m is the range and logn is for binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : I do not have premium so could not run on leetcode, but have followed the exact approach done in class


// Approach
/*
Step 1 - Check if the target is at the first index, returning 0 if true.(as we are returning the index of the target not the value)
Then keep expanding the search range till we get something greater than the target,
the approach for expansion is low becomes high and high gets multiplied by 2 everytime
Finally, perform a standard binary search within our range, return the index of the target if found, or -1 if not found.
*/
public class SearchIsaUnknown {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        int low = 0, 
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while (low <= high) {
            mid = low + (high - low )/2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
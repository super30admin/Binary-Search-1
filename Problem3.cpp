// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//Search in Infinite sorted array:

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        if(reader.get(0) == target) return 0; // Check if the target is at the first position.
        if(reader.get(1) == target) return 1; // Check if the target is at the second position.
        int start = 0, end = 1; // Initialize pointers for binary search.
        while(start <= end) { // Perform binary search, dynamically expanding the search space.
            if(target > reader.get(end)) { start = end; end *= 2; } // Double the search space if target is greater than the current end value.
            else if(target <= reader.get(end)) { // Perform binary search in the current expanded space.
                int mid = start + (end - start) / 2;
                if(reader.get(mid) == target) return mid; // Return the index if target is found.
                else if(target < reader.get(mid)) end = mid - 1; // Adjust the search space based on comparison.
                else start = mid + 1;
            }
        }
        return -1; // Return -1 if target is not found in the array.
    }
};

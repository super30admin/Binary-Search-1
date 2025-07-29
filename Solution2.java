
// Approach:
// We perform a modified binary search by comparing the mid element to the ends to determine which half is properly sorted.
// Once we know which side is sorted, we check if the target lies within that sorted half and adjust our search range accordingly.
// Repeat until we find the target or exhaust the search space in O(log n) time.

// Time Complexity : O(log n)  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No  

class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0;                  // start pointer
        int right = nums.length - 1;   // end pointer
        
        while (left <= right) {
            int mid = left+(right - left) / 2;  // middle index
            
            // if mid is the target, return immediately
            if (nums[mid] == target) {
                return mid;
            }
            
            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half [left..mid] is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target lies in the sorted left half
                    right = mid - 1;
                } else {
                    // Otherwise search in the right half
                    left = mid + 1;
                }
            } else {
                // Right half [mid..right] is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target lies in the sorted right half
                    left = mid + 1;
                } else {
                    // Otherwise search in the left half
                    right = mid - 1;
                }
            }
        }
        
        // Target not found
        return -1;
    }
}


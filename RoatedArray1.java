// Time Complexity : O(log n) --> where n is size of input
// Space Complexity : O(log n) --> recursion stack space
// Did this code successfully run on Leetcode (33) : Yes
// Any problem you faced while coding this : Didn't aware of this approach


// Your code here along with comments explaining your approach
// Using Recursion
class Solution {
    
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        return binarySearch(nums, target, low, high);
    }  
    
    private int binarySearch(int[] nums, int target, int low, int high) {
        
        // base case
        if (low > high) return -1;
        
        // logic
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) return mid; 

        else if (nums[low] <= nums[mid]) { // left side sorted
            if (nums[low] <= target && target <= nums[mid]) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }

        else { // right side sorted
            if (nums[mid] <= target && target <= nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    return binarySearch(nums, target, low, high);
    }
}
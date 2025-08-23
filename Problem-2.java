// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Check if the left half or right half of the array is sorted
// check if target is in the range of the left half if not it is in the right half
// perform binary search to find the target on ther sorted half

class Solution {

    // Binary search function to search for target element in the array
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) // If element at mid is target then return the index mid
                return mid;
            else if(nums[mid] >= nums[low]) { //check if left half is sorted
                //if target is in the left half skip searching right half otherwise skip searching left half
                if(nums[low] <= target && nums[mid] > target) { 
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else { // right half is sorted
                //if target is in the right half skip searching left half otherwise skip searching right half
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            } 
        }
        // Element is not found
        return -1;
    }
}
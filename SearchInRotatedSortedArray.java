// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2; // To prevent Integer Overflow
            if(nums[mid] == target){
                return mid;
            }

            // Determining which side is sorted
            if(nums[low] <= nums[mid]){
                // Left side is sorted
                if(target < nums[mid] && target >= nums[low]){
                    high = mid - 1; // Target lies in left sorted part
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                // Right side is sorted
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1; // Target lies in right sorted part
                }
                else{
                    high = mid - 1;
                }
            }
            
        }
        return -1; // Target not found

    }
}
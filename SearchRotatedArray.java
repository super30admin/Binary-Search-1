// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
            
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            // if mid element is equal to target then return mid index
            if(nums[mid] == target) return mid;
            
            // check if left part of array is sorted
            if(nums[low] <= nums[mid]) {
                // check if the target is within left part of array's range
                if (target >=  nums[low] && target < nums[mid]) 
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // right part of array is sorted
            else {
                // check if target is within right part of array's range
                if (target > nums[mid] && target <= nums[high]) 
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
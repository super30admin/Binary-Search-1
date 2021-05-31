// Time Complexity : O(2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//One pass binary search solution
class Solution {

    public int search(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        
        if(nums == null || nums.length == 0) return -1; // check for empty array
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            
            else if(nums[low] <= nums[mid]) {  // if the left half of the array is sorted
                if(nums[low] <= target && nums[mid] > target) { // check if the target is lies within the sorted array
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else { // if the right half of the array is sorted
                if(nums[mid] < target && nums[high] >= target) // check if the target is lies within the sorted array
                    low = mid + 1;
                else
                    high = mid - 1;
                
            }
        }
        return -1;
    }
}
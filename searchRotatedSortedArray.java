// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * Check if one of the half is sorted and also check if target element lies in that range.
 * Based on this criteria, reduce the search space by half.
 */

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[low]){
                if(nums[mid] > target && target >= nums[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
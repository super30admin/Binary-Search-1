// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
        
        if(target == nums[mid]) {
            return mid;
        }
        else if(nums[low] <= nums[mid]) {
            if(nums[low] <= target && nums[mid] > target) {
            high = mid - 1; 
        }
        else low = mid + 1;
    }
        else {
            if(nums[high] >= target && nums[mid] < target){
                low = mid + 1;
            }
            else high = mid - 1;
        }
        }
        return -1;
        }
}
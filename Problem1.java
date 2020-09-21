  
// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes - Time Limit Exceeded but solved


// Your code here along with comments explaining your approach
Approach using Binary search moving towards target element by checking the sequence flow using pivot element
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        if(nums == null || nums.length == 0) return -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(target == nums[mid]) return mid;
            if(nums[left] <= nums[mid]){
                 if((target < nums[mid]) && (target >= nums[left])) right = mid-1;
                 else left = mid+1;
            }
            else{
                if(target > nums[mid] && target <= nums[right]) left = mid+1;
                else right = mid-1;
            }
        }
        return -1;
    }
}

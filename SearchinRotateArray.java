// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : looking for pivot and searching based on that


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]) left = mid+1;
            else right = mid;
        }
        int start = left;
        left = 0;
        right = nums.length-1;
        if(target >= nums[start] && target <=nums[right])
            left = start;
        else
            right = start - 1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid -1;
        }
        return -1;
        
    }
}
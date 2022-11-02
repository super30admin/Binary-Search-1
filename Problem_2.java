// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//Search in a Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while(start <= end){
            mid = (start + (end - start) / 2);
            if (nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                if((target < nums[mid]) && (target >= nums[start])){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if((target > nums[mid]) && (target <= nums[end])){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
}
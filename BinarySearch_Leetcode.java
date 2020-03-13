// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was failing a few edge cases at first as I didn't consider that nums[start] = nums[end]


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        
        while(start<=end){
        int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[start]<=nums[mid]){
                if(target >= nums[start] && target<nums[mid]){
                    end = mid-1;
                }   
                else{
                    start = mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[end]){
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
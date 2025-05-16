// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Approach :
// As in the rotated sorted array , atleast one half of the elements is alway sorted , so first I had found which find is sorted either the left part or the right part.
// If left side is sorted , I can ignore/reject the right side of array then run a binary search in the left side to find the target . 
// Similary vice versa - (i.e, if right side is sorted , I will reject the left side of the array). Continue the process.


class Solution {
    public int search(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]<=nums[mid]){ //left is sorted
                if(nums[start]<=target && target<nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(nums[mid]<target && target<=nums[end]){
                    start = mid + 1;
                }
                else{
                end = mid - 1;
                }
            }
        }
        return -1;
    }
        
    
}
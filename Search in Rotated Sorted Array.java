// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// First i will check which half is sorted onece i find the sorted half, i will check if my target lies with in that range if yes i will move low or high pointers respectivley.
// If the target dosen't lies within the sorted ranges we skip that part to search  and we move the low or high pointers to the other part of the array .
// This runs until low<= high , and if there is no target exist in array it comes out from while loop at last step it return -1. 

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
        
    }
}

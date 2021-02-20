// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I was able to get which part of array to disregard but to find whether selected space it is sorted or not was missing and it 
//got cleared after the class


// Your code here along with comments explaining your approach
© 2021 GitHub, Inc.

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            // This is straigh-forward and the best case
            if(nums[mid]==target){
                return mid;
            }
            
            else if(nums[mid]>target){
                // Normally we should high=mid-1 here but there are chances that array lies in the right half, so we check target is in the left range and 
                //whether left is actually sorted
                if(nums[low]>target && nums[mid]>=nums[low]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            
            else{
                // Normally we should low=mid+1 here but there are chances that array lies in the left half, so we check target is in the right range and 
                //whether it is actually sorted
                if(target>nums[high] && nums[mid]<=nums[high]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
    }
        return -1;
}
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1; 
        
        int n= nums.length; 
        int low=0;
        int high=n-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;   //prevent integer overflow
            if(target==nums[mid]){
                return mid;
            }
            //if left portion is sorted
            else if(nums[low]<=nums[mid]){        
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
                
            }
            //if right portion is sorted
            else{
                
                if(target>nums[mid] && target<=nums[high])
                { 
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
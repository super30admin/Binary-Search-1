
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Finding the pivot or the min element in the array


class Solution {
    
    //find the pivot using altered binary search , pivot is the min element of the array 
    //set 2 pointer - one at the begining and one at the end , and  find the pivot - 3rd pointer
    
    
    public int search(int[] nums, int target) {
        
        int left = 0 ;
        int right = nums.length-1;
        
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
            
        }
        
        //to check where the target is present in the array before pivot or array after pivot
        
        int pivot = left;
        left = 0;
        right = nums.length-1;
        
        if(target>=nums[pivot] && target<=nums[right]){
            left = pivot;
        }
        
        else{
            right = pivot;
        }
        
     //peform normal binary search on the selected array
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(target==nums[mid])
            {
                return mid;
            }
            
            if(target<nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        
        
       return -1; 
        
        
        
    }
}
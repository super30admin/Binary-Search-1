// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//1. define low , high and mid
//2. Find which side is sorted
//3. Adjust low and high accordingly and search in that particular direction

class Solution {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
        }else if(nums[low]<=nums[mid]){
                //left side is sorted
                
                if(target>=nums[low]&&target<=nums[mid]){
                    //target is in middle 
                    high=mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                //right side is sorted
                if(target>=nums[mid]&&target<=nums[high]){
                    low=mid+1;
                }else{
                    high = mid-1;
                }
            }
            
            
        }
        return -1;
        
        
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int search(int[] nums, int key) {
        
        int start=0, end=nums.length-1, mid=0;
        

        
        while(start<=end){
            mid=start+(end-start)/2;
            
            if(nums[mid]==key)
                return mid;
        
            if(nums[mid]<key){
                if(nums[mid]>=nums[end] || (nums[mid]<=nums[end] && key<=nums[end]))
                    start=mid+1;
                else
                    end=mid-1;
            }else{
                if(nums[mid]>nums[end] && key <=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
            
            
        }
        return -1;
        
        
    }
    
  
}
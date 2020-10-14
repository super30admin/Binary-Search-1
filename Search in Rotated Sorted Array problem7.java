// Time Complexity :O(logn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No 

class Solution {
    public int search(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;
        int result=binarySearch(nums,lo,hi,target);
          
        return result;
    }
    public int binarySearch(int[] nums,int lo,int hi,int target)
    {   
         
       
        while(lo<=hi)
        {
        int mid=lo+(hi-lo)/2;
        if(nums[mid]==target)
        {
            return mid;
        }
        if(nums[lo]<=nums[mid])
        {
            if(target<nums[mid] && target>=nums[lo])
            {
                return binarySearch(nums,lo,mid,target);
            }
            else
            {
                 return binarySearch(nums,mid+1,hi,target);
            }
        }
        else if(nums[mid]<=nums[hi])
        {
            if(target>nums[mid] && target<=nums[hi])
            {
                return binarySearch(nums,mid+1,hi,target);
            }
            else
            {
                return binarySearch(nums,lo,mid,target);
            }
        }
        }
        return -1;
      
    }
}

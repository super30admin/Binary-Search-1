// Time Complexity : O(logn) reduced the serach by half everytime for finding both pivot and target element
// Space Complexity : O(1) no extra data structures are used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


class Solution {
    public int find_pivot(int[] nums, int low, int high){
        if(high < low)
            return -1;
        if(high == low)
            return high;
        int mid = low+(high-low)/2;
        if(mid<high && nums[mid]>nums[mid+1])
            return mid;
        if(mid>low && nums[mid]<nums[mid-1])
            return (mid-1);
        if(nums[low]>=nums[mid])
            return find_pivot(nums,low,mid-1);
        return find_pivot(nums,mid+1,high);
        
        }
    public int BS(int[] nums, int low, int high, int target){
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (target == nums[mid])
            return mid;
        if (target > nums[mid])
            return BS(nums, (mid + 1), high, target);
        return BS(nums, low, (mid - 1), target);
    }
            
            // while(low<high){
            //     int mid = low+(high-low)/2;
            //     if(nums[mid]==target)
            //         return mid;
            //     if(nums[mid]>target)
            //         high = mid-1;
            //         //return BS(nums,low,mid-1,target);
            //     low = mid+1;
            //     //return BS(nums,mid+1,high,target);
            // }
            // return -1;
        
    
    public int search(int[] nums, int target) {
    int low=0, mid, high = nums.length-1;
        int pivot_index = find_pivot(nums,low,high);
        if(pivot_index==-1)
           return BS(nums,low,high,target);
            if(nums[pivot_index]==target)
                return pivot_index;
            if(nums[low] > target)
              return BS(nums,pivot_index+1,high,target);
        return BS(nums,low,pivot_index-1,target);
    }      
        
               
    }

// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        //calling recursive function
        return binarySearch(nums,0,nums.length-1,target);
    }
    
    public int binarySearch(int[] nums,int low,int high,int target)
    {
        int mid=low+(high-low)/2;
        if(low>high) return -1;
        if(nums[mid]==target) return mid;
        //left sorted
        else if(nums[low]<=nums[mid])
        {
         if(nums[mid]>=target && nums[low]<=target)
        {high=mid-1;}
        else{low=mid+1;}
        }//right sorted
        else 
        {
            if(nums[mid]<=target && nums[high]>=target)
            {
               low=mid+1; 
            }
            else{
                high=mid-1;
            }
        }
        //calling function again(recursion)
       return binarySearch(nums,low,high,target);
       // return -1;
    }
}
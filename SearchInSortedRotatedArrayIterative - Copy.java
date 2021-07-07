// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Index out of bound


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        //initialising the variables 
        int mid;
        int low=0;
        int high=nums.length-1;
        //while loop to iterate until the target is found
        while(low<=high)
        {
            //assigning mid as middle of the array
            mid=low+(high-low)/2;
        //if target is equal to the middle element,mid is returned
        if(nums[mid]==target)
        {
            return mid;
        }
        
        //if array is left sorted
       else if(nums[low]<=nums[mid])
        {
           //if element lies in sorted part
           if(nums[mid]>=target && nums[low]<=target)
        {high=mid-1;
         }
         else{
             //if element doesn't lie in sorted part,move to right part
             low=mid+1;
         }
            
        }
            //if array is right sorted
        else
        {
           if(nums[mid]<=target && nums[high]>=target)
           {
               //if element lies in sorted part
               low=mid+1;
            }            
            else{ //if element doesn't lie in sorted part,move to left part
               high=mid-1;}
        }
        }
        //return -1 if target doesn't lie at all
     return -1;  
    }
}
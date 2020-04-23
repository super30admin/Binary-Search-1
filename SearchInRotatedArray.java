// Time Complexity :
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
      int l=0;
      int h=nums.length-1;
      
      while(l<=h){
          int mid = l+(h-l)/2;
          
          if(nums[mid]==target)
              return mid;
          
          if(nums[l]<=nums[mid]){
              if(nums[l]<=target && target<nums[mid])
                  h=mid-1;
              else
                  l=mid+1;
          }
          
          else{
              if(target<=nums[h] && target>nums[mid])
                  l=mid+1;
              else
                  h=mid-1;
          }
      }
        
        return -1;
        
    } 
}



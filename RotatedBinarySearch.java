// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none
class Solution {
    public int search(int[] nums, int target) {
        //init low
        int l=0;
        // init high
        int h= nums.length-1;
        //iterate while l is less than high
        while (l<=h){
            // find mid
            int mid= l+(h-l)/2;
            // if mid is target, return mid
            if(target== nums[mid])
                return mid;
                // if left side is sorted
           if(nums[l]<=nums[mid]){
            // then check if target is in range, then update h
               if(target>=nums[l] && target<nums[mid]){
                   h= mid-1;
                   //otherwise, update low
               }else{
                   l=mid+1;
               }
               // if the right side is sorted
           }else{
            // check is target is in range, and update low
               if(target>nums[mid] && target<=nums[h]){
                   l= mid+1;
                   //other wise update high
               }else{
                   h=mid-1;
               }
               
           }
        }
        return -1;
        
        
    }
}
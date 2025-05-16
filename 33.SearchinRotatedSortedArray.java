// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
// divided array segment at mid to look for sorted part
// then checked whether target can exist in sorted part
// based on it went further by eleminating one part (reduced to half) 

class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            //System.out.println(i+" "+j+" "+mid);
            if(nums[mid]==target)return mid;
            if(nums[i]<=nums[mid]){
                if(target<=nums[mid]&&target>=nums[i]){
                    j=mid-1;
                }else{
                    i=mid+1;
                }
            }else{
                if(target<=nums[j]&&target>=nums[mid]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}
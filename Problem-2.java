// Search in a Rotated Sorted Array

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int search(int[] nums, int target) {
        int size=nums.length;
        if(size==0) return -1;
        int low=0; int high=size-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]) high=mid-1;
                else low = mid+1;
            }else if(nums[mid]<=nums[high]){
                if(nums[mid]<target && target<=nums[high]) low=mid+1;
                else high = mid-1;
            }
        }   
        return -1;
    }
}
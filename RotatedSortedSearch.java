// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// In rotated sorted array, once we find a midpoint to split the array, atleast one of the halves of the array will be sorted
// We need to find which half is sorted and decide whether we can throw away that section or keep it based on if target lies in that range

class Solution {
    public int search(int[] nums, int target) {
        
        int low =0; int high = nums.length-1; int mid=0;

        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]==target) 
                return mid;
        
            else if(nums[low]<=nums[mid]) //left half is sorted
            {
                if(target<nums[mid]&&target>=nums[low]) //check if target lies in this half
                    high = mid-1;
                else
                    low = mid+1;
            }
            else //right half is sorted
            {
                if(target>=nums[mid]&&target<=nums[high]) //check if target lies in this half
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        return -1;
    }
}
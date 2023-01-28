/*
 * Time Complexity : O(log(m))
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - As it's a rotated sorted array, at every stage either the left side or the right side of the array is sorted. So we first find the low, mid and high and check if the array 
 * between mid and low is sorted or not, if it is sorted and if target lies between low and mid. If yes, the high will be mid-1. If the array is not sorted and if the element lies between 
 * high and mid. If true, then low becomes mid +1 else high = mid-1 
 */

//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/886245720/
class RotatedSorted {
    public int search(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        int mid;
        while(low<=high){
            mid = low+(high-low)/2;
            if(target==nums[mid])
                    return mid;
            if(nums[mid]>=nums[low]){
                if(target<nums[mid] && target>=nums[low]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
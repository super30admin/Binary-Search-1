// Time Complexity : O(log n)
// Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes


/*
Approach:
1. In a rotated sorted array, for sure one half of the array is always sorted
2. In every iteration , check which half of the array is sorted and if target is in its range
3. If not, switch to the other half repeating step 2
 */

class Solution {
    public int search(int[] nums, int target) {

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(target==nums[mid])
                return mid;

            //Check if the array is left sorted
            if(nums[low]<=nums[mid]){
                //if target is in the left sorted array
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            //else array is right sorted
            else{
                //if target is in the right sorted array
                if(target>nums[mid]&& target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }

        return -1;
    }
}
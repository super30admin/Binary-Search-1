/*
 *  Time Complexity: O(log n) Since we are eliminating half of the search location every time.
 *  Space Complexity: O(1) Constanct space as we do not use additional storage.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Similar to Binary search find the mid element and identify the part of array which is sorted and check if the target lies in that part based on this modify the left and right index.
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right=nums.length-1;
        while(left<=right){
            int mid=left + (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && nums[mid]>target) right=mid-1;
                else left=mid+1;
            }else if(nums[mid]<=nums[right]){
                if(nums[mid]<target && nums[right]>=target) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}
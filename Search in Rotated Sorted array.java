//Search in Rotated Sorted array
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
           int k = start+(end - start)/2;
            if(nums[k]==target) {
                return k;
            }
            if(nums[start] <= nums[k]) {
                if(target<nums[k] && target>=nums[start]) {
                    end = k-1;
                }
                else {
                    start = k+1;
                }
            }
            else {
                if(target>nums[k] && target<=nums[end]) {
                    start = k+1;
                }
                else {
                    end = k -1;
                }
            }
        }
        return -1;
    }
}
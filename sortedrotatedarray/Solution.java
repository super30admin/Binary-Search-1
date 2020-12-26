// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting started but resolved in class


// Your code here along with comments explaining your approach
package sortedrotatedarray;

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        //set low and high
        int left = 0;
        int right = nums.length -1;

        //find index of smallest value using modified binary search
        while(left < right){
            int midpoint = left+(right-left)/2;

            if(nums[midpoint] > nums[right]){
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        //search for target using regular binary search
        int start = left;
        left = 0;
        right  = nums.length -1;

        if(target >= nums[start] && target <= nums[right]){
            left = start;
        } else {
            right = start;
        }

        while(left <= right){
            int midpoint = left + (right - left)/2;

            if(target == nums[midpoint]){
                return midpoint;
            } else if (target < nums[midpoint]){
                right = midpoint -1;
            } else {
                left = midpoint + 1;
            }
        }
        return -1;
    }
}
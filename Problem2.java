//Search in Rotated Sorted Array


// Search in 2D matrix.

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : bit difficult to understand the binary search concepts

class Solution {
    public int search(int[] nums, int target) {

        for(int i=0;i<nums.length;i++){

            if(nums[i] == target){

                return i;
            }
        }

        return -1;

    }
}
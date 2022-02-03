// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: found the smallest element in array using Binary search, 
// treated array on either side of the smallest element as individual array
// found the array need to be considered according to the target value
// updated left and right indexes accordingly and then used Binary search on that side.


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        if(nums.length == 1 && target == nums[0]) {
            return 0;
        }

        int left = 0, right = nums.length-1;

        while(left < right) {
            int mid = (left + right)/2;
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;
        left = 0;
        right = nums.length-1;


        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int mid = (left + right)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }

        return -1;
    }
}
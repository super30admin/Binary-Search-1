// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 we want to check and compare which sub array might have the target element,in this problem, given this
 is sorted at a pivot element, we want to understand at which part did sorting happen, so, we try to check
 the left/right direction by comparing left and mid or mid and right to get idea of the sorted range and
 then have respective comparisons with target to split and continue the iteration
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }

        }
        return -1;
    }
}
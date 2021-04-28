// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We check which is sorted, if sorted, we check if the target lies in that range of sorted values.
    If yes, we move towards that direction. If not we move in the opposite direction. 
*/

class Solution {
    public int searchRotatedSortedArray(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int l = 0; 
        int r = nums.length-1;
        int mid;

        while (l<=r){
            mid = l+(r-l)/2;

            if (nums[mid] == target) return mid;

            if (nums[l]<=nums[mid]){
                if (nums[l]<=target && target<=nums[mid]) r = mid-1;
                else l = mid+1;
            }
            else {
                if (nums[mid]<=target && target<=nums[r]) l = mid+1;
                else r = mid-1;
            }
        }
        return -1;
    }
} 
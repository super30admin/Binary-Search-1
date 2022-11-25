// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if(nums == null || nums.length == 0) {
            return -1;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else {
                //check which side is sorted
                if(nums[low] <= nums[mid]) {
                    //check if target is in the left side
                    if(nums[low] <= target && nums[mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    //check if target is in the right side
                    if(nums[mid] < target && nums[high] >= target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
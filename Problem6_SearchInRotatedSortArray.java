// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(nums == null || nums.length == 0)
            return -1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid]) {
                    if(nums[left] <= target && nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
            }
            else {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
                }
        }
        return -1;
    }
}
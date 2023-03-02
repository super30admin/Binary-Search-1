// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && nums[mid] >= target)
                    right = mid-1;
                else
                    left = mid+1;
            }

            else {
                if(nums[right] >= target && nums[mid] <= target)
                    left = mid+1;
                else
                    right = mid-1;
            }

        }
        return -1;
    }
}
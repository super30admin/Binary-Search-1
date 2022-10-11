// Time Complexity : 1ms (faster than 80.17%)
// Space Complexity : 42.7MB (less than 35.79%)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int mid = (s + e) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;

    }
}